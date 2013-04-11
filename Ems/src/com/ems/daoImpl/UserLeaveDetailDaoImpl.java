package com.ems.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ems.dao.UserLeave;
import com.ems.dto.RegisterUserDTO;
import com.ems.dto.UserLeaveDetailDto;
import com.ems.util.HibernateUtil;

public class UserLeaveDetailDaoImpl implements UserLeave{
	
	RegisterUserDTO objRegisterDto = new RegisterUserDTO();

	@Override
	public int dbInsertLeaveApplication(UserLeaveDetailDto userLeaveDto) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		userLeaveDto.setId(objRegisterDto.getId());
		
		objRegisterDto.setUserLeaveDto(userLeaveDto);
		
		int getLeaveId = (Integer)session.save(userLeaveDto);
		
		transaction.commit();
		
		session.close();
		
		return getLeaveId;
	}

}
 /* */