/**
 * 
 */
package com.billionman.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.billionman.model.Boulders;
import com.billionman.model.Bricks;
import com.billionman.model.Cement;
import com.billionman.model.Centering;
import com.billionman.model.Grill;
import com.billionman.model.GroupDoors;
import com.billionman.model.Jelly;
import com.billionman.model.Labour;
import com.billionman.model.LimeRendering;
import com.billionman.model.Painting;
import com.billionman.model.Plastering;
import com.billionman.model.Plumbing;
import com.billionman.model.Power;
import com.billionman.model.Project;
import com.billionman.model.Sand;
import com.billionman.model.Sanitary;
import com.billionman.model.SizeStone;
import com.billionman.model.Steel;
import com.billionman.model.Tiles;
import com.billionman.model.Vehicle;
import com.billionman.model.Water;
import com.billionman.model.Wood;
import com.billionman.service.CreateProjectService;
import com.billionman.util.Constants;

/**
 * @author CTM
 *
 */
@ManagedBean
@SessionScoped
public class MaterialsController implements Serializable {

	@ManagedProperty(value = "#{createProjectService}", name ="createProjectService")
	CreateProjectService createProjectService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1861032763200722516L;
	private Collection<Project> projectList;
	private Project selectedProject;
	private long quantityTonnes;
	private int bundle;
	private BigDecimal amount;
	private int type;
	private Date addedDate;
	private int projectId;
	private Integer fuelType;

	private Cement newCement;
	private Sand newSand;
	private Vehicle newVehicleDetails;
	private Power powerSpendings;
	private Jelly jellyDetails;
	private Water waterDetails;
	private Wood woodDetails;
	private Centering centeringDetails;
	private SizeStone sizeStoneDetails;
	private Boulders bouldersDetails;
	private Bricks bricksDetails;
	private GroupDoors doorDetails;
	private LimeRendering limeDetails;
	private Plastering plasteringDetails;
	private Tiles tilesDetails;
	private Painting paintingDetails;
	private Plumbing plumbingDetails;
	private Sanitary sanitaryDetails;
	private Grill grillDetails;
	private Labour labourDetails;

	public String cancel() {
		return "materials";
	}

