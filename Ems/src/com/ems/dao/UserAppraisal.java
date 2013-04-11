package com.ems.dao;

import com.ems.dto.AppraisalDetailDTO;

public interface UserAppraisal {

	public int dbUpdateAppraisal(AppraisalDetailDTO appraisalDto);

	public boolean isUpdated(int getResult);

}
