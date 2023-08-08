package com.digit.aadharcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.aadharmodel.HibernateManager;
@WebServlet("/View")
public class ViewController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HibernateManager hbm1 = new HibernateManager();
		 HttpSession session = req.getSession();
		 session.setAttribute("list",hbm1.readAll());
		 resp.sendRedirect("/AadharProject/View.jsp");
		 
		 
	}

}
