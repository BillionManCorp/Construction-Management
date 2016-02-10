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
@Table(name = "BRICKS")
public class Bricks implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 96512393409286374L;

	private int bricksId;
	private long quantity;
	private BigDecimal amount;
	private Date addedDate;
	private int project;

	/**
	 * 
	 */
	public Bricks() {
		// TODO Auto-generated constructor stub
	}

	public Bricks(int bricksId, long quantity, BigDecimal amount,
			Date addedDate, int project) {
		super();
		this.bricksId = bricksId;
		this.quantity = quantity;
		this.amount = amount;
		this.addedDate = addedDate;
		this.project = project;
	}

	/**
	 * @return the bricksId
	 */
	@Id
	@Column(name = "BRICKS_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(name = "QUANTITY", nullable = false)
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
