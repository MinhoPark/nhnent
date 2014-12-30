<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guestbook.GuestArticle" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language = "javascript">
function checkBlank(){
	var form = document.write_form;
	
	if(!form.email.value){
		alert("이메일을 적어주세요");
		form.email.focus();
		return;
	}
		
	if(!form.article.value){
		alert("내용을 적어주세요");
		form.article.focus();
		return;
	}
	
	// email 유효성 검사 (regex)
	// [영문,숫자,'.','_','-']@도메인형식(.com이나 .co.kr처럼 점이 1개 또는 2개만 허용)
	var regexEmail = /^([A-Za-z0-9\._-]+)@([A-Za-z0-9\-]+)(\.[A-Za-z0-9]+){1,2}$/;
	if(!regexEmail.test(form.email.value)){
		alert("이메일 주소 형식이 맞지 않습니다.");
		return;
	}
	
	form.submit();
}
function gotoList(){
	location.href = "List";
}
</script>
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
		<td><input type = "text" name = "email" size = "50" value = "<%=article.getEmail() %>"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea name = "article" cols = "50" rows = "15"><%=article.getArticle() %></textarea></td>
	</tr>
	<tr>
		<td><input type = "button" value = "글 쓰기" onClick ="javascript:checkBlank()"><input type = "reset" value = "되돌리기">
			<input type = "button" value = "취소" onClick = "javascript:gotoList()"></td>
	</tr>	
</table>
<input type = "hidden" name = "id" value = "<%=article.getId() %>">
</form>
</body>
</html>