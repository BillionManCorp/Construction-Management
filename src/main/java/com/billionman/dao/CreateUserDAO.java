/**
 * 
 */
package com.billionman.dao;

import com.billionman.model.User;
import com.billionman.model.UserRoles;

/**
 * @author CTM
 *
 */
public interface CreateUserDAO {
	public String saveNewUser(User newUser, UserRoles newRoles);
}
