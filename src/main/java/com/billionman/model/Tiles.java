/**
 * 
 */
package com.billionman.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.billionman.util.TilesType;

/**
 * @author CTM
 *
 */
@Entity
@Table(name = "TILES")
public class Tiles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8953147000932503442L;

	private int tilesId;
	private TilesType tilesType;
	private long quantity;
	private BigDecimal amount;
	private Date addedDate;
	private int project;

	/**
	 * 
	 */
	public Tiles() {
		// TODO Auto-generated constructor stub
	}

	public Tiles(int tilesId, TilesType tilesType, long quantity,
			BigDecimal amount, Date addedDate, int project) {
		super();
		this.tilesId = tilesId;
		this.tilesType = tilesType;
		this.quantity = quantity;
		this.amount = amount;
		this.addedDate = addedDate;
		this.project = project;
	}

	/**
	 * @return the tilesId
	 */
	@Id
	@Column(name = "TILES_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getTilesId() {
		return tilesId;
	}

	/**
	 * @param tilesId
	 *            the tilesId to set
	 */
	public void setTilesId(int tilesId) {
		this.tilesId = tilesId;
	}

	/**
	 * @return the tilesType
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="TILES_TYPE", nullable = false)
	public TilesType getTilesType() {
		return tilesType;
	}

	/**
	 * @param tilesType
	 *            the tilesType to set
	 */
	public void setTilesType(TilesType tilesType) {
		this.tilesType = tilesType;
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
