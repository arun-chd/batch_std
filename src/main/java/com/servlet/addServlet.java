package com.servlet;

import java.io.IOException;
//import java.lang.invoke.ClassSpecializer.Factory;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.student;
import com.model.factory;

public class addServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
//			System.out.println("hibernate...");

			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String marks = request.getParameter("marks");
			String address = request.getParameter("address");

			student std = new student(name, gender, address);


			Session s = factory.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			s.save(std);
			tx.commit();
			s.close();
			
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			out.println("<html><body bgcolor='cyan'>");
			out.println("<center><h1>Data added successfully...</h1></center>");
			out.println("</body></html>");
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
