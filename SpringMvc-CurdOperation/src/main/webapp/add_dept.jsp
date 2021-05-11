<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add Department</h2>
	<sf:form method="post" modelAttribute="depts">
Id:<sf:input path="id" />
name:<sf:input path="name" />
name:<sf:input path="location" />

		<p></p>
		<input type="submit" value="add_dept" />
	</sf:form>
	<h4>${message}</h4>
</body>
</html>