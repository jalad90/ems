package com.ems.dto;

import java.util.Date;

public class WorkDetailDTO {

	private String jobTitle, reportTo, designation, department;
	private Date dateStarted, reviewDate, terminationDate, probationExpiry,
			contractExpiry;

	public Date getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public Date getProbationExpiry() {
		return probationExpiry;
	}

	public void setProbationExpiry(Date probationExpiry) {
		this.probationExpiry = probationExpiry;
	}

	public Date getContractExpiry() {
		return contractExpiry;
	}

	public void setContractExpiry(Date contractExpiry) {
		this.contractExpiry = contractExpiry;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getReportTo() {
		return (null == reportTo) ? "" : reportTo;
	}

	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}

	public String getDesignation() {
		return (null == designation) ? "" : designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return (null == department) ? "" : department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
