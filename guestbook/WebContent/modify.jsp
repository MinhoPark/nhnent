<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guestbook.GuestArticle" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MinGuest Write</title>
</head>
<body>
<form name = "mod_form" action = "Modify" method = "POST">
<%
	GuestArticle article = (GuestArticle)request.getAttribute("article");
%>
<table border='1' align = "center">
	<tr>
		<td>이메일</td>
		<td><input type = "text" name = "email" size = "50" value = "<%=article.getEmail() %>" readonly></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea name = "article" cols = "50" rows = "15"><%=article.getArticle() %></textarea></td>
	</tr>
	<tr>
		<td><input type = "submit" value = "글 쓰기"><input type = "reset" value = "되돌리기"></td>
	</tr>	
</table>
<input type = "hidden" name = "id" value = "<%=article.getId() %>">
</form>
</body>
</html>