package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.student;
import com.model.factory;


public class editServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int stdID = Integer.parseInt(request.getParameter("id"));
			int stdMarks = Integer.parseInt(request.getParameter("marks"));
			
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");
			
			Session s = factory.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			student std = (student)s.get(student.class, stdID);
			std.setName(name);
			std.setGender(gender);
			std.setMarks(stdMarks);
			std.setAddress(address);
		
			tx.commit();
			s.close();
			
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			out.println("<html><body bgcolor='cyan'>");
			out.println("<center><h1>Data edit successfully...</h1></center>");
			out.println("</body></html>");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
