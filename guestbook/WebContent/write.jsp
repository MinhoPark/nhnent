<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MinGuest Write</title>
</head>
<body>
<form name = "write_form" action = "writeproc.jsp" method = "POST">
<table border='1' align = "center">
	<tr>
		<td>이메일</td>
		<td><input type = "text" name = "email"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type = "password" name = "password"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea cols = "40" rows = "10"></textarea></td>
	</tr>
	<tr>
		<td><input type = "submit" value = "글 쓰기"><input type = "reset" value = "지우기"></td>
	</tr>	
</table>
</form>
</body>
</html>