<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>
<% String error = (String) session.getAttribute("error");

if(error != null ) {
	
	out.print(error); 
	session.setAttribute("error", null);
}
%>
</h2>
<form method="post" action="registerServlet">

Firstname: <input type="text" name="firstname"><br>
Lastname: <input type="text" name="lastname"><br>
Username: <input type="text" name="username"><br>
Password: <input type="password" name="password"><br>
<input type="submit" value="submit">
</form>
</body>
</html>