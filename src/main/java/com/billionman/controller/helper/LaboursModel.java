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
public class LaboursModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 90653102319110952L;

	private int labourId;
	private String description;
	private BigDecimal amount;
	private Date addedDate;
	private String projectName;

	public LaboursModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the labourId
	 */
	public int getLabourId() {
		return labourId;
	}

	/**
	 * @param labourId
	 *            the labourId to set
	 */
	public void setLabourId(int labourId) {
		this.labourId = labourId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
