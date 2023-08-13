package com.digit.javaTraining.LibraryManagement.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.LibraryManagemet.model.User;

@WebServlet("/authorizeNewUser")
public class AuthorizeNewUserController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int curIndex = (int) session.getAttribute("curIndex");

		ArrayList<User> allUnAuthorizedUsers = (ArrayList<User>) session.getAttribute("allUnAuthorizedUsers");
		User curUser = allUnAuthorizedUsers.get(curIndex - 1);

		String operation = req.getParameter("operation");
		if (operation.equalsIgnoreCase("approve")) {
			User.authorizeUser(curUser);
		}
		resp.sendRedirect("/LMS/AuthorizeNewUsers.jsp");
	}
}
