package cn.edu.xjtu.se.vampire.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.xjtu.se.vampire.hibernate.entity.AdminGroupInfo;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdminGroupInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xjtu.se.vampire.hibernate.entity.AdminGroupInfo
 * @author MyEclipse Persistence Tools
 */
public class AdminGroupInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AdminGroupInfoDAO.class);
	// property constants
	public static final String ADMIN_GROUP = "adminGroup";
	public static final String PRIVILEGE = "privilege";
	// Table name
	public static final String TABLE_NAME = "AdminGroupInfo";

	public boolean save(AdminGroupInfo transientInstance) {
		boolean flag = true;
		log.debug("saving AdminGroupInfo instance");
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

	public boolean delete(AdminGroupInfo persistentInstance) {
		boolean flag = true;
		log.debug("deleting AdminGroupInfo instance");
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

	public boolean update(AdminGroupInfo instance) {
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

	public AdminGroupInfo findById(java.lang.Integer id) {
		log.debug("getting AdminGroupInfo instance with id: " + id);
		try {
			AdminGroupInfo instance = (AdminGroupInfo) getSession().get(
					"cn.edu.xjtu.se.vampire.hibernate.entity.AdminGroupInfo",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AdminGroupInfo> findByExample(AdminGroupInfo instance) {
		log.debug("finding AdminGroupInfo instance by example");
		try {
			List<?> results = getSession()
					.createCriteria(
							"cn.edu.xjtu.se.vampire.hibernate.entity.AdminGroupInfo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return (List<AdminGroupInfo>) results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AdminGroupInfo> findByProperty(String propertyName, Object value) {
		log.debug("finding AdminGroupInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AdminGroupInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return (List<AdminGroupInfo>) queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AdminGroupInfo> findByAdminGroup(String adminGroup) {
		return findByProperty(ADMIN_GROUP, adminGroup);
	}

	public List<AdminGroupInfo> findByPrivilege(Integer privilege) {
		return findByProperty(PRIVILEGE, privilege);
	}

	@SuppressWarnings("unchecked")
	public List<AdminGroupInfo> findAll() {
		log.debug("finding all AdminGroupInfo instances");
		try {
			String queryString = "from AdminGroupInfo";
			Query queryObject = getSession().createQuery(queryString);
			return (List<AdminGroupInfo>) queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AdminGroupInfo> select(String key) {
		log.debug("select all Admin instances with constrain that " + key);
		try {
			String queryString = "from " + TABLE_NAME + " as model "
					+ Utilities.generateWhereStatementH(key);
			return (List<AdminGroupInfo>) getSession().createQuery(queryString)
					.list();
		} catch (RuntimeException re) {
			log.error("select with constrain failed", re);
			throw re;
		}
	}
}