package com.dao;

import com.model.TLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Data access object (DAO) for domain model class TLog.
 * 
 * @see com.model.TLog
 * @author MyEclipse Persistence Tools
 */

public class TLogDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TLogDAO.class);

	protected void initDao(){
		// do nothing
	}

	public void save(TLog transientInstance)
	{
		log.debug("saving TLog instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TLog persistentInstance)
	{
		log.debug("deleting TLog instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TLog findById(Integer id)
	{
		log.debug("getting TLog instance with id: " + id);
		try
		{
			TLog instance = (TLog) getHibernateTemplate().get(
					"com.model.TLog", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}


	public List findAll()
	{
		log.debug("finding all TLog instances");
		try
		{
			String queryString = "from TLog ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}


	public static TLogDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TLogDAO) ctx.getBean("TLogDAO");
	}
}