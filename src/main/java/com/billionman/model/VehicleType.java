/**
 * 
 */
package com.billionman.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author CTM
 *
 */
@Entity
@Table(name = "VEHICLE_TYPE")
public class VehicleType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6607208607662459133L;

	private int vehicleTypeId;
	private String name;

	public VehicleType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleType(int vehicleTypeId, String name) {
		super();
		this.vehicleTypeId = vehicleTypeId;
		this.name = name;
	}

	/**
	 * @return the vehicleTypeId
	 */
	@Id
	@Column(name = "VEHICLE_TYPE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getVehicleTypeId() {
		return vehicleTypeId;
	}

	/**
	 * @param vehicleTypeId
	 *            the vehicleTypeId to set
	 */
	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "VEHICLE_NAME", nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
