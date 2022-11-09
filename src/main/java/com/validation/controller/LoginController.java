package com.validation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();

		response.setContentType("text/html; charset=utf-8");
		if(request.getParameter("username")==null || request.getParameter("username")=="" )
		{
			
			RequestDispatcher rd = request.getRequestDispatcher("loginForm.html");
			rd.include(request, response);
			out.println("<span style = 'color:red'>Enter the Username</span>");
			
		}
		else if(request.getParameter("password")==null || request.getParameter("password")=="")
		{
			RequestDispatcher rd = request.getRequestDispatcher("loginForm.html");
			rd.include(request, response);
			out.println("<span style = 'color:red'>Enter the Password</span>");
		}
		else 
		{
			if(request.getParameter("username").equalsIgnoreCase("admin") && request.getParameter("password").equalsIgnoreCase("admin"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("user.html");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("loginForm.html");
				rd.include(request, response);
				out.print("<span style = 'color:red'>Invalid credential</span>");
			}
			
		}
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
		//doGet(request, response);
		
	}

}
