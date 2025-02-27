<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>タスク追加</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-3">
        <h2 class="text-center mb-4">新しいタスクを追加</h2>
        <form action="AddTask" method="post">
            <div class="form-group">
                <label for="customerId">顧客:</label>
                <select class="form-control" name="customerId" id="customerId" required>
                    <option value="101" >顧客A</option>
                    <option value="102" >顧客B</option>
                    <option value="103" >顧客C</option>
                    <option value="104" >顧客D</option>
                    <option value="105" >顧客E</option>
                    <option value="106" >顧客F</option>
                    <option value="107" >顧客H</option>
                    <option value="108" >顧客I</option>
                    <option value="109" >顧客J</option>
                    <option value="110" >顧客K</option>
                    <option value="111" >顧客L</option>
                </select>
            </div>
            <div class="form-group">
                <label for="taskName">タスク名:</label>
                <select class="form-control" name="taskName" id="taskName" required>
                    <option value="チェックイン" >チェックイン</option>
                    <option value="チェックアウト" >チェックアウト</option>
                    <option value="備品貸し出し" >備品貸し出し</option>
                    <option value="観光プラン提案" >観光プラン提案</option>
                    <option value="観光プラン手配" >観光プラン手配</option>
                    <option value="レストラン・カフェ予約" >レストラン・カフェ予約</option>
                    <option value="タクシー・レンタカー手配" >タクシー・レンタカー手配</option>
                    <option value="クリーニング取次" >クリーニング取次</option>
                    <option value="整体・マッサージ手配" >整体・マッサージ手配</option>
                    <option value="宅配便手配" >宅配便手配</option>
                    <option value="急病人付き添い" >急病人付き添い</option>
                    <option value="カスタマイズ">カスタマイズ</option>
                </select>
            </div>
            <div class="form-group">
                <label for="details">詳細:</label>
                <textarea class="form-control" id="details" name="details" rows="3" required></textarea>
            </div>
            <div class="form-group">
                <label for="priority">優先度:</label>
                <select class="form-control" name="priority" id="priority" required>
                    <option value="A" >A</option>
                    <option value="B" >B</option>
                    <option value="C" >C</option>
                </select>
            </div>
            <div class="form-group">
                <label for="deadline">期限:</label>
                <input type="datetime-local" class="form-control" id="deadline" name="deadline" required>
            </div>
            
            <div class="form-group">
                <label for="duration">所要時間:</label>
                <input type="number" class="form-control" id="duration" name="duration" required>
            </div>
            <button type="submit" class="btn btn-primary">追加</button>
        </form>
    </div>
</body>
</html>
