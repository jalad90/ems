/**
 * 
 */
package com.ems.dao;

import java.util.logging.Logger;

import com.ems.dto.LoginDetailDTO;

/**
 * @author JaladK
 * 
 */
public interface UserLogin {

	
	
	public int dbCheckUser(LoginDetailDTO loginObj);
	
	
	
	public boolean isVerified(int getResponse);
}
