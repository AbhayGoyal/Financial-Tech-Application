<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="changepass.css">
</head>
<body>

<div><% if(request.getAttribute("message")!=null){ %>
<center><%=(String)request.getAttribute("message") %></center>
<%} %>
</div class="first">

	<div class="nav">
		<li><a href="../Transaction/maketransact.jsp" class="active">Go to my bank account</a></li>
		
		<li><a href="../Profile/changedprofile.jsp" >Change profile</a></li>
		
		
		
		<li><a href="../Logout/logout.jsp" >Logout</a></li>
		
	</div>
	
	
<form name="changepassword" method="post" action="/Bank_Work/Passchange">
	
	Old password:-<input type="password" name="oldpass"><br><br>
	New password:-<input type="password" name="pass1"><br><br>
	Confirm password:-<input type="password" name="pass2"><br><br>
	<input class="button" type="submit" value="Change the password" name="Change" ><br><br>
</form>
</body>
</html>