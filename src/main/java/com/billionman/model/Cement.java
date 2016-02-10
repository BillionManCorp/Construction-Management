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
@Table(name = "CEMENT")
public class Cement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2402821096169887608L;

	private int cementId;
	private long numberBags;
	private BigDecimal amount;
	private Date addedDate;
	private int projectCement;

	public Cement() {
		super();
	}

	public Cement(int cementId, long numberBags, BigDecimal amount,
			Date addedDate, int project) {
		super();
		this.cementId = cementId;
		this.numberBags = numberBags;
		this.amount = amount;
		this.addedDate = addedDate;
		this.projectCement = project;
	}

	/**
	 * @return the cementId
	 */
	@Id
	@Column(name = "CEMENT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(name = "BAGS", nullable = false)
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
	@Column(name = "PRICE", nullable = false, columnDefinition = "Decimal(15,2)")
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
	 * @return the projectCement
	 */
	@Column(name = "ID", nullable = false)
	public int getProjectCement() {
		return projectCement;
	}

	/**
	 * @param projectCement
	 *            the projectCement to set
	 */
	public void setProjectCement(int projectCement) {
		this.projectCement = projectCement;
	}

}
