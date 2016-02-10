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
@Table(name = "POWER")
public class Power implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8826962359831216329L;

	private int powerId;
	private BigDecimal amount;
	private int electricityType;
	private Date addedDate;
	private int project;

	public Power() {
		super();
	}

	/**
	 * @return the powerId
	 */
	@Id
	@Column(name = "POWER_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPowerId() {
		return powerId;
	}

	/**
	 * @param powerId
	 *            the powerId to set
	 */
	public void setPowerId(int powerId) {
		this.powerId = powerId;
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
	@Column(name = "ELECTRICITY_TYPE", nullable = false)
	public int getElectricityType() {
		return electricityType;
	}

	/**
	 * @param electricityType
	 *            the electricityType to set
	 */
	public void setElectricityType(int electricityType) {
		this.electricityType = electricityType;
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
