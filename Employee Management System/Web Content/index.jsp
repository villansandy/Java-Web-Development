<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<h1>WELCOME TO LOGIN PAGE</h1>
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

	<form action="/Employee_Management_System/login" method="post">
		<h3>
			Enter Email : <input name="email" placeholder="Enter user name">
		</h3>
		<h3>
			Enter Password : <input type="password" name="password"
				placeholder="Enter password">
		</h3>
		<input type="submit" value="Login">
	</form>
	<br>
	<form action="${pageContext.request.contextPath}/register.jsp">
		<input type="submit" value="Register" />
	</form>

</body>
</html>