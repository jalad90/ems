package com.ems.daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ems.dao.UpdateLeaveRequest;
import com.ems.util.HibernateUtil;

public class UpdateLeaveRequestDaoImpl implements UpdateLeaveRequest {

	@Override
	public int updateUserLeaveRequest(int getUserLeaveId) {


		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		StringBuffer strSQL = new StringBuffer();

		strSQL.append("UPDATE leave_detail SET approve = 'Y'").append("WHERE ");
		strSQL.append("user_leave_id = :userleaveid");

		
		
		SQLQuery query = session.createSQLQuery(strSQL.toString());

		query.setParameter("userleaveid",getUserLeaveId);
		
		int getResultSet = query.executeUpdate();
		
		transaction.commit();
		
		session.close();
		
		return getResultSet;

	}

}
