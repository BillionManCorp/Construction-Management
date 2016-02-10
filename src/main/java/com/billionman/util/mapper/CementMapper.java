/**
 * 
 */
package com.billionman.util.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.billionman.controller.helper.CementModel;
import com.billionman.model.Cement;
import com.billionman.model.Project;

/**
 * @author CTM
 *
 */
public class CementMapper extends ProjectMapper {

	public CementMapper() {
		// TODO Auto-generated constructor stub
	}

	public static final Collection<CementModel> mapFetchCement(
			Collection<Cement> cementList, List<Project> projList, int projId) {
		String projName = filterProjectName(projList, projId);
		Collection<CementModel> cementModelBeans = new ArrayList<CementModel>();
		for (Cement cement : cementList) {
			CementModel cementModelBean = new CementModel();
			cementModelBean.setAddedDate(cement.getAddedDate());
			cementModelBean.setAmount(cement.getAmount());
			cementModelBean.setNumberBags(cement.getNumberBags());
			cementModelBean.setProjectName(projName);
			cementModelBean.setCementId(cement.getCementId());
			cementModelBeans.add(cementModelBean);
		}
		return cementModelBeans;
	}

	public static Cement mapUpdateCement(CementModel cementModel, int projId,
			List<Project> projects) {
		Project tmpProject = filterProject(projects, projId);
		Cement cement = new Cement();
		cement.setCementId(cementModel.getCementId());
		cement.setProjectCement(tmpProject.getId());
		cement.setNumberBags(cementModel.getNumberBags());
		cement.setAmount(cementModel.getAmount());
		cement.setAddedDate(new Date());
		return cement;
	}
}
