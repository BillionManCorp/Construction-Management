/**
 * 
 */
package com.billionman.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.billionman.dao.LoginDAO;
import com.billionman.model.User;
import com.billionman.model.UserRoles;

/**
 * @author CTM
 *
 */
@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory mySessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.billionman.dao.LoginDAO#validateLogin(java.lang.String,
	 * java.lang.String)
	 */
	public String validateLogin(String userName, String password) {
		Session session = mySessionFactory.openSession();
		String role = null;
		try {
			Query query = session
					.createQuery("from User u where u.userName=:name and u.password=:psw");
			query.setParameter("name", userName);
			query.setParameter("psw", password);
			if (CollectionUtils.isEmpty(query.list())) {
				return role;
			} else {
				User user = (User) query.list().get(0);
				query = session
						.createQuery("from UserRoles u where u.username=:name");
				query.setParameter("name", user.getUserName());
				role = user.getEnabled() == 1 ? ((UserRoles) query.list()
						.get(0)).getUserRole() : null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return role;
	}
}
