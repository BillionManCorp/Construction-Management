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
public interface DeleteMaterialsDAO {
	public String deleteBricks(Bricks deleteBrick);

	public String deleteBricks(Cement deleteCement);

	public String deleteBricks(Boulders deleteBoulders);

	public String deleteCentering(Centering centeringDetails);

	public String deleteDoors(GroupDoors doorsDetails);

	public String deleteGrill(Grill deleteGrill);

	public String deleteJelly(Jelly deleteJelly);

	public String deleteJelly(Labour deleteLabour);

	public String deleteLime(LimeRendering deleteLime);
}
