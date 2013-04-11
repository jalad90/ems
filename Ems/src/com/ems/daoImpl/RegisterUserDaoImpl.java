package com.ems.daoImpl;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ems.dao.RegisterUser;
import com.ems.dto.RegisterUserDTO;
import com.ems.util.ConstCondition;
import com.ems.util.HibernateUtil;

public class RegisterUserDaoImpl implements RegisterUser {

	int getResultSet = 0, getResult = 0;

	@Override
	public int dbRegisterUser(RegisterUserDTO objRegisterDto) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		int getResultSet = (Integer) session.save(objRegisterDto);

		transaction.commit();

		session.close();

		return getResultSet;
	}

	@Override
	public boolean isRegistered(int getResult) {

		this.getResult = getResult;

		if (getResult == ConstCondition.SUCCESS) {
			return true;
		} else {
			return false;
		}
	}

}
