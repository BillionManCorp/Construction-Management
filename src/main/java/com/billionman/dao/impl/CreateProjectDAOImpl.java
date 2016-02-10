/**
 * 
 */
package com.billionman.dao.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
import com.billionman.util.Constants;

/**
 * @author CTM
 *
 */
@Repository
public class CreateProjectDAOImpl implements CreateProjectDAO {

	@Autowired
	private SessionFactory mySessionFactory;

	public String createNewProject(Project newProject) {
		Session session = mySessionFactory.openSession();
		// getSessionFactory().getCurrentSession().save(newProject);
		Transaction tx = null;
		tx = session.beginTransaction();
		session.save(newProject);
		tx.commit();
		session.close();
		return "success";
	}

	@SuppressWarnings("unchecked")
	public Collection<? extends Project> fetchProjects() {
		Collection<Project> projectList = new ArrayList<Project>();
		Session session = mySessionFactory.openSession();
		// getSessionFactory().getCurrentSession().save(newProject);
		projectList = session.createCriteria(Project.class).list();
		session.close();
		return projectList;
	}

	public String saveSteelDetails(Steel newDetail) {
		Session session = mySessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.save(newDetail);
		tx.commit();
		session.close();
		return "success";
	}

	public String updateProjectDetails(Project selectedProject) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(selectedProject);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveSteelDetails(Cement newCement) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(newCement);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveSandDetails(Sand newSand) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(newSand);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveVehicleDetails(Vehicle newVehicleDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(newVehicleDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String savePowerDetails(Power powerSpendings) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(powerSpendings);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveJellyDetails(Jelly jellyDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(jellyDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveWaterDetails(Water waterDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(waterDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveWoodDetails(Wood woodDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(woodDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveCenteringDetails(Centering centeringDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(centeringDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveSizeStoneDetails(SizeStone sizeStoneDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(sizeStoneDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveBouldersDetails(Boulders boulderDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(boulderDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveBrickDetails(Bricks brickDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(brickDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveDoorDetails(GroupDoors doorDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(doorDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveLimeDetails(LimeRendering limeDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(limeDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String savePlasteringDetails(Plastering plasteringDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(plasteringDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveTilesDetails(Tiles tilesDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(tilesDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String savePaintingDetails(Painting paintingDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(paintingDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String savePlumbingDetails(Plumbing plumbingDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(plumbingDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveSanitaryDetails(Sanitary sanitaryDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(sanitaryDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveGrillDetails(Grill grillDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(grillDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String saveLabourDetails(Labour labourDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(labourDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}
}
