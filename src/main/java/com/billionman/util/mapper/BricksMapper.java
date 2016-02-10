/**
 * 
 */
package com.billionman.util.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.billionman.controller.helper.BricksModel;
import com.billionman.model.Bricks;
import com.billionman.model.Project;

/**
 * @author CTM
 *
 */
public class BricksMapper extends ProjectMapper {

	/**
	 * 
	 */
	public BricksMapper() {
		// TODO Auto-generated constructor stub
	}

	public static final Collection<BricksModel> mapFetchBricks(
			Collection<Bricks> bricksList, List<Project> projList, int projId) {
		String projName = filterProjectName(projList, projId);
		Collection<BricksModel> cementModelBeans = new ArrayList<BricksModel>();
		for (Bricks bricks : bricksList) {
			BricksModel bricksModelBean = new BricksModel();
			bricksModelBean.setAddedDate(bricks.getAddedDate());
			bricksModelBean.setAmount(bricks.getAmount());
			bricksModelBean.setBricksId(bricks.getBricksId());
			bricksModelBean.setQuantity(bricks.getQuantity());
			bricksModelBean.setProject(projName);
			cementModelBeans.add(bricksModelBean);
		}
		return cementModelBeans;
	}

	public static Bricks mapUpdateBrick(BricksModel bricksModel, int projId,
			List<Project> projects) {
		Project tmpProject = filterProject(projects, projId);
		Bricks bricks = new Bricks();
		bricks.setBricksId(bricksModel.getBricksId());
		bricks.setAmount(bricksModel.getAmount());
		bricks.setAddedDate(new Date());
		bricks.setProject(tmpProject.getId());
		bricks.setQuantity(bricksModel.getQuantity());
		return bricks;

	}
}
