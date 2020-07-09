package com.tourguide;

import java.io.*;
import javax.servlet.*;

import javax.servlet.http.*;




public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(Validate.checkUser(email, password))
        {
            RequestDispatcher rs = request.getRequestDispatcher("touristspot.html");
            rs.forward(request, response);
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("register.html");
           rs.include(request, response);
        }
	out.close();
	}
}

