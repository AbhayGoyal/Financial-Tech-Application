package Changes;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileSelection
 */
//@WebServlet("/ProfileSelection")
public class ProfileSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileSelection() {
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
		System.out.println("DO POST");
		String button1=request.getParameter("profilemod");
		String button2=request.getParameter("changepass");
		String button3=request.getParameter("logout");
		
		if(button1!=null)
		{
			 ServletContext servletContext=getServletContext();
	    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Profile/changedprofile.jsp");
	    	 // rsd.include(request,response);
	    	  rsd.forward(request, response);
	    	  return;
		}
		
		if(button2!=null)
		{
			 ServletContext servletContext=getServletContext();
	    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Profile/changepass.jsp");
	    	 // rsd.include(request,response);
	    	  rsd.forward(request, response);
	    	  return;
		}
		
		if(button3!=null)
		{
			request.getSession().invalidate();
		}
		
		
	}

}
