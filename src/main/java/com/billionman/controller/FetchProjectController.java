/**
 * 
 */
package com.billionman.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.billionman.model.Project;
import com.billionman.service.CreateProjectService;

/**
 * @author CTM
 *
 */
@ManagedBean
@RequestScoped
public class FetchProjectController {

	@ManagedProperty(value = "#{createProjectService}")
	CreateProjectService createProjectService;

	private Collection<Project> projectList;
	private Project selectedProject;

	public String fetchProject() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(createProjectService.fetchProjects());
		return "fetch";
	}

	public void editProject() {
		RequestContext.getCurrentInstance().openDialog("newProject");
	}

	public void onProjectChoosen(SelectEvent event) {
		Project tempProject = (Project) event.getObject();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Project Selected", "Id:" + tempProject.getId());

		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String updateProject() {
		createProjectService.updateProjectDetails(getSelectedProject());
		FacesMessage message = new FacesMessage("Successfully saved");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		fetchProject();
		return "fetch";
	}

	public String handleKeyEvent() {
		getProjectList().clear();
		getProjectList().addAll(createProjectService.fetchProjects());
		return "home";
	}

	public Collection<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(Collection<Project> projectList) {
		this.projectList = projectList;
	}

	/**
	 * @return the selectedProject
	 */
	public Project getSelectedProject() {
		return selectedProject;
	}

	/**
	 * @param selectedProject
	 *            the selectedProject to set
	 */
	public void setSelectedProject(Project selectedProject) {
		this.selectedProject = selectedProject;
	}

	/**
	 * @return the createProjectService
	 */
	public CreateProjectService getCreateProjectService() {
		return createProjectService;
	}

	/**
	 * @param createProjectService
	 *            the createProjectService to set
	 */
	public void setCreateProjectService(
			CreateProjectService createProjectService) {
		this.createProjectService = createProjectService;
	}

}
