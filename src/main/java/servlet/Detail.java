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

@WebServlet("/Detail")
public class Detail extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String taskIdstr = request.getParameter("taskId");
        int taskId = Integer.parseInt(taskIdstr);

        // Retrieve the task list from the session
        List<Task> taskList = (List<Task>) session.getAttribute("tasks");

        // Find the task by taskId
        Task selectedTask = null;
        if (taskList != null) {
            for (Task task : taskList) {
                if (task.getTaskId() == taskId ) {
                    selectedTask = task;
                    break;
                }
            }
        }

        if (selectedTask != null) {
            // Set the task in the request scope and forward to detail.jsp
            request.setAttribute("task", selectedTask);
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        } else {
            response.sendRedirect("GetListServlet"); // Redirect if task not found
        }
    }
}
