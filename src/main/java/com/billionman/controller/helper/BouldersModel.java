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
public class BouldersModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1352145324216593703L;

	private int bouldersId;
	private long trips;
	private BigDecimal amount;
	private Date addedDate;
	private String projectName;

	public BouldersModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the bouldersId
	 */
	public int getBouldersId() {
		return bouldersId;
	}

	/**
	 * @param bouldersId
	 *            the bouldersId to set
	 */
	public void setBouldersId(int bouldersId) {
		this.bouldersId = bouldersId;
	}

	/**
	 * @return the trips
	 */
	public long getTrips() {
		return trips;
	}

	/**
	 * @param trips
	 *            the trips to set
	 */
	public void setTrips(long trips) {
		this.trips = trips;
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
