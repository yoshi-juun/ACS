package servlet;

import model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@WebServlet("/AddTask")
public class AddTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // リクエストからフォームの値を取得
        String customerIdStr = request.getParameter("customerId");
        String taskName = request.getParameter("taskName");
        String details = request.getParameter("details");
        String priority = request.getParameter("priority");
        String deadlineStr = request.getParameter("deadline");
        String durationStr = request.getParameter("duration");

        // 必要な値を変換
        int customerId = Integer.parseInt(customerIdStr);

        int requiredTime = Integer.parseInt(durationStr);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date deadline = null;
        try {
            deadline = dateFormat.parse(deadlineStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String customerName = "";
        if(customerId == 101){
            customerName = "顧客A";
        }else if(customerId == 102){
            customerName = "顧客B";
        }else if(customerId == 103){
            customerName = "顧客C";
        }else if(customerId == 104){
            customerName = "顧客D";
        }else if(customerId == 105){
            customerName = "顧客E";
        }else if(customerId == 106){
            customerName = "顧客F";
        }else if(customerId == 107){
            customerName = "顧客G";
        }else if(customerId == 108){
            customerName = "顧客H";
        }else if(customerId == 109){
            customerName = "顧客I";
        }else if(customerId == 110){
            customerName = "顧客J";
        }else if(customerId == 111){
            customerName = "顧客K";
        }

        // タスクIDの自動生成などを考慮し、仮のIDを設定
        int taskId = 0; // ここでは仮のIDを設定。実際には自動生成や管理方法が必要

        // 新しいタスクオブジェクトを作成
        Task newTask = new Task(taskId, customerId, customerName, new Date(), taskName, details, priority, deadline, "No", 0, requiredTime, null);

        // セッションからタスクリストを取得し、新しいタスクを追加
        HttpSession session = request.getSession();
        List<Task> taskList = (List<Task>) session.getAttribute("tasks");

        if (taskList == null) {
            taskList = new ArrayList<>();
        }
        
        taskList.add(newTask);
        // 優先度と締切でソート
        Collections.sort(taskList, Comparator.comparing(Task::getPriority).thenComparing(Task::getDeadline));


        // 更新されたタスクリストをセッションに保存
        session.setAttribute("tasks", taskList);

        // タスク一覧ページにリダイレクト
        response.sendRedirect("list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // GETリクエストがあった場合、add.jspにフォワード
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }
}
