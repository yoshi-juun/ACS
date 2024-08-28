<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.Task" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>タスクリスト</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .in-progress { background-color: #d4edda; } /* 薄緑 */
        .completed { background-color: #e2e3e5; }   /* 薄めのグレー */
    </style>
</head>
<body class="bg-light">
    <div class="container mt-3">
        <h2 class="text-center mb-4">タスク一覧</h2>

        <!-- コンシェルジュの情報を表示 -->
        <div class="alert alert-info">
            <p>現在稼働中のコンシェルジュ: <strong>田中 太郎</strong></p>
            <p>対応中のタスク: 書類作成</p>
            <p>所要時間: 45分</p>
        </div>

        <!-- No・InProgressのタスクを表示 -->
        <h4 class="text-primary mb-3">No・InProgressのタスク</h4>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>顧客名</th>
                    <th>タスク名</th>
                    <th>優先度</th>
                    <th>受注日時</th>
                    <th>期限</th>
                    <th>進捗状況</th>
                    <th>登録</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Task> taskList = (List<Task>) session.getAttribute("tasks");
                    if (taskList != null) {
                        for (Task task : taskList) {
                            if (!"Complete".equals(task.getStatus())) {
                %>
                <tr class="<%= task.getStatus().equals("InProgress") ? "in-progress" : "" %>">
                    <td><%= task.getCustomerName() %></td>
                    <td><%= task.getTaskName() %></td>
                    <td><%= task.getPriority() %></td>
                    <td><%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").format(task.getOrderDate()) %></td> <!-- 受注日時 -->
                    <td><%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").format(task.getDeadline()) %></td>
                    <td>
                        <form action="Recreate" method="post">
                            <input type="hidden" name="taskId" value="<%= task.getTaskId() %>">
                            <select class="form-control" name="status">
                                <option value="No" <%= task.getStatus().equals("No") ? "selected" : "" %>>No</option>
                                <option value="InProgress" <%= task.getStatus().equals("InProgress") ? "selected" : "" %>>InProgress</option>
                                <option value="Complete" <%= task.getStatus().equals("Complete") ? "selected" : "" %>>Complete</option>
                            </select>
                    </td>
                    <td>
                            <button type="submit" class="btn btn-outline-primary btn-sm">登録</button>
                        </form>
                    </td>
                </tr>
                <%      }
                        }
                    }
                %>
            </tbody>
        </table>

        <!-- Completeタスクを表示 -->
        <h4 class="text-secondary mt-4 mb-3">Completeタスク</h4>
        <table class="table table-bordered">
            <thead class="thead-light">
                <tr>
                    <th>顧客名</th>
                    <th>タスク名</th>
                    <th>優先度</th>
                    <th>受注日時</th>
                    <th>Complete日時</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (taskList != null) {
                        for (Task task : taskList) {
                            if ("Complete".equals(task.getStatus())) {
                %>
                <tr class="completed">
                    <td><%= task.getCustomerName() %></td>
                    <td><%= task.getTaskName() %></td>
                    <td><%= task.getPriority() %></td>
                    <td><%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").format(task.getOrderDate()) %></td>
                    <td><%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").format(task.getCompletionDate()) %></td>
                </tr>
                <%      }
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
