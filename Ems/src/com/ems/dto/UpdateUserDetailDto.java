package com.ems.dto;

import java.util.Date;

public class UpdateUserDetailDto {

	private String firstName, lastName, emailId, address, gender, division,
			department, userRegisterType, mobileNumber;

	private int id;

	private long uidNumber, panNumber;
	private Date dateOfBirth;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserRegisterType() {
		return userRegisterType;
	}

	public void setUserRegisterType(String userRegisterType) {
		this.userRegisterType = userRegisterType;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getFirstName() {
		return (null == firstName) ? "" : firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return (null == lastName) ? "" : lastName;

	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return (null == emailId) ? "" : emailId;

	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return (null == address) ? "" : address;

	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return (null == gender) ? "" : gender;

	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getUidNumber() {
		return uidNumber;
	}

	public void setUidNumber(long uidNumber) {
		this.uidNumber = uidNumber;
	}

	public long getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(long panNumber) {
		this.panNumber = panNumber;
	}
}
