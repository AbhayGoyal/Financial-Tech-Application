<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="Login/login.css" />" />
</head>
<body>
<h1 class="head">BANK HERE</h1>

	
	<div class="for"><form name="alreadydone" method="post" action="Login">
			<h1>LOGIN</h1>
			<div style="color: red; font-size: 120%; padding-top: -50px; "><b><% if(request.getAttribute("message")!=null){ %>
<center><%=(String)request.getAttribute("message") %></center>
<%} %></b></div><br><br>
			<div class="em"><b>Username:</b></div><input type="text" name="email"/><br><br>
			<div class="pa"><b>Password:</b></div><input type="password" name="pass"/><br><br>
			<input type="submit" value="ENTER" name="alread" class="button"><br><br>
			
		</center>
	</form></div>
</body>
</html>