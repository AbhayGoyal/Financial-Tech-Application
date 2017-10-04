package Banking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class selectchoice
 */
//@WebServlet("/selectchoice")
public class Selectchoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Selectchoice() {
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
		try
		{
		
		String button1=request.getParameter("prev");
		String button2=request.getParameter("make");
		
		if(button1!=null)
		{
			ServletContext servletContext=getServletContext();
			//request.setAttribute("message","");
	    	  //RequestDispatcher rsd=servletContext.getRequestDispatcher("Previoustransact");
	    	 // rsd.include(request,response);
	    	  request.getRequestDispatcher("Previoustransact").forward(request, response);
		}
		if(button2!=null)
		{
			ServletContext servletContext=getServletContext();
			request.setAttribute("message","");
			RequestDispatcher rsd=servletContext.getRequestDispatcher("/Transaction/maketransact.jsp");
	    	 // rsd.include(request,response);
	    	  rsd.forward(request, response);
	    	  return;
		}
		}
		catch(Exception e)
		{}
		
	}

}
