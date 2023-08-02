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
	if (value) { %>
	<h1>welcome  <%= request.getSession().getAttribute("username") %></h1>
<a href="<%=request.getContextPath() %>/member_area?action=logout" >logout</a>

<% } %>
<% }%>

<% if (request.getSession().getAttribute("loggedin")==null){%> 
<a href="<%=request.getContextPath() %>/general?action=login" >login</a>
</br>
<a href="<%=request.getContextPath() %>/general?action=signup" >signup</a>
<br> 
<%} %>
<a href="<%=request.getContextPath() %>/general?action=blogs"> blogs</a>
<br>

</body>
</html>