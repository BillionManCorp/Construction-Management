/**
 * 
 */
package com.billionman.util.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.billionman.controller.helper.GrillModel;
import com.billionman.model.Grill;
import com.billionman.model.Project;

/**
 * @author CTM
 *
 */
public class GrillMapper extends ProjectMapper {
	public static final Collection<GrillModel> mapFetchGrill(
			Collection<Grill> grillList, List<Project> projList, int projId) {
		String projName = filterProjectName(projList, projId);
		Collection<GrillModel> grillModelBeans = new ArrayList<GrillModel>();
		for (Grill grill : grillList) {
			GrillModel grillModelBean = new GrillModel();
			grillModelBean.setAddedDate(grill.getAddedDate());
			grillModelBean.setAmount(grill.getAmount());
			grillModelBean.setQuantity(grill.getQuantity());
			grillModelBean.setProjectName(projName);
			grillModelBean.setGrillId(grill.getGrillId());
			grillModelBeans.add(grillModelBean);
		}
		return grillModelBeans;
	}

	public static Grill mapUpdateGrill(GrillModel grillModel, int projId,
			List<Project> projects) {
		Project tmpProject = filterProject(projects, projId);
		Grill grill = new Grill();
		grill.setGrillId(grillModel.getGrillId());
		grill.setProject(tmpProject.getId());
		grill.setQuantity(grillModel.getQuantity());
		grill.setAmount(grillModel.getAmount());
		grill.setAddedDate(new Date());
		return grill;
	}
}
