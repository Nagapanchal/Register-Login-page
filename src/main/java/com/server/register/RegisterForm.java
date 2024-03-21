package com.server.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class RegisterForm extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reg = req.getParameter("reg1");
		String Name = req.getParameter("name1");
		String Mail = req.getParameter("mail1");
		String Password = req.getParameter("pass1");
		String Gender = req.getParameter("gender1");
		String City = req.getParameter("city1");

		PrintWriter out = resp.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/naga", "root", "root");
			PreparedStatement stmt = con.prepareStatement("insert into registerform values(?,?,?,?,?,?)");
			stmt.setString(1, reg);
			stmt.setString(2, Name);
			stmt.setString(3, Mail);
			stmt.setString(4, Password);
			stmt.setString(5, Gender);
			stmt.setString(6, City);

			int n = stmt.executeUpdate();
			if (n>0) {
				resp.setContentType("text/html");
				out.print("<h2 style='color:green'> User registered Successfully..</h2>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			} else {
				resp.setContentType("text/html");
				out.print("<h2 style='color:red'> User registered Successfully..</h2>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
