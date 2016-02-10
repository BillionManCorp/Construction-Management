/**
 * 
 */
package com.billionman.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billionman.dao.FetchMaterialsDAO;
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
import com.billionman.service.FetchMaterialsService;

/**
 * @author CTM
 *
 */
@Service(value="fetchMaterialsService")
public class FetchMaterialsServiceImpl implements FetchMaterialsService {

	@Autowired
	FetchMaterialsDAO fetchMaterialsDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.billionman.service.FetchMaterialsService#fetchMaterials(java.lang
	 * .Object)
	 */
	public Collection<Steel> fetchSteel(int projectId) {
		return fetchMaterialsDAO.fetchSteel(projectId);
	}

	public Collection<Cement> fetchCement(int projectId) {
		return fetchMaterialsDAO.fetchCement(projectId);
	}

	public Collection<Bricks> fetchBricks(int projId) {
		return fetchMaterialsDAO.fetchBricks(projId);
	}

	public Collection<Boulders> fetchBoulders(int projId) {
		return fetchMaterialsDAO.fetchBoulders(projId);
	}

	public Collection<Centering> fetchCentering(int projId) {
		return fetchMaterialsDAO.fetchCentering(projId);
	}

	public Collection<GroupDoors> fetchGroupDoors(int projId) {
		return fetchMaterialsDAO.fetchGroupDoors(projId);
	}

	public Collection<Grill> fetchGrill(int projId) {
		return fetchMaterialsDAO.fetchGrill(projId);
	}

	public Collection<Labour> fetchLabours(int projId) {
		return fetchMaterialsDAO.fetchLabours(projId);
	}

	public Collection<Jelly> fetchJelly(int projId) {
		return fetchMaterialsDAO.fetchJelly(projId);
	}

	public Collection<LimeRendering> fetchLime(int projId) {
		return fetchMaterialsDAO.fetchLime(projId);
	}

}
