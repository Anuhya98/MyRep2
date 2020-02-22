package com.cts.training.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.training.dao.IpoDao;
import com.cts.training.model.Ipo;
import com.cts.training.model.User;

@Transactional
@Repository(value="ipoDAO")
public class IpoDAOImpl implements IpoDao
{
	@Autowired
    SessionFactory sessionFactory;

	@Override
	public boolean addIpo(Ipo ipo) {
		try {
    sessionFactory.getCurrentSession().save(ipo);
		return true;
	} catch (HibernateException e) {
		e.printStackTrace();
		return false;
		}
	}

	@Override
	public boolean updateIpo(Ipo ipo) {
		try {
			sessionFactory.getCurrentSession().update(ipo);
			return true;
	  } catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteIpo(Ipo ipo) {
		try {
			sessionFactory.getCurrentSession().delete(ipo);
			return true;
	  } catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Ipo getIpoById(int id) {
try {
			
			return sessionFactory.getCurrentSession().get(Ipo.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Ipo> getAllIpos() {
try {
			
			List<Ipo> ipos = sessionFactory.getCurrentSession().createQuery("from Ipo").list();
			return ipos;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

}
