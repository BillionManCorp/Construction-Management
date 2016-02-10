/**
 * 
 */
package com.billionman.util.mapper;

import java.util.List;

import com.billionman.model.Project;

/**
 * @author CTM
 *
 */
public class ProjectMapper {

	/**
	 * 
	 */
	public ProjectMapper() {
		// TODO Auto-generated constructor stub
	}

	protected static final String filterProjectName(List<Project> projList,
			int projId) {
		for (Project project : projList) {
			if (projId == project.getId()) {
				return project.getProjectName();
			}
		}
		return null;
	}

	protected static Project filterProject(List<Project> projList, int projId) {
		for (Project project : projList) {
			if (projId == project.getId()) {
				return project;
			}
		}
		return null;
	}
}
