package Transactiondone;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class move
 */
//@WebServlet("/move")
public class Move extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Move() {
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
		String button1=request.getParameter("backtooptions");
		
		//String val=request.getParameter("accno");
		//JOptionPane.showMessageDialog(null,"Error here");
		
		/*if(val.isEmpty())
		{
			ServletContext servletContext=getServletContext();
			request.setAttribute("message","Enter the account number");  
			RequestDispatcher rsd=servletContext.getRequestDispatcher("/Transaction/index1.jsp");
	    	 // rsd.include(request,response);
	    	  rsd.forward(request, response);
		}*/
		if(button1!=null)
		{
			ServletContext servletContext=getServletContext();
	    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Login/Login.jsp");
	    	  //request.setAttribute("accno",val);
	    	  
	    	 // rsd.include(request,response);
	    	  rsd.forward(request, response);
	    	  return;
		}
	}

}
