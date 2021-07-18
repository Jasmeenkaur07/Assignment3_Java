<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>
</head>
<body>
	<div align="center">
		<h1>Student Register Page</h1>
		<form action="<%= request.getContextPath() %>/StudentServlet" method="post">
			<table style="with: 80%">
				<tr>
					<td>Id</td>
					<td><input type="text" name="id" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age" /></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="text" name="gender" /></td>
				</tr>
			</table>
			<input type="submit" name="formSubType" value="Insert" /> <input
				type="submit" name="formSubType" value="Update" />
		</form>
	</div>
</body>
</html>
