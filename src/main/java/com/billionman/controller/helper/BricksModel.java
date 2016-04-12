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
public class BricksModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6095587693156711197L;

	/**
	 * 
	 */
	public BricksModel() {
		// TODO Auto-generated constructor stub
	}

	private int bricksId;
	private long quantity;
	private BigDecimal amount;
	private Date addedDate;
	private String project;
	private int projId;

	/**
	 * @return the bricksId
	 */
	public int getBricksId() {
		return bricksId;
	}

	/**
	 * @param bricksId
	 *            the bricksId to set
	 */
	public void setBricksId(int bricksId) {
		this.bricksId = bricksId;
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
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * @return the projId
	 */
	public int getProjId() {
		return projId;
	}

	/**
	 * @param projId
	 *            the projId to set
	 */
	public void setProjId(int projId) {
		this.projId = projId;
	}

}
