package com.ems.dao;

import java.util.List;

import com.ems.dto.RegisterUserDTO;
import com.ems.dto.UpdateUserDetailDto;

/**
 * @author JaladK
 * 
 */
public interface UpdateUser {
	
	public List dbUpdateUserDetail(UpdateUserDetailDto objRegisterDto);
	
	public boolean isUpdated(int getResultSet);

}
