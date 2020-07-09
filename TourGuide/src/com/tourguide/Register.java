package com.tourguide;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mobile=request.getParameter("mobile");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tourguide","root","ki131200");
			
			String query ="insert into user(name,email,password,mobile,city,state)"+"values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,password);
			ps.setString(4,mobile);
			ps.setString(5,city);
			ps.setString(6,state);
			
			int i = ps.executeUpdate();
			if (i>0) {
				out.println("SUCCESSFULLY REGISTERED");
				
				RequestDispatcher rs = request.getRequestDispatcher("login.html");
	            rs.forward(request, response);
			}
			con.close();
		}
		catch(Exception se) {
			throw new ServletException("Login failed", se);
		}
	}

}
