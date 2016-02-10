/**
 * 
 */
package com.billionman.controller.materialscontroller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import com.billionman.controller.helper.CementModel;
import com.billionman.model.Project;
import com.billionman.service.CreateProjectService;
import com.billionman.service.DeleteMaterialsService;
import com.billionman.service.FetchMaterialsService;
import com.billionman.service.UpdateMaterialsService;
import com.billionman.util.Constants;
import com.billionman.util.mapper.CementMapper;

/**
 * @author CTM
 *
 */
@ManagedBean
@SessionScoped
public class CementEditDeleteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4111784736444666324L;

	@ManagedProperty(value = "#{createProjectService}")
	private CreateProjectService createProjectService;
	@ManagedProperty(value = "#{fetchMaterialsService}")
	private FetchMaterialsService fetchMaterialsService;
	@ManagedProperty(value = "#{deleteMaterialsService}")
	private DeleteMaterialsService deleteMaterialsService;
	@ManagedProperty(value = "#{updateMaterialsService}")
	private UpdateMaterialsService updateMaterialsService;

	@ManagedProperty(value = "#{materialsModel}")
	private MaterialsModel materialsModel;

	private CementModel selectedCementModel;

	private Collection<CementModel> cementList;

	private int selectedProject;

	public String updateCement() {
		String success = updateMaterialsService.updateCement(CementMapper
				.mapUpdateCement(getSelectedCementModel(), getMaterialsModel()
						.getSelectedProject(), getMaterialsModel()
						.getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage(
				"Successfully saved") : new FacesMessage("Failed Saving");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearAndFetchCement();
		return "report";
	}

	public String deleteCement() {
		String success = deleteMaterialsService.deleteCement(CementMapper
				.mapUpdateCement(getSelectedCementModel(), getMaterialsModel()
						.getSelectedProject(), getMaterialsModel()
						.getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage(
				"Successfully saved") : new FacesMessage("Failed Deleting");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearAndFetchCement();
		return "report";
	}

	public MaterialsModel getMaterialsModel() {
		if (materialsModel == null) {
			this.materialsModel = (MaterialsModel) FacesContext
					.getCurrentInstance().getExternalContext().getSessionMap()
					.get("materialsModel");
			setSelectedProject(getMaterialsModel().getSelectedProject());
		}
		return materialsModel;
	}

	/**
	 * 
	 * @param projId
	 */
	public void fetchCement(int projId) {
		getMaterialsModel().setAppendDialogPage(
				"/view/secure/report/dialog/cementDialog.xhtml");
		getMaterialsModel().clearMaterialsList();
		getMaterialsModel().setAppendPage(Constants.PATH_CEMENT);
		setCementList(new ArrayList<CementModel>());
		this.cementList.clear();
		this.cementList.addAll(CementMapper.mapFetchCement(
				fetchMaterialsService.fetchCement(projId), getMaterialsModel()
						.getProjectList(), projId));
	}

	private void clearAndFetchCement() {
		getMaterialsModel().clearMaterialsList();
		getMaterialsModel().setAppendPage(Constants.PATH_CEMENT);
		fetchCement(getMaterialsModel().getSelectedProject());
	}

	/**
	 * @return the selectedProject
	 */
	public int getSelectedProject() {
		return selectedProject;
	}

	/**
	 * @param selectedProject
	 *            the selectedProject to set
	 */
	public void setSelectedProject(int selectedProject) {
		this.selectedProject = selectedProject;
	}

	public List<Project> getProjectList() {
		return getMaterialsModel().getProjectList();
	}

	/**
	 * @return the cementList
	 */
	public Collection<CementModel> getCementList() {
		clearAndFetchCement();
		return cementList;
	}

	/**
	 * @param cementList
	 *            the cementList to set
	 */
	public void setCementList(Collection<CementModel> cementList) {
		this.cementList = cementList;
	}

	/**
	 * @return the selectedCementModel
	 */
	public CementModel getSelectedCementModel() {
		return selectedCementModel;
	}

	/**
	 * @param selectedCementModel
	 *            the selectedCementModel to set
	 */
	public void setSelectedCementModel(CementModel selectedCementModel) {
		this.selectedCementModel = selectedCementModel;
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
	 * @return the fetchMaterialsService
	 */
	public FetchMaterialsService getFetchMaterialsService() {
		return fetchMaterialsService;
	}

	/**
	 * @param fetchMaterialsService
	 *            the fetchMaterialsService to set
	 */
	public void setFetchMaterialsService(
			FetchMaterialsService fetchMaterialsService) {
		this.fetchMaterialsService = fetchMaterialsService;
	}

	/**
	 * @return the deleteMaterialsService
	 */
	public DeleteMaterialsService getDeleteMaterialsService() {
		return deleteMaterialsService;
	}

	/**
	 * @param deleteMaterialsService
	 *            the deleteMaterialsService to set
	 */
	public void setDeleteMaterialsService(
			DeleteMaterialsService deleteMaterialsService) {
		this.deleteMaterialsService = deleteMaterialsService;
	}

	/**
	 * @return the updateMaterialsService
	 */
	public UpdateMaterialsService getUpdateMaterialsService() {
		return updateMaterialsService;
	}

	/**
	 * @param updateMaterialsService
	 *            the updateMaterialsService to set
	 */
	public void setUpdateMaterialsService(
			UpdateMaterialsService updateMaterialsService) {
		this.updateMaterialsService = updateMaterialsService;
	}

	/**
	 * @param materialsModel
	 *            the materialsModel to set
	 */
	public void setMaterialsModel(MaterialsModel materialsModel) {
		this.materialsModel = materialsModel;
	}

	public void resetValues() {
		// reset input fields to prevent stuck values after a validation failure
		// not necessary in JSF 2.2+ (@resetValues on a4j:commandButton)
		// if (!JsfVersion.getCurrent().isCompliantWith(JsfVersion.JSF_2_2)) {
		FacesContext fc = FacesContext.getCurrentInstance();
		UIComponent comp = fc.getViewRoot().findComponent("form:editGrid");

		((EditableValueHolder) comp.findComponent("form:price")).resetValue();
		((EditableValueHolder) comp.findComponent("form:mage")).resetValue();
		((EditableValueHolder) comp.findComponent("form:vin")).resetValue();
		// }
	}
}
