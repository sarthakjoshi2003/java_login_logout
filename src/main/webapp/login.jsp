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
	if (value)
	response.sendRedirect(request.getContextPath()+"/member_area?action=welcome");
	
}%>
<% if (request.getParameter("error")!=null){

	out.print(request.getParameter("error"));
}


%>
<form action="<%=request.getContextPath()%>/member_area" method="post">
<h1>username</h1><input type="text" name="username" value="null">
<br>
<h1>password</h1><input type="password" name="password" >
<br>
<input type="submit" value="submit">

</form>
<h2> do not have an account move to <a href="<%=request.getContextPath() %>/general?action=signup">signup</a></h2>

</body>
</html>