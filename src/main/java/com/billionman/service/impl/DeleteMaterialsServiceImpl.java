/**
 * 
 */
package com.billionman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billionman.dao.DeleteMaterialsDAO;
import com.billionman.model.Boulders;
import com.billionman.model.Bricks;
import com.billionman.model.Cement;
import com.billionman.model.Centering;
import com.billionman.model.Grill;
import com.billionman.model.GroupDoors;
import com.billionman.model.Jelly;
import com.billionman.model.Labour;
import com.billionman.model.LimeRendering;
import com.billionman.service.DeleteMaterialsService;

/**
 * @author CTM
 *
 */
@Service(value="deleteMaterialsService")
public class DeleteMaterialsServiceImpl implements DeleteMaterialsService {

	@Autowired
	private DeleteMaterialsDAO deleteMaterialsDAO;

	public String deleteBricks(Bricks deleteBrick) {
		return deleteMaterialsDAO.deleteBricks(deleteBrick);
	}

	public String deleteCement(Cement deleteCement) {
		return deleteMaterialsDAO.deleteBricks(deleteCement);
	}

	public String deleteBoulders(Boulders deleteBoulders) {
		return deleteMaterialsDAO.deleteBricks(deleteBoulders);
	}

	public String deleteCentering(Centering centeringDetails) {
		return deleteMaterialsDAO.deleteCentering(centeringDetails);
	}

	public String deleteDoors(GroupDoors deleteDoors) {
		return deleteMaterialsDAO.deleteDoors(deleteDoors);
	}

	public String deleteGrill(Grill deleteGrill) {
		return deleteMaterialsDAO.deleteGrill(deleteGrill);
	}

	public String deleteJelly(Jelly deleteJelly) {
		return deleteMaterialsDAO.deleteJelly(deleteJelly);
	}

	public String deleteLabours(Labour deleteLabour) {
		return deleteMaterialsDAO.deleteJelly(deleteLabour);
	}

	public String deleteLime(LimeRendering deleteLime) {
		return deleteMaterialsDAO.deleteLime(deleteLime);
	}

}
