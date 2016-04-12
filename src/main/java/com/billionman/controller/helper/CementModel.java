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
public class CementModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7994475742270150930L;
	
	private int cementId;
	private long numberBags;
	private BigDecimal amount;
	private Date addedDate;
	private String projectName;
	private int projId;

	/**
	 * 
	 */
	public CementModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the cementId
	 */
	public int getCementId() {
		return cementId;
	}

	/**
	 * @param cementId
	 *            the cementId to set
	 */
	public void setCementId(int cementId) {
		this.cementId = cementId;
	}

	/**
	 * @return the numberBags
	 */
	public long getNumberBags() {
		return numberBags;
	}

	/**
	 * @param numberBags
	 *            the numberBags to set
	 */
	public void setNumberBags(long numberBags) {
		this.numberBags = numberBags;
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

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}
	
}
