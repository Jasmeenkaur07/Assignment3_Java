<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Grade</title>
</head>
<body>
	<div align="center">
		<h1>Student Grade Register Page</h1>
		<form action="<%= request.getContextPath() %>/StudentGradeServlet"
			method="post">
			
			<table style="with: 80%">
				<tr>
					<td>CourseId</td>
					<td><input type="text" name="courseid" /></td>
				</tr>
				<tr>
					<td>CourseName</td>
					<td><input type="text" name="coursename" /></td>
				</tr>
				<tr>
					<td>CourseScore</td>
					<td><input type="text" name="coursescore" /></td>
				</tr>
			</table>
			<input type="submit" name="formSubType" value="Insert" /> <input
				type="submit" name="formSubType" value="Update" /> <input
				type="submit" name="formSubType" value="Select" />
		</form>
	</div>
</body>
</html>
