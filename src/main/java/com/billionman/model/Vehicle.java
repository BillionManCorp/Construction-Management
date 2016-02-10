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
@Table(name = "VEHICLE")
public class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8385071713303953510L;
	private int vehicleId;
	private BigDecimal amount;
	private int vehicleType;
	private int fuelType;
	private String spareName;
	private int spareOrFuel;
	private Date addedDate;
	private int project;

	public Vehicle() {
		super();
	}

	public Vehicle(int vehicleId, BigDecimal amount, int vehicleType,
			int fuelType, String spareName, int spareOrFuel, Date addedDate,
			int project) {
		super();
		this.vehicleId = vehicleId;
		this.amount = amount;
		this.vehicleType = vehicleType;
		this.fuelType = fuelType;
		this.spareName = spareName;
		this.spareOrFuel = spareOrFuel;
		this.addedDate = addedDate;
		this.project = project;
	}

	/**
	 * @return the vehicleId
	 */
	@Id
	@Column(name = "VEHICLE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getVehicleId() {
		return vehicleId;
	}

	/**
	 * @param vehicleId
	 *            the vehicleId to set
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
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
	 * @return the vehicleType
	 */
	@Column(name = "VEHICLE_TYPE", nullable = false)
	public int getVehicleType() {
		return vehicleType;
	}

	/**
	 * @param vehicleType
	 *            the vehicleType to set
	 */
	public void setVehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * @return the fuelType
	 */
	@Column(name = "FUEL_TYPE")
	public int getFuelType() {
		return fuelType;
	}

	/**
	 * @param fuelType
	 *            the fuelType to set
	 */
	public void setFuelType(int fuelType) {
		this.fuelType = fuelType;
	}

	/**
	 * @return the spareName
	 */
	@Column(name = "SPARE_NAME")
	public String getSpareName() {
		return spareName;
	}

	/**
	 * @param spareName
	 *            the spareName to set
	 */
	public void setSpareName(String spareName) {
		this.spareName = spareName;
	}

	/**
	 * @return the spareOrFuel
	 */
	@Column(name = "FUEL_SPARE", nullable = false)
	public int getSpareOrFuel() {
		return spareOrFuel;
	}

	/**
	 * @param spareOrFuel
	 *            the spareOrFuel to set
	 */
	public void setSpareOrFuel(int spareOrFuel) {
		this.spareOrFuel = spareOrFuel;
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
