<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table style="background-color: lightgrey; margin: auto" border="1">
		<caption>User List</caption>
		<tr>
			<th>User ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>DoB</th>
			<th>Voting Status</th>
			<th>Action</th>
			<th>Action</th>
		</tr>
		<c:forEach var="u" items="${requestScope.user_list}">
			<tr>
				<td>${u.id}</td>
				<td>${u.firstName}</td>
				<td>${u.lastName}</td>
				<td>${u.email}</td>
				<td>${u.dob}</td>
				<td>${u.status}</td>
				<td><a href="update?id=${u.id}">Update</a></td>
				<td><a href="delete?id=${u.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<h5 align="center">
		<a href="./add">Add New User</a>
	</h5>

</body>
</html>