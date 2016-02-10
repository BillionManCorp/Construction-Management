/**
 * 
 */
package com.billionman.util.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.billionman.controller.helper.DoorsModel;
import com.billionman.model.GroupDoors;
import com.billionman.model.Project;

/**
 * @author CTM
 *
 */
public class DoorsMapper extends ProjectMapper {
	public static final Collection<DoorsModel> mapFetchDoors(
			Collection<GroupDoors> doorsList, List<Project> projList, int projId) {
		String projName = filterProjectName(projList, projId);
		Collection<DoorsModel> doorsModelBeans = new ArrayList<DoorsModel>();
		for (GroupDoors doors : doorsList) {
			DoorsModel doorsModelBean = new DoorsModel();
			doorsModelBean.setAddedDate(doors.getAddedDate());
			doorsModelBean.setAmount(doors.getAmount());
			doorsModelBean.setQuantity(doors.getQuantity());
			doorsModelBean.setProjectName(projName);
			doorsModelBean.setDoorsId(doors.getDoorsId());
			doorsModelBeans.add(doorsModelBean);
		}
		return doorsModelBeans;
	}

	public static GroupDoors mapUpdateDoors(DoorsModel doorsModel, int projId,
			List<Project> projects) {
		Project tmpProject = filterProject(projects, projId);
		GroupDoors doors = new GroupDoors();
		doors.setDoorsId(doorsModel.getDoorsId());
		doors.setProject(tmpProject.getId());
		doors.setQuantity(doorsModel.getQuantity());
		doors.setAmount(doorsModel.getAmount());
		doors.setAddedDate(new Date());
		return doors;
	}
}
