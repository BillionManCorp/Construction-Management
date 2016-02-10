/**
 * 
 */
package com.billionman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billionman.dao.CreateUserDAO;
import com.billionman.model.User;
import com.billionman.model.UserRoles;
import com.billionman.service.CreateUserService;

/**
 * @author CTM
 *
 */
@Service(value="createUserService")
public class CreateUserServiceImpl implements CreateUserService {

	@Autowired
	CreateUserDAO createUserDAO;

	public String saveNewUser(User newUser, UserRoles newRoles) {
		return createUserDAO.saveNewUser(newUser, newRoles);
	}

}
