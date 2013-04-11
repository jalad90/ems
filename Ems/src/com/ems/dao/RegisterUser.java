/**
 * 
 */
package com.ems.dao;

import com.ems.dto.RegisterUserDTO;

/**
 * @author Jaladk
 *
 */
public interface RegisterUser {

	public int dbRegisterUser(RegisterUserDTO objRegisterDto);
	
	public boolean isRegistered(int getResult);
}
