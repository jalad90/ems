package com.ems.dao;

import com.ems.dto.RegisterUserDTO;
import com.ems.dto.UpdateDbUserDetailDto;
import com.ems.dto.UpdateUserDetailDto;

public interface UpdateDbUserDetail {

	public void dbUpdateShowUserDetail(UpdateDbUserDetailDto updateUserDetailDto);
	
}
