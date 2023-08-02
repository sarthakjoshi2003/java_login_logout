<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if (request.getSession().getAttribute("loggedin")!=null) {
	boolean value=(Boolean)request.getSession().getAttribute("loggedin");
	if (value) {%>
	<h1>welcome  <%= request.getSession().getAttribute("username") %></h1>
<a href="<%=request.getContextPath() %>/member_area?action=logout" >logout</a>

	
<% }} %> 
</body>
</html>