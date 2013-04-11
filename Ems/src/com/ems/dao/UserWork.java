package com.ems.dao;

import com.ems.dto.WorkDetailDTO;

public interface UserWork {

	public int dbUpdateUserWorkDetail(WorkDetailDTO workDetailDto);
	
	public boolean isUpdate(int getResultSet);
}
