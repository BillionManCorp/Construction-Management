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
@Table(name = "PROJECT")
public class Project implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = -6342310717686443347L;
	private int id;
	private String projectName;
	private Date startDate;
	private Date endDate;
	private String userName;
	private BigDecimal estimatedCost;
	private String place;
	private int projectType;

	public Project() {
		super();
	}

	public Project(int id, String projectName, Date startDate, Date endDate,
			String userName, BigDecimal estimatedCost, String place,
			int projectType) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userName = userName;
		this.estimatedCost = estimatedCost;
		this.place = place;
		this.projectType = projectType;
	}

	/**
	 * @return the id
	 */
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the projectName
	 */
	@Column(name = "PROJ_NAME", unique = true, nullable = false)
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

	/**
	 * @return the startDate
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE", nullable = false)
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the userName
	 */
	@Column(name = "USER_NAME", nullable = false)
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the estimatedCost
	 */
	@Column(name = "EST_COST", nullable = false, columnDefinition = "Decimal(10,2)")
	public BigDecimal getEstimatedCost() {
		return estimatedCost;
	}

	/**
	 * @param estimatedCost
	 *            the estimatedCost to set
	 */
	public void setEstimatedCost(BigDecimal estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	/**
	 * @return the place
	 */
	@Column(name = "PLACE", nullable = false)
	public String getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the projectType
	 */
	@Column(name = "PROJ_TYPE", nullable = false)
	public int getProjectType() {
		return projectType;
	}

	/**
	 * @param projectType
	 *            the projectType to set
	 */
	public void setProjectType(int projectType) {
		this.projectType = projectType;
	}

}
