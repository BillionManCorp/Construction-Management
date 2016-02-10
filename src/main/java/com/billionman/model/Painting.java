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

import com.billionman.util.PaintType;

/**
 * @author CTM
 *
 */
@Entity
@Table(name = "PAINTING")
public class Painting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1671407878513003564L;

	private int paintId;
	private PaintType paintType;
	private String description;
	private long quantity;
	private BigDecimal amount;
	private Date addedDate;
	private int project;

	/**
	 * 
	 */
	public Painting() {
		// TODO Auto-generated constructor stub
	}

	public Painting(int paintId, PaintType paintType, String description,
			long quantity, BigDecimal amount, Date addedDate, int project) {
		super();
		this.paintId = paintId;
		this.paintType = paintType;
		this.description = description;
		this.quantity = quantity;
		this.amount = amount;
		this.addedDate = addedDate;
		this.project = project;
	}

	/**
	 * @return the paintId
	 */
	@Id
	@Column(name = "PAINT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPaintId() {
		return paintId;
	}

	/**
	 * @param paintId
	 *            the paintId to set
	 */
	public void setPaintId(int paintId) {
		this.paintId = paintId;
	}

	/**
	 * @return the paintType
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "PAINT_TYPE", nullable = false)
	public PaintType getPaintType() {
		return paintType;
	}

	/**
	 * @param paintType
	 *            the paintType to set
	 */
	public void setPaintType(PaintType paintType) {
		this.paintType = paintType;
	}

	/**
	 * @return the description
	 */
	@Column(name = "DESCRIPTION", nullable = false, length = 100)
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
