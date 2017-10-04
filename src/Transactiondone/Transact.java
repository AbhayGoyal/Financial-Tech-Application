package Transactiondone;

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
 * Servlet implementation class maketransact
 */
//@WebServlet("/maketransact")
public class Transact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transact() {
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
		
		String button2=request.getParameter("prevtransact");
		 if(button2!=null)
         {
        	 
        	 ServletContext servletContext=getServletContext();
	    	  //RequestDispatcher rsd=servletContext.getRequestDispatcher("Previoustransact");
	    	 // rsd.include(request,response);
	    	  request.getRequestDispatcher("Previoustransact").forward(request, response); 
	    	  return;
         }
		 
		String accno=request.getParameter("accno");
		//int acc=Integer.parseInt(accno);
		String type=request.getParameter("typeoftransact");
		String amtcheck=request.getParameter("amount");
		
		int debitamount=0,creditamount=0;
		try
		{
			//System.out.println("msg0");
			final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
		     final String DB_URL="jdbc:mysql://localhost:3306/serv";
			
		    /*if((type.equals("Debit") || (type.equals("Credit"))))
		    {
		    	ServletContext servletContext=getServletContext();
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Login/wrongdet.html");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    }*/
		     
		    // System.out.println("msg00");
		     Class.forName("com.mysql.jdbc.Driver");
		     //System.out.println("msg01");
				Connection conn = DriverManager.getConnection(DB_URL, "root", "abhay");
				//System.out.println("msg02");
				//int tot=0;
		         // Execute SQL query
		         Statement stmt = conn.createStatement();
		     
		         //System.out.println("msg0000"); 
		         
		     if(accno.isEmpty())
		     {
		    	 
		    	 /*ServletContext servletContext=getServletContext();
	    		 request.setAttribute("message","The account number has not been entered"); 
	    		 RequestDispatcher rsd=servletContext.getRequestDispatcher("/Transaction/maketransact.jsp");
	    		 rsd.forward(request, response);
	    		 return;*/
		    	 request.setAttribute("message","The account number has not been entered"); 
		    	 RequestDispatcher rsd = request.getRequestDispatcher("/Transaction/maketransact.jsp");
		    	 rsd.forward(request, response);
		    	 return;
		    	 
		     }
		     
		     //System.out.println("msg here");
		     
	        
		     
		    	 if(amtcheck.isEmpty())
		    	 {
		    		 ServletContext servletContext=getServletContext();
		    		 request.setAttribute("message","Enter amount");
		    		 RequestDispatcher rsd=servletContext.getRequestDispatcher("/Transaction/maketransact.jsp");
		    		 rsd.forward(request, response);
		    		 return;
		    	 }
		    	 //ServletContext servletContext=getServletContext();
	        	 //request.setAttribute("message","The number should of 10 digits"); 
		    	  
		    	//System.out.println("msg here1");
		    	 long amount1=Long.parseLong(amtcheck);
		    	// System.out.println("msg here00");
		    	 
		    	 //System.out.println(type);
		    	 
		    if(type==null)
		     {
		    	ServletContext servletContext=getServletContext();
	    		 request.setAttribute("message","Select the type of transaction");
	    		 RequestDispatcher rsd=servletContext.getRequestDispatcher("/Transaction/maketransact.jsp");
	    		 rsd.forward(request, response); 
	    		 return;
		     }
		     else
		     {
		    	 
		     }
		     
		     //System.out.println("msg here1");
		     String accsearch="Select id from bankaccount where accno='"+accno+"';";
		     ResultSet rsse=stmt.executeQuery(accsearch);
		     //System.out.println("msg here2");
		     
		     while(rsse.next())
		     {
		    	 String id=rsse.getString(1);
		    	 if(id.isEmpty())
		    	 {
		    		 ServletContext servletContext=getServletContext();
		    		 request.setAttribute("message","The bankaccount does not exists. Make account first");
		    		 RequestDispatcher rsd=servletContext.getRequestDispatcher("/Transaction/maketransact.jsp");
		    		 rsd.forward(request, response);
		    		 return;
		    	 }
		     }
		     
		     if(amount1>100000)
	       	 {
	       		ServletContext servletContext=getServletContext();
	       		request.setAttribute("message","The amount should not be more than 100000.Re-enter value"); 
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Transaction/maketransact.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  return;
	       	 }
		     
		     int amount=(int)(long)amount1;
		     
		    if(type.equals("Debit"))
			{
				debitamount=amount;
				creditamount=0;
			}
		    
			if(type.equals("Credit"))
			{
				creditamount=amount;
				debitamount=0;
			}
			
			
	         
	         String gethas="Select accno from bankaccount where accno='"+accno+"';";
	         
	         ResultSet rs1=stmt.executeQuery(gethas);
	         int flag=0;double total=0;
	         while(rs1.next())
	         {
	        	String gets=rs1.getString(1);
	        	if(gets.equals(accno))
	        	{
	        		flag=1;
	        	}
	         }
	         if(flag==0)
	         {
	        	 ServletContext servletContext=getServletContext();
	        	 request.setAttribute("message","The account does not exist"); 
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Transaction/maketransact.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  return;
	         }
	         
	         
	         
	         //System.out.println("msg1");
	         String gethas1="Select total from transactions where accno='"+accno+"';";
        	 ResultSet rs2=stmt.executeQuery(gethas1);
        	 int debamt=0,creditamt=0;
        	 
        	 while(rs2.next())
        	 {
        		 total=rs2.getDouble(1);
        		 System.out.println("in here"+total);
        		 //debamt=rs2.getInt(1);
        		 //creditamt=rs2.getInt(2);
        	 }
	         
	       	 if(total<debitamount)
	        	 {
	        		 ServletContext servletContext=getServletContext();
	        		 request.setAttribute("message","The total is less than  the amount yo want to debit"); 
			    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Transaction/maketransact.jsp");
			    	 // rsd.include(request,response);
			    	  rsd.forward(request, response);
			    	  return;
	        	 }
	        	 //tot=tot+creditamount-debitamount;
	        	 //System.out.println(tot);
	       	//System.out.println("msg2");
	       	
	       	 if(debitamount>total)
	       	 {
	       		ServletContext servletContext=getServletContext();
	        	 request.setAttribute("message","The balance is not sufficient"); 
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Transaction/maketransact.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  return;
	       	 }
	       	 
	       	 
	       	 
	      
	         String getval="Select count(id) from transactions;";
	         ResultSet rs=stmt.executeQuery(getval);
	         int count=0;
	         while(rs.next())
	         {
	        	count=rs.getInt(1);
	         }
	         //System.out.println("msg3");
	         
	         total=total+creditamount-debitamount;
	         //System.out.println("thi si"+total);
	         String s="Insert into transactions values("+(count+1)+","+debitamount+","+creditamount+","+total+",'"+accno+"');";
	         //System.out.println(s);
	         //System.out.println("Reached here");
	         stmt.executeUpdate(s);
	         
	         PrintWriter out=response.getWriter();
	         //out.println("<h1 align='center'>THE TRANSACTION HAS BEEN MADE</h1>");
	         /*ServletContext servletContext=getServletContext();
	    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Bank/alreadybank.html");
	    	 // rsd.include(request,response);
	    	  rsd.forward(request, response);
	         */
	        // PrintWriter out=response.getWriter();
	         String button1=request.getParameter("transact");
	         
	         
	         //System.out.println("msg4");
	         if(button1!=null)
	         {
	        	 //System.out.println("Reached here too");
	        	 ServletContext servletContext=getServletContext();
		    	  RequestDispatcher rsd=servletContext.getRequestDispatcher("/Transaction/move2.jsp");
		    	 // rsd.include(request,response);
		    	  rsd.forward(request, response);
		    	  return;
	        	 //out.println("<h1>THANK YOU FOR BANKING WITH US</h1>");
	         }
	         
	        
	         
	         //System.exit(0);
	         
		}
		catch(Exception e)
		{
			PrintWriter out=response.getWriter();
			//System.out.println("Error here");
			out.println(e.getStackTrace());
		}
		
		
	}

}