	// Navigation
	public String addSteelDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		return "steel";
	}

	public String addSandDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearSand();
		setNewSand(new Sand());
		return "sand";
	}

	public String addCementDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearCement();
		setNewCement(new Cement());
		return "cement";
	}

	public String addPowerDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearPower();
		setPowerSpendings(new Power());
		return "power";
	}

	public String addVehicleDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearVehicle();
		setNewVehicleDetails(new Vehicle());
		return "vehicle";
	}

	public String addJellyDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearJelly();
		setJellyDetails(new Jelly());
		return "jelly";
	}

	public String addWaterDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearWater();
		setWaterDetails(new Water());
		return "water";
	}

	public String addWoodDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearWood();
		setWoodDetails(new Wood());
		return "wood";
	}

	public String addCenteringDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearCenteringDetails();
		setCenteringDetails(new Centering());
		return "centering";
	}

	public String addStoneDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearStoneDetails();
		setSizeStoneDetails(new SizeStone());
		return "stone";
	}

	public String addBoulderDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearBoulderDetails();
		setBouldersDetails(new Boulders());
		return "boulder";
	}

	public String addBrickDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearBrickDetails();
		setBricksDetails(new Bricks());
		return "brick";
	}

	public String addDoorDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearDoorDetails();
		setDoorDetails(new GroupDoors());
		return "doors";
	}

	public String addLimeDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearLimeDetails();
		setLimeDetails(new LimeRendering());
		return "lime";
	}

	public String addPlasteringDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearPlasteringDetails();
		setPlasteringDetails(new Plastering());
		return "plastering";
	}

	public String addTilesDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearTilesDetails();
		setTilesDetails(new Tiles());
		return "tiles";
	}

	public String addPaintingDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearPaintingDetails();
		setPaintingDetails(new Painting());
		return "paint";
	}

	public String addPlumbingDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearPlumbingDetails();
		setPlumbingDetails(new Plumbing());
		return "plumbing";
	}

	public String addSanitaryDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearSanitaryDetails();
		setSanitaryDetails(new Sanitary());
		return "sanitary";
	}

	public String addGrillDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearGrillDetails();
		setGrillDetails(new Grill());
		return "grill";
	}

	public String addLabourDetails() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		clearLabourDetails();
		setLabourDetails(new Labour());
		return "labour";
	}

	public String otherData() {
		setProjectList(new ArrayList<Project>());
		getProjectList().addAll(fetchProjects());
		return "labour";
	}

	// Clear Model beans
	private void clearCement() {
		setProjectId(0);
		setNewCement(null);
	}

	private void clearSand() {
		setProjectId(0);
		setNewSand(null);
	}

	private void clearVehicle() {
		setProjectId(0);
		setNewVehicleDetails(null);
	}

	private void clearPower() {
		setProjectId(0);
		setPowerSpendings(null);
	}

	private void clearJelly() {
		setProjectId(0);
		setJellyDetails(null);
	}

	private void clearWater() {
		setProjectId(0);
		setWaterDetails(null);
	}

	private void clearWood() {
		setProjectId(0);
		setWoodDetails(null);
	}

	private void clearCenteringDetails() {
		setProjectId(0);
		setCenteringDetails(null);
	}

	private void clearStoneDetails() {
		setProjectId(0);
		setSizeStoneDetails(null);
	}

	private void clearBoulderDetails() {
		setProjectId(0);
		setSizeStoneDetails(null);
	}

	private void clearBrickDetails() {
		setProjectId(0);
		setBricksDetails(null);
	}

	private void clearDoorDetails() {
		setProjectId(0);
		setDoorDetails(null);
	}

	private void clearLimeDetails() {
		setProjectId(0);
		setDoorDetails(null);
	}

	private void clearPlasteringDetails() {
		setProjectId(0);
		setPlasteringDetails(null);
	}

	private void clearTilesDetails() {
		setProjectId(0);
		setTilesDetails(null);
	}

	private void clearPaintingDetails() {
		setProjectId(0);
		setPaintingDetails(null);
	}

	private void clearPlumbingDetails() {
		setProjectId(0);
		setPlumbingDetails(null);
	}

	private void clearSanitaryDetails() {
		setProjectId(0);
		setSanitaryDetails(null);
	}

	private void clearGrillDetails() {
		setProjectId(0);
		setGrillDetails(null);
	}

	private void clearLabourDetails() {
		setProjectId(0);
		setLabourDetails(null);
	}

	// Save the materials
	public String saveSteelDetails() {
		Steel newDetail = null;
		newDetail = putSteelDetails(newDetail);
		return createProjectService.saveSteelDetails(newDetail);
	}

	public String saveCementDetails() {
		getNewCement().setAddedDate(new Date());
		return createProjectService.saveCementDetails(getNewCement());
	}

	public String saveSandDetails() {
		getNewSand().setAddedDate(new Date());
		return createProjectService.saveSandDetails(getNewSand());
	}

	public String saveVehicleDetails() {
		getFuelType();
		getNewVehicleDetails().setAddedDate(new Date());
		return createProjectService.saveVehicleDetails(getNewVehicleDetails());
	}

	public String savePowerDetails() {
		getPowerSpendings().setAddedDate(new Date());
		return createProjectService.savePowerDetails(getPowerSpendings());
	}

	public String saveJellyDetails() {
		getJellyDetails().setAddedDate(new Date());
		return createProjectService.saveJellyDetails(getJellyDetails());
	}

	public String saveWaterDetails() {
		Water tempWaterDetails = getWaterDetails();
		tempWaterDetails.setAddedDate(new Date());
		String saved = createProjectService.saveWaterDetails(tempWaterDetails);
		if (Constants.FAILURE.equals(saved)) {
			return Constants.FAILURE;
		}
		clearWater();
		return Constants.SUCCESS;
	}

	public String saveWoodDetails() {
		Wood tempwoodDetails = getWoodDetails();
		tempwoodDetails.setAddedDate(new Date());
		String saved = createProjectService.saveWoodDetails(tempwoodDetails);
		if (Constants.FAILURE.equals(saved)) {
			return Constants.FAILURE;
		}
		clearWood();
		return Constants.SUCCESS;
	}

	public String saveCenteringDetails() {
		Centering tempCentering = getCenteringDetails();
		tempCentering.setAddedDate(new Date());
		String saved = createProjectService.saveCenteringDetails(tempCentering);
		if (Constants.FAILURE.equals(saved)) {
			return Constants.FAILURE;
		}
		clearCenteringDetails();
		return Constants.SUCCESS;
	}

	public String saveBrickDetails() {
		Bricks tempBrick = getBricksDetails();
		tempBrick.setAddedDate(new Date());
		String saved = createProjectService.saveBrickDetails(tempBrick);
		if (Constants.FAILURE.equals(saved)) {
			return Constants.FAILURE;
		}
		clearBrickDetails();
		return Constants.SUCCESS;
	}

	public String savePaintingDetails() {
		Painting tempPaint = getPaintingDetails();
		tempPaint.setAddedDate(new Date());
		String saved = createProjectService.savePaintingDetails(tempPaint);
		if (Constants.FAILURE.equals(saved)) {
			return Constants.FAILURE;
		}
		clearPaintingDetails();
		return Constants.SUCCESS;
	}

	public String savePlumbingDetails() {
		Plumbing tempPlumbing = getPlumbingDetails();
		tempPlumbing.setAddedDate(new Date());
		String saved = createProjectService.savePlumbingDetails(tempPlumbing);
		if (Constants.FAILURE.equals(saved)) {
			return Constants.FAILURE;
		}
		clearPlumbingDetails();
		return Constants.SUCCESS;
	}

	public String saveSizeStoneDetails() {
		SizeStone tempStone = getSizeStoneDetails();
		tempStone.setAddedDate(new Date());
		String saved = createProjectService.saveSizeStoneDetails(tempStone);
		if (Constants.FAILURE.equals(saved)) {
			return Constants.FAILURE;
		}
		clearStoneDetails();
		return Constants.SUCCESS;
	}

	public String saveTilesDetails() {
		Tiles tempTiles = getTilesDetails();
		tempTiles.setAddedDate(new Date());
		String saved = createProjectService.saveTilesDetails(tempTiles);
		if (Constants.FAILURE.equals(saved)) {
			return Constants.FAILURE;
		}
		clearTilesDetails();
		return Constants.SUCCESS;
	}

	public String saveSanitaryDetails() {
		Sanitary tempSanitary = getSanitaryDetails();
		tempSanitary.setAddedDate(new Date());
		String saved = createProjectService.saveSanitaryDetails(tempSanitary);
		if (Constants.FAILURE.equals(saved)) {
			return Constants.FAILURE;
		}
		clearSanitaryDetails();
		return Constants.SUCCESS;
	}

	public String saveLabourDetails() {
		Labour tempLabour = getLabourDetails();
		tempLabour.setAddedDate(new Date());
		String saved = createProjectService.saveLabourDetails(tempLabour);
		if (Constants.FAILURE.equals(saved)) {
			return Constants.FAILURE;
		}
		clearLabourDetails();
		return Constants.SUCCESS;
	}

	public String saveGrillDetails() {
		Grill tempGrill = getGrillDetails();
		tempGrill.setAddedDate(new Date());
		String saved = createProjectService.saveGrillDetails(tempGrill);
		if (Constants.FAILURE.equals(saved)) {
			return Constants.FAILURE;
		}
		clearGrillDetails();
		return Constants.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	private Collection<Project> fetchProjects() {
		return (Collection<Project>) createProjectService.fetchProjects();
	}

	private Steel putSteelDetails(Steel newData) {
		newData = new Steel();
		newData.setType(getType());
		newData.setQuantityTonnes(getQuantityTonnes());
		newData.setBundle(getBundle());
		newData.setProject(getProjectId());
		newData.setAmount(getAmount());
		newData.setAddedDate(new Date());
		return newData;
	}

	/**
	 * @return the projectList
	 */
	public Collection<Project> getProjectList() {
		return projectList;
	}

	/**
	 * @param projectList
	 *            the projectList to set
	 */
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

	public long getQuantityTonnes() {
		return quantityTonnes;
	}

	public void setQuantityTonnes(long quantityTonnes) {
		this.quantityTonnes = quantityTonnes;
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
	 * @return the bundle
	 */
	public int getBundle() {
		return bundle;
	}

	/**
	 * @param bundle
	 *            the bundle to set
	 */
	public void setBundle(int bundle) {
		this.bundle = bundle;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
	 * @return the addedDate
	 */
	public Date getAddedDate() {
		return addedDate;
	}

	/**
	 * @param addedDate
	 *            the addedDate to set
	 */
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId
	 *            the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the newCement
	 */
	public Cement getNewCement() {
		return newCement;
	}

	/**
	 * @param newCement
	 *            the newCement to set
	 */
	public void setNewCement(Cement newCement) {
		this.newCement = newCement;
	}

	/**
	 * @return the newSand
	 */
	public Sand getNewSand() {
		return newSand;
	}

	/**
	 * @param newSand
	 *            the newSand to set
	 */
	public void setNewSand(Sand newSand) {
		this.newSand = newSand;
	}

	/**
	 * @return the newVehicleDetails
	 */
	public Vehicle getNewVehicleDetails() {
		return newVehicleDetails;
	}

	/**
	 * @param newVehicleDetails
	 *            the newVehicleDetails to set
	 */
	public void setNewVehicleDetails(Vehicle newVehicleDetails) {
		this.newVehicleDetails = newVehicleDetails;
	}

	/**
	 * @return the fuelType
	 */
	public Integer getFuelType() {
		return fuelType;
	}

	/**
	 * @param fuelType
	 *            the fuelType to set
	 */
	public void setFuelType(Integer fuelType) {
		this.fuelType = fuelType;
	}

	/**
	 * @return the powerSpendings
	 */
	public Power getPowerSpendings() {
		return powerSpendings;
	}

	/**
	 * @param powerSpendings
	 *            the powerSpendings to set
	 */
	public void setPowerSpendings(Power powerSpendings) {
		this.powerSpendings = powerSpendings;
	}

	/**
	 * @return the jellyDetails
	 */
	public Jelly getJellyDetails() {
		return jellyDetails;
	}

	/**
	 * @param jellyDetails
	 *            the jellyDetails to set
	 */
	public void setJellyDetails(Jelly jellyDetails) {
		this.jellyDetails = jellyDetails;
	}

	/**
	 * @return the waterDetails
	 */
	public Water getWaterDetails() {
		return waterDetails;
	}

	/**
	 * @param waterDetails
	 *            the waterDetails to set
	 */
	public void setWaterDetails(Water waterDetails) {
		this.waterDetails = waterDetails;
	}

	/**
	 * @return the woodDetails
	 */
	public Wood getWoodDetails() {
		return woodDetails;
	}

	/**
	 * @param woodDetails
	 *            the woodDetails to set
	 */
	public void setWoodDetails(Wood woodDetails) {
		this.woodDetails = woodDetails;
	}

	/**
	 * @return the centeringDetails
	 */
	public Centering getCenteringDetails() {
		return centeringDetails;
	}

	/**
	 * @param centeringDetails
	 *            the centeringDetails to set
	 */
	public void setCenteringDetails(Centering centeringDetails) {
		this.centeringDetails = centeringDetails;
	}

	/**
	 * @return the sizeStoneDetails
	 */
	public SizeStone getSizeStoneDetails() {
		return sizeStoneDetails;
	}

	/**
	 * @param sizeStoneDetails
	 *            the sizeStoneDetails to set
	 */
	public void setSizeStoneDetails(SizeStone sizeStoneDetails) {
		this.sizeStoneDetails = sizeStoneDetails;
	}

	/**
	 * @return the bouldersDetails
	 */
	public Boulders getBouldersDetails() {
		return bouldersDetails;
	}

	/**
	 * @param bouldersDetails
	 *            the bouldersDetails to set
	 */
	public void setBouldersDetails(Boulders bouldersDetails) {
		this.bouldersDetails = bouldersDetails;
	}

	/**
	 * @return the bricksDetails
	 */
	public Bricks getBricksDetails() {
		return bricksDetails;
	}

	/**
	 * @param bricksDetails
	 *            the bricksDetails to set
	 */
	public void setBricksDetails(Bricks bricksDetails) {
		this.bricksDetails = bricksDetails;
	}

	/**
	 * @return the doorDetails
	 */
	public GroupDoors getDoorDetails() {
		return doorDetails;
	}

	/**
	 * @param doorDetails
	 *            the doorDetails to set
	 */
	public void setDoorDetails(GroupDoors doorDetails) {
		this.doorDetails = doorDetails;
	}

	/**
	 * @return the limeDetails
	 */
	public LimeRendering getLimeDetails() {
		return limeDetails;
	}

	/**
	 * @param limeDetails
	 *            the limeDetails to set
	 */
	public void setLimeDetails(LimeRendering limeDetails) {
		this.limeDetails = limeDetails;
	}

	/**
	 * @return the plasteringDetails
	 */
	public Plastering getPlasteringDetails() {
		return plasteringDetails;
	}

	/**
	 * @param plasteringDetails
	 *            the plasteringDetails to set
	 */
	public void setPlasteringDetails(Plastering plasteringDetails) {
		this.plasteringDetails = plasteringDetails;
	}

	/**
	 * @return the tilesDetails
	 */
	public Tiles getTilesDetails() {
		return tilesDetails;
	}

	/**
	 * @param tilesDetails
	 *            the tilesDetails to set
	 */
	public void setTilesDetails(Tiles tilesDetails) {
		this.tilesDetails = tilesDetails;
	}

	/**
	 * @return the paintingDetails
	 */
	public Painting getPaintingDetails() {
		return paintingDetails;
	}

	/**
	 * @param paintingDetails
	 *            the paintingDetails to set
	 */
	public void setPaintingDetails(Painting paintingDetails) {
		this.paintingDetails = paintingDetails;
	}

	/**
	 * @return the plumbingDetails
	 */
	public Plumbing getPlumbingDetails() {
		return plumbingDetails;
	}

	/**
	 * @param plumbingDetails
	 *            the plumbingDetails to set
	 */
	public void setPlumbingDetails(Plumbing plumbingDetails) {
		this.plumbingDetails = plumbingDetails;
	}

	/**
	 * @return the sanitaryDetails
	 */
	public Sanitary getSanitaryDetails() {
		return sanitaryDetails;
	}

	/**
	 * @param sanitaryDetails
	 *            the sanitaryDetails to set
	 */
	public void setSanitaryDetails(Sanitary sanitaryDetails) {
		this.sanitaryDetails = sanitaryDetails;
	}

	/**
	 * @return the grillDetails
	 */
	public Grill getGrillDetails() {
		return grillDetails;
	}

	/**
	 * @param grillDetails
	 *            the grillDetails to set
	 */
	public void setGrillDetails(Grill grillDetails) {
		this.grillDetails = grillDetails;
	}

	/**
	 * @return the labourDetails
	 */
	public Labour getLabourDetails() {
		return labourDetails;
	}

	/**
	 * @param labourDetails
	 *            the labourDetails to set
	 */
	public void setLabourDetails(Labour labourDetails) {
		this.labourDetails = labourDetails;
	}

}
