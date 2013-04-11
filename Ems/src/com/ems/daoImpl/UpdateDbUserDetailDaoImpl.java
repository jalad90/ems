package com.ems.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ems.dao.UpdateDbUserDetail;
import com.ems.dto.RegisterUserDTO;
import com.ems.dto.UpdateDbUserDetailDto;
import com.ems.dto.UpdateUserDetailDto;
import com.ems.util.HibernateUtil;

public class UpdateDbUserDetailDaoImpl implements UpdateDbUserDetail{

	@Override
	public void dbUpdateShowUserDetail(UpdateDbUserDetailDto updateUserDetailDto) {
		
		

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		UpdateDbUserDetailDto dbUserDetailDto = (UpdateDbUserDetailDto) session.get(UpdateDbUserDetailDto.class,updateUserDetailDto.getId());
		
		System.out.println("Id >>>>>" +updateUserDetailDto.getId());
		
		
		if(!(dbUserDetailDto == null)){
		
		dbUserDetailDto.setFirstName(updateUserDetailDto.getFirstName());
		dbUserDetailDto.setLastName(updateUserDetailDto.getLastName());
		dbUserDetailDto.setDateOfBirth(updateUserDetailDto.getDateOfBirth());
		dbUserDetailDto.setAddress(updateUserDetailDto.getAddress());
		dbUserDetailDto.setUidNumber(updateUserDetailDto.getUidNumber());
		dbUserDetailDto.setPanNumber(updateUserDetailDto.getPanNumber());
		dbUserDetailDto.setDepartment(updateUserDetailDto.getDepartment());
		dbUserDetailDto.setDivision(updateUserDetailDto.getDivision());
		dbUserDetailDto.setMobileNumber(updateUserDetailDto.getMobileNumber());
		dbUserDetailDto.setGender(updateUserDetailDto.getGender());
		dbUserDetailDto.setUserRegisterType(updateUserDetailDto.getUserRegisterType());
		
		session.update(dbUserDetailDto);
		
		transaction.commit();
		
		System.out.println("Calling");
		
		session.close();
		
		}else{
			System.out.println("OOps ");
		}
		
	}

	
	

}
