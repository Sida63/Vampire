package cn.edu.xjtu.se.vampire.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.xjtu.se.vampire.hibernate.entity.GoodsType;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xjtu.se.vampire.hibernate.entity.GoodsType
 * @author MyEclipse Persistence Tools
 */
public class GoodsTypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(GoodsTypeDAO.class);
	// property constants
	public static final String TYPE_NAME = "typeName";
	// table name
	public static final String TABLE_NAME = "GoodsType";

	public boolean save(GoodsType transientInstance) {
		boolean flag = true;
		log.debug("saving GoodsType instance");
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

	public boolean delete(GoodsType persistentInstance) {
		boolean flag = true;
		log.debug("deleting GoodsType instance");
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
	
	public boolean update(GoodsType instance) {
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

	public GoodsType findById(java.lang.Integer id) {
		log.debug("getting GoodsType instance with id: " + id);
		try {
			GoodsType instance = (GoodsType) getSession().get(
					"cn.edu.xjtu.se.vampire.hibernate.entity.GoodsType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsType> findByExample(GoodsType instance) {
		log.debug("finding GoodsType instance by example");
		try {
			List<?> results = getSession()
					.createCriteria(
							"cn.edu.xjtu.se.vampire.hibernate.entity.GoodsType")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return (List<GoodsType>)results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsType> findByProperty(String propertyName, Object value) {
		log.debug("finding GoodsType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from GoodsType as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return (List<GoodsType>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<GoodsType> findByTypeName(Object typeName) {
		return findByProperty(TYPE_NAME, typeName);
	}

	@SuppressWarnings("unchecked")
	public List<GoodsType> findAll() {
		log.debug("finding all GoodsType instances");
		try {
			String queryString = "from GoodsType";
			Query queryObject = getSession().createQuery(queryString);
			return (List<GoodsType>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<GoodsType> select(String key) {
		log.debug("select all GoodsType instances with constrain that " + key);
		try {
			String queryString = "from " + TABLE_NAME + " as model " + Utilities.generateWhereStatementH(key);
			return (List<GoodsType>)getSession().createQuery(queryString).list();
		} catch (RuntimeException re) {
			log.error("select with constrain failed", re);
			throw re;
		}
	}
}