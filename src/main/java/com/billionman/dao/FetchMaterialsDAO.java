/**
 * 
 */
package com.billionman.dao;

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
import com.billionman.model.Steel;

/**
 * @author CTM
 *
 */
public interface FetchMaterialsDAO {
	public Collection<Steel> fetchSteel(int projectId);

	public Collection<Cement> fetchCement(int projectId);

	public Collection<Bricks> fetchBricks(int projId);

	public Collection<Boulders> fetchBoulders(int projId);

	public Collection<Centering> fetchCentering(int projId);

	public Collection<GroupDoors> fetchGroupDoors(int projId);

	public Collection<Grill> fetchGrill(int projId);

	public Collection<Labour> fetchLabours(int projId);

	public Collection<Jelly> fetchJelly(int projId);

	public Collection<LimeRendering> fetchLime(int projId);

}
