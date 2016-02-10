/**
 * 
 */
package com.billionman.util.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.billionman.controller.helper.JellyModel;
import com.billionman.model.Jelly;
import com.billionman.model.Project;

/**
 * @author CTM
 *
 */
public class JellyMapper extends ProjectMapper {
	public static final Collection<JellyModel> mapFetchJelly(
			Collection<Jelly> jellyList, List<Project> projList, int projId) {
		String projName = filterProjectName(projList, projId);
		Collection<JellyModel> jellyModelBeans = new ArrayList<JellyModel>();
		for (Jelly jelly : jellyList) {
			JellyModel jellyModelBean = new JellyModel();
			jellyModelBean.setAddedDate(jelly.getAddedDate());
			jellyModelBean.setAmount(jelly.getAmount());
			jellyModelBean.setQuantity(jelly.getQuantity());
			jellyModelBean.setProjectName(projName);
			jellyModelBean.setJellyId(jelly.getJellyId());
			jellyModelBean.setJellyType(jelly.getJellyType());
			jellyModelBeans.add(jellyModelBean);
		}
		return jellyModelBeans;
	}

	public static Jelly mapUpdateJelly(JellyModel jellyModel, int projId,
			List<Project> projects) {
		Project tmpProject = filterProject(projects, projId);
		Jelly jelly = new Jelly();
		jelly.setJellyId(jellyModel.getJellyId());
		jelly.setProject(tmpProject.getId());
		jelly.setQuantity(jellyModel.getQuantity());
		jelly.setAmount(jellyModel.getAmount());
		jelly.setAddedDate(new Date());
		jelly.setJellyType(jellyModel.getJellyType());
		return jelly;
	}
}
