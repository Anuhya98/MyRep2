package com.cts.training.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.training.dao.SectorDao;
import com.cts.training.model.Sector;
import com.cts.training.model.StockExchange;

@Transactional
@Repository(value = "sectorDAO")
public class SectorDAOImpl implements SectorDao
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addSector(Sector sector) {
		try {
			sessionFactory.getCurrentSession().save(sector);
			return true;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteSector(Sector sector) {
		try {
			sessionFactory.getCurrentSession().delete(sector);
			return true;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateSector(Sector sector) {
		try {
			sessionFactory.getCurrentSession().update(sector);
			return true;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Sector getSectorById(int sectorId) {
		try {
			return sessionFactory.getCurrentSession().get(Sector.class, sectorId);

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Sector> getAllSectors() {
		try {
			List<Sector> sectors = sessionFactory.getCurrentSession().createQuery("from Sector").list();
			return sectors;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

}
