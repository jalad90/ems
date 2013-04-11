package com.ems.daoImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ems.dao.UpdateUser;
import com.ems.dto.RegisterUserDTO;
import com.ems.dto.UpdateUserDetailDto;
import com.ems.util.HibernateUtil;

public class UpdateUserDetailDaoImpl implements UpdateUser {

	@Override
	public boolean isUpdated(int getResultSet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List dbUpdateUserDetail(UpdateUserDetailDto objRegisterDto) {


		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		String hql = "FROM UpdateUserDetailDto WHERE id = :userId";

		Query query = session.createQuery(hql).setParameter("userId",
				objRegisterDto.getId());

		List<UpdateUserDetailDto> list = query.list();

		
		transaction.commit();

		session.close();

		return list;
	}

}
