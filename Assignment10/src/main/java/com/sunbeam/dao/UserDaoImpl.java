 package com.sunbeam.dao;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User signIn(String email, String pwd) {
		User user=null;
			// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin tx
		Transaction tx = session.beginTransaction();
		try {
			String jpql ="select u from User u where u.email=:e and u.password=:p";
			
			user=session.createQuery(jpql,User.class).setParameter("e", email).setParameter("p", pwd).getSingleResult();
			
			
			
			tx.commit();
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return user;
	}

	@Override
	public String signUp(User newUser) {
		String mesg = "reg failed !!!!!!";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin tx
		Transaction tx = session.beginTransaction();
		try {
			// transient -> persistent
			
			session.persist(newUser);
			
			tx.commit();
			mesg = "user registered with ID " + newUser.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	

	@Override
	public String updateUserDetails(User user) {
		String mesg = "Updation failed";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			session.merge(user);
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteUser(Long userId) {
		String mesg = "Deletion failed";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			
			User u = session.get(User.class, userId);
			u.setStatus(false);
			
			
		
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return mesg;

	}

	@Override
	public List<User> listUsers() {
		List<User> users = null;
		
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
				String jpql ="select u from User u where u.status=true";
				
				users=session.createQuery(jpql,User.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return users;
	}

	@Override
	public User getUserDetails(Long userId) {
		User user = null;
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			String jpql = "select u from User u where u.id=:userid";
			user=session.createQuery(jpql,User.class).setParameter("userid", userId).getSingleResult();
	
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return user;

	}

}
