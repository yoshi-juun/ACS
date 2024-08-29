package servlet;

import model.Task;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/DeleteTask")
public class DeleteTask extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        List<Task> tasks = (List<Task>) session.getAttribute("tasks");

        if (tasks != null) {
            tasks.removeIf(task -> task.getTaskId() == taskId);
            session.setAttribute("tasks", tasks);
        }

        response.sendRedirect("GetListServlet");
    }
}
