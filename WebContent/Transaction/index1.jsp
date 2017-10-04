<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<HTML>
    <HEAD>
        <TITLE>Database Lookup</TITLE>
        <link rel="stylesheet" type="text/css" href="../Bank_Work/Transaction/index.css">
    </HEAD>
     
    <BODY>
    
    <div class="nav">
		<li><a href="../Bank_Work/Profile/changepass.jsp" class="active">Change password of profile</a></li>
	
		<li><a href="../Bank_Work/Profile/changedprofile.jsp">Change profile details</a></li>
		
		<li><a href="../Bank_Work/Login/Login.jsp">Login</a></li>
		
		<li><a href="Bankput">Make bank account</a></li>
		
		<li><a href="../Bank_Work/Logout/logout.jsp">Logout</a></li>
		</div>
	
	
	<% if(request.getAttribute("message")!=null){ %>
<center><%=(String)request.getAttribute("message") %></center>
<%} %>
        <H1 align="center">Database Lookup for previous details</H1>
        <center>
        <FORM  METHOD="POST"  ACTION="Showaccdetails" name="index1">
            <div class="acc">Please enter the Account number:</div>
            <INPUT TYPE="text" NAME="accno"><br><br>
            <select name="banks">
      <c:forEach var = "row" items = "${bankname}">
               <option value="${row}">${row}</option>
         </c:forEach>
         </select><br><br>
         <input type="submit" name="find" value="Find my transactions">
         </FORM>
         </center>
         </BODY>
         </HTML>
            
            