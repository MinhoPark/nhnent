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
<h1>방명록</h1><br>
<a href = "write.jsp">[새 글쓰기]</a><br>
<hr><br>
<table border = "1" width = "50%">
<%
	List<GuestArticle> lists = (List<GuestArticle>)request.getAttribute("lists");
	int articleNo = Integer.parseInt((String)request.getAttribute("totalArticles"));
	int totalPageCount = Integer.parseInt((String)request.getAttribute("totalPageCount"));
	int reqPage = Integer.parseInt((String)request.getAttribute("reqPage"));
	int idx;
	
	final int ARTICLES_PER_PAGE = Integer.parseInt((String)request.getAttribute("articlesPerPage"));
	
	articleNo = articleNo - ARTICLES_PER_PAGE * (reqPage-1);
	
	for(GuestArticle article : lists){
%>
	<tr>
		<td>글 번호</td>
		<td><%=articleNo %></td>
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
	<tr>
		<td>옵션</td>
		<td><a href = "check.jsp?opr=modify&id=<%=article.getId() %>">[수정]</a>&nbsp;&nbsp;
			<a href = "check.jsp?opr=delete&id=<%=article.getId() %>">[삭제]</a>
		</td>
	</tr>
<%
	--articleNo;
	}
%>
</table>
<br>
<%
	// paging 처리
	
	for(idx = 1; idx <= totalPageCount; ++idx){
		if(idx != reqPage){
%>
	[<a href = "List?page=<%=idx %>"><%=idx %></a>]
<% 
		}else{
%>		[<%=idx %>]
<%
		}
	}
%>
</center>
</body>
</html>