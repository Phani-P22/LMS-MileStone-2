package com.digit.javaTraining.LibraryManagemet.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.digit.javaTraining.LibraryManagementApp.HibernateManager;

public class Subscription {

	private int sub_id;
	private int user_id;
	private float amount;
	private Long invoice_no;
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Subscription() {

	}

	public int getSub_id() {
		return sub_id;
	}

	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Long getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(Long invoice_no) {
		this.invoice_no = invoice_no;
	}

	@SuppressWarnings("rawtypes")
	public static ArrayList<Subscription> getAllSubscriptions() {
		ArrayList<Subscription> allSubscriptions = new ArrayList<Subscription>();
		HibernateManager hbm = new HibernateManager();

		Query allListQuery = hbm.session.createQuery("FROM Subscription");
		List list = allListQuery.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Subscription curSub = (Subscription) it.next();
			allSubscriptions.add(curSub);
		}
		return allSubscriptions;
	}

	public static void subscribe(int userID, int amount) {
		HibernateManager hbm = new HibernateManager();
		Transaction t = hbm.session.beginTransaction();

		Subscription s = new Subscription();
		s.setUser_id(userID);
		s.setAmount(amount);
		s.setInvoice_no(hbm.generateRandomInvoiceNumber());

		Date date = new Date(System.currentTimeMillis());
		s.setDate(date);

		hbm.session.save(s);
		t.commit();
	}
}
