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

import RegisterandLogin.Registration;

/**
 * Servlet implementation class Profilechange
 */
//@WebServlet("/Profilechange")
public class Profilechange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profilechange() {
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
		//System.out.println("DO POST");
		
		String button1=request.getParameter("change");
		//System.out.println("Here1");
		//String user=request.getParameter("user");
		String first=request.getParameter("first");
		String last=request.getParameter("last");
		String add=request.getParameter("add");
		String contact=request.getParameter("email");
		String age=request.getParameter("age");
		//String birth=request.getParameter("birth");
			
		//login_1 l=new login_1();
		//String s=l.getUsername();
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("username");
		//System.out.println(user);
		
		
		
		try
		{
			
			final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
		     final String DB_URL="jdbc:mysql://localhost:3306/serv";
		     Class.forName("com.mysql.jdbc.Driver");
		     Connection conn = DriverManager.getConnection(DB_URL, "root", "abhay");
		     Statement stmt = conn.createStatement();
		     
			String sq="Update servlet set ";
			//System.out.println("Inside try");
			
			/*if(user.isEmpty())
			{
				ServletContext servletContext=getServletContext();
       		 request.setAttribute("message","Enter the username"); 
       		 RequestDispatcher rsd=servletContext.getRequestDispatcher("/Profile/errors.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
			}*/
			
			//String button1=(String)request.getParameter("change");
			
			//stmt.executeUpdate(sq);
		
			if(button1!=null)
			{
				//System.out.println("checking button");
				if(add.isEmpty() && contact.isEmpty() && first.isEmpty() && last.isEmpty() && age.isEmpty())
				{
					ServletContext servletcontext=getServletContext();
					request.setAttribute("message", "No changes has been made");
					RequestDispatcher rd=servletcontext.getRequestDispatcher("Profile/changedprofile.jsp");
					//request.getRequestDispatcher("../Bank_Work/Profile/changedprofile.jsp").forward(request, response);
					rd.forward(request, response);
					return;
				}
				if(!add.isEmpty())
				{
					
					String sql=sq+"address='"+add+"' where username='"+user+"';";;
					//stmt.executeUpdate(sql);
					//System.out.println(sql);
					stmt.addBatch(sql);
					//sq=sq+
					//ServletContext servletcontext=getServletContext();
					//request.setAttribute("message", "The record has been updated");
					//RequestDispatcher rd=servletcontext.getRequestDispatcher("/Transaction/move2.jsp");
					//rd.forward(request, response);
					//System.out.println("Done1");
					
				}
				
				//stmt.executeUpdate(sql);
				
				if(!contact.isEmpty())
				{
					//int contact1=Integer.parseInt(contact);
					String sql=sq+"emailid= '"+contact+"' where username='"+user+"';";
					//stmt.executeUpdate(sql);
					//System.out.println(sql);
					stmt.addBatch(sql);
					//sq=sq+
					//ServletContext servletcontext=getServletContext();
					//request.setAttribute("message", "The record has been updated");
					//RequestDispatcher rd=servletcontext.getRequestDispatcher("/Transaction/move2.jsp");
					//rd.forward(request, response);
					//System.out.println("Done1");
					
				}
				
				//stmt.executeUpdate(sq);
				
				if(!age.isEmpty())
				{
					int age1=Integer.parseInt(age);
					//int contact1=Integer.parseInt(contact);
					String sql=sq+"age= "+age1+" where username='"+user+"';";
					//stmt.executeUpdate(sql);
					if(age1<18 || age1>80)
					{
						ServletContext servletcontext=getServletContext();
						request.setAttribute("message", "The age should be between 18 and 80");
						RequestDispatcher rd=servletcontext.getRequestDispatcher("/Profile/changedprofile.jsp");
						rd.forward(request, response);
					}
					System.out.println(sql);
					stmt.addBatch(sql);
					//sq=sq+
					//ServletContext servletcontext=getServletContext();
					//request.setAttribute("message", "The record has been updated");
					//RequestDispatcher rd=servletcontext.getRequestDispatcher("/Transaction/move2.jsp");
					//rd.forward(request, response);
					//sq=sq+"age="+age1+" where username='"+user+"';";
					//System.out.println("Done1");
				}
				
				if(!first.isEmpty())
				{
					//int age1=Integer.parseInt(age);
					//int contact1=Integer.parseInt(contact);
					String sql=sq+"firstname= '"+first+"' where username='"+user+"';";
					//stmt.executeUpdate(sql);
					//System.out.println(sql);
					stmt.addBatch(sql);
					//sq=sq+
					//ServletContext servletcontext=getServletContext();
					//request.setAttribute("message", "The record has been updated");
					//RequestDispatcher rd=servletcontext.getRequestDispatcher("/Transaction/move2.jsp");
					//rd.forward(request, response);
					//sq=sq+"age="+age1+" where username='"+user+"';";
					//System.out.println("Done1");
				}
				
				if(!last.isEmpty())
				{
					//int age1=Integer.parseInt(age);
					//int contact1=Integer.parseInt(contact);
					String sql=sq+"lastname= '"+last+"' where username='"+user+"';";
					//stmt.executeUpdate(sql);
					//System.out.println(sql);
					stmt.addBatch(sql);
					//sq=sq+
					//ServletContext servletcontext=getServletContext();
					//request.setAttribute("message", "The record has been updated");
					//RequestDispatcher rd=servletcontext.getRequestDispatcher("/Transaction/move2.jsp");
					//rd.forward(request, response);
					//sq=sq+"age="+age1+" where username='"+user+"';";
					//System.out.println("Done1");
				}
				
				int[] done=stmt.executeBatch();
				//System.out.println(done+"here");
				//System.out.println("here");
					ServletContext servletcontext=getServletContext();
					request.setAttribute("message", "The record has been updated");
					RequestDispatcher rd=servletcontext.getRequestDispatcher("/Transaction/move2.jsp");
					rd.forward(request, response);
				
				
			}
			
		     
		}
		catch(Exception e)
		{
			
		}
			
		
	}

}
