package com.ems.dto;

import java.util.Date;

public class AppraisalDetailDTO {

	private String firstName, division, department;
	private Date lastAppraisalDate, futureAppraisalDate;
	private int appraisal_id;

	public int getAppraisal_id() {
		return appraisal_id;
	}

	public void setAppraisal_id(int appraisal_id) {
		this.appraisal_id = appraisal_id;
	}

	public String getFirstName() {
		return (null == firstName) ? "" : firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDivision() {
		return (null == division) ? "" : division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getDepartment() {
		return (null == department) ? "" : department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getLastAppraisalDate() {
		return lastAppraisalDate;
	}

	public void setLastAppraisalDate(Date lastAppraisalDate) {
		this.lastAppraisalDate = lastAppraisalDate;
	}

	public Date getFutureAppraisalDate() {
		return futureAppraisalDate;
	}

	public void setFutureAppraisalDate(Date futureAppraisalDate) {
		this.futureAppraisalDate = futureAppraisalDate;
	}

}
