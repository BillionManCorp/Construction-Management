/**
 * 
 */
package com.billionman.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import com.billionman.model.Project;
import com.billionman.service.CreateProjectService;
import com.billionman.util.Constants;

/**
 * @author CTM
 *
 */
@Component
@ManagedBean
@RequestScoped
public class CreateProjectController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2743355894795974136L;
	@ManagedProperty(value = "#{createProjectService}")
	private CreateProjectService createProjectService;

	@ManagedProperty(value = "#{loginModel}")
	LoginModel loginController;
	private String projName;
	private Project newProject;
	private Date startDate;
	private Date endDate;
	private String place;
	private int type;
	private String userName;
	private BigDecimal estimatedCost;

	public String createNewProject() {
		try {

			newProject = new Project();
			newProject.setProjectName(projName);
			newProject.setStartDate(startDate);
			newProject.setEndDate(null);
			newProject.setEstimatedCost(estimatedCost);
			newProject.setPlace(place);
			newProject.setProjectType(type);

			newProject.setUserName(loginController.getUserName());
			return createProjectService.createNewProject(newProject);
		} catch (Exception e) {
			Throwable ex = e.getCause();
			if (((SQLException) ex).getErrorCode() == Constants.ERROR_DUPLICATE_DATA) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL,
								"Same Project",
								"Project name should be unique!!!"));
			}
		}
		return null;
	}

	public String cancelCreateProject() {
		return "cancel";
	}

	/**
	 * @return the projName
	 */
	public String getProjName() {
		return projName;
	}

	/**
	 * @param projName
	 *            the projName to set
	 */
	public void setProjName(String projName) {
		this.projName = projName;
	}

	/**
	 * @return the newProject
	 */
	public Project getNewProject() {
		return newProject;
	}

	/**
	 * @param newProject
	 *            the newProject to set
	 */
	public void setNewProject(Project newProject) {
		this.newProject = newProject;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the estimatedCost
	 */
	public BigDecimal getEstimatedCost() {
		return estimatedCost;
	}

	/**
	 * @param estimatedCost
	 *            the estimatedCost to set
	 */
	public void setEstimatedCost(BigDecimal estimatedCost) {
		this.estimatedCost = estimatedCost;
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

	/**
	 * @return the loginController
	 */
	public LoginModel getLoginController() {
		return loginController;
	}

	/**
	 * @param loginController
	 *            the loginController to set
	 */
	public void setLoginController(LoginModel loginController) {
		this.loginController = loginController;
	}

}
