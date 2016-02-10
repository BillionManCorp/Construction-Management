/**
 * 
 */
package com.billionman.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
import com.billionman.util.Constants;

/**
 * @author CTM
 *
 */
@Repository
public class UpdateMaterialsDAOImpl implements UpdateMaterialsDAO {

	@Autowired
	private SessionFactory mySessionFactory;

	public String updateBricks(Bricks brickDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(brickDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String updateCement(Cement cementDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(cementDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String updateCement(Boulders boulderDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(boulderDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String updateCentering(Centering centeringDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(centeringDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String updateDoors(GroupDoors doorsDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(doorsDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String updateGrill(Grill grillDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(grillDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String updateJelly(Jelly jellyDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(jellyDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String updateLabours(Labour labourDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(labourDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String updateLime(LimeRendering limeDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(limeDetails);
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
