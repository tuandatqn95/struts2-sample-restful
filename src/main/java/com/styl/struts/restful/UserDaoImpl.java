package com.styl.struts.restful;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDaoImpl implements UserDao {

	SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	public UserDaoImpl() {
		super();
		this.sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public void add(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("from User");

		List<User> users = query.list();
		if (users == null)
			users = new ArrayList<User>();

		tx.commit();
		session.close();
		return users;
	}

	public User get(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("from User where id=:id");
		query.setParameter("id", id);
		User users = (User) query.uniqueResult();

		tx.commit();
		session.close();
		return users;
	}

	public void update(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.update(user);

		tx.commit();
		session.close();

	}

	public void delete(long id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("delete User where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
		tx.commit();
		session.close();

	}

}
