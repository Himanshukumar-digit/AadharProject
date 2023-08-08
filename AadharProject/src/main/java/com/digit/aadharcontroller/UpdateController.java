package com.digit.aadharcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.aadharmodel.HibernateManager;
@WebServlet("/Update")
public class UpdateController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int ID = Integer.parseInt(req.getParameter("ID"));
		String changecolumn = req.getParameter("changecolumn");
		String newValue =req.getParameter("newValue");
		
	
		 HibernateManager hbm1 = new HibernateManager();
		 hbm1.update(ID, changecolumn, newValue);
		 
		 
	
	}

}
