/**
 * 
 */
package com.billionman.service;

import com.billionman.model.User;
import com.billionman.model.UserRoles;

/**
 * @author CTM
 *
 */
public interface CreateUserService {

	public String saveNewUser(User newUser, UserRoles newRoles);
}
