package com.digit.javaTraining.LibraryManagemet.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.digit.javaTraining.LibraryManagementApp.HibernateManager;

public class User {

	private int uid;
	private String uname;
	private String pwd;
	private String addr;
	private String phone;
	private String email;
	private String status;

	public User() {

	}

	public User(int uid, String uname, String pwd, String addr, String phone, String email, String status) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.pwd = pwd;
		this.addr = addr;
		this.phone = phone;
		this.email = email;
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	public static ArrayList<User> getAllUnAuthorizedUsers() {
		ArrayList<User> allUnAuthorizedUsers = new ArrayList<User>();
		HibernateManager hbm = new HibernateManager();

		Transaction trn = hbm.session.beginTransaction();
		Query allListQuery = hbm.session.createQuery("FROM User WHERE status=:status");
		allListQuery.setParameter("status", "INACTIVE");
		List list = allListQuery.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			User curUser = (User) it.next();
			allUnAuthorizedUsers.add(curUser);
		}
		return allUnAuthorizedUsers;
	}

	public static void authorizeUser(User curUser) {
		HibernateManager hbm = new HibernateManager();
		Transaction trn = hbm.session.beginTransaction();

		User User = (User) hbm.session.get(User.class, curUser.getUid());
		User.setStatus("ACTIVE");

		hbm.session.update(User);
		trn.commit();
	}

	public static boolean removeUser(int userId) {
		HibernateManager hbm = new HibernateManager();
		Transaction trn = hbm.session.beginTransaction();

		User User = (User) hbm.session.get(User.class, userId);
		if (User == null) {
			return false;
		}

		hbm.session.delete(User);
		trn.commit();
		return true;
	}

	public static boolean authenticateUser(int userID, String password) {
		HibernateManager hbm = new HibernateManager();
		hbm.session.beginTransaction();
		Query q = hbm.session.createQuery("FROM User where uid=:uid and pwd=:pwd");
		q.setInteger("uid", userID);
		q.setString("pwd", password);
		List l = q.list();
		if (l.isEmpty()) {
			return false;
		}
		return true;
	}

	public static User getUser(int uid) {
		HibernateManager hbm = new HibernateManager();
		hbm.session.beginTransaction();

		User user = (User) hbm.session.get(User.class, uid);
		return user;
	}

	public static void registerUser(User user) {
		
		HibernateManager hbm = new HibernateManager();
		Transaction tr = hbm.session.beginTransaction();
		
		hbm.session.save(user);
		tr.commit();
	}
}
