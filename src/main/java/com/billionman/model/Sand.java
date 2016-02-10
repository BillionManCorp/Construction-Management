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
@Table(name = "SAND")
public class Sand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1736978888362330579L;

	private int sandId;
	private long quantity;
	private BigDecimal amount;
	private int sandType;
	private Date addedDate;
	private int project;

	/**
	 * @return the sandId
	 */
	@Id
	@Column(name = "SAND_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getSandId() {
		return sandId;
	}

	/**
	 * @param sandId
	 *            the sandId to set
	 */
	public void setSandId(int sandId) {
		this.sandId = sandId;
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
	 * @return the sandType
	 */
	@Column(name = "SAND_TYPE", nullable = false)
	public int getSandType() {
		return sandType;
	}

	/**
	 * @param sandType
	 *            the sandType to set
	 */
	public void setSandType(int sandType) {
		this.sandType = sandType;
	}

	/**
	 * @return the addedDate
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "ADDED_DATE", nullable = false)
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
