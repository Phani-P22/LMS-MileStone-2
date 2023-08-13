package com.digit.javaTraining.LibraryManagemet.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.digit.javaTraining.LibraryManagementApp.HibernateManager;

public class Book {

	private int bid;
	private String bname;
	private String author;
	private float cost;
	private String category;
	private String status;

	public Book() {

	}

	public Book(int bid, String bname, String author, float cost, String category, String status) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.cost = cost;
		this.category = category;
		this.status = status;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	public static ArrayList<Book> getAllUnAuthorizedBooks() {
		ArrayList<Book> allUnAuthorizedBooks = new ArrayList<Book>();
		HibernateManager hbm = new HibernateManager();

		Transaction trn = hbm.session.beginTransaction();
		Query allListQuery = hbm.session.createQuery("FROM Book WHERE status=:status");
		allListQuery.setParameter("status", "INACTIVE");
		List list = allListQuery.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Book curBook = (Book) it.next();
			allUnAuthorizedBooks.add(curBook);
		}
		return allUnAuthorizedBooks;
	}

	@SuppressWarnings("rawtypes")
	public static ArrayList<Book> getAllBooks() {
		ArrayList<Book> allBooks = new ArrayList<Book>();
		HibernateManager hbm = new HibernateManager();

		hbm.session.beginTransaction();
		Query allListQuery = hbm.session.createQuery("FROM Book");
		List list = allListQuery.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Book curBook = (Book) it.next();
			allBooks.add(curBook);
		}
		return allBooks;
	}

	public static void authorizeBook(Book curBook) {
		HibernateManager hbm = new HibernateManager();
		Transaction trn = hbm.session.beginTransaction();

		Book book = (Book) hbm.session.get(Book.class, curBook.getBid());
		book.setStatus("ACTIVE");

		hbm.session.update(book);
		trn.commit();
	}

	public static boolean removeBook(int bookId) {
		HibernateManager hbm = new HibernateManager();
		Transaction trn = hbm.session.beginTransaction();

		Book book = (Book) hbm.session.get(Book.class, bookId);
		if (book == null) {
			return false;
		}
		
		hbm.session.delete(book);
		trn.commit();
		return true;
	}

	public static void addNewBook(Book b) {
		HibernateManager hbm = new HibernateManager();
		Transaction trn = hbm.session.beginTransaction();

		hbm.session.save(b);

		trn.commit();
	}
}
