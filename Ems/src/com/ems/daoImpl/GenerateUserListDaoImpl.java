package com.ems.daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ems.dao.GetUserLists;
import com.ems.dto.RegisterUserDTO;
import com.ems.util.HibernateUtil;

public class GenerateUserListDaoImpl implements GetUserLists {

	@Override
	public List generateUserList(RegisterUserDTO registerUserDTO) {

		List userListDetails = new ArrayList();

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		StringBuffer strSQL = new StringBuffer();

		strSQL.append("SELECT * FROM register_user WHERE user_reg_id = :userId");

		SQLQuery query = session.createSQLQuery(strSQL.toString());

		query.setParameter("userId", registerUserDTO.getId());

		List list = query.list();

		Iterator iter = list.iterator();

		while (iter.hasNext()) {
			userListDetails.add(iter.next());
		}

		transaction.commit();

		session.close();

		return userListDetails;
	}

}
