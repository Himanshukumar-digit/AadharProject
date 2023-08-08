package com.digit.aadharcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.aadharmodel.HibernateManager;
import com.digit.hibernate.aadhar.AadharDetails;
@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String Name=req.getParameter("Name");

	        String DOB=req.getParameter("DOB");
	        String Address=req.getParameter("Address");
	        int PIN = Integer.parseInt(req.getParameter("PIN"));
	        int ID = Integer.parseInt(req.getParameter("ID"));
	        AadharDetails a = new AadharDetails();
	        a.setName(Name);
	        a.setDOB(DOB);
	        a.setId(ID);
	        a.setPin(PIN);
	        a.setAddress(Address);
	        HibernateManager hbm1 = new HibernateManager();
	        hbm1.saveObject(a);
	        boolean b = hbm1.saveObject(a);
	        if(b) {
	        	resp.sendRedirect("/AadharProject/Home.html");
	        }
	        
	        
	}

}
