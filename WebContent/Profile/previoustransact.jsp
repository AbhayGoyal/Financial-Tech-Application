<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% if(request.getAttribute("message")!=null){ %>
<center><%=(String)request.getAttribute("message") %></center>
<%} %>
	<form name="previoustransact" method="post" action="prev">
		<p align='center'>
			<h1 align="center">PREVIOUS TRANSACTIONS</h1>
			Account Number:-<input type="number" name="accno"/><br><br>
			<textarea  rows="100" cols="100"></textarea>
	    </p>
	    
	</form>
	
</body>
</html>