package com.digit.javaTraining.LibraryManagemet.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.digit.javaTraining.LibraryManagementApp.HibernateManager;

public class Admin {

	private int admin_id;
	private String secret_pin;

	public Admin() {

	}

	public Admin(int admin_id, String secret_pin) {
		super();
		this.admin_id = admin_id;
		this.secret_pin = secret_pin;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getSecret_pin() {
		return secret_pin;
	}

	public void setSecret_pin(String secret_pin) {
		this.secret_pin = secret_pin;
	}

	public static boolean authenticateAdmin(int adminID, String password) {
		HibernateManager hbm = new HibernateManager();
		hbm.session.beginTransaction();

		Query q = hbm.session.createQuery("FROM Admin where admin_id=:aid and secret_pin=:apin");
		q.setInteger("aid", adminID);
		q.setString("apin", password);
		List l = q.list();
		if (l.isEmpty()) {
			return false;
		}
		return true;

	}

}
