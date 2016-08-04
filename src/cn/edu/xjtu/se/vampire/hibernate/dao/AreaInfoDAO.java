package cn.edu.xjtu.se.vampire.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.xjtu.se.vampire.hibernate.entity.AreaInfo;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * A data access object (DAO) providing persistence and search support for
 * AreaInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xjtu.se.vampire.hibernate.entity.AreaInfo
 * @author MyEclipse Persistence Tools
 */
public class AreaInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AreaInfoDAO.class);
	// property constants
	public static final String AREA = "area";
	// table name
	public static final String TABLE_NAME = "AreaInfo";

	public boolean save(AreaInfo transientInstance) {
		boolean flag = true;
		log.debug("saving AreaInfo instance");
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
	
	public void evict(AreaInfo persistentInstance, boolean deep) {
		log.debug("evicting AreaInfo instance");
		try {
			getSession().evict(persistentInstance);
			
			if(deep) {
			}
			
			log.debug("evicit successful");
		} catch (RuntimeException re) {
			log.error("evicit failed", re);
			throw re;
		}
	}

	public boolean delete(AreaInfo persistentInstance) {
		boolean flag = true;
		log.debug("deleting AreaInfo instance");
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
	
	public boolean update(AreaInfo instance) {
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

	public AreaInfo findById(java.lang.Integer id) {
		log.debug("getting AreaInfo instance with id: " + id);
		try {
			AreaInfo instance = (AreaInfo) getSession().get(
					"cn.edu.xjtu.se.vampire.hibernate.entity.AreaInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AreaInfo> findByExample(AreaInfo instance) {
		log.debug("finding AreaInfo instance by example");
		try {
			List<?> results = getSession()
					.createCriteria(
							"cn.edu.xjtu.se.vampire.hibernate.entity.AreaInfo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return (List<AreaInfo>)results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AreaInfo> findByProperty(String propertyName, Object value) {
		log.debug("finding AreaInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AreaInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return (List<AreaInfo>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AreaInfo> findByArea(Object area) {
		return findByProperty(AREA, area);
	}
	
	@SuppressWarnings("unchecked")
	public List<AreaInfo> findAll() {
		log.debug("finding all AreaInfo instances");
		try {
			String queryString = "from AreaInfo";
			Query queryObject = getSession().createQuery(queryString);
			return (List<AreaInfo>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AreaInfo> findAllProvince() {
		log.debug("finding all AreaInfo instances");
		try {
			String queryString = "from AreaInfo as model where MOD(model.id, 10000) = 0";
			Query queryObject = getSession().createQuery(queryString);
			return (List<AreaInfo>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AreaInfo> findAllCity(Integer provinceId) {
		log.debug("finding all AreaInfo instances");
		try {
			String queryString = "from AreaInfo as model where model.id <> ? "
					+ "and MOD(model.id, 100) = 0 "
					+ "and (model.id-MOD(model.id, 10000)) = ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, provinceId);
			queryObject.setParameter(1, provinceId);
			return (List<AreaInfo>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AreaInfo> findAllTown(Integer cityId) {
		log.debug("finding all AreaInfo instances");
		try {
			String queryString = "from AreaInfo as model where model.id <> ? and (model.id-MOD(model.id, 100)) = ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, cityId);
			queryObject.setParameter(1, cityId);
			return (List<AreaInfo>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AreaInfo> select(String key, String other) {
		log.debug("select all AreaInfo instances with constrain that " + key);
		try {
			String queryString = "from " + TABLE_NAME + " as model " + Utilities.generateWhereStatementH(key) + " " + other;
			return (List<AreaInfo>)getSession().createQuery(queryString).list();
		} catch (RuntimeException re) {
			log.error("select with constrain failed", re);
			throw re;
		}
	}
}