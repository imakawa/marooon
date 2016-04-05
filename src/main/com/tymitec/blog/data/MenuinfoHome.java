package blog.data;

// Generated 2016-3-31 0:33:16 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Menuinfo.
 * @see blog.data.Menuinfo
 * @author Hibernate Tools
 */
@Stateless
public class MenuinfoHome {

	private static final Log log = LogFactory.getLog(MenuinfoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Menuinfo transientInstance) {
		log.debug("persisting Menuinfo instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Menuinfo persistentInstance) {
		log.debug("removing Menuinfo instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Menuinfo merge(Menuinfo detachedInstance) {
		log.debug("merging Menuinfo instance");
		try {
			Menuinfo result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Menuinfo findById(Integer id) {
		log.debug("getting Menuinfo instance with id: " + id);
		try {
			Menuinfo instance = entityManager.find(Menuinfo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
