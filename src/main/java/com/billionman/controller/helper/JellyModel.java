/**
 * 
 */
package com.billionman.controller.helper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author CTM
 *
 */
public class JellyModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2324043481477134809L;

	private int jellyId;
	private BigDecimal amount;
	private int jellyType;
	private Date addedDate;
	private String projectName;
	private BigDecimal quantity;

	public JellyModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the jellyId
	 */
	public int getJellyId() {
		return jellyId;
	}

	/**
	 * @param jellyId
	 *            the jellyId to set
	 */
	public void setJellyId(int jellyId) {
		this.jellyId = jellyId;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the jellyType
	 */
	public int getJellyType() {
		return jellyType;
	}

	/**
	 * @param jellyType
	 *            the jellyType to set
	 */
	public void setJellyType(int jellyType) {
		this.jellyType = jellyType;
	}

	/**
	 * @return the addedDate
	 */
	public Date getAddedDate() {
		return addedDate;
	}

	/**
	 * @param addedDate
	 *            the addedDate to set
	 */
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
