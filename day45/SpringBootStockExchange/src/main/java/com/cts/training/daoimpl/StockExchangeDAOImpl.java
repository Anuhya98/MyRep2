package com.cts.training.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.training.dao.StockExchangeDao;
import com.cts.training.model.Company;
import com.cts.training.model.StockExchange;

@Transactional
@Repository(value = "StockExchangeDAO")
public class StockExchangeDAOImpl implements StockExchangeDao
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addStockExchange(StockExchange stockExchange) {
		try {
		sessionFactory.getCurrentSession().save(stockExchange);
		return true;
	}
	catch(HibernateException e) {
		e.printStackTrace();
		return false;
	}
	}

	@Override
	public boolean updateStockExchange(StockExchange stockExchange) {
		try {
			sessionFactory.getCurrentSession().update(stockExchange);
			return true;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteStockExchange(StockExchange stockExchange) {
		try {
			sessionFactory.getCurrentSession().delete(stockExchange);
			return true;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public StockExchange getStockExchangeById(int stockId) {
		try {
			return sessionFactory.getCurrentSession().get(StockExchange.class, stockId);

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<StockExchange> getAllStockExchanges() {
		try {
			List<StockExchange> stockexchanges = sessionFactory.getCurrentSession().createQuery("from StockExchange").list();
			return stockexchanges;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

}
