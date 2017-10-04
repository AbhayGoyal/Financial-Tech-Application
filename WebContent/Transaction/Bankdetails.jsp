<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Transaction/Bankdetails.css">
</head>
<body>

<div class="nav">
		<li><a href="../Bank_Work/Bank/showoptions1.jsp" class="active">Go back to options</a></li>
	
		</div>
	

<form name="Bankdetails" action="" method="post">
<br><br>
      

     <TABLE align="center" cellpadding="15" border="2" >
      	<TR>
			<TD>DEBIT AMOUNT</TD>
			<TD>CREDIT AMOUT</TD>
		</TR>
		<tr>
			<td>
				<table>
					<c:forEach var="debit" items="${debit}">
                        <tr>
                            <td>${debit}</td>
                        </tr>
                    </c:forEach>
				</table>
			</td>
			<td>
				<table>
					<c:forEach var="credit" items="${credit}">
                        <tr>
                            <td>${credit}</td>
                        </tr>
                    </c:forEach>
				</table>
			</td>
		</tr>
	</TABLE>
</form>
</body>
</html>