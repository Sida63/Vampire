package cn.edu.xjtu.se.vampire.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.xjtu.se.vampire.hibernate.entity.OrderStatusInfo;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrderStatusInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xjtu.se.vampire.hibernate.entity.OrderStatusInfo
 * @author MyEclipse Persistence Tools
 */
public class OrderStatusInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrderStatusInfoDAO.class);
	// property constants
	public static final String ORDER_STATUS = "orderStatus";
	// table name
	public static final String TABLE_NAME = "OrderStatusInfo";

	public boolean save(OrderStatusInfo transientInstance) {
		boolean flag = true;
		log.debug("saving OrderStatusInfo instance");
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

	public boolean delete(OrderStatusInfo persistentInstance) {
		boolean flag = true;
		log.debug("deleting OrderStatusInfo instance");
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

	public boolean update(OrderStatusInfo instance) {
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

	public OrderStatusInfo findById(java.lang.Integer id) {
		log.debug("getting OrderStatusInfo instance with id: " + id);
		try {
			OrderStatusInfo instance = (OrderStatusInfo) getSession().get(
					"cn.edu.xjtu.se.vampire.hibernate.entity.OrderStatusInfo",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderStatusInfo> findByExample(OrderStatusInfo instance) {
		log.debug("finding OrderStatusInfo instance by example");
		try {
			List<?> results = getSession()
					.createCriteria(
							"cn.edu.xjtu.se.vampire.hibernate.entity.OrderStatusInfo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return (List<OrderStatusInfo>) results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderStatusInfo> findByProperty(String propertyName,
			Object value) {
		log.debug("finding OrderStatusInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from OrderStatusInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return (List<OrderStatusInfo>) queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<OrderStatusInfo> findByOrderStatus(Object orderStatus) {
		return findByProperty(ORDER_STATUS, orderStatus);
	}

	@SuppressWarnings("unchecked")
	public List<OrderStatusInfo> findAll() {
		log.debug("finding all OrderStatusInfo instances");
		try {
			String queryString = "from OrderStatusInfo";
			Query queryObject = getSession().createQuery(queryString);
			return (List<OrderStatusInfo>) queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderStatusInfo> select(String key) {
		log.debug("select all OrderStatusInfo instances with constrain that "
				+ key);
		try {
			String queryString = "from " + TABLE_NAME + " as model "
					+ Utilities.generateWhereStatementH(key);
			return (List<OrderStatusInfo>) getSession()
					.createQuery(queryString).list();
		} catch (RuntimeException re) {
			log.error("select with constrain failed", re);
			throw re;
		}
	}
}