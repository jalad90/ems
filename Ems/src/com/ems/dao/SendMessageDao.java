package com.ems.dao;

import com.ems.dto.SendMailDto;


public interface SendMessageDao {
	
	public int sendTo (SendMailDto sendMailDto);

}
