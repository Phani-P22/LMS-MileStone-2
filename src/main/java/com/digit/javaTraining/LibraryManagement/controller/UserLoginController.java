package com.digit.javaTraining.LibraryManagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.LibraryManagemet.model.User;

@WebServlet("/userLogin")
public class UserLoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userID = Integer.parseInt(req.getParameter("uid"));
		String password = req.getParameter("pwd");

		boolean status = User.authenticateUser(userID, password);
		if (status) {
			User curUser = User.getUser(userID);
			if (curUser.getStatus().equalsIgnoreCase("INACTIVE")) {
				resp.sendRedirect("UserPendingPage.jsp");
				return;
			}
			
			HttpSession session = req.getSession(true);
			System.out.println(userID);
			session.setAttribute("curUser", User.getUser(userID));
			resp.sendRedirect("/LMS/user.html");
			return;
		}
		resp.sendRedirect("/LMS/index.html");
	}
}
