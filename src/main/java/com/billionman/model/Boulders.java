/**
 * 
 */
package com.billionman.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author CTM
 *
 */
@Entity
@Table(name = "BOULDERS")
public class Boulders implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4770335588466115905L;

	private int bouldersId;
	private long trips;
	private BigDecimal amount;
	private Date addedDate;
	private int project;

	/**
	 * 
	 */
	public Boulders() {
		// TODO Auto-generated constructor stub
	}

	public Boulders(int bouldersId, long trips, BigDecimal amount,
			Date addedDate, int project) {
		super();
		this.bouldersId = bouldersId;
		this.trips = trips;
		this.amount = amount;
		this.addedDate = addedDate;
		this.project = project;
	}

	/**
	 * @return the bouldersId
	 */
	@Id
	@Column(name = "BOULDERS_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(name = "TRIPS", nullable = false)
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
	@Column(name = "AMOUNT", nullable = false, columnDefinition = "Decimal(15,2)")
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
	@Temporal(TemporalType.DATE)
	@Column(name = "ADDED_DATE")
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
	@Column(name = "ID", nullable = false)
	public int getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(int project) {
		this.project = project;
	}

}
