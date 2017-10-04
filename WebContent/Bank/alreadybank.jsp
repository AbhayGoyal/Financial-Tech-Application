<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../Bank_Work/Profile/changesinprofile.css" />
</head>
<body>

	<h1>BANK HERE</h1>

	<div class="nav">
			<li><a href="Change profile" class="active">Change my profile</a></li>
			<li><a href="">Log out</a></li>
	</div>
	
	<% if(request.getAttribute("message")!=null){ %>
<center><%=(String)request.getAttribute("message") %></center>
<%} %>
<br><br>

	<form action="/Bank_Work/Alreadydo" method="post" name="alreadybankaccount">
		Bank Account Number:<input type="text" name="bankaccountnum">
		<select name="banking">
			<option value="option1"><%=(String)request.getAttribute("bank1")%></option>
			<option value="option2"><%=(String)request.getAttribute("bank2")%></option>
			<option value="option3"><%=(String)request.getAttribute("bank3")%></option>
			<option value="option4"><%=(String)request.getAttribute("bank4")%></option>
			<option value="option5"><%=(String)request.getAttribute("bank5")%></option>
		</select>
	
	</form>
</body>
</html>
