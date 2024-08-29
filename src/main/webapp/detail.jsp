<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Task" %>
<%
    Task task = (Task) session.getAttribute("task");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>タスク詳細</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .task-details-table th {
            width: 25%;
            background-color: #f8f9fa;
        }
        .task-details-table td {
            background-color: #ffffff;
        }
        .action-buttons .btn {
            width: 200px;
            margin-bottom: 15px;
        }
    </style>
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="card shadow-sm">
            <div class="card-header bg-primary text-white text-center">
                <h3>タスク詳細</h3>
            </div>
            <div class="card-body">
                <table class="table task-details-table table-bordered">
                    <tr>
                        <th>顧客名</th>
                        <td><%= task.getCustomerName() %></td>
                    </tr>
                    <tr>
                        <th>顧客ID</th>
                        <td><%= task.getCustomerId() %></td>
                    </tr>
                    <tr>
                        <th>タスク名</th>
                        <td><%= task.getTaskName() %></td>
                    </tr>
                    <tr>
                        <th>タスク詳細</th>
                        <td><%= task.getDetails() %></td>
                    </tr>
                    <tr>
                        <th>優先度</th>
                        <td><%= task.getPriority() %></td>
                    </tr>
                    <tr>
                        <th>受注日時</th>
                        <td><%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").format(task.getOrderDate()) %></td>
                    </tr>
                    <tr>
                        <th>所要時間</th>
                        <td><%= task.getRequiredTime() %>分</td>
                    </tr>
                </table>

                <%-- Display the "予約・手配" button for specific task names --%>
                <div class="text-center action-buttons">
                    <%
                        String taskName = task.getTaskName();
                        if (taskName.equals("レストラン・カフェ予約") || 
                            taskName.equals("タクシー・レンタカー手配") || 
                            taskName.equals("整体・マッサージ手配")) {
                    %>
                        <button class="btn btn-primary">予約・手配</button>
                    <% } %>
                </div>

                <div class="text-center">
                    <a href="GetListServlet" class="btn btn-secondary">リスト一覧に戻る</a>
                </div>

                <%-- Edit and Delete buttons --%>
                <div class="text-center action-buttons">
                    <form action="EditTask" method="get" style="display:inline;">
                        <input type="hidden" name="taskId" value="<%= task.getTaskId() %>">
                        <button type="submit" class="btn btn-warning">編集</button>
                    </form>
                    <form action="DeleteTask" method="post" style="display:inline;">
                        <input type="hidden" name="taskId" value="<%= task.getTaskId() %>">
                        <button type="submit" class="btn btn-danger" onclick="return confirm('本当に削除しますか？');">削除</button>
                    </form>
                </div>

            </div>
        </div>
    </div>
</body>
</html>
