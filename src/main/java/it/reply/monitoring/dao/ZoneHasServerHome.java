package it.reply.monitoring.dao;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class ZoneHasServer.
 * 
 * @see .ZoneHasServer
 * @author Hibernate Tools
 */
public class ZoneHasServerHome {

	private static final Log log = LogFactory.getLog(ZoneHasServerHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ZoneHasServer transientInstance) {
		log.debug("persisting ZoneHasServer instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ZoneHasServer instance) {
		log.debug("attaching dirty ZoneHasServer instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ZoneHasServer instance) {
		log.debug("attaching clean ZoneHasServer instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ZoneHasServer persistentInstance) {
		log.debug("deleting ZoneHasServer instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ZoneHasServer merge(ZoneHasServer detachedInstance) {
		log.debug("merging ZoneHasServer instance");
		try {
			ZoneHasServer result = (ZoneHasServer) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ZoneHasServer findById(ZoneHasServerId id) {
		log.debug("getting ZoneHasServer instance with id: " + id);
		try {
			ZoneHasServer instance = (ZoneHasServer) sessionFactory.getCurrentSession().get("ZoneHasServer", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ZoneHasServer instance) {
		log.debug("finding ZoneHasServer instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("ZoneHasServer")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
