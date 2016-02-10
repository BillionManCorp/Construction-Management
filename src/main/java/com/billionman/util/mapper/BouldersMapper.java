/**
 * 
 */
package com.billionman.util.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.billionman.controller.helper.BouldersModel;
import com.billionman.model.Boulders;
import com.billionman.model.Project;

/**
 * @author CTM
 *
 */
public class BouldersMapper extends ProjectMapper {

	public static final Collection<BouldersModel> mapFetchBoulders(
			Collection<Boulders> bouldersList, List<Project> projList,
			int projId) {
		String projName = filterProjectName(projList, projId);
		Collection<BouldersModel> bouldersModelBeans = new ArrayList<BouldersModel>();
		for (Boulders boulders : bouldersList) {
			BouldersModel bouldersModelBean = new BouldersModel();
			bouldersModelBean.setAddedDate(boulders.getAddedDate());
			bouldersModelBean.setAmount(boulders.getAmount());
			bouldersModelBean.setTrips(boulders.getTrips());
			bouldersModelBean.setProjectName(projName);
			bouldersModelBean.setBouldersId(boulders.getBouldersId());
			bouldersModelBeans.add(bouldersModelBean);
		}
		return bouldersModelBeans;
	}

	public static Boulders mapUpdateBoulders(BouldersModel bouldersModel,
			int projId, List<Project> projects) {
		Project tmpProject = filterProject(projects, projId);
		Boulders boulders = new Boulders();
		boulders.setBouldersId(bouldersModel.getBouldersId());
		boulders.setProject(tmpProject.getId());
		boulders.setTrips(bouldersModel.getTrips());
		boulders.setAmount(bouldersModel.getAmount());
		boulders.setAddedDate(new Date());
		return boulders;
	}
}
