/**
 * 
 */
package com.billionman.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
import com.billionman.util.Constants;

/**
 * @author CTM
 *
 */
@Repository
public class DeleteMaterialsDAOImpl implements DeleteMaterialsDAO {

	@Autowired
	private SessionFactory mySessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.billionman.dao.DeleteMaterialsDAO#deleteBricks(com.billionman.model
	 * .Bricks)
	 */
	public String deleteBricks(Bricks deleteBrick) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(deleteBrick);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String deleteBricks(Cement deleteCement) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(deleteCement);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String deleteBricks(Boulders deleteBoulders) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(deleteBoulders);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String deleteCentering(Centering centeringDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(centeringDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String deleteDoors(GroupDoors doorsDetails) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(doorsDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String deleteGrill(Grill deleteGrill) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(deleteGrill);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String deleteJelly(Jelly deleteJelly) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(deleteJelly);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String deleteJelly(Labour deleteLabour) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(deleteLabour);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		} finally {
			session.close();
		}
		return Constants.SUCCESS;
	}

	public String deleteLime(LimeRendering deleteLime) {
		Session session = mySessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(deleteLime);
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
