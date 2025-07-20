<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User Details Form</title>
</head>
<body>
	<form action="process_add" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter User First Name</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Enter User Last Name</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Enter User Email</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="pass" /></td>
			</tr>
			<tr>
				<td>Edit DoB</td>
				<td><input type="date" name="dob" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add User Details" /></td>
			</tr>
		</table>
	</form>
</body>
</html>