<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/Transaction/maketransact.css"/>" />
</head>

<body>

<div class="nav">
		<li><a href="../Profile/changedprofile.jsp" class="active">Change profile</a></li>
		
		<li><a href="../Profile/changepass.jsp" >Change password</a></li>
		
		<li><a href="../Login/Login.jsp" >Login</a></li>
		
		
		<li><a href="../Logout/logout.jsp" id="fourth">Logout</a></li>		
	
		</div>
	
	
	<% if(request.getAttribute("message")!=null){ %>
<center><%=(String)request.getAttribute("message") %></center>
<%} %>
	
		<form name=	"loginBank" method="post" action="/Bank_Work/Transact">
			<h1 align="center">THE TRANSACTION</h1>
				<center>
				<div class="acc">Account No:-</div><input type="text" name="accno"><br><br>
				<div class="am">Amount:-</div><input type="number" name="amount"><br><br>
				<input type="radio" name="typeoftransact" value="Debit" class="radio1"><div class="debit">Debit</div><br><br>
				<input type="radio" name="typeoftransact" value="Credit"><div class="credit">Credit</div><br><br>
				<input type="submit" value="Make transaction" name="transact" class="button1">
				<input type="submit" value="Show previous transactions" name="prevtransact" class="button2">
				</center>
			
		</form>	


</body>
</html>