package cn.edu.xjtu.se.vampire.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.xjtu.se.vampire.hibernate.entity.Favorite;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * A data access object (DAO) providing persistence and search support for
 * Favorite entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xjtu.se.vampire.hibernate.entity.Favorite
 * @author MyEclipse Persistence Tools
 */
public class FavoriteDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(FavoriteDAO.class);

	// property constants

	// table name
	public static final String TABLE_NAME = "Favorite";

	public boolean save(Favorite transientInstance) {
		boolean flag = true;
		log.debug("saving Favorite instance");
		try {
			getSession().getTransaction().begin();
			getSession().save(transientInstance);
			getSession().getTransaction().commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			getSession().getTransaction().rollback();
			flag = false;
			log.error("save failed", re);
			throw re;
		}
		return flag;
	}

	public boolean delete(Favorite persistentInstance) {
		boolean flag = true;
		log.debug("deleting Favorite instance");
		try {
			getSession().getTransaction().begin();
			getSession().delete(persistentInstance);
			getSession().getTransaction().commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			getSession().getTransaction().rollback();
			flag = false;
			log.error("delete failed", re);
			throw re;
		}
		return flag;
	}

	public boolean update(Favorite instance) {
		boolean flag = true;
		try {
			getSession().getTransaction().begin();
			getSession().merge(instance);
			getSession().getTransaction().commit();
		} catch (RuntimeException re) {
			getSession().getTransaction().rollback();
			flag = false;
			throw re;
		}
		return flag;
	}

	public Favorite findById(java.lang.Integer id) {
		log.debug("getting Favorite instance with id: " + id);
		try {
			Favorite instance = (Favorite) getSession().get(
					"cn.edu.xjtu.se.vampire.hibernate.entity.Favorite", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Favorite> findByExample(Favorite instance) {
		log.debug("finding Favorite instance by example");
		try {
			List<?> results = getSession()
					.createCriteria(
							"cn.edu.xjtu.se.vampire.hibernate.entity.Favorite")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return (List<Favorite>) results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Favorite> findByProperty(String propertyName, Object value) {
		log.debug("finding Favorite instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Favorite as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return (List<Favorite>) queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Favorite> findAll() {
		log.debug("finding all Favorite instances");
		try {
			String queryString = "from Favorite";
			Query queryObject = getSession().createQuery(queryString);
			return (List<Favorite>) queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Favorite> select(String key) {
		log.debug("select all Favorite instances with constrain that " + key);
		try {
			String queryString = "from " + TABLE_NAME + " as model "
					+ Utilities.generateWhereStatementH(key);
			return (List<Favorite>) getSession().createQuery(queryString)
					.list();
		} catch (RuntimeException re) {
			log.error("select with constrain failed", re);
			throw re;
		}
	}
}