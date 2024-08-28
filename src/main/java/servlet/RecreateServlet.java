package servlet;

import model.Task;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/Recreate")
public class RecreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Task> tasks = (List<Task>) session.getAttribute("tasks");

        // フォームから送信されたタスクIDと新しいステータスを取得
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        System.out.println(taskId);
        String newStatus = request.getParameter("status");
        System.out.println(newStatus);

        // タスクリストの中で該当するタスクを探し、ステータスを更新
        if (tasks != null) {
            for (Task task : tasks) {
                if (task.getTaskId() == taskId) {
                    task.setStatus(newStatus);

                    // "Complete"ステータスになった場合はComplete日を設定
                    if ("Complete".equals(newStatus)) {
                        task.completeTask(new java.util.Date());
                    }
                    break;
                }
            }
        }
        // 優先度と締切でソート
        Collections.sort(tasks, Comparator.comparing(Task::getPriority).thenComparing(Task::getDeadline));


        // 更新されたタスクリストをセッションに再保存
        session.setAttribute("tasks", tasks);

        // タスク一覧ページにリダイレクト
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
