package com.digit.javaTraining.LibraryManagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.javaTraining.LibraryManagemet.model.User;

@WebServlet("/register")
public class UserRegisterController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String Address = req.getParameter("addr");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String status = req.getParameter("status");
		int UID = Integer.parseInt(req.getParameter("uid"));

		User u = new User();

		u.setUname(Name);
		u.setStatus(status);
		u.setPwd(pwd);
		u.setEmail(email);
		u.setUid(UID);
		u.setPhone(phone);
		u.setStatus("INACTIVE");
		u.setAddr(Address);

		User.registerUser(u);
		resp.sendRedirect("RegisterSucc.jsp");
	}
}
