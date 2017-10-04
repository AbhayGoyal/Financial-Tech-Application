package RegisterandLogin;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.*;
//import javax.mail.*;
//import javax.mail.internet.*;
import java.util.Date;

import javax.net.ssl.SSLSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Banking.Bankput;

/**
 * Servlet implementation class login_1
 */

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("DO GET");

		String s1 = request.getParameter("name");
		String s2 = request.getParameter("username");
		String s3 = request.getParameter("pass");
		/*
		 * final String JDBC_DRIVER="com.mysql.jdbc.Driver"; final String
		 * DB_URL="jdbc:mysql://localhost/serv";
		 * 
		 * // Database credentials final String USER = "root"; final String PASS
		 * = "abhay";
		 * 
		 * // Set response content type response.setContentType("text/html");
		 * PrintWriter out = response.getWriter(); try{ // Register JDBC driver
		 * Class.forName("com.mysql.jdbc.Driver");
		 * 
		 * // Open a connection Connection conn =
		 * DriverManager.getConnection(DB_URL, USER, PASS);
		 * 
		 * // Execute SQL query Statement stmt = conn.createStatement(); String
		 * sql; sql = "SELECT * FROM servlet"; ResultSet rs =
		 * stmt.executeQuery(sql);
		 * 
		 * // Extract data from result set while(rs.next()){ //Retrieve by
		 * column name int id = rs.getInt("id"); int age = rs.getInt("age");
		 * String first = rs.getString("first"); String last =
		 * rs.getString("last"); out.println(id); out.println(age);
		 * out.println(first); out.println(last); } } catch (Exception e) {
		 * System.out.println(e.getMessage()); }
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/*
	 * public String usern="";
	 * 
	 * public String getUsername() { return usern; }
	 * 
	 * public void sendusername(String username) { usern=username; }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		// String forwardPage="";
		System.out.println("DO POST");

		String button2 = request.getParameter("already");
		if (button2 != null) {
			/*
			 * RequestDispatcher
			 * rsd=request.getRequestDispatcher("/alreadyreg.html");
			 * rsd.include(request,response);
			 */
			ServletContext servletContext = getServletContext();
			request.setAttribute("message", "");
			RequestDispatcher rsd = servletContext.getRequestDispatcher("/Login/Login.jsp");
			// rsd.include(request,response);
			rsd.forward(request, response);
			return;
		}

		try {

			// String age=request.getParameter("age");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String agec;
			int age;
			double cont;
			String contact = request.getParameter("contact");

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			//System.out.println(dateFormat.format(date));
			String birth = request.getParameter("birth");
			// String pass=request.getParameter("pass");
			try {
				//agec = request.getParameter("age");
				//age = Integer.parseInt(agec);
				cont = Double.parseDouble(contact);
				Date birthday = null;
				if (!birth.isEmpty()) {
					birthday = dateFormat.parse(birth);
				} else {
					//System.out.println("in else for date");
				}
				int age1;
				if (!birthday.before(date)) {
					ServletContext servletContext = getServletContext();
					request.setAttribute("message", "Please enter correct date");
					// forwardPage="/Login/login.jsp";
					RequestDispatcher rsd = servletContext.getRequestDispatcher("/Login/Register.jsp");
					rsd.forward(request, response);
				}

				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(birthday);
				Calendar cal2 = Calendar.getInstance();
				int year1 = cal1.get(Calendar.YEAR);
				int year2 = cal2.get(Calendar.YEAR);
				if (year1 > year2) {
					//System.out.println("Wrong");
				} else {
					age1 = year2 - year1;
					//System.out.println(age1);
				}
			} catch (Exception e) {
				age = 0;
				cont = 0.0;
			}
			String user = "";
			user = request.getParameter("username");
			//System.out.println( "vlaue of age");

			int length = contact.length();
			// double cont=Double.parseDouble(contact);
			String email = request.getParameter("email");

			//System.out.println("message here3");

			String add = request.getParameter("add");
			out.println("Content-type:text/html");

			///System.out.println("message here2");

			System.out.println(birth);

			System.out.println("message1");

			// System.out.println(""+Period.between(birthday, date).getYears());
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			final String DB_URL = "jdbc:mysql://localhost:3306/serv";

			System.out.println("message11");

			/*
			 * int len1=firstname.length(); int len2=lastname.length();
			 */

			String pass = request.getParameter("pass");
			//System.out.println((String) pass);

			//System.out.println(" " + cont);

			String message = validate(firstname, lastname, pass, user, 19 , cont);
			//System.out.println(message);

			if (message != null && message != "") {

				ServletContext servletContext = getServletContext();
				request.setAttribute("message", message);
				RequestDispatcher rsd = servletContext.getRequestDispatcher("/Login/Register.jsp");
				// rsd.include(request,response);
				rsd.forward(request, response);
				return;
				
			} else {

				//System.out.println("message here");

				// Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");// mam we can also use
				// Class.forName("java.sql.Driver");
				// Open a connection
				Connection conn = DriverManager.getConnection(DB_URL, "root", "abhay");

				// Execute SQL query
				Statement stmt = conn.createStatement();
				// Statement stmt1=conn.createStatement();
				String sql;

				int val = 0;
				String s1 = "Select count(id) from servlet;";
				ResultSet rs = stmt.executeQuery(s1);
				while (rs.next()) {
					val = rs.getInt(1);
					System.out.println(val);
				}
				sql = "SELECT * FROM servlet";
				ResultSet rs1 = stmt.executeQuery(sql);

				String s2 = "Select username,emailid from servlet;";
				ResultSet rs2 = stmt.executeQuery(s2);
				while (rs2.next()) {
					String use = rs2.getString(1);
					String em = rs2.getString(2);
					if (use.equals(user)) {
						ServletContext servletContext1 = getServletContext();
						request.setAttribute("message", "The username has already been taken. Try another one");
						RequestDispatcher rsd1 = servletContext1.getRequestDispatcher("/Login/Register.jsp");
						// rsd.include(request,response);
						rsd1.forward(request, response);
						return;

					}
				}

				HttpSession session = request.getSession();
				session.setAttribute("user", user);

				String sq = "Insert into servlet values(" + (val + 1) + ",'" + email + "','" + user + "','" + pass
						+ "','" + firstname + "','" + lastname + "','" + add + "'," + cont + "," + 19 + ");";

				String button1 = request.getParameter("reg");

				System.out.println(sq);
				stmt.execute(sq);

				if (button1 != null) {
					ServletContext servletContext2 = getServletContext();
					request.setAttribute("message", "");
					//Bankput ba=new Bankput();
					//ba.doPost(request, response);
					RequestDispatcher rsd2 = servletContext2.getRequestDispatcher("/Bank/showoptions1.jsp");
					// rsd2.include(request,response);
					rsd2.forward(request, response);
					return;
					// response.sendRedirect("login_bank.html");
					/*
					 * response.setStatus(response.SC_MOVED_TEMPORARILY);
					 * response.setHeader("Location", "login_bank.html");
					 */
					/*
					 * ServletContext sc = getServletContext();
					 * sc.getRequestDispatcher("/login_bank.html").forward(
					 * request, response);
					 */
				}

			}

		}

		catch (Exception e) {
			// out.println(e.getStackTrace());
			//System.out.println("Here");
			ServletContext servletContext = getServletContext();
			request.setAttribute("message", "Enter the details");
			e.printStackTrace();
			RequestDispatcher rsd = servletContext.getRequestDispatcher("/Login/Register.jsp");
			// rsd.include(request,response);
			rsd.forward(request, response);
			return;
			// out.println(e);
		}

		/*
		 * ServletContext servletContext=getServletContext(); RequestDispatcher
		 * rsd=servletContext.getRequestDispatcher(forwardPage);
		 * rsd.include(request,response);
		 */
	}

	static String validate(String firstname, String lastname, String pass, String user, int age, double contact) {
		String message = "";
		// 0nt length=Integer.parseInt(contact);//int
		// agec=Integer.parseInt(age);
		if (firstname.isEmpty() || lastname.isEmpty()) {
			// ServletContext servletContext=getServletContext();
			// request.setAttribute("message", "Please enter the password");
			// forwardPage="/Login/login.jsp";
			message = message + "Enter the first name";
			// RequestDispatcher
			// rsd=servletContext.getRequestDispatcher("/Login/login.jsp");
			// rsd.forward(request, response);
			// rsd.forward(request, response);
		}

		else if (pass.equalsIgnoreCase("") || pass.isEmpty() || pass == null) {
			// ServletContext servletContext=getServletContext();
			// request.setAttribute("message", "Please enter the first and last
			// name");
			// forwardPage="/Login/login.jsp";
			// RequestDispatcher
			// rsd=servletContext.getRequestDispatcher("/Login/login.jsp");
			// rsd.forward(request, response);
			message = message + "Enter the password";
		} else if (user.isEmpty()) {
			message = message + "Enter username";
		}
		/*
		 * else if(length<10 || length>10) { //ServletContext
		 * servletContext=getServletContext(); //request.setAttribute(
		 * "message","The phone number should of 10 digits");
		 * //out.print("The length should be 10"); //RequestDispatcher
		 * rsd=servletContext.getRequestDispatcher("/Login/login.jsp"); //
		 * rsd.include(request,response); //rsd.forward(request, response);
		 * message=message+"The number should be of 10 digits";
		 * 
		 * }
		 */
		else if (age < 18 || age > 80) {
			// ServletContext servletContext=getServletContext();
			// request.setAttribute("message", "Please enter age between 18 and
			// 80");
			// forwardPage="/Login/login.jsp";
			// RequestDispatcher
			// rsd=servletContext.getRequestDispatcher("/Login/login.jsp");
			// rsd.forward(request, response);
			message = message + "Enter the correct age";
		}

		return message;
	}
}
