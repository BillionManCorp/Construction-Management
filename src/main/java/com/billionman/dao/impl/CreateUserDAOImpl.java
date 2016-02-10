/**
 * 
 */
package com.billionman.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.billionman.dao.CreateUserDAO;
import com.billionman.model.User;
import com.billionman.model.UserRoles;
import com.billionman.util.Constants;

/**
 * @author CTM
 *
 */
@Repository
public class CreateUserDAOImpl implements CreateUserDAO {

	@Autowired
	private SessionFactory mySessionFactory;

	public String saveNewUser(User newUser, UserRoles newRoles) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(newUser);
			tx.commit();
			session.close();
			session = mySessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(newRoles);
			tx.commit();
		} catch (Exception e) {
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}
}
