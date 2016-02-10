package com.billionman.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.billionman.dao.CreateProjectDAO;
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

/**
 * @author CTM
 *
 */
@Service(value = "createProjectService")
public class CreateProjectServiceImpl implements CreateProjectService {
	@Autowired
	CreateProjectDAO createProjectDAO;

	@Transactional
	public String createNewProject(Project newProject) {
		return createProjectDAO.createNewProject(newProject);
	}

	public Collection<? extends Project> fetchProjects() {
		return createProjectDAO.fetchProjects();
	}

	/**
	 * @return the createProjectDAO
	 */
	public CreateProjectDAO getCreateProjectDAO() {
		return createProjectDAO;
	}

	/**
	 * @param createProjectDAO
	 *            the createProjectDAO to set
	 */
	public void setCreateProjectDAO(CreateProjectDAO createProjectDAO) {
		this.createProjectDAO = createProjectDAO;
	}

	public String saveSteelDetails(Steel newDetail) {
		return createProjectDAO.saveSteelDetails(newDetail);
	}

	public String updateProjectDetails(Project selectedProject) {
		return createProjectDAO.updateProjectDetails(selectedProject);
	}

	public String saveCementDetails(Cement newCement) {
		return createProjectDAO.saveSteelDetails(newCement);
	}

	public String saveSandDetails(Sand newSand) {
		return createProjectDAO.saveSandDetails(newSand);
	}

	public String saveVehicleDetails(Vehicle newVehicleDetails) {
		return createProjectDAO.saveVehicleDetails(newVehicleDetails);
	}

	public String savePowerDetails(Power powerSpendings) {
		return createProjectDAO.savePowerDetails(powerSpendings);
	}

	public String saveJellyDetails(Jelly jellyDetails) {
		return createProjectDAO.saveJellyDetails(jellyDetails);
	}

	public String saveWaterDetails(Water waterDetails) {
		return createProjectDAO.saveWaterDetails(waterDetails);
	}

	public String saveCenteringDetails(Centering centeringDetails) {
		return createProjectDAO.saveCenteringDetails(centeringDetails);
	}

	public String saveSizeStoneDetails(SizeStone sizeStoneDetails) {
		return createProjectDAO.saveSizeStoneDetails(sizeStoneDetails);
	}

	public String saveBouldersDetails(Boulders boulderDetails) {
		return createProjectDAO.saveBouldersDetails(boulderDetails);
	}

	public String saveBrickDetails(Bricks brickDetails) {
		return createProjectDAO.saveBrickDetails(brickDetails);
	}

	public String saveDoorDetails(GroupDoors doorDetails) {
		return createProjectDAO.saveDoorDetails(doorDetails);
	}

	public String saveLimeDetails(LimeRendering limeDetails) {
		return createProjectDAO.saveLimeDetails(limeDetails);
	}

	public String savePlasteringDetails(Plastering plasteringDetails) {
		return createProjectDAO.savePlasteringDetails(plasteringDetails);
	}

	public String saveTilesDetails(Tiles tilesDetails) {
		return createProjectDAO.saveTilesDetails(tilesDetails);
	}

	public String savePaintingDetails(Painting paintingDetails) {
		return createProjectDAO.savePaintingDetails(paintingDetails);
	}

	public String savePlumbingDetails(Plumbing plumbingDetails) {
		return createProjectDAO.savePlumbingDetails(plumbingDetails);
	}

	public String saveSanitaryDetails(Sanitary sanitaryDetails) {
		return createProjectDAO.saveSanitaryDetails(sanitaryDetails);
	}

	public String saveGrillDetails(Grill grillDetails) {
		return createProjectDAO.saveGrillDetails(grillDetails);
	}

	public String saveLabourDetails(Labour labourDetails) {
		return createProjectDAO.saveLabourDetails(labourDetails);
	}

	public String saveWoodDetails(Wood woodDetails) {
		return createProjectDAO.saveWoodDetails(woodDetails);
	}

}