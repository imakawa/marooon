package blog.data;

// Generated 2016-3-31 0:33:16 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Articleinfo.
 * @see blog.data.Articleinfo
 * @author Hibernate Tools
 */
@Stateless
public class ArticleinfoHome {

	private static final Log log = LogFactory.getLog(ArticleinfoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Articleinfo transientInstance) {
		log.debug("persisting Articleinfo instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Articleinfo persistentInstance) {
		log.debug("removing Articleinfo instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Articleinfo merge(Articleinfo detachedInstance) {
		log.debug("merging Articleinfo instance");
		try {
			Articleinfo result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Articleinfo findById(Integer id) {
		log.debug("getting Articleinfo instance with id: " + id);
		try {
			Articleinfo instance = entityManager.find(Articleinfo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
