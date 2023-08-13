package com.digit.javaTraining.LibraryManagement.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.LibraryManagemet.model.PurchaseHistory;
import com.digit.javaTraining.LibraryManagemet.model.User;

@WebServlet("/purchaseBook")
public class PurchaseBookController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String lists = req.getParameter("booksList");
		
		ArrayList<Integer> bookIDs = new ArrayList<Integer>();
		for (String curS : lists.split(",")) {
			bookIDs.add(Integer.parseInt(curS.trim()));
		}
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("curUser");
		
		for (int curBookID: bookIDs) {
			PurchaseHistory.purchaseBook(curBookID, user.getUid());
		}
		
		resp.sendRedirect("PurchaseSucc.jsp");
	}
}
