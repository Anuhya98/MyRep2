package com.cts.training.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.training.dao.StockpriceDao;
import com.cts.training.model.Stockprice;
import com.cts.training.model.User;

@Transactional
@Repository(value="stockpriceDAO")
public class StockpriceDAOImpl implements StockpriceDao
{
	@Autowired
    SessionFactory sessionFactory;

	//@Override
	public boolean updateStockprice(Stockprice stockprice) {
		try {
		sessionFactory.getCurrentSession().update(stockprice);
		return true;
		}
		catch (HibernateException e) {
			e.printStackTrace();
		return false;
		}
	}

	//@Override
	public boolean addStockprice(Stockprice stockprice) {
		try {
			sessionFactory.getCurrentSession().save(stockprice);
			return true;
			}
			catch (HibernateException e) {
				e.printStackTrace();
			return false;
			}
	}

	//@Override
	public boolean deleteStockprice(Stockprice stockprice) {
		try {
			sessionFactory.getCurrentSession().delete(stockprice);
			return true;
			}
			catch (HibernateException e) {
				e.printStackTrace();
			return false;
			}
	}

	//@Override
	public Stockprice getStockPriceById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Stockprice.class, id);
			
			}
			catch (HibernateException e) {
				e.printStackTrace();
			return null;
			}
	}

	@Override
	public List<Stockprice> getAllStockPrices() {
try {
			
			List<Stockprice> prices = sessionFactory.getCurrentSession().createQuery("from Stockprice").list();
			return prices;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
