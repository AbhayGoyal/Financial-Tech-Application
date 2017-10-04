<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../Profile/changedprofile.css" />
</head>
<body>

<h1>BANK HERE</h1>

	<div class="nav">
	
		<li><a href="../Profile/changepass.jsp" class="active" >Change password</a></li>
		<li><a href="../Login/Login.jsp" >Login page</a></li>
		<li><a href="../Transaction/maketransact.jsp" >Go to my bank account</a></li>
		<li><a href="../Logout/logout.jsp" >Logout</a></li>
	
	</div>
	
	<% if(request.getAttribute("message")!=null){ %>
<center><%=(String)request.getAttribute("message") %></center>
<%} %>
<br><br>

<form action="/Bank_Work/Profilechange" method="post" name="changedprofile">
	
	<center>
	<div class="firstname"><b>First name:-</b></div><input type="text" name="first"><br><br>
	<div class="secondname"><b>Last name:-</b></div><input type="text" name="last"><br><br>
	<div class="em"><b>Email-Id:-</b></div><input type="email" name="email"><br><br>
	<div class="add"><b>Address:-</b></div><input type="text" name="add"><br><br>
	<div class="ag"><b>Age:-</b></div><input type="number" name="age"><br><br>
	<input type="submit" name="change" value="Change my details" class="button">
	</center>
	</div>
</form>
</body>
</html>