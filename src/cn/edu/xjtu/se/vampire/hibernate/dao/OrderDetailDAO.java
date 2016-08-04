package cn.edu.xjtu.se.vampire.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.xjtu.se.vampire.hibernate.entity.OrderDetail;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrderDetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xjtu.se.vampire.hibernate.entity.OrderDetail
 * @author MyEclipse Persistence Tools
 */
public class OrderDetailDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrderDetailDAO.class);
	// property constants
	public static final String AMOUNT = "amount";
	public static final String PRICE = "price";
	// table name
	public static final String TABLE_NAME = "OrderDetail";

	public boolean save(OrderDetail transientInstance) {
		boolean flag = true;
		log.debug("saving OrderDetail instance");
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

	public boolean delete(OrderDetail persistentInstance) {
		boolean flag = true;
		log.debug("deleting OrderDetail instance");
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

	public boolean update(OrderDetail instance) {
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

	public OrderDetail findById(java.lang.Integer id) {
		log.debug("getting OrderDetail instance with id: " + id);
		try {
			OrderDetail instance = (OrderDetail) getSession().get(
					"cn.edu.xjtu.se.vampire.hibernate.entity.OrderDetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderDetail> findByExample(OrderDetail instance) {
		log.debug("finding OrderDetail instance by example");
		try {
			List<?> results = getSession()
					.createCriteria(
							"cn.edu.xjtu.se.vampire.hibernate.entity.OrderDetail")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return (List<OrderDetail>) results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderDetail> findByProperty(String propertyName, Object value) {
		log.debug("finding OrderDetail instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OrderDetail as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return (List<OrderDetail>) queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<OrderDetail> findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List<OrderDetail> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	@SuppressWarnings("unchecked")
	public List<OrderDetail> findAll() {
		log.debug("finding all OrderDetail instances");
		try {
			String queryString = "from OrderDetail";
			Query queryObject = getSession().createQuery(queryString);
			return (List<OrderDetail>) queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderDetail> select(String key) {
		log.debug("select all OrderDetail instances with constrain that " + key);
		try {
			String queryString = "from " + TABLE_NAME + " as model "
					+ Utilities.generateWhereStatementH(key);
			return (List<OrderDetail>) getSession().createQuery(queryString)
					.list();
		} catch (RuntimeException re) {
			log.error("select with constrain failed", re);
			throw re;
		}
	}
}