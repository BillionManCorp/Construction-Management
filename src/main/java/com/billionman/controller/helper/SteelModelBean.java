/**
 * 
 */
package com.billionman.controller.helper;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author CTM
 *
 */
public class SteelModelBean {

	private int steelId;
	private long quantityTonnes;
	private int bundle;
	private BigDecimal amount;
	private int type;
	private Date addedDate;
	private String projectName;

	/**
	 * 
	 */
	public SteelModelBean() {
		// TODO Auto-generated constructor stub
	}

	public SteelModelBean(int steelId, long quantityTonnes, int bundle,
			BigDecimal amount, int type, Date addedDate, String projectName) {
		super();
		this.steelId = steelId;
		this.quantityTonnes = quantityTonnes;
		this.bundle = bundle;
		this.amount = amount;
		this.type = type;
		this.addedDate = addedDate;
		this.projectName = projectName;
	}

	/**
	 * @return the steelId
	 */
	public int getSteelId() {
		return steelId;
	}

	/**
	 * @param steelId
	 *            the steelId to set
	 */
	public void setSteelId(int steelId) {
		this.steelId = steelId;
	}

	/**
	 * @return the quantityTonnes
	 */
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
	 * @return the type
	 */
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

	/**
	 * @return the addedDate
	 */
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
	 * @return the projectName
	 */
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
}
