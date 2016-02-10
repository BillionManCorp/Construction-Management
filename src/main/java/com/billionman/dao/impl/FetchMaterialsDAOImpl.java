/**
 * 
 */
package com.billionman.dao.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
import com.billionman.util.ConstantsSQL;

/**
 * @author CTM
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class FetchMaterialsDAOImpl implements FetchMaterialsDAO {

	@Autowired
	private SessionFactory mySessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.billionman.dao.FetchMaterialsDAO#fetchMaterials(java.lang.Object)
	 */
	public Collection<Steel> fetchSteel(int projectId) {
		Session session = mySessionFactory.openSession();
		Collection<Steel> fetchedMaterial = new ArrayList<Steel>();
		try {
			Query query = session.createQuery(ConstantsSQL.FETCH_STEEL);
			query.setParameter("proj_id", projectId);
			fetchedMaterial = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return fetchedMaterial;
	}

	public Collection<Cement> fetchCement(int projectId) {
		Session session = mySessionFactory.openSession();
		Collection<Cement> fetchedMaterial = new ArrayList<Cement>();
		try {
			Query query = session.createQuery(ConstantsSQL.FETCH_CEMENT);
			query.setParameter("proj_id", projectId);
			fetchedMaterial = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fetchedMaterial;
	}

	public Collection<Bricks> fetchBricks(int projId) {
		Session session = mySessionFactory.openSession();
		Collection<Bricks> fetchedMaterial = new ArrayList<Bricks>();
		try {
			Query query = session.createQuery(ConstantsSQL.FETCH_BRICKS);
			query.setParameter("proj_id", projId);
			fetchedMaterial = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fetchedMaterial;
	}

	public Collection<Boulders> fetchBoulders(int projId) {
		Session session = mySessionFactory.openSession();
		Collection<Boulders> fetchedMaterial = new ArrayList<Boulders>();
		try {
			Query query = session.createQuery(ConstantsSQL.FETCH_BOULDERS);
			query.setParameter("proj_id", projId);
			fetchedMaterial = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fetchedMaterial;
	}

	public Collection<Centering> fetchCentering(int projId) {
		Session session = mySessionFactory.openSession();
		Collection<Centering> fetchedMaterial = new ArrayList<Centering>();
		try {
			Query query = session.createQuery(ConstantsSQL.FETCH_CENTERING);
			query.setParameter("proj_id", projId);
			fetchedMaterial = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fetchedMaterial;
	}

	public Collection<GroupDoors> fetchGroupDoors(int projId) {
		Session session = mySessionFactory.openSession();
		Collection<GroupDoors> fetchedMaterial = new ArrayList<GroupDoors>();
		try {
			Query query = session.createQuery(ConstantsSQL.FETCH_DOORS);
			query.setParameter("proj_id", projId);
			fetchedMaterial = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fetchedMaterial;
	}

	public Collection<Grill> fetchGrill(int projId) {
		Session session = mySessionFactory.openSession();
		Collection<Grill> fetchedMaterial = new ArrayList<Grill>();
		try {
			Query query = session.createQuery(ConstantsSQL.FETCH_GRILL);
			query.setParameter("proj_id", projId);
			fetchedMaterial = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fetchedMaterial;
	}

	public Collection<Labour> fetchLabours(int projId) {
		Session session = mySessionFactory.openSession();
		Collection<Labour> fetchedMaterial = new ArrayList<Labour>();
		try {
			Query query = session.createQuery(ConstantsSQL.FETCH_LABOURS);
			query.setParameter("proj_id", projId);
			fetchedMaterial = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fetchedMaterial;
	}

	public Collection<Jelly> fetchJelly(int projId) {
		Session session = mySessionFactory.openSession();
		Collection<Jelly> fetchedMaterial = new ArrayList<Jelly>();
		try {
			Query query = session.createQuery(ConstantsSQL.FETCH_JELLY);
			query.setParameter("proj_id", projId);
			fetchedMaterial = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fetchedMaterial;
	}

	public Collection<LimeRendering> fetchLime(int projId) {
		Session session = mySessionFactory.openSession();
		Collection<LimeRendering> fetchedMaterial = new ArrayList<LimeRendering>();
		try {
			Query query = session.createQuery(ConstantsSQL.FETCH_LIME);
			query.setParameter("proj_id", projId);
			fetchedMaterial = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fetchedMaterial;
	}

}
