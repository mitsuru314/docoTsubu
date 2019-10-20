<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "docoTsubu.User" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "docoTsubu.Mutter"%>
<%@ page import = "model.Login" %>

<% Login login = (Login) session.getAttribute("login");%>
<% List<Mutter> mutterList = (ArrayList<Mutter>) request.getAttribute("mutterList"); %>
<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メイン画面</title>
</head>
<body>
<h1>メイン画面</h1>
<p>
<%=login.getUserId() %>さんログイン中<br>
<% if(errorMessage != null){
%>
<%=errorMessage %>
<%} %>

<form action = "/docoTsubu2/Main" method = "Post">
	<input type = "text" name = "mutter"><br>
	<input type = "submit" value = "つぶやく"><br>
</form>
<a href = /docoTsubu2/Main>更新</a>
<a href = "/docoTsubu2/Logout">ログアウト</a><br>


<% for(Mutter mutter : mutterList){ %>

<%=mutter.getUserName()%> : <%= mutter.getText() %><br>

<%} %>

</p>
</body>
</html>