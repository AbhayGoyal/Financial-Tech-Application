package Changes;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Passchange
 */
//@WebServlet("/Passchange")
public class Passchange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Passchange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get passchange");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("passchange");
		doGet(request, response);
		
		//String use=request.getParameter("use");
		String old=request.getParameter("oldpass");
		String new1=request.getParameter("pass1");
		String new2=request.getParameter("pass2");
		String button1=request.getParameter("Change");
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	     final String DB_URL="jdbc:mysql://localhost:3306/serv";
	     
	     HttpSession session=request.getSession();
			String use=(String)session.getAttribute("username");
			System.out.println(use);
		
		try
		{
			
			if(old.isEmpty() || new1.isEmpty() || new2.isEmpty())
			{
				ServletContext servletContext=getServletContext();
				request.setAttribute("message","Enter all the fields"); 
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Profile/changepass.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  return;
			}
			
			if(new1.length()>10)
			{
				ServletContext servletContext=getServletContext();
				request.setAttribute("message","Passwords should be of maximum 10 characters length"); 
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Profile/changepass.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  return;
			}
			
			if(!new1.equals(new2))
			{
				ServletContext servletContext=getServletContext();
				request.setAttribute("message","Passwords are not same"); 
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Profile/changepass.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  return;
		    	  
			}
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, "root", "abhay");
			Statement stmt = conn.createStatement();
			String sq= "Select pass from servlet where username='"+use+"'";
			ResultSet rs=stmt.executeQuery(sq); int flag=0;
			while(rs.next())
			{
				String p=rs.getString(1);
				System.out.println(p);
				if(p.equals(old))
				{
					flag=1;
					break;
				}
				
			}
			
			
			if(flag==1 && button1!=null)
			{
				String s2="Update servlet set pass='"+new1+"' where username='"+use+"'";
				
				stmt.executeUpdate(s2);
				//System.out.println("Updation done");
				ServletContext servletContext=getServletContext();
				request.setAttribute("message",""); 
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Bank/showoptions1.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  return;
			}
			else
			{
				ServletContext servletContext=getServletContext();
				request.setAttribute("message","Passwords do not match"); 
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Profile/changepass.jsp");
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
