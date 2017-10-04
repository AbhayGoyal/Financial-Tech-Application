package Transactiondone;

import java.io.IOException;
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
 * Servlet implementation class Previoustransact
 */
//@WebServlet("/Previoustransact")
public class Previoustransact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Previoustransact() {
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
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	     final String DB_URL="jdbc:mysql://localhost/serv";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//mam we can aldo use 

	         // Open a connection
	         Connection conn = DriverManager.getConnection(DB_URL, "root", "abhay");

	         // Execute SQL query
	         Statement stmt = conn.createStatement();
	         
	         String s="Select bank from bankname";
	         
	         ResultSet rs=stmt.executeQuery(s);
	         ArrayList<String> bankname=new ArrayList<String>();
	        		 
	         while(rs.next())
	         {
	        	 String s1=rs.getString(1);
	        	 bankname.add(s1);
	         }
	         
	         request.setAttribute("bankname", bankname);
	         request.getRequestDispatcher("/Transaction/index1.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			
		}

	}

}
