package Transactiondone;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Showaccdetails
 */
//@WebServlet("/Showaccdetails")
public class Showaccdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Showaccdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String name=request.getParameter("accno");
		
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	     final String DB_URL="jdbc:mysql://localhost/serv";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//mam we can aldo use 

	         // Open a connection
	         Connection conn = DriverManager.getConnection(DB_URL, "root", "abhay");

	         // Execute SQL query
	         Statement stmt = conn.createStatement();
	         
	         String QueryString = "SELECT transactions.debitamount,transactions.creditamount from transactions,bankaccount where transactions.accno= '"+name+"' and transactions.accno=bankaccount.accno;";
	         
	         ResultSet rs=stmt.executeQuery(QueryString);
	         
	         ArrayList <Integer> debit=new ArrayList<Integer>();
	         ArrayList <Integer> credit=new ArrayList<Integer>();
	         
	         while(rs.next())
	         {
	        	 int deb=rs.getInt(1);
	        	 int cre=rs.getInt(2);
	        	 debit.add(deb);
	        	 credit.add(cre);
	         }
	         
	         request.setAttribute("debit", debit);
	         request.setAttribute("credit", credit);
	         request.getRequestDispatcher("/Transaction/Bankdetails.jsp").forward(request, response);
	         /*PrintWriter out=response.getWriter();
	         
	         
	         out.println("<TABLE align='center' cellpadding='15' border='2'>");
	         out.println("<TR>");
	         out.println("<TD>DEBIT AMOUNT</TD>");
	         out.println("<TD>CREDIT AMOUT</TD>");
	         out.println("</TR>");
	         while(rs.next())
	         {
	        	 out.println("<TR>");
	        	 out.println("<TD>"+rs.getInt(1)+"</TD>");
	        	 out.println("<TD>"+rs.getInt(2)+"</TD>");
	        	 out.println("</TR>");
	         }
	         out.println("<TABLE>");*/
		}
		
		catch(Exception e)
		{
			
		}
	}

}
