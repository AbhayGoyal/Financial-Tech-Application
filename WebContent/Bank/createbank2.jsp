<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../Bank_Work/Bank/createbank.css">
</head>
<body>

<div class="nav">
		<li><a href="../Bank_Work/Profile/changedprofile.jsp" class="active">Change profile</a></li>
		
		<li><a href="../Bank_Work/Login/Login.jsp" >Login</a></li>
		
		<li><a href="../Bank_Work/Profile/changepass.jsp" id="fourth">Change password</a></li>		
	
		</div>

<div class="error"><% if(request.getAttribute("message")!=null){ %>
<center><%=(String)request.getAttribute("message") %></center>
<%} %></div>
<br><br>
<center>
<form name="createbank" action="Makenewacc" method="post">

Account No:<input type="text" name="accno"><br><br>
      
      <select name="select">
      <c:forEach var = "row" items = "${bankname}">
               <option value="${row}">${row}</option>
         </c:forEach>
         </select><br><br>
         <input type="submit" name="Make" value="Make my account">

</form></center>
</body>
</html>