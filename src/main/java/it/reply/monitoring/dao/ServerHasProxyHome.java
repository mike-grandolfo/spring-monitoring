package it.reply.monitoring.dao;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class ServerHasProxy.
 * 
 * @see .ServerHasProxy
 * @author Hibernate Tools
 */
public class ServerHasProxyHome {

	private static final Log log = LogFactory.getLog(ServerHasProxyHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ServerHasProxy transientInstance) {
		log.debug("persisting ServerHasProxy instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ServerHasProxy instance) {
		log.debug("attaching dirty ServerHasProxy instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ServerHasProxy instance) {
		log.debug("attaching clean ServerHasProxy instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ServerHasProxy persistentInstance) {
		log.debug("deleting ServerHasProxy instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ServerHasProxy merge(ServerHasProxy detachedInstance) {
		log.debug("merging ServerHasProxy instance");
		try {
			ServerHasProxy result = (ServerHasProxy) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ServerHasProxy findById(ServerHasProxyId id) {
		log.debug("getting ServerHasProxy instance with id: " + id);
		try {
			ServerHasProxy instance = (ServerHasProxy) sessionFactory.getCurrentSession().get("ServerHasProxy", id);
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

	public List findByExample(ServerHasProxy instance) {
		log.debug("finding ServerHasProxy instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("ServerHasProxy")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
