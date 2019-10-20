<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<form action = "/docoTsubu2/LoginServlet"  method = "post">
ユーザID: <input type = "text" name = "userId"><br>
パスワード: <input type = "text" name = "pass"><br>
<input type = submit value = "ログイン"><br>
</form>

</body>
</html>