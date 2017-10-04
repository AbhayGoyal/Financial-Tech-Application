<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../Bank_Work/Login/Register.css" />
</head>
<body>
<h1 class="head" align="center">BANK WITH US</h1>
<h2 align="center">Please enter the details below</h2>

<div class="firstone"><% if(request.getAttribute("message")!=null){ %>
<center><%=(String)request.getAttribute("message") %></center>
<%} %>
					
</div>
	
	<form name=	"loginForm" method="post" action="/Bank_Work/Registration">
		<p align="center">
		
		First Name:<input  type="text" name="firstname"><br><br>
		Last Name:<input class="font2" type="text" name="lastname"><br><br>
		Username:<input  class="font3" type="text" name="username"><br><br>
		Email-ID:<input  class="font4" type="email" name="email"/><br><br>
		Password:<input  class="font5" type="password" name="pass"/><br><br>
		Address:<input type="text"  class="font6" name="add"/><br><br>
		Contact No.:<input type="number"  class="font7" name="contact"/><br><br>
		Birthday:<input type="date" name="birth"/><br><br>
		<input class="button1" type="submit" value="Register" name="reg" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input class="button2" type="submit" value="Already registered.." name="already" /><br><br>
		
		
		</p>
	</form>
</body>
</html>