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
    <title>タスク編集</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="card shadow-sm">
            <div class="card-header bg-warning text-white text-center">
                <h3>タスク編集</h3>
            </div>
            <div class="card-body">
                <form action="EditTask" method="post">
                    <input type="hidden" name="taskId" value="<%= task.getTaskId() %>">
                    
                    <div class="form-group">
                        <label for="taskName">タスク名</label>
                        <select class="form-control" name="taskName" id="taskName" required>
                            <option value="チェックイン" <%= task.getTaskName().equals("チェックイン") ? "selected" : "" %>>チェックイン</option>
                            <option value="チェックアウト" <%= task.getTaskName().equals("チェックアウト") ? "selected" : "" %>>チェックアウト</option>
                            <option value="備品貸し出し" <%= task.getTaskName().equals("備品貸し出し") ? "selected" : "" %>>備品貸し出し</option>
                            <option value="観光プラン提案" <%= task.getTaskName().equals("観光プラン提案") ? "selected" : "" %>>観光プラン提案</option>
                            <option value="観光プラン手配" <%= task.getTaskName().equals("観光プラン手配") ? "selected" : "" %>>観光プラン手配</option>
                            <option value="レストラン・カフェ予約" <%= task.getTaskName().equals("レストラン・カフェ予約") ? "selected" : "" %>>レストラン・カフェ予約</option>
                            <option value="タクシー・レンタカー手配" <%= task.getTaskName().equals("タクシー・レンタカー手配") ? "selected" : "" %>>タクシー・レンタカー手配</option>
                            <option value="クリーニング取次" <%= task.getTaskName().equals("クリーニング取次") ? "selected" : "" %>>クリーニング取次</option>
                            <option value="整体・マッサージ手配" <%= task.getTaskName().equals("整体・マッサージ手配") ? "selected" : "" %>>整体・マッサージ手配</option>
                            <option value="宅配便手配" <%= task.getTaskName().equals("宅配便手配") ? "selected" : "" %>>宅配便手配</option>
                            <option value="急病人付き添い" <%= task.getTaskName().equals("急病人付き添い") ? "selected" : "" %>>急病人付き添い</option>
                            <option value="カスタマイズ" <%= task.getTaskName().equals("カスタマイズ") ? "selected" : "" %>>カスタマイズ</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="details">タスク詳細</label>
                        <textarea class="form-control" id="details" name="details" rows="5"><%= task.getDetails() %></textarea>
                    </div>

                    <div class="form-group">
                        <label for="priority">優先度</label>
                        <select class="form-control" id="priority" name="priority">
                            <option value="A" <%= task.getPriority().equals("A") ? "selected" : "" %>>A</option>
                            <option value="B" <%= task.getPriority().equals("B") ? "selected" : "" %>>B</option>
                            <option value="C" <%= task.getPriority().equals("C") ? "selected" : "" %>>C</option>
                        </select>
                    </div>

                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">保存</button>
                        <a href="Detail?taskId=<%= task.getTaskId() %>" class="btn btn-secondary">キャンセル</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
