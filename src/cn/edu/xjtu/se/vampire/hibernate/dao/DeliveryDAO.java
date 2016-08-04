package cn.edu.xjtu.se.vampire.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.xjtu.se.vampire.hibernate.entity.Delivery;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * A data access object (DAO) providing persistence and search support for
 * Delivery entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xjtu.se.vampire.hibernate.entity.Delivery
 * @author MyEclipse Persistence Tools
 */
public class DeliveryDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DeliveryDAO.class);
	// property constants
	public static final String RECEIVER = "receiver";
	public static final String DETAIL_ADDR = "detailAddr";
	public static final String TEL = "tel";
	// table name
	public static final String TABLE_NAME = "Delivery";

	public boolean save(Delivery transientInstance) {
		boolean flag = true;
		log.debug("saving Delivery instance");
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

	public boolean delete(Delivery persistentInstance) {
		boolean flag = true;
		log.debug("deleting Delivery instance");
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
	
	public boolean update(Delivery instance) {
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
	
	public void evict(Delivery persistentInstance, boolean deep) {
		log.debug("evicting Delivery instance");
		try {
			getSession().evict(persistentInstance);
			
			if(deep) {				
				new UserDAO().evict(persistentInstance.getUser(), true);
				new AreaInfoDAO().evict(persistentInstance.getAreaCode(), true);
			}
			
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public Delivery findById(java.lang.Integer id) {
		log.debug("getting Delivery instance with id: " + id);
		try {
			Delivery instance = (Delivery) getSession().get(
					"cn.edu.xjtu.se.vampire.hibernate.entity.Delivery", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Delivery> findByExample(Delivery instance) {
		log.debug("finding Delivery instance by example");
		try {
			List<?> results = getSession()
					.createCriteria(
							"cn.edu.xjtu.se.vampire.hibernate.entity.Delivery")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return (List<Delivery>)results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Delivery> findByProperty(String propertyName, Object value) {
		log.debug("finding Delivery instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Delivery as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return (List<Delivery>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Delivery> findByReceiver(Object receiver) {
		return findByProperty(RECEIVER, receiver);
	}

	public List<Delivery> findByDetailAddr(Object detailAddr) {
		return findByProperty(DETAIL_ADDR, detailAddr);
	}

	public List<Delivery> findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	@SuppressWarnings("unchecked")
	public List<Delivery> findAll() {
		log.debug("finding all Delivery instances");
		try {
			String queryString = "from Delivery";
			Query queryObject = getSession().createQuery(queryString);
			return (List<Delivery>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Delivery> select(String key) {
		log.debug("select all Delivery instances with constrain that " + key);
		try {
			String queryString = "from " + TABLE_NAME + " as model " + Utilities.generateWhereStatementH(key);
			return (List<Delivery>)getSession().createQuery(queryString).list();
		} catch (RuntimeException re) {
			log.error("select with constrain failed", re);
			throw re;
		}
	}
}