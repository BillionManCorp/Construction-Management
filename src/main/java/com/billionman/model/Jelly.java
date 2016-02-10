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
@Table(name = "JELLY")
public class Jelly implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1185549575789623944L;

	private int jellyId;
	private BigDecimal amount;
	private int jellyType;
	private Date addedDate;
	private int project;
	private BigDecimal quantity;

	public Jelly() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jelly(int jellyId, BigDecimal amount, int jellyType, Date addedDate,
			int project, BigDecimal quantity) {
		super();
		this.jellyId = jellyId;
		this.amount = amount;
		this.jellyType = jellyType;
		this.addedDate = addedDate;
		this.project = project;
		this.quantity = quantity;
	}

	/**
	 * @return the jellyId
	 */
	@Id
	@Column(name = "JELLY_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	 * @return the electricityType
	 */
	@Column(name = "JELLY_TYPE", nullable = false)
	public int getJellyType() {
		return jellyType;
	}

	/**
	 * @param electricityType
	 *            the electricityType to set
	 */
	public void setJellyType(int jellyType) {
		this.jellyType = jellyType;
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

	/**
	 * @return the quantity
	 */
	@Column(name = "QUANTITY", nullable = false, columnDefinition = "Decimal(15,2)")
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
