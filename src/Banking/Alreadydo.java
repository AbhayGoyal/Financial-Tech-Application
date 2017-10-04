package Banking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Alreadydo
 */
//@WebServlet("/Alreadydo")
public class Alreadydo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alreadydo() {
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
		doGet(request, response);
		//Already registered bank to be searched here
		
		

	      // Set response content type
	      response.setContentType("text/html");
	      PrintWriter out=response.getWriter();
		
		try
		{
			final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	 	     final String DB_URL="jdbc:mysql://localhost/serv";
			Class.forName("com.mysql.jdbc.Driver");//mam we can aldo use 

	         // Open a connection
	         Connection conn = DriverManager.getConnection(DB_URL, "root", "abhay");

	         // Execute SQL query
	         Statement stmt = conn.createStatement();
	         //Statement stmt1=conn.createStatement();
	         String sql,s1;
	         s1="Select * from bankname";
	         ArrayList <String> banks=new ArrayList<String>();
	         ResultSet rs=stmt.executeQuery(s1);
	         
	         while(rs.next())
	         {
	        	 String s=rs.getString(1);
	        	 banks.add(s);
	         }
	         
	         int c=banks.size();
	         
	         
	         
	         ServletContext servletContext=getServletContext();
				request.setAttribute("message","Enter username");
	         for(int i=0;i<c;i++)
	         {
	        	 request.setAttribute("banki", banks.get(i));
	         }
	          
	         RequestDispatcher rsd=servletContext.getRequestDispatcher("/Bank/alreadybank.jsp");
		    	 // rsd.include(request,response);
		      rsd.forward(request, response);
		      
	         
	        
	         String accno=request.getParameter("accno");
	 		 String bank=request.getParameter("Bankname");
	 		
	 		

	 	      //  Database credentials
	 	       //final String USER = "root";
	 	       //final String PASS = "abhay";
	 	       
	         sql="Select accno,bankname from bankaccount where accno='"+accno+"' and bankname='"+bank+"';";
	         System.out.println(sql);
	         
	         ResultSet rs1=stmt.executeQuery(sql);
	         while(rs1.next())
	         {
	        	 String f1=rs.getString(1);
	        	 String f2=rs.getString(2);
	         }
	         
	         
	         RequestDispatcher rd=request.getRequestDispatcher("/Transaction/maketransact.jsp");
	         rd.forward(request, response);
	         return;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		/*String d1=request.getParameter("search");
		String d2=request.getParameter("account");
		
		if(d1!=null)
		{
			RequestDispatcher rs1=request.getRequestDispatcher("search.html");
			rs1.forward(request, response);
		}
		if(d2!=null)
		{
			RequestDispatcher rs2=request.getRequestDispatcher("transacthistory.html");
			rs2.forward(request, response);
		}
		String accno=request.getParameter("accno");
		String bank=request.getParameter("bank");
		
		*/
	}
}
