package RegisterandLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Bankentry
 */
//@WebServlet("/Bankentry") no need for this annotation
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//Searching for an account 
		//System.out.println("DO POST");
		PrintWriter out=response.getWriter();
		//out.println("<h1 align='center'>LOGIN</h1>");
		String em=request.getParameter("email");
		String pass=request.getParameter("pass");
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	     final String DB_URL="jdbc:mysql://localhost:3306/serv";
	     
		try
		{
			if(em.isEmpty())
			{
				ServletContext servletContext=getServletContext();
				request.setAttribute("message","Enter username"); 
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Login/Login.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  return;
			}
			else if(pass.isEmpty())
			{
				ServletContext servletContext=getServletContext();
				request.setAttribute("message","Enter password"); 
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Login/Login.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  return;
			}
			
			else
			{
				
			}
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, "root", "abhay");
			Statement stmt = conn.createStatement();
			String sq="Select emailid,pass from servlet where emailid='"+em+"'and pass='"+pass+"';";
			//System.out.println(sq);
			
			String sq1="Select emailid from servlet where emailid='"+em+"';";
			//System.out.println(sq1);
			ResultSet rs2=stmt.executeQuery(sq1);int c=0;
			while(rs2.next())
			{
				String val=rs2.getString(1);
				if(val==null)
				{
					c=1;
				}
			}
			
			if(c==1)
			{
				ServletContext servletContext=getServletContext();
				request.setAttribute("message","The email id does not exist. Register first"); 
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Login/Login.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
			}
			
			
			ResultSet rs=stmt.executeQuery(sq);
			String getem="",getpass;int flag=0;
			
			
					
			while(rs.next())
			{
				 getem=rs.getString(1);
				 getpass=rs.getString(2);
				 //System.out.println(getem);
				 //System.out.println(getpass);
				 
				 if(getem.isEmpty() && getpass.isEmpty())
				 {
					 flag=2;
					 break;
				 }
				if(em.equals(getem) && pass.equals(getpass))
				{
					//System.out.println("Welcome");
					flag=1;
				}
				
				
			}
			
			response.setContentType("text/html");
			
			String button1=request.getParameter("alread");
			if(button1!=null && flag==1)
			{
				ServletContext servletContext=getServletContext();
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Bank/showoptions1.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  String wal="";
		    	  String sql="Select username from servlet where emailid='"+em+"' and pass='"+pass+"';";
		    	  ResultSet rsp1=stmt.executeQuery(sql);
		    	  while(rsp1.next())
		    	  {
		    		  wal=rsp1.getString(1);
		    	  }
		    	  HttpSession session=request.getSession();
		    	  session.setAttribute("username",wal);
		    	  System.out.println(wal);
		    	  return;
			}
			else if(flag==0)
			{
				ServletContext servletContext=getServletContext();
				request.setAttribute("message","The password and email id do not match"); 
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Login/Login.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  return;
			}
			
			if(flag==2)
			{
				ServletContext servletContext=getServletContext();
				request.setAttribute("message","Create an account first"); 
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Login/Login.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  return;
			}
		}
		catch(Exception e)
		{
			
		}
		
		
	}

}
