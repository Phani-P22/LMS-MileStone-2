package com.digit.javaTraining.LibraryManagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.LibraryManagemet.model.Subscription;
import com.digit.javaTraining.LibraryManagemet.model.User;

@WebServlet("/subscribe")
public class SubscriptionController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cost = Integer.parseInt(req.getParameter("type"));
		
		HttpSession curSession = req.getSession();
		User curUser = (User) curSession.getAttribute("curUser");
		
		Subscription.subscribe(curUser.getUid(), cost);
		
		resp.sendRedirect("SubscriptionSucc.jsp");
	}
}
