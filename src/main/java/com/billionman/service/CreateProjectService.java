/**
 * 
 */
package com.billionman.service;

import java.util.Collection;

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

/**
 * @author Pavan C T
 *
 */
public interface CreateProjectService {

	public String createNewProject(Project newProject);

	public Collection<? extends Project> fetchProjects();

	public String saveSteelDetails(Steel newDetail);

	public String updateProjectDetails(Project selectedProject);

	public String saveCementDetails(Cement newCement);

	public String saveSandDetails(Sand newSand);

	public String saveVehicleDetails(Vehicle newVehicleDetails);

	public String savePowerDetails(Power powerSpendings);

	public String saveJellyDetails(Jelly jellyDetails);

	public String saveWaterDetails(Water waterDetails);
	
	public String saveWoodDetails(Wood woodDetails);

	public String saveCenteringDetails(Centering centeringDetails);

	public String saveSizeStoneDetails(SizeStone sizeStoneDetails);

	public String saveBouldersDetails(Boulders boulderDetails);

	public String saveBrickDetails(Bricks brickDetails);

	public String saveDoorDetails(GroupDoors doorDetails);

	public String saveLimeDetails(LimeRendering limeDetails);

	public String savePlasteringDetails(Plastering plasteringDetails);

	public String saveTilesDetails(Tiles tilesDetails);

	public String savePaintingDetails(Painting paintingDetails);

	public String savePlumbingDetails(Plumbing plumbingDetails);

	public String saveSanitaryDetails(Sanitary sanitaryDetails);

	public String saveGrillDetails(Grill grillDetails);

	public String saveLabourDetails(Labour labourDetails);
}
