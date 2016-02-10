/**
 * 
 */
package com.billionman.util.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.billionman.controller.helper.LaboursModel;
import com.billionman.model.Labour;
import com.billionman.model.Project;

/**
 * @author CTM
 *
 */
public class LaboursMapper extends ProjectMapper {
	public static final Collection<LaboursModel> mapFetchLabour(
			Collection<Labour> labourList, List<Project> projList, int projId) {
		String projName = filterProjectName(projList, projId);
		Collection<LaboursModel> laboursModelBeans = new ArrayList<LaboursModel>();
		for (Labour labour : labourList) {
			LaboursModel laboursModelBean = new LaboursModel();
			laboursModelBean.setAddedDate(labour.getAddedDate());
			laboursModelBean.setAmount(labour.getAmount());
			laboursModelBean.setProjectName(projName);
			laboursModelBean.setLabourId(labour.getLabourId());
			laboursModelBean.setDescription(labour.getDescription());
			laboursModelBeans.add(laboursModelBean);
		}
		return laboursModelBeans;
	}

	public static final Labour mapUpdateLabour(LaboursModel laboursModel,
			int projId, List<Project> projects) {
		Project tmpProject = filterProject(projects, projId);
		Labour labour = new Labour();
		labour.setLabourId(laboursModel.getLabourId());
		labour.setProject(tmpProject.getId());
		labour.setAmount(laboursModel.getAmount());
		labour.setAddedDate(new Date());
		labour.setDescription(laboursModel.getDescription());
		return labour;
	}
}
