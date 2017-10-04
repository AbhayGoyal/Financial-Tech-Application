<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Bank/showoptions1.css" />
</head>
<body>

		<div class="nav">
		
				<li><a href="../Bank_Work/Profile/changepass.jsp" class="active">Change password</a></li>		
				<li><a href="../Bank_Work/Profile/changedprofile.jsp" >Change profile</a></li>
				<li><a href="Bankput" >Make a new bank account</a></li>
				<li><a href="../Bank_Work/Logout/logout.jsp" >Logout</a></li>
		
		</div>
		
	<form name=	"showoptions1" method="post" action="Selectchoice">
		<p align="center">
			<input class="one" type="submit" value="See previous transactions" name="prev">
			<input class="two" type="submit" value="Make transaction" name="make">
		</p>
		
	</form>


</body>
</html>