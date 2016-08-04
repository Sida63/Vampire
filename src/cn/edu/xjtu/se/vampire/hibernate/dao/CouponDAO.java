package cn.edu.xjtu.se.vampire.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.xjtu.se.vampire.hibernate.entity.Coupon;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * A data access object (DAO) providing persistence and search support for
 * Coupon entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xjtu.se.vampire.hibernate.entity.Coupon
 * @author MyEclipse Persistence Tools
 */
public class CouponDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CouponDAO.class);
	// property constants
	public static final String COUPON_NUMBER = "couponNumber";
	// table name 
	public static final String TABLE_NAME = "Coupon";

	public boolean save(Coupon transientInstance) {
		boolean flag = true;
		log.debug("saving Coupon instance");
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

	public boolean delete(Coupon persistentInstance) {
		boolean flag = true;
		log.debug("deleting Coupon instance");
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

	public boolean update(Coupon instance) {
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
	
	public Coupon findById(java.lang.Integer id) {
		log.debug("getting Coupon instance with id: " + id);
		try {
			Coupon instance = (Coupon) getSession().get(
					"cn.edu.xjtu.se.vampire.hibernate.entity.Coupon", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Coupon> findByExample(Coupon instance) {
		log.debug("finding Coupon instance by example");
		try {
			List<?> results = getSession()
					.createCriteria(
							"cn.edu.xjtu.se.vampire.hibernate.entity.Coupon")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return (List<Coupon>)results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Coupon> findByProperty(String propertyName, Object value) {
		log.debug("finding Coupon instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Coupon as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return (List<Coupon>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Coupon> findByCouponNumber(Object couponNumber) {
		return findByProperty(COUPON_NUMBER, couponNumber);
	}

	@SuppressWarnings("unchecked")
	public List<Coupon> findAll() {
		log.debug("finding all Coupon instances");
		try {
			String queryString = "from Coupon";
			Query queryObject = getSession().createQuery(queryString);
			return (List<Coupon>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Coupon> select(String key) {
		log.debug("select all Coupon instances with constrain that " + key);
		try {
			String queryString = "from " + TABLE_NAME + " as model " + Utilities.generateWhereStatementH(key);
			return (List<Coupon>)getSession().createQuery(queryString).list();
		} catch (RuntimeException re) {
			log.error("select with constrain failed", re);
			throw re;
		}
	}
}