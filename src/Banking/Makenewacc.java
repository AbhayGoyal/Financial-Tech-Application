package Banking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Makenewacc
 */
//@WebServlet("/Makenewacc")
public class Makenewacc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Makenewacc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Making and new account 
		doGet(request, response);
		System.out.println("DO POST");
		String accno=request.getParameter("accno");
		//String pass=request.getParameter("pass");
		String select=request.getParameter("select");
		
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	     final String DB_URL="jdbc:mysql://localhost/serv";

	     System.out.println("Here1");
	      //  Database credentials
	       final String USER = "root";
	       final String PASS = "abhay";

	      // Set response content type
	      response.setContentType("text/html");
	      PrintWriter out=response.getWriter();
	      //out.println("<h1 align='center'>MAKING A NEW BANK ACCOUNT</h1>");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//mam we can aldo use 

	         // Open a connection
	         Connection conn = DriverManager.getConnection(DB_URL, "root", "abhay");

	         // Execute SQL query
	         Statement stmt = conn.createStatement();
	         //Statement stmt1=conn.createStatement();
	         String sql;
	         
	         sql="Select count(id) from bankaccount;";
	         int count=0;
	         ResultSet rs=stmt.executeQuery(sql);
	         
	         System.out.println("Here2");
	         while(rs.next())
	         {
	        	  count=rs.getInt(1);
	         }
	         
	         if(accno.isEmpty())
	         {
	        	 ServletContext servletContext=getServletContext();
					request.setAttribute("message","Enter bank account number"); 
					Bankput b=new Bankput();
					b.doGet(request, response);
			    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Bank/createbank2.jsp");
			    	 // rsd.include(request,response);
			    	  rsd.forward(request, response);
	         }
	         if(accno.length()>8 || accno.length()<8)
	         {
	        	 ServletContext servletContext=getServletContext();
	        	 request.setAttribute("message","The account number length should be exactly 8");
	        	 Bankput b=new Bankput();
					b.doGet(request, response);
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Bank/createbank2.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  return;
	         }
	         
	         String s1="Select id from bankaccount where accno='"+accno+"' and bankname='"+select+"';";
	         ResultSet rs1=stmt.executeQuery(s1);
	         int flag=0;
	         while(rs1.next())
	         {
	        	 String a=rs1.getString(1);
	        	 if(a.length()!=0)
	        	 {
	        		 flag=1;
	        		 break;
	        	 }
	         }
	         
	         if(flag==1)
	         {
	        	 ServletContext servletContext=getServletContext();
	        	 request.setAttribute("message","The account number already exists");
	        	 Bankput b=new Bankput();
					b.doGet(request, response);
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Bank/createbank2.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  return;
	         }
	         String s="INSERT INTO BANKACCOUNT VALUES("+(count+1)+",'"+accno+"','"+select+"');";
	         System.out.println(s);
	         stmt.executeUpdate(s);
	         //System.out.println(s);
	         String button1=request.getParameter("Create");
	         
	         if(button1!=null)
	         {
	        	 ServletContext servletContext=getServletContext();
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Transaction/maketransact.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  return;
	         }
	         //stmt.executeUpdate(s);
	         
	         
			
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}

		
}	

