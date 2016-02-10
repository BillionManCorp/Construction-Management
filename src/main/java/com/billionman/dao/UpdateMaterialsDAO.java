/**
 * 
 */
package com.billionman.dao;

import com.billionman.model.Boulders;
import com.billionman.model.Bricks;
import com.billionman.model.Cement;
import com.billionman.model.Centering;
import com.billionman.model.Grill;
import com.billionman.model.GroupDoors;
import com.billionman.model.Jelly;
import com.billionman.model.Labour;
import com.billionman.model.LimeRendering;

/**
 * @author CTM
 *
 */
public interface UpdateMaterialsDAO {
	public String updateBricks(Bricks brickDetails);

	public String updateCement(Cement cementDetails);

	public String updateCement(Boulders boulderDetails);

	public String updateCentering(Centering centeringDetails);

	public String updateDoors(GroupDoors doorsDetails);

	public String updateGrill(Grill grillDetails);

	public String updateJelly(Jelly jellyDetails);

	public String updateLabours(Labour labourDetails);

	public String updateLime(LimeRendering limeDetails);
}
