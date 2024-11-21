<%@ page import="com.learn.bean.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
out.println(request.getAttribute("student"));

	Student student = (Student) request.getAttribute("student");
	out.println(student.getName());
%>
</body>
</html>