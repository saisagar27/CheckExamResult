package com.te.result;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Percentage
 */
@WebServlet("/Percentage")
public class Percentage extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String reg=(String) session.getAttribute("usn");
		String name=(String)session.getAttribute("name");
		int eng=(int)session.getAttribute("m1");
		int kan=(int)session.getAttribute("m2");
		int math=(int)session.getAttribute("m3");
		int sci=(int)session.getAttribute("m4");
		
		double percentage=((eng+kan+math+sci)*100)/400;
		
		PrintWriter pw=response.getWriter();
		pw.println("Register No = "+reg+"<br>");
		pw.println("Name = "+name+"<br>");
		pw.println("English = "+eng+"<br>");
		pw.println("Kannada = "+kan+"<br>");
		pw.println("Maths = "+math+"<br>");
		pw.println("Science = "+sci+"<br>");
		pw.println("Percentage = "+percentage);
	}

}
