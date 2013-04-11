package com.ems.daoImpl;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ems.dao.UserDetailDelete;
import com.ems.dto.UserDetailDeleteDTO;
import com.ems.util.HibernateUtil;

public class UserDetailDeleteDaoImpl implements UserDetailDelete {

	@Override
	public void dbDeleteUserDetail(UserDetailDeleteDTO userDeleteDto) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		
		System.out.println("get user id >>>" +userDeleteDto.getId());

		UserDetailDeleteDTO userDetailDeleteDto = (UserDetailDeleteDTO)session.get(UserDetailDeleteDTO.class, userDeleteDto.getId());
		
		session.delete(userDetailDeleteDto);

		transaction.commit();

		session.close();
	}

}
