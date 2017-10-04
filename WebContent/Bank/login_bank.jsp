<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center" >Please the bank details here:</h2>
	<form name=	"loginBank" method="post" action="Bankentry">
		<p align='center'>
		Account Number:<input type="number" name="accno"><br><br>
		
		Bank name:<input type="text" name="bankname"/><br><br>
		Password:<input type="password" name="passBank"/><br><br>
		
		<input type="submit" value="Enter into my account" name="account"/>
		<input type="submit" value="Search my account" name="search"/>
		
		<%=(String)request.getAttribute("message") %>
		</p>
	</form>
</body>
</html>