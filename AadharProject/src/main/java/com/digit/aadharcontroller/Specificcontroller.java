package com.digit.aadharcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.aadharmodel.HibernateManager;
import com.digit.hibernate.aadhar.AadharDetails;
@WebServlet("/Specific")
public class Specificcontroller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int ID = Integer.parseInt(req.getParameter("ID"));

		 HibernateManager hbm1 = new HibernateManager();
		 HttpSession session = req.getSession();
		 AadharDetails a1=hbm1.readSpecific(ID);
		 session.setAttribute("specific", a1);
		resp.sendRedirect("/AadharProject/SpecificView.jsp");
	}

}
