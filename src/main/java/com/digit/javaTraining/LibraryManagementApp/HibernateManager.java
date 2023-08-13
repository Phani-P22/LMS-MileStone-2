package com.digit.javaTraining.LibraryManagementApp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.digit.javaTraining.LibraryManagemet.model.PurchaseHistory;

public class HibernateManager {

	public Session session;

	public HibernateManager() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());
		session = sessionFactory.openSession();
		System.out.println("Connected to Pf...");
	}

	public Long generateRandomInvoiceNumber() {
		Long curGenNum = 0L;
		while (true) {
			curGenNum = (long) (Math.random() * (999999999999L - 100000000000L) + 100000000000L);
			Query q = session.createQuery("FROM PurchaseHistory where invoice_no=:num");
			q.setLong("num", curGenNum);
			List l = q.list();
			if (l.isEmpty()) {
				return curGenNum;
			}
		}
	}

}
