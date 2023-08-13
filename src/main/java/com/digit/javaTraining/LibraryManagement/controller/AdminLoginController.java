package com.digit.javaTraining.LibraryManagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.LibraryManagemet.model.Admin;
import com.digit.javaTraining.LibraryManagemet.model.User;

@WebServlet("/adminLogin")
public class AdminLoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int adminID = Integer.parseInt(req.getParameter("adminID"));
		String password = req.getParameter("secretPin");
		
		boolean status = Admin.authenticateAdmin(adminID, password);
		System.out.println(status);
		if (status) {
			resp.sendRedirect("/LMS/admin.html");
			return;
		}
		resp.sendRedirect("/LMS/index.html");
	
	}
}
