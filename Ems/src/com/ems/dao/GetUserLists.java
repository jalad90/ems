package com.ems.dao;

import java.util.List;

import com.ems.dto.RegisterUserDTO;

public interface GetUserLists {
	
	public List generateUserList(RegisterUserDTO registerUserDTO);

}
