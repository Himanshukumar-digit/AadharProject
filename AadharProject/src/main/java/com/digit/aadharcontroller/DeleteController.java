package com.digit.aadharcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.aadharmodel.HibernateManager;
@WebServlet("/Delete")
public class DeleteController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int ID = Integer.parseInt(req.getParameter("ID"));

		 HibernateManager hbm1 = new HibernateManager();
		 hbm1.delete(ID);
		 resp.sendRedirect("/AadharProject/Home.html");
		 
	}
	

}
