<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Details Form</title>
</head>
<body>
	<c:set var="user" value="${requestScope.user_details}" />
	<form action="process_update" method="post">
		<input type="hidden" name="id" value="${user.id}" />

		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Edit DoB</td>
				<td><input type="date" name="dob" value="${user.dob}" /></td>
			</tr>
			<tr>
				<td>Edit Password</td>
				<td><input type="password" name="pass" value="${user.password}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update User Details" /></td>
			</tr>
		</table>
	</form>
</body>
</html>