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

@WebServlet("/EditTask")
public class EditTask extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        List<Task> tasks = (List<Task>) session.getAttribute("tasks");
        
        if (tasks != null) {
            for (Task task : tasks) {
                if (task.getTaskId() == taskId) {
                    session.setAttribute("task", task);
                    request.getRequestDispatcher("/edit.jsp").forward(request, response);
                    return;
                }
            }
        }

        response.sendRedirect("GetListServlet"); // タスクが見つからない場合リダイレクト
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        List<Task> tasks = (List<Task>) session.getAttribute("tasks");

        if (tasks != null) {
            for (Task task : tasks) {
                if (task.getTaskId() == taskId) {
                    task.setTaskName(request.getParameter("taskName"));
                    task.setDetails(request.getParameter("details"));
                    task.setPriority(request.getParameter("priority"));
                    
                    return;
                }
            }
        }
        // 優先度と締切でソート
        Collections.sort(tasks, Comparator.comparing(Task::getPriority).thenComparing(Task::getDeadline));

        session.setAttribute("tasks", tasks);
        response.sendRedirect("Detail?taskId=" + taskId);
        
        response.sendRedirect("GetListServlet"); // タスクが見つからない場合リダイレクト
    }
}
