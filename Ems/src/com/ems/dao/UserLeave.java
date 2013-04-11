package com.ems.dao;

import com.ems.dto.UserLeaveDetailDto;

public interface UserLeave {
	
	public int dbInsertLeaveApplication(UserLeaveDetailDto userLeaveDto);

}
