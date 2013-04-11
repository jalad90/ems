package com.ems.daoImpl;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ems.dao.RegisterUser;
import com.ems.dao.UserAppraisal;
import com.ems.dto.AppraisalDetailDTO;
import com.ems.dto.RegisterUserDTO;
import com.ems.util.HibernateUtil;

public class UserAppraisalDaoImpl implements UserAppraisal {

	@Override
	public int dbUpdateAppraisal(AppraisalDetailDTO appraisalDto) {

		

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		StringBuffer strSQL = new StringBuffer();

		int getAppraisalId = (Integer) session.save(appraisalDto);

		transaction.commit();

		session.close();

		return getAppraisalId;

	}

	@Override
	public boolean isUpdated(int getResult) {
		// TODO Auto-generated method stub
		return false;
	}

}
