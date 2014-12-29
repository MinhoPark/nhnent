<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language = "javascript">
function checkBlank(){
	var form = document.write_form;
	
	if(!form.email.value){
		alert("이메일을 적어주세요");
		form.email.focus();
		return;
	}
	
	if(!form.password.value){
		alert("비밀번호를 적어주세요");
		form.password.focus();
		return;
	}
	
	if(!form.article.value){
		alert("내용을 적어주세요");
		form.article.focus();
		return;
	}
	
	// email 유효성 검사 (regex)
	var regexEmail = /^([A-Za-z0-9\._-]+)@([A-Za-z0-9\-]+)(\.[A-Za-z0-9]+){1,2}$/;
	
	form.submit();
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MinGuest Write</title>
</head>
<body>
<center>
<form name = "write_form" action = "WriteProc" method = "POST">
<table border='1' align = "center">
	<tr>
		<td align = "center">이메일</td>
		<td><input type = "text" name = "email" size = "50"></td>
	</tr>
	<tr>
		<td align = "center">비밀번호</td>
		<td><input type = "password" name = "password" size = "50" ></td>
	</tr>
	<tr>
		<td align = "center">내용</td>
		<td><textarea name = "article" cols = "50" rows = "15"></textarea></td>
	</tr>
</table>
<hr><br>
<input type = "button" value = "글 쓰기" onClick = "javascript:checkBlank()"><input type = "reset" value = "지우기">
<input type = "button" value = "취소" onClick = "javascript:history.back()">
</form>
</center>
</body>
</html>