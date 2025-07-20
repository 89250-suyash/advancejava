<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title her</title>
</head>
<body>

	<jsp:useBean id="lb" class="bean.LoginBean"/>
	<jsp:setProperty property="email" name="lb" param="email"/>
	<jsp:setProperty property="password" name="lb" param="password"/>
	<%lb.login(); %>
	<% if(lb.getUser()!=null){%>
	<%="sucess" %>
	<% }%>
	

</body>
</html>