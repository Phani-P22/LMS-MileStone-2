package com.digit.javaTraining.LibraryManagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.javaTraining.LibraryManagemet.model.Book;

@WebServlet("/addBook")
public class AddBookController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book b = new Book();
		b.setBname(req.getParameter("bname"));
		b.setAuthor(req.getParameter("author"));
		b.setCost(Float.parseFloat(req.getParameter("cost")));
		b.setCategory(req.getParameter("category"));
		b.setStatus("INACTIVE");

		Book.addNewBook(b);
		resp.sendRedirect("AddBookSucc.jsp");
	}
}
