package com.digit.javaTraining.LibraryManagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.javaTraining.LibraryManagemet.model.User;

@WebServlet("/removeUser")
public class RemoveUserController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userID = Integer.parseInt(req.getParameter("uid"));

		boolean status = User.removeUser(userID);
		if (status) {
			resp.sendRedirect("RemoveUserSucc.jsp");
			return;
		} else {
			resp.sendRedirect("RemoveUserFail.jsp");
			return;
		}
	}
}

