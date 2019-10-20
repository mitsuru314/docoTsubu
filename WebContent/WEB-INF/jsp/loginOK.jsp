<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ようこそどこつぶへ></title>
</head>
<body>
<p>ようこそ<c:out value = "${login.userId}"/>さん</p>
<a href = "/docoTsubu2/Main">メイン画面へ</a><br>
<a href = "/docoTsubu2/WelcomeServlet">Topへ</a>
</body>
</html>