/**
 * 
 */
package com.billionman.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author CTM
 *
 */
@ManagedBean
@RequestScoped
public class NavigationController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String home() {
		return "home";
	}

	public String materials() {
		return "materials";
	}

}
