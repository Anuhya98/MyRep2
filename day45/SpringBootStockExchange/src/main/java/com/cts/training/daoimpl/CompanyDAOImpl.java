package com.cts.training.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.training.dao.CompanyDao;
import com.cts.training.model.Company;
import com.cts.training.model.StockExchange;

@Transactional
@Repository(value = "CompanyDAO")
public class CompanyDAOImpl implements CompanyDao {
	@Autowired
	SessionFactory sessionFactory;

//	@Override
//	public boolean addCompany(Company company) {
//		try {
//			sessionFactory.getCurrentSession().save(company);
//			return true;
//		}
//		catch(HibernateException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}

//	@Override
//	public boolean updateCompany(Company company) {
//		try {
//			sessionFactory.getCurrentSession().update(company);
//			return true;
//		}
//		catch(HibernateException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}

	@Override
	public boolean deleteCompany(Company company) {
		try {
			sessionFactory.getCurrentSession().delete(company);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Company getCompanyById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Company.class, id);

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Company> getAllCompanyies() {
		try {
			List<Company> companies = sessionFactory.getCurrentSession().createQuery("from Company").list();
			return companies;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean saveOrUpdateCompany(Company company) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(company);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

}
