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
@Table(name = "STEEL")
public class Steel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4760173533796985389L;

	private int steelId;
	private long quantityTonnes;
	private int bundle;
	private BigDecimal amount;
	private int type;
	private Date addedDate;
	private int project;

	public Steel() {
		super();
	}

	public Steel(int steelId, long quantityTonnes, int bundle,
			BigDecimal amount, int type, Date addedDate, int project) {
		super();
		this.steelId = steelId;
		this.quantityTonnes = quantityTonnes;
		this.bundle = bundle;
		this.amount = amount;
		this.type = type;
		this.addedDate = addedDate;
		this.project = project;
	}

	/**
	 * @return the id
	 */
	@Id
	@Column(name = "STEEL_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getSteelId() {
		return steelId;
	}

	/**
	 * @param id
	 *            the id to set
	 */

	public void setSteelId(int id) {
		this.steelId = id;
	}

	/**
	 * @return the quantityTonnes
	 */
	@Column(name = "QUANTITY", nullable = false)
	public long getQuantityTonnes() {
		return quantityTonnes;
	}

	/**
	 * @param quantityTonnes
	 *            the quantityTonnes to set
	 */
	public void setQuantityTonnes(long quantityTonnes) {
		this.quantityTonnes = quantityTonnes;
	}

	/**
	 * @return the bundle
	 */
	@Column(name = "BUNDLE", nullable = false)
	public int getBundle() {
		return bundle;
	}

	/**
	 * @param bundle
	 *            the bundle to set
	 */
	public void setBundle(int bundle) {
		this.bundle = bundle;
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

	/**
	 * @return the type
	 */
	@Column(name = "TYPE", nullable = false)
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

}
