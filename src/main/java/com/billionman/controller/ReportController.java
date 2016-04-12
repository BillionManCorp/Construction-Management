/**
 * 
 */
package com.billionman.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import com.billionman.controller.helper.BouldersModel;
import com.billionman.controller.helper.BricksModel;
import com.billionman.controller.helper.CementModel;
import com.billionman.controller.helper.CenteringModel;
import com.billionman.controller.helper.DoorsModel;
import com.billionman.controller.helper.GrillModel;
import com.billionman.controller.helper.JellyModel;
import com.billionman.controller.helper.LaboursModel;
import com.billionman.controller.helper.LimeModel;
import com.billionman.controller.helper.SteelModelBean;
import com.billionman.controller.materialscontroller.BricksController;
import com.billionman.controller.materialscontroller.CementEditDeleteController;
import com.billionman.controller.materialscontroller.MaterialsModel;
import com.billionman.model.Project;
import com.billionman.service.CreateProjectService;
import com.billionman.service.DeleteMaterialsService;
import com.billionman.service.FetchMaterialsService;
import com.billionman.service.UpdateMaterialsService;
import com.billionman.util.Constants;
import com.billionman.util.Constants.Materials;
import com.billionman.util.mapper.BouldersMapper;
import com.billionman.util.mapper.BricksMapper;
import com.billionman.util.mapper.CementMapper;
import com.billionman.util.mapper.CenteringMapper;
import com.billionman.util.mapper.DoorsMapper;
import com.billionman.util.mapper.GrillMapper;
import com.billionman.util.mapper.JellyMapper;
import com.billionman.util.mapper.LaboursMapper;
import com.billionman.util.mapper.LimeMapper;
import com.billionman.util.mapper.SteelMapper;

/**
 * @author CTM
 *
 */
