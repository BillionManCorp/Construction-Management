/**
 * 
 */
package com.billionman.util.mapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.billionman.controller.helper.SteelModelBean;
import com.billionman.model.Project;
import com.billionman.model.Steel;

/**
 * @author CTM
 *
 */
public final class SteelMapper extends ProjectMapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4762932716153423978L;

	/**
	 * 
	 */
	public SteelMapper() {
		// TODO Auto-generated constructor stub
	}

	public static final Collection<SteelModelBean> mapFetchSteel(
			Collection<Steel> steelList, List<Project> projList, int projId) {
		String projName = filterProjectName(projList, projId);
		Collection<SteelModelBean> steelModelBeans = new ArrayList<SteelModelBean>();
		for (Steel steel : steelList) {
			SteelModelBean steelModelBean = new SteelModelBean();
			steelModelBean.setAddedDate(steel.getAddedDate());
			steelModelBean.setAmount(steel.getAmount());
			steelModelBean.setBundle(steel.getBundle());
			steelModelBean.setProjectName(projName);
			steelModelBean.setQuantityTonnes(steel.getQuantityTonnes());
			steelModelBean.setSteelId(steel.getSteelId());
			steelModelBean.setType(steel.getType());
			steelModelBeans.add(steelModelBean);
		}
		return steelModelBeans;
	}

}
