<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guestbook.GuestArticle" %>
<%@ page import="java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MinGuest v0.1</title>
</head>
<body>
<center>
<h1>방명록</h1><br><br>
<table border = "1">
<%
	List<GuestArticle> lists = (List<GuestArticle>)request.getAttribute("lists");
	int size = lists.size();
	
	for(GuestArticle article : lists){
%>
	<tr>
		<td>글 번호</td>
		<td><%=size %></td>
	</tr>
	<tr>
		<td>글 쓴 날짜</td>
		<td><%=(article.getLastModifyDate() == null)?article.getFirstDate():article.getLastModifyDate() %></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><a href = "mailto:<%=article.getEmail() %>"><%=article.getEmail() %></a></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><%=article.getArticle() %></td>
	</tr>
<%
	--size;
	}
%>
</table>
</center>
</body>
</html>