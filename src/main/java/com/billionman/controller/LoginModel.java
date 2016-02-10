/**
 * 
 */
package com.billionman.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author CTM
 *
 */
@ManagedBean(name = "loginModel")
@SessionScoped
public class LoginModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3724431643145438346L;
	private String userName;
	private String password;
	private boolean admin;
	private String role;

	public LoginModel() {
		super();
	}

	@PostConstruct
	public void init() {
		System.out.println("!! Seat postconstruct : " + getUserName());
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the loggedIn
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * @param loggedIn
	 *            the loggedIn to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
