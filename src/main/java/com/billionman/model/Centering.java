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
@Table(name = "CENTERING")
public class Centering implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9129283682220850452L;

	private int centeringId;
	private double quantity;
	private BigDecimal amount;
	private Date addedDate;
	private int project;

	/**
	 * 
	 */
	public Centering() {
		// TODO Auto-generated constructor stub
	}

	public Centering(int centeringId, double quantity, BigDecimal amount,
			Date addedDate, int project) {
		super();
		this.centeringId = centeringId;
		this.quantity = quantity;
		this.amount = amount;
		this.addedDate = addedDate;
		this.project = project;
	}

	/**
	 * @return the centeringId
	 */
	@Id
	@Column(name = "CENTERING_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(name = "QUANTITY", nullable = false)
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
