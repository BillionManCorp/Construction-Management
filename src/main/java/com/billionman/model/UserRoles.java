/**
 * 
 */
package com.billionman.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author CTM
 *
 */
@Entity
@Table(name = "user_roles")
public class UserRoles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4109779674095995112L;

	private int userRoleId;
	private String username;
	private String userRole;

	public UserRoles() {
		super();
	}

	public UserRoles(int userRoleId, String username, String userRole) {
		super();
		this.userRoleId = userRoleId;
		this.username = username;
		this.userRole = userRole;
	}

	/**
	 * @return the userRoleId
	 */
	@Id
	@Column(name = "user_role_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUserRoleId() {
		return userRoleId;
	}

	/**
	 * @param userRoleId
	 *            the userRoleId to set
	 */
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 * @return the username
	 */
	@Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the userRole
	 */
	@Column(name = "ROLE", nullable = false)
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
