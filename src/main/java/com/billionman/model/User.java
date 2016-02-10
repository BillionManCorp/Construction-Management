/**
 * 
 */
package com.billionman.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author CTM
 *
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1467630770232286234L;

	private String userName;
	private String password;
	private int enabled;
	private String fullName;
	private String email;
	private String mobileNumber;

	public User() {
		super();
	}

	public User(String userName, String password, int enabled, String fullName,
			String email, String mobileNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
		this.fullName = fullName;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the userName
	 */
	@Id
	@Column(name = "username", unique = true, nullable = false)
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
	 * @return the password
	 */
	@Column(name = "password", nullable = false)
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
	 * @return the enabled
	 */
	@Column(name = "enabled", nullable = false)
	public int getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the fullName
	 */
	@Column(name = "FULL_NAME", nullable = false)
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the email
	 */
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobileNumber
	 */
	@Column(name = "mobile", nullable = false)
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber
	 *            the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
