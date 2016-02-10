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
public class LimeModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7841567064437024394L;

	private int limeId;
	private long quantity;
	private BigDecimal amount;
	private Date addedDate;
	private String projectName;

	/**
	 * @return the limeId
	 */
	public int getLimeId() {
		return limeId;
	}

	/**
	 * @param limeId
	 *            the limeId to set
	 */
	public void setLimeId(int limeId) {
		this.limeId = limeId;
	}

	/**
	 * @return the quantity
	 */
	public long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(long quantity) {
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
	 * @return the projName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projName
	 *            the projName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
