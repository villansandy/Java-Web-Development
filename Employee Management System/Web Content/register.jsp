<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration form</title>
</head>
<body>
	<%
	Object message = session.getAttribute("message");
	if (message != null) {
		out.println("<font color='green' size='5'>"+message+"</font>");
	}
	Object error = session.getAttribute("error");
	if (error != null) {
		out.println("<font color='red' size='5'>"+error+"</font>");
	}
	session.invalidate();
	%>
	<form action="${pageContext.request.contextPath}/register"
		method="post">
		<label for="fname">ID:</label><br> <input type="text" name="id"><br>
		<label for="fname">Name:</label><br> <input type="text" name="name"><br> 
		<label for="fname">Email:</label><br> <input type="text" name="email"><br> 
		<label for="fname">Password:</label><br> <input type="password" name="password"><br> 
		<label for="fname">Salary:</label><br> <input type="text" name="salary"><br>
		<br> <input type="submit" value="Register">
	</form>
</body>
</html>