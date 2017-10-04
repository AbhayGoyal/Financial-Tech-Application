<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="logout.css">
</head>
<body>
<h1>ARE YOU SURE YOU WANT TO LOGOUT?</h1>

<center><input class="button1" type="submit" value="LOG ME OUT" name="back" onclick="myFunction()"></center>
<script type="text/javascript">
	function myFunction()
	{
		window.location="../Transaction/move2.jsp";	
	}
</script>
</body>
</html>