package com.ems.daoImpl;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ems.dao.UserLogin;
import com.ems.dto.LoginDetailDTO;
import com.ems.util.ConstCondition;
import com.ems.util.HibernateUtil;

/**
 * @author JaladK
 * 
 */

public class UserLoginDetailImpl implements UserLogin {

	@Override
	public int dbCheckUser(LoginDetailDTO loginObj) {

		int i = 0;

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		StringBuffer strSQL = new StringBuffer();

		strSQL.append("SELECT count(*) FROM login_detail WHERE username_nn = :userName AND password_nn = ");

		strSQL.append(" :passWord AND userType_nn = :userType ");

		Transaction transaction = session.beginTransaction();

		SQLQuery query = session.createSQLQuery(strSQL.toString());

		query.setParameter("userName", loginObj.getUserName());
		query.setParameter("passWord", loginObj.getPassWord());
		query.setParameter("userType", loginObj.getUserType());
		List list = query.list();

		Iterator iter = list.iterator();

		while (iter.hasNext()) {
			i = Integer.parseInt(String.valueOf(iter.next()));
		}

		return i;

	}

	@Override
	public boolean isVerified(int getResponse) {
		if (getResponse == ConstCondition.SUCCESS) {
			return true;
		} else {
			return false;
		}
	}

}
