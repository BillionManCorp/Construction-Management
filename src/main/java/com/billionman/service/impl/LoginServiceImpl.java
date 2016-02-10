/**
 * 
 */
package com.billionman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billionman.dao.LoginDAO;
import com.billionman.service.LoginService;

/**
 * @author CTM
 *
 */
@Service(value="loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO loginDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.billionman.service.LoginService#validateLogin(java.lang.String,
	 * java.lang.String)
	 */
	public String validateLogin(String userName, String password) {
		return loginDAO.validateLogin(userName, password);
	}

}
