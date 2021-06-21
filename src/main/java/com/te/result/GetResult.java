package com.te.result;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class GetResult
 */
@WebServlet("/GetResult")
public class GetResult extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usn=request.getParameter("regno");
		
		HttpSession session=request.getSession();
				
					try {
						Class.forName("com.mysql.jdbc.Driver");
						String db="select * from student where reg_no=?";
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_resul", "root", "root");
						PreparedStatement s=con.prepareStatement(db);
						s.setString(1, usn);
						ResultSet rs=s.executeQuery();
						
						while(rs.next()) {
							session.setAttribute("usn", rs.getString(1));
							session.setAttribute("name", rs.getString(2));
							session.setAttribute("m1", rs.getInt(3));
							session.setAttribute("m2", rs.getInt(4));
							session.setAttribute("m3", rs.getInt(5));
							session.setAttribute("m4", rs.getInt(6));
							
							
						}
						response.sendRedirect("Percentage");
					} 
					
	catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
	
	}
}
