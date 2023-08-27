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

public class selectServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			int stdID = Integer.parseInt(request.getParameter("id"));

			Session s = factory.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			student std = (student) s.get(student.class, stdID);
			std.equals(std);

			tx.commit();
			s.close();

			response.setContentType("text/html");

			PrintWriter out = response.getWriter();
			out.println("<html><body bgcolor='cyan'>");
			out.println("<center><h1>Data selected successfully...</h1></center>");
			out.println("</body></html>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
