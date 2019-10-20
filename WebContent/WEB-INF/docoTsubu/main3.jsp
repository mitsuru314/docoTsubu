<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メイン画面</title>
</head>
<body>
<h1>メイン画面</h1>
<p>

<c:out value = "${User.name}" />さんログイン中<br>
<p>
<form action = "/docoTsubu2/Main" method = "Post">
	<input type = "text" name = "mutter"><br>
	<input type = "submit" value = "つぶやく"><br>
</form>
<a href = /docoTsubu2/Main>更新</a>
<a href = "/docoTsubu2/Logout">ログアウト</a><br>

<c:if test="${not empty errorMessage}">
<p>${errorMessage}</p>
</c:if>

<c:forEach var="mutter" items = "${mutterList}">
	<p><c:out value="${mutter.userName}"/><c:out value= "${mutter.text}"/></p>
</c:forEach>

</body>
</html>