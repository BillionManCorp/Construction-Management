/**
 * 
 */
package com.billionman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billionman.dao.UpdateMaterialsDAO;
import com.billionman.model.Boulders;
import com.billionman.model.Bricks;
import com.billionman.model.Cement;
import com.billionman.model.Centering;
import com.billionman.model.Grill;
import com.billionman.model.GroupDoors;
import com.billionman.model.Jelly;
import com.billionman.model.Labour;
import com.billionman.model.LimeRendering;
import com.billionman.service.UpdateMaterialsService;

/**
 * @author CTM
 *
 */
@Service(value="updateMaterialsService")
public class UpdateMaterialsServiceImpl implements UpdateMaterialsService {

	@Autowired
	public UpdateMaterialsDAO updateMaterialsDAO;

	public String updateBricks(Bricks brickDetails) {
		return updateMaterialsDAO.updateBricks(brickDetails);
	}

	public String updateCement(Cement cementDetails) {
		return updateMaterialsDAO.updateCement(cementDetails);
	}

	public String updateBoulders(Boulders boulderDetails) {
		return updateMaterialsDAO.updateCement(boulderDetails);
	}

	public String updateCentering(Centering centeringDetails) {
		return updateMaterialsDAO.updateCentering(centeringDetails);
	}

	public String updateDoors(GroupDoors doorsDetails) {
		return updateMaterialsDAO.updateDoors(doorsDetails);
	}

	public String updateGrill(Grill grillDetails) {
		return updateMaterialsDAO.updateGrill(grillDetails);
	}

	public String updateJelly(Jelly jellyDetails) {
		return updateMaterialsDAO.updateJelly(jellyDetails);
	}

	public String updateLabours(Labour labourDetails) {
		return updateMaterialsDAO.updateLabours(labourDetails);
	}

	public String updateLime(LimeRendering limeDetails) {
		return updateMaterialsDAO.updateLime(limeDetails);
	}

}
