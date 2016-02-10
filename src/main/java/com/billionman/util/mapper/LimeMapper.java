/**
 * 
 */
package com.billionman.util.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.billionman.controller.helper.LimeModel;
import com.billionman.model.LimeRendering;
import com.billionman.model.Project;

/**
 * @author CTM
 *
 */
public class LimeMapper extends ProjectMapper {
	public static final Collection<LimeModel> mapFetchLime(
			Collection<LimeRendering> limeList, List<Project> projList,
			int projId) {
		String projName = filterProjectName(projList, projId);
		Collection<LimeModel> limeModelBeans = new ArrayList<LimeModel>();
		for (LimeRendering lime : limeList) {
			LimeModel limeModelBean = new LimeModel();
			limeModelBean.setAddedDate(lime.getAddedDate());
			limeModelBean.setAmount(lime.getAmount());
			limeModelBean.setProjectName(projName);
			limeModelBean.setLimeId(lime.getLimeId());
			limeModelBeans.add(limeModelBean);
		}
		return limeModelBeans;
	}

	public static final LimeRendering mapUpdateLime(LimeModel limeModel,
			int projId, List<Project> projects) {
		Project tmpProject = filterProject(projects, projId);
		LimeRendering lime = new LimeRendering();
		lime.setLimeId(limeModel.getLimeId());
		lime.setProject(tmpProject.getId());
		lime.setAmount(limeModel.getAmount());
		lime.setAddedDate(new Date());
		return lime;
	}
}
