/**
 * 
 */
package com.billionman.service;

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
public interface DeleteMaterialsService {
	public String deleteBricks(Bricks deleteBrick);

	public String deleteCement(Cement deleteCement);

	public String deleteBoulders(Boulders bouldersDetails);

	public String deleteCentering(Centering centeringDetails);

	public String deleteDoors(GroupDoors deleteDoors);

	public String deleteGrill(Grill deleteGrill);

	public String deleteJelly(Jelly deleteJelly);

	public String deleteLabours(Labour deleteLabour);

	public String deleteLime(LimeRendering deleteLime);
}
