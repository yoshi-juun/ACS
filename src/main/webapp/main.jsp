<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>メインページ</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-3">
        <div class="row">
            <div class="col-12">
                <p>ログイン中のユーザー: <strong><%= session.getAttribute("userId") %></strong></p>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-md-4 mb-3">
                <form action="./GetListServlet" method="get">
                    <button type="submit" class="btn btn-primary btn-block">ToDoリスト表示画面</button>
                </form>
            </div>
            <div class="col-md-4 mb-3">
                <button class="btn btn-secondary btn-block">録音機能</button>
            </div>
            <div class="col-md-4 mb-3">
                <button class="btn btn-secondary btn-block">レコメンド機能</button>
            </div>
            <div class="col-md-4 mb-3">
                <button class="btn btn-secondary btn-block">施設予約</button>
            </div>
            <div class="col-md-4 mb-3">
                <button class="btn btn-secondary btn-block">宿泊予約管理</button>
            </div>
            <div class="col-md-4 mb-3">
                <button class="btn btn-secondary btn-block">顧客情報管理</button>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
