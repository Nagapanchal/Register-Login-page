package com.server.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LogInPage extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Mail = req.getParameter("mail1");
		String Password = req.getParameter("pass1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/naga", "root", "root");
			PreparedStatement stmt = con.prepareStatement("select * from registerform where mail=? and password=?");
			stmt.setString(1,Mail);
			stmt.setString(2,Password);
			
			PrintWriter out=resp.getWriter();
			
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
				out.print("<html><body bgcolor='green'><h1>Login Successfull...</h1></body></html>");
			}
			else
			{
				out.print("<html><body bgcolor='red'><h1>Login Falied...</h1></body></html>");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
