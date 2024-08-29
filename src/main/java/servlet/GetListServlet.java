package servlet;

import model.Task;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@WebServlet("/GetListServlet")
public class GetListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Task> tasks = (List<Task>) session.getAttribute("tasks");

        if (tasks == null) {
            tasks = new ArrayList<>();
            tasks.add(new Task(1, 101, "顧客A", new Date(), "チェックイン", "詳細A", "A", new Date(System.currentTimeMillis() + 86400000), "No", 201, 60,null));
            tasks.add(new Task(2, 102, "顧客B", new Date(), "備品貸し出し", "詳細B", "B", new Date(System.currentTimeMillis() + 172800000), "No", 202, 30,null));
            tasks.add(new Task(3, 103, "顧客C", new Date(), "観光プラン提案", "詳細C", "A", new Date(System.currentTimeMillis() + 43200000), "InProgress", 203, 45,null));
            // 他のタスクを追加
            tasks.add(new Task(4, 104, "顧客D", new Date(), "備品貸し出し", "詳細D", "C", new Date(System.currentTimeMillis() + 259200000), "Complete", 204, 50,new Date(System.currentTimeMillis() - 259200000)));
            tasks.add(new Task(5, 105, "顧客E", new Date(), "レストラン・カフェ予約", "ロコモコ丼がだべれるお店に行きたい。恩納村とかで。", "A", new Date(System.currentTimeMillis() + 604800000), "No", 205, 70,null));
            tasks.add(new Task(6, 106, "顧客F", new Date(), "備品貸し出し", "歯ブラシを忘れてしまった。", "B", new Date(System.currentTimeMillis() + 86400000 * 10), "InProgress", 206, 90,null));
            tasks.add(new Task(7, 107, "顧客G", new Date(), "備品貸し出し", "詳細G", "C", new Date(System.currentTimeMillis() + 43200000 * 3), "No", 207, 20,new Date(System.currentTimeMillis() - 259200000)));
            tasks.add(new Task(8, 108, "顧客H", new Date(), "整体・マッサージ手配", "詳細H", "A", new Date(System.currentTimeMillis() + 86400000 * 5), "No", 208, 40,null));
            tasks.add(new Task(9, 109, "顧客I", new Date(), "整体・マッサージ手配", "詳細I", "B", new Date(System.currentTimeMillis() + 172800000 * 2), "InProgress", 209, 25,null));
            tasks.add(new Task(10, 110, "顧客J", new Date(), "カスタマイズ", "詳細J", "C", new Date(System.currentTimeMillis() + 86400000 * 7), "No", 210, 35,new Date(System.currentTimeMillis() - 259200000)));
            tasks.add(new Task(11, 111, "顧客K", new Date(), "チェックイン", "詳細K", "B", new Date(System.currentTimeMillis() + 86400000), "No", 211, 55,null));

            // 優先度と締切でソート
            Collections.sort(tasks, Comparator.comparing(Task::getPriority).thenComparing(Task::getDeadline));

            // セッションにタスクリストを格納
            session.setAttribute("tasks", tasks);
        }

        // JSPに遷移
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
