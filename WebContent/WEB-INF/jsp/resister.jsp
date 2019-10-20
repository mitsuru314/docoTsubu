<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>
<form action = "/docoTsubu2/Resister" method = "post">
<br>
USER_ID : <input type = "text" name = "userId"/><br>
PASSWARD: <input type = "text" name = "pass"/><br>
MAIL    : <input type = "text" name = "mail"/><br>
NAME    : <input type = "text" name = "name"/><br>
AGE     : <input type = "text" name = "age"/><br>
<input type = "submit" value = "登録">
</form>
</body>
</html>