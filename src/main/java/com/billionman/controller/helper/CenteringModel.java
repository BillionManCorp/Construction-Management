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
public class CenteringModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7613727420569854744L;

	private int centeringId;
	private double quantity;
	private BigDecimal amount;
	private Date addedDate;
	private String projectName;

	public CenteringModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the centeringId
	 */
	public int getCenteringId() {
		return centeringId;
	}

	/**
	 * @param centeringId
	 *            the centeringId to set
	 */
	public void setCenteringId(int centeringId) {
		this.centeringId = centeringId;
	}

	/**
	 * @return the quantity
	 */
	public double getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(double quantity) {
		this.quantity = quantity;
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

}
