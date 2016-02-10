/**
 * 
 */
package com.billionman.util.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.billionman.controller.helper.CenteringModel;
import com.billionman.model.Centering;
import com.billionman.model.Project;

/**
 * @author CTM
 *
 */
public class CenteringMapper extends ProjectMapper {
	public static final Collection<CenteringModel> mapFetchCentering(
			Collection<Centering> centeringList, List<Project> projList,
			int projId) {
		String projName = filterProjectName(projList, projId);
		Collection<CenteringModel> centeringModelBeans = new ArrayList<CenteringModel>();
		for (Centering centering : centeringList) {
			CenteringModel centeringModelBean = new CenteringModel();
			centeringModelBean.setAddedDate(centering.getAddedDate());
			centeringModelBean.setAmount(centering.getAmount());
			centeringModelBean.setQuantity(centering.getQuantity());
			centeringModelBean.setProjectName(projName);
			centeringModelBean.setCenteringId(centering.getCenteringId());
			centeringModelBeans.add(centeringModelBean);
		}
		return centeringModelBeans;
	}

	public static Centering mapUpdateCentering(CenteringModel centeringModel,
			int projId, List<Project> projects) {
		Project tmpProject = filterProject(projects, projId);
		Centering centering = new Centering();
		centering.setCenteringId(centeringModel.getCenteringId());
		centering.setProject(tmpProject.getId());
		centering.setQuantity(centeringModel.getQuantity());
		centering.setAmount(centeringModel.getAmount());
		centering.setAddedDate(new Date());
		return centering;
	}
}