@ManagedBean
@SessionScoped
public class ReportController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7954640139828840510L;

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
	@ManagedProperty(value = "#{cementEditDeleteController}")
	private CementEditDeleteController cementEditDeleteController;
	@ManagedProperty(value = "#{bricksController}")
	private BricksController bricksController;

	private Collection<SteelModelBean> steelList;
	private Collection<CementModel> cementList;
	private Collection<BricksModel> bricksList;
	private Collection<BouldersModel> bouldersList;
	private Collection<CenteringModel> centeringList;
	private Collection<DoorsModel> doorsList;
	private Collection<GrillModel> grillList;
	private Collection<JellyModel> jellyList;
	private Collection<LaboursModel> laboursList;
	private Collection<LimeModel> limeList;

	private boolean editMode;

	private BricksModel brickDetails;

	private CementModel selectedCementModel;
	private BouldersModel selectedBouldersModel;
	private CenteringModel selectedCenteringModel;
	private DoorsModel selectedDoorsModel;
	private GrillModel selectedGrillModel;
	private JellyModel selectedJellyModel;
	private LaboursModel selectedLaboursModel;
	private LimeModel selectedLimeModel;

	public String redirectToReport() {
		// setMaterialsModel(new MaterialsModel());
		System.out.println("getModelBean: " + getMaterialsModel() + " " + this.materialsModel);
		clear();
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(createProjectService.fetchProjects());
		return "report";
	}

	private void clear() {
		setSelectedMaterial(null);
		setSelectedProject(0);
		setAppendPage(null);
		setMaterial(false);
	}

	public SelectItem[] getMaterialValues() {
		SelectItem[] items = new SelectItem[Constants.Materials.values().length];
		List<Materials> materials = new ArrayList<Constants.Materials>();
		int i = 0;
		for (Materials g : Constants.Materials.values()) {
			materials.add(g);
		}
		Collections.sort(materials);
		Collections.sort(materials, new Comparator<Materials>() {
			public int compare(Materials mat1, Materials mat2) {
				return mat1.getLabel().compareTo(mat2.getLabel());
			}
		});
		for (Materials materials2 : materials) {
			items[i++] = new SelectItem(materials2, materials2.getLabel());
		}
		return items;
	}

	public void enableMaterial(ValueChangeEvent e) {
		if (e.getNewValue() != Integer.valueOf(0)) {
			setMaterial(true);
			if (getSelectedMaterial() != null && !getSelectedMaterial().isEmpty()) {
				setSelectedProject(Integer.parseInt(e.getNewValue().toString()));
				filterMaterial(getSelectedMaterial());
			}
		} else {
			clear();
			clearListFields();
		}
	}

	public void fetchMaterial(ValueChangeEvent e) {
		filterMaterial(e.getNewValue().toString());
	}

	private void filterMaterial(String val) {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		setModelBeanObject(request, val);
		switch (Materials.getEnumForValue(val)) {
		case BOULDERS:
			fetchBoulders(getSelectedProject());
			setAppendPage(Constants.PATH_BOULDER);
			getMaterialsModel().setAppendPage(Constants.PATH_BOULDER);
			break;
		case BRICKS:
			getBricksController().fetchBricks(getSelectedProject());
			getMaterialsModel().setAppendPage(Constants.PATH_BRICK);
			break;
		case CEMENT:
			getCementEditDeleteController().fetchCement(getSelectedProject());
			getMaterialsModel().setAppendPage(Constants.PATH_CEMENT);
			break;
		case CENTERING:
			fetchCentering(getSelectedProject());
			setAppendPage(Constants.PATH_CENTERING);
			getMaterialsModel().setAppendPage(Constants.PATH_CENTERING);
			break;
		case DOORS:
			fetchGroupDoors(getSelectedProject());
			setAppendPage(Constants.PATH_DOORS);
			getMaterialsModel().setAppendPage(Constants.PATH_DOORS);
			break;
		case GRILL:
			fetchGrill(getSelectedProject());
			setAppendPage(Constants.PATH_GRILL);
			getMaterialsModel().setAppendPage(Constants.PATH_GRILL);
			break;
		case JELLY:
			fetchJelly(getSelectedProject());
			setAppendPage(Constants.PATH_JELLY);
			getMaterialsModel().setAppendPage(Constants.PATH_JELLY);
			break;
		case LABOURS:
			fetchLabours(getSelectedProject());
			setAppendPage(Constants.PATH_LABOURS);
			getMaterialsModel().setAppendPage(Constants.PATH_LABOURS);
			break;
		case LIME:
			fetchLabours(getSelectedProject());
			setAppendPage(Constants.PATH_LIME);
			getMaterialsModel().setAppendPage(Constants.PATH_LIME);
			break;
		case PAINTING:
			setAppendPage(Constants.PATH_PAINTING);
			break;
		case PLASTERING:
			setAppendPage(Constants.PATH_PLASTERING);
			break;
		case PLUMBING:
			setAppendPage(Constants.PATH_PLUMBING);
			break;
		case POWER:
			setAppendPage(Constants.PATH_POWER);
			break;
		case SAND:
			setAppendPage(Constants.PATH_SAND);
			break;
		case SANITARY:
			setAppendPage(Constants.PATH_SANITARY);
			break;
		case STEEL:
			fetchSteel(getSelectedProject());
			setAppendPage(Constants.PATH_STEEL);
			break;
		case STONE:
			setAppendPage(Constants.PATH_STONE);
			break;
		case TILES:
			setAppendPage(Constants.PATH_TILES);
			break;
		case VEHICLE:
			setAppendPage(Constants.PATH_VEHICLE);
			break;
		case WATER:
			setAppendPage(Constants.PATH_WATER);
			break;
		case WOOD:
			setAppendPage(Constants.PATH_WOOD);
			break;
		default:
			setAppendPage(null);
			clear();
			clearListFields();
			request.getSession().setAttribute("materialsModel", null);
			break;
		}
		setSelectedMaterial(val);
	}

	private void setModelBeanObject(HttpServletRequest request, String material) {
		getMaterialsModel().setProjectList(getProjectList());
		getMaterialsModel().setSelectedMaterial(material);
		request.getSession().setAttribute("materialsModel", getMaterialsModel());
	}

	public void enterEditMode(ActionEvent a) {
		System.out.println("enter edit mode");
		// for (Materials material : Materials.values()) {
		// if(selectedMaterial.equals(material)) {
		RequestContext.getCurrentInstance().openDialog("bricksDialog");
		// }
		// }
	}

	/**
	 * 
	 * @param projId
	 */
	private void fetchSteel(int projId) {
		clearListFields();
		setSteelList(new ArrayList<SteelModelBean>());
		getSteelList()
				.addAll(SteelMapper.mapFetchSteel(fetchMaterialsService.fetchSteel(projId), getProjectList(), projId));
	}

	private void fetchBricks(int projId) {
		clearListFields();
		setBricksList(new ArrayList<BricksModel>());
		getBricksList().addAll(
				BricksMapper.mapFetchBricks(fetchMaterialsService.fetchBricks(projId), getProjectList(), projId));
	}

	public String updateBricks() {
		String success = updateMaterialsService
				.updateBricks(BricksMapper.mapUpdateBrick(getBrickDetails(), getSelectedProject(), getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Saving");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_BRICK);
		fetchBricks(getSelectedProject());
		return "report";
	}

	public String deleteBricks() {
		String success = deleteMaterialsService
				.deleteBricks(BricksMapper.mapUpdateBrick(getBrickDetails(), getSelectedProject(), getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Saving");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_BRICK);
		fetchBricks(getSelectedProject());
		return "report";
	}

	/** Boulder */
	public String updateBoulders() {
		String success = updateMaterialsService
				.updateBoulders(BouldersMapper.mapUpdateBoulders(getSelectedBouldersModel(),
						getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Saving");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_BOULDER);
		fetchBoulders(getSelectedProject());
		return "report";
	}

	public String deleteBoulders() {
		String success = deleteMaterialsService
				.deleteBoulders(BouldersMapper.mapUpdateBoulders(getSelectedBouldersModel(),
						getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Deleting");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_BOULDER);
		fetchBoulders(getSelectedProject());
		return "report";
	}

	/**
	 * 
	 * @param projId
	 */
	private void fetchBoulders(int projId) {
		getMaterialsModel().clearMaterialsList();
		setBouldersList(new ArrayList<BouldersModel>());
		this.bouldersList.clear();
		this.bouldersList.addAll(BouldersMapper.mapFetchBoulders(fetchMaterialsService.fetchBoulders(projId),
				getMaterialsModel().getProjectList(), projId));
	}

	/** Centering */
	public String updateCentering() {
		String success = updateMaterialsService
				.updateCentering(CenteringMapper.mapUpdateCentering(getSelectedCenteringModel(),
						getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Saving");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_CENTERING);
		fetchCentering(getSelectedProject());
		return "report";
	}

	public String deleteCentering() {
		String success = deleteMaterialsService
				.deleteCentering(CenteringMapper.mapUpdateCentering(getSelectedCenteringModel(),
						getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Deleting");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_CENTERING);
		fetchCentering(getSelectedProject());
		return "report";
	}

	/**
	 * 
	 * @param projId
	 */
	private void fetchCentering(int projId) {
		getMaterialsModel().clearMaterialsList();
		setCenteringList(new ArrayList<CenteringModel>());
		this.centeringList.clear();
		this.centeringList.addAll(CenteringMapper.mapFetchCentering(fetchMaterialsService.fetchCentering(projId),
				getMaterialsModel().getProjectList(), projId));
	}

	/** Group Doors */
	public String updateDoors() {
		String success = updateMaterialsService.updateDoors(DoorsMapper.mapUpdateDoors(getSelectedDoorsModel(),
				getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Saving");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_DOORS);
		fetchGroupDoors(getSelectedProject());
		return "report";
	}

	public String deleteDoors() {
		String success = deleteMaterialsService.deleteDoors(DoorsMapper.mapUpdateDoors(getSelectedDoorsModel(),
				getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Deleting");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_DOORS);
		fetchGroupDoors(getSelectedProject());
		return "report";
	}

	/**
	 * 
	 * @param projId
	 */
	private void fetchGroupDoors(int projId) {
		getMaterialsModel().clearMaterialsList();
		setDoorsList(new ArrayList<DoorsModel>());
		this.doorsList.clear();
		this.doorsList.addAll(DoorsMapper.mapFetchDoors(fetchMaterialsService.fetchGroupDoors(projId),
				getMaterialsModel().getProjectList(), projId));
	}

	/** Grill */
	public String updateGrill() {
		String success = updateMaterialsService.updateGrill(GrillMapper.mapUpdateGrill(getSelectedGrillModel(),
				getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Saving");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_GRILL);
		fetchGrill(getSelectedProject());
		return "report";
	}

	public String deleteGrill() {
		String success = deleteMaterialsService.deleteGrill(GrillMapper.mapUpdateGrill(getSelectedGrillModel(),
				getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Deleting");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_GRILL);
		fetchGrill(getSelectedProject());
		return "report";
	}

	/**
	 * 
	 * @param projId
	 */
	private void fetchGrill(int projId) {
		getMaterialsModel().clearMaterialsList();
		setGrillList(new ArrayList<GrillModel>());
		this.grillList.clear();
		this.grillList.addAll(GrillMapper.mapFetchGrill(fetchMaterialsService.fetchGrill(projId),
				getMaterialsModel().getProjectList(), projId));
	}

	/** Jelly */
	public String updateJelly() {
		String success = updateMaterialsService.updateJelly(JellyMapper.mapUpdateJelly(getSelectedJellyModel(),
				getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Saving");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_JELLY);
		fetchGrill(getSelectedProject());
		return "report";
	}

	public String deleteJelly() {
		String success = deleteMaterialsService.deleteJelly(JellyMapper.mapUpdateJelly(getSelectedJellyModel(),
				getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Deleting");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_JELLY);
		fetchGrill(getSelectedProject());
		return "report";
	}

	/**
	 * 
	 * @param projId
	 */
	private void fetchJelly(int projId) {
		getMaterialsModel().clearMaterialsList();
		setJellyList(new ArrayList<JellyModel>());
		this.jellyList.clear();
		this.jellyList.addAll(JellyMapper.mapFetchJelly(fetchMaterialsService.fetchJelly(projId),
				getMaterialsModel().getProjectList(), projId));
	}

	/** Labours */
	public String updateLabours() {
		String success = updateMaterialsService.updateLabours(LaboursMapper.mapUpdateLabour(getSelectedLaboursModel(),
				getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Saving");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_LABOURS);
		fetchGrill(getSelectedProject());
		return "report";
	}

	public String deleteLabours() {
		String success = deleteMaterialsService.deleteLabours(LaboursMapper.mapUpdateLabour(getSelectedLaboursModel(),
				getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Deleting");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_LABOURS);
		fetchGrill(getSelectedProject());
		return "report";
	}

	/**
	 * 
	 * @param projId
	 */
	private void fetchLabours(int projId) {
		getMaterialsModel().clearMaterialsList();
		setLaboursList(new ArrayList<LaboursModel>());
		this.laboursList.clear();
		this.laboursList.addAll(LaboursMapper.mapFetchLabour(fetchMaterialsService.fetchLabours(projId),
				getMaterialsModel().getProjectList(), projId));
	}

	/** Lime Rendering */
	public String updateLimeRendering() {
		String success = updateMaterialsService.updateLime(LimeMapper.mapUpdateLime(getSelectedLimeModel(),
				getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Saving");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_LIME);
		fetchGrill(getSelectedProject());
		return "report";
	}

	public String deleteLimeRendering() {
		String success = deleteMaterialsService.deleteLime(LimeMapper.mapUpdateLime(getSelectedLimeModel(),
				getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Deleting");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_LIME);
		fetchGrill(getSelectedProject());
		return "report";
	}

	/** Painting */
	public String updatePainting() {
		String success = updateMaterialsService.updateLime(LimeMapper.mapUpdateLime(getSelectedLimeModel(),
				getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Saving");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_LIME);
		fetchGrill(getSelectedProject());
		return "report";
	}

	public String deletePainting() {
		String success = deleteMaterialsService.deleteLime(LimeMapper.mapUpdateLime(getSelectedLimeModel(),
				getMaterialsModel().getSelectedProject(), getMaterialsModel().getProjectList()));
		FacesMessage message = Constants.SUCCESS.equals(success) ? new FacesMessage("Successfully saved")
				: new FacesMessage("Failed Deleting");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		clearListFields();
		setAppendPage(Constants.PATH_LIME);
		fetchGrill(getSelectedProject());
		return "report";
	}

	private void clearListFields() {
		setSteelList(null);
		setCementList(null);
		setBouldersList(null);
		setCenteringList(null);
		setDoorsList(null);
		setGrillList(null);
		setJellyList(null);
		setLaboursList(null);
		setLimeList(null);
		materialsModel.clearMaterialsList();
	}

	public MaterialsModel getMaterialsModel() {
		return materialsModel;
	}

	/**
	 * @param materialsModel
	 *            the materialsModel to set
	 */
	public void setMaterialsModel(MaterialsModel materialsModel) {
		this.materialsModel = materialsModel;
	}

	/**
	 * @return the steelList
	 */
	public Collection<SteelModelBean> getSteelList() {
		return steelList;
	}

	/**
	 * @param steelList
	 *            the steelList to set
	 */
	public void setSteelList(Collection<SteelModelBean> steelList) {
		this.steelList = steelList;
	}

	/**
	 * @return the selectedProject
	 */
	public int getSelectedProject() {
		return materialsModel.getSelectedProject();
	}

	/**
	 * @param selectedProject
	 *            the selectedProject to set
	 */
	public void setSelectedProject(int selectedProject) {
		materialsModel.setSelectedProject(selectedProject);
	}

	/**
	 * @return the projectList
	 */
	public List<Project> getProjectList() {
		return materialsModel.getProjectList();
	}

	/**
	 * @param projectList
	 *            the projectList to set
	 */
	public void setProjectList(List<Project> projectList) {
		materialsModel.setProjectList(projectList);
	}

	/**
	 * @return the selectedMaterial
	 */
	public String getSelectedMaterial() {
		return materialsModel.getSelectedMaterial();
	}

	/**
	 * @param selectedMaterial
	 *            the selectedMaterial to set
	 */
	public void setSelectedMaterial(String selectedMaterial) {
		materialsModel.setSelectedMaterial(selectedMaterial);
	}

	/**
	 * @return the appendPage
	 */
	public String getAppendPage() {
		return materialsModel.getAppendPage();
	}

	/**
	 * @param appendPage
	 *            the appendPage to set
	 */
	public void setAppendPage(String appendPage) {
		materialsModel.setAppendPage(appendPage);
	}

	/**
	 * @return the material
	 */
	public boolean isMaterial() {
		return materialsModel.isMaterial();
	}

	/**
	 * @param material
	 *            the material to set
	 */
	public void setMaterial(boolean material) {
		materialsModel.setMaterial(material);
	}

	/**
	 * @return the cementList
	 */
	public Collection<CementModel> getCementList() {
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
	 * @return the bricksList
	 */
	public Collection<BricksModel> getBricksList() {
		return bricksList;
	}

	/**
	 * @param bricksList
	 *            the bricksList to set
	 */
	public void setBricksList(Collection<BricksModel> bricksList) {
		this.bricksList = bricksList;
	}

	/**
	 * @return the brickDetails
	 */
	public BricksModel getBrickDetails() {
		return brickDetails;
	}

	/**
	 * @param brickDetails
	 *            the brickDetails to set
	 */
	public void setBrickDetails(BricksModel brickDetails) {
		this.brickDetails = brickDetails;
	}

	/**
	 * @return the editMode
	 */
	public boolean isEditMode() {
		return editMode;
	}

	/**
	 * @param editMode
	 *            the editMode to set
	 */
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
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
	 * @return the bouldersList
	 */
	public Collection<BouldersModel> getBouldersList() {
		return bouldersList;
	}

	/**
	 * @param bouldersList
	 *            the bouldersList to set
	 */
	public void setBouldersList(Collection<BouldersModel> bouldersList) {
		this.bouldersList = bouldersList;
	}

	/**
	 * @return the selectedBouldersModel
	 */
	public BouldersModel getSelectedBouldersModel() {
		return selectedBouldersModel;
	}

	/**
	 * @param selectedBouldersModel
	 *            the selectedBouldersModel to set
	 */
	public void setSelectedBouldersModel(BouldersModel selectedBouldersModel) {
		this.selectedBouldersModel = selectedBouldersModel;
	}

	/**
	 * @return the centeringList
	 */
	public Collection<CenteringModel> getCenteringList() {
		return centeringList;
	}

	/**
	 * @param centeringList
	 *            the centeringList to set
	 */
	public void setCenteringList(Collection<CenteringModel> centeringList) {
		this.centeringList = centeringList;
	}

	/**
	 * @return the selectedCenteringModel
	 */
	public CenteringModel getSelectedCenteringModel() {
		return selectedCenteringModel;
	}

	/**
	 * @param selectedCenteringModel
	 *            the selectedCenteringModel to set
	 */
	public void setSelectedCenteringModel(CenteringModel selectedCenteringModel) {
		this.selectedCenteringModel = selectedCenteringModel;
	}

	/**
	 * @return the doorsList
	 */
	public Collection<DoorsModel> getDoorsList() {
		return doorsList;
	}

	/**
	 * @param doorsList
	 *            the doorsList to set
	 */
	public void setDoorsList(Collection<DoorsModel> doorsList) {
		this.doorsList = doorsList;
	}

	/**
	 * @return the selectedDoorsModel
	 */
	public DoorsModel getSelectedDoorsModel() {
		return selectedDoorsModel;
	}

	/**
	 * @param selectedDoorsModel
	 *            the selectedDoorsModel to set
	 */
	public void setSelectedDoorsModel(DoorsModel selectedDoorsModel) {
		this.selectedDoorsModel = selectedDoorsModel;
	}

	/**
	 * @return the selectedGrillModel
	 */
	public GrillModel getSelectedGrillModel() {
		return selectedGrillModel;
	}

	/**
	 * @param selectedGrillModel
	 *            the selectedGrillModel to set
	 */
	public void setSelectedGrillModel(GrillModel selectedGrillModel) {
		this.selectedGrillModel = selectedGrillModel;
	}

	/**
	 * @return the grillList
	 */
	public Collection<GrillModel> getGrillList() {
		return grillList;
	}

	/**
	 * @param grillList
	 *            the grillList to set
	 */
	public void setGrillList(Collection<GrillModel> grillList) {
		this.grillList = grillList;
	}

	/**
	 * @return the jellyList
	 */
	public Collection<JellyModel> getJellyList() {
		return jellyList;
	}

	/**
	 * @param jellyList
	 *            the jellyList to set
	 */
	public void setJellyList(Collection<JellyModel> jellyList) {
		this.jellyList = jellyList;
	}

	/**
	 * @return the selectedJellyModel
	 */
	public JellyModel getSelectedJellyModel() {
		return selectedJellyModel;
	}

	/**
	 * @param selectedJellyModel
	 *            the selectedJellyModel to set
	 */
	public void setSelectedJellyModel(JellyModel selectedJellyModel) {
		this.selectedJellyModel = selectedJellyModel;
	}

	/**
	 * @return the laboursList
	 */
	public Collection<LaboursModel> getLaboursList() {
		return laboursList;
	}

	/**
	 * @param laboursList
	 *            the laboursList to set
	 */
	public void setLaboursList(Collection<LaboursModel> laboursList) {
		this.laboursList = laboursList;
	}

	/**
	 * @return the selectedLaboursModel
	 */
	public LaboursModel getSelectedLaboursModel() {
		return selectedLaboursModel;
	}

	/**
	 * @param selectedLaboursModel
	 *            the selectedLaboursModel to set
	 */
	public void setSelectedLaboursModel(LaboursModel selectedLaboursModel) {
		this.selectedLaboursModel = selectedLaboursModel;
	}

	/**
	 * @return the limeList
	 */
	public Collection<LimeModel> getLimeList() {
		return limeList;
	}

	/**
	 * @param limeList
	 *            the limeList to set
	 */
	public void setLimeList(Collection<LimeModel> limeList) {
		this.limeList = limeList;
	}

	/**
	 * @return the selectedLimeModel
	 */
	public LimeModel getSelectedLimeModel() {
		return selectedLimeModel;
	}

	/**
	 * @param selectedLimeModel
	 *            the selectedLimeModel to set
	 */
	public void setSelectedLimeModel(LimeModel selectedLimeModel) {
		this.selectedLimeModel = selectedLimeModel;
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
	public void setCreateProjectService(CreateProjectService createProjectService) {
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
	public void setFetchMaterialsService(FetchMaterialsService fetchMaterialsService) {
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
	public void setDeleteMaterialsService(DeleteMaterialsService deleteMaterialsService) {
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
	public void setUpdateMaterialsService(UpdateMaterialsService updateMaterialsService) {
		this.updateMaterialsService = updateMaterialsService;
	}

	/**
	 * @return the cementEditDeleteController
	 */
	public CementEditDeleteController getCementEditDeleteController() {
		return cementEditDeleteController;
	}

	/**
	 * @param cementEditDeleteController
	 *            the cementEditDeleteController to set
	 */
	public void setCementEditDeleteController(CementEditDeleteController cementEditDeleteController) {
		this.cementEditDeleteController = cementEditDeleteController;
	}

	/**
	 * @return the bricksController
	 */
	public BricksController getBricksController() {
		return bricksController;
	}

	/**
	 * @param bricksController
	 *            the bricksController to set
	 */
	public void setBricksController(BricksController bricksController) {
		this.bricksController = bricksController;
	}

}
