package com.te.result;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Validation")
public class Validation extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String usn=request.getParameter("regno");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String db="select reg_no from student where reg_no=?";
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_resul", "root", "root");
			PreparedStatement s=con.prepareStatement(db);
			s.setString(1, usn);
			ResultSet rs=s.executeQuery();
			
			while(rs.next()) {
		
		if(usn.equals(rs.getString(1)) && usn.length()==6) {
			RequestDispatcher rq=request.getRequestDispatcher("GetResult");
			rq.forward(request, response);
			
		}
		
		}
			response.sendRedirect("/ExamResult/Error.html");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		

}
