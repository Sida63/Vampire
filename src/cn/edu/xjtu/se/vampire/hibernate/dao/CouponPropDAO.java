package cn.edu.xjtu.se.vampire.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.xjtu.se.vampire.hibernate.entity.CouponProp;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * A data access object (DAO) providing persistence and search support for
 * CouponProp entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xjtu.se.vampire.hibernate.entity.CouponProp
 * @author MyEclipse Persistence Tools
 */
public class CouponPropDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CouponPropDAO.class);
	// property constants
	public static final String LIMITS = "limits";
	public static final String DISCOUNT = "discount";
	public static final String LEAST = "least";
	public static final String GUARANTEE = "guarantee";
	public static final String Description = "description";
	// table name
	public static final String TABLE_NAME = "CouponProp";

	public boolean save(CouponProp transientInstance) {
		boolean flag = true;
		log.debug("saving CouponProp instance");
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

	public boolean delete(CouponProp persistentInstance) {
		boolean flag = true;
		log.debug("deleting CouponProp instance");
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
	
	public boolean update(CouponProp instance) {
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

	public CouponProp findById(java.lang.Integer id) {
		log.debug("getting CouponProp instance with id: " + id);
		try {
			CouponProp instance = (CouponProp) getSession().get(
					"cn.edu.xjtu.se.vampire.hibernate.entity.CouponProp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CouponProp> findByExample(CouponProp instance) {
		log.debug("finding CouponProp instance by example");
		try {
			List<?> results = getSession()
					.createCriteria(
							"cn.edu.xjtu.se.vampire.hibernate.entity.CouponProp")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return (List<CouponProp>)results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CouponProp> findByProperty(String propertyName, Object value) {
		log.debug("finding CouponProp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CouponProp as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return (List<CouponProp>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<CouponProp> findByLimits(Object limits) {
		return findByProperty(LIMITS, limits);
	}

	public List<CouponProp> findByDiscount(Object discount) {
		return findByProperty(DISCOUNT, discount);
	}

	public List<CouponProp> findByLeast(Object least) {
		return findByProperty(LEAST, least);
	}

	public List<CouponProp> findByGuarantee(Object guarantee) {
		return findByProperty(GUARANTEE, guarantee);
	}
	
	public List<CouponProp> findByDescription(Object description){
		return findByProperty(Description, description);
	}

	@SuppressWarnings("unchecked")
	public List<CouponProp> findAll() {
		log.debug("finding all CouponProp instances");
		try {
			String queryString = "from CouponProp";
			Query queryObject = getSession().createQuery(queryString);
			return (List<CouponProp>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CouponProp> select(String key) {
		log.debug("select all CouponProp instances with constrain that " + key);
		try {
			String queryString = "from " + TABLE_NAME + " as model " + Utilities.generateWhereStatementH(key);
			return (List<CouponProp>)getSession().createQuery(queryString).list();
		} catch (RuntimeException re) {
			log.error("select with constrain failed", re);
			throw re;
		}
	}
}