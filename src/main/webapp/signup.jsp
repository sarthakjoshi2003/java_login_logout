<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signup</title>
</head>
<body>
<h1>if already have an acoount plz <a href="<%=request.getContextPath() %>/general?action=login" >login</a><a href="<%=request.getContextPath() %>/general?action=login" >login</a></h1>

<% if (request.getSession().getAttribute("loggedin")!=null) {
	boolean value=(Boolean)request.getSession().getAttribute("loggedin");
	if (value)
	response.sendRedirect(request.getContextPath()+"/member_area?action=welcome");
	
}%>
<% if (request.getParameter("error")!=null){
	out.print(request.getParameter("error"));
}
%>

<form action="<%=request.getContextPath()%>/general" method="post">
<h1>enter id</h1>
<input type="text" name="id" value="000" required>
<h1>enter username</h1>
<input type="text" name="username" value="give username">
<h1>enter email</h1>
<input type= "email" name= "email" value="">

<h1> enter password </h1>
<input type="password" name="password" value="give username">
<input type="submit" value="submit">
</form>

</body>
</html>