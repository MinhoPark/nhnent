<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Check Password</title>
</head>
<body>
<center>
<h1>비밀번호를 입력하세요</h1>
<form name = "checkForm" action = "Check" method = "POST">
<%
	String mode = (String)request.getParameter("opr");
	if(mode.equals("modify")){	
		mode = "수정";
	}else if(mode.equals("delete")){
		mode = "삭제";
	}
%>

<input name = "password" type="password">
<input type = "submit" value = "<%=mode%>">&nbsp;&nbsp;
<input type = "button" value = "뒤로" onClick="javascript:history.back()">
<input type = "hidden" name = "opr" value = "<%=request.getParameter("opr")%>">
<input type = "hidden" name = "id" value= "<%=request.getParameter("id") %>">
</form>
</center>
</body>
</html>