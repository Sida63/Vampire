package cn.edu.xjtu.se.vampire.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.xjtu.se.vampire.hibernate.entity.UserStatusInfo;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserStatusInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xjtu.se.vampire.hibernate.entity.UserStatusInfo
 * @author MyEclipse Persistence Tools
 */
public class UserStatusInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserStatusInfoDAO.class);
	// property constants
	public static final String USER_STATUS = "userStatus";
	// table name
	public static final String TABLE_NAME = "UserStatusInfo";

	public boolean save(UserStatusInfo transientInstance) {
		boolean flag = true;
		log.debug("saving UserStatusInfo instance");
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

	public boolean delete(UserStatusInfo persistentInstance) {
		boolean flag = true;
		log.debug("deleting UserStatusInfo instance");
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

	public boolean update(UserStatusInfo instance) {
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

	public UserStatusInfo findById(java.lang.Integer id) {
		log.debug("getting UserStatusInfo instance with id: " + id);
		try {
			UserStatusInfo instance = (UserStatusInfo) getSession().get(
					"cn.edu.xjtu.se.vampire.hibernate.entity.UserStatusInfo",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserStatusInfo> findByExample(UserStatusInfo instance) {
		log.debug("finding UserStatusInfo instance by example");
		try {
			List<?> results = getSession()
					.createCriteria(
							"cn.edu.xjtu.se.vampire.hibernate.entity.UserStatusInfo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return (List<UserStatusInfo>) results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserStatusInfo> findByProperty(String propertyName, Object value) {
		log.debug("finding UserStatusInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UserStatusInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return (List<UserStatusInfo>) queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<UserStatusInfo> findByUserStatus(Object userStatus) {
		return findByProperty(USER_STATUS, userStatus);
	}

	@SuppressWarnings("unchecked")
	public List<UserStatusInfo> findAll() {
		log.debug("finding all UserStatusInfo instances");
		try {
			String queryString = "from UserStatusInfo";
			Query queryObject = getSession().createQuery(queryString);
			return (List<UserStatusInfo>) queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserStatusInfo> select(String key) {
		log.debug("select all UserStatusInfo instances with constrain that "
				+ key);
		try {
			String queryString = "from " + TABLE_NAME + " as model "
					+ Utilities.generateWhereStatementH(key);
			return (List<UserStatusInfo>) getSession().createQuery(queryString)
					.list();
		} catch (RuntimeException re) {
			log.error("select with constrain failed", re);
			throw re;
		}
	}
}