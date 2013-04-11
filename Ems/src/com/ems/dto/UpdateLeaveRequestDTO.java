package com.ems.dto;

public class UpdateLeaveRequestDTO {

	private String employeeName, description, department;

	public String getDepartment() {
		return (null == department) ? "" : department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	private int units, id, userRegisterId;

	public int getUserRegisterId() {
		return userRegisterId;
	}

	public void setUserRegisterId(int userRegisterId) {
		this.userRegisterId = userRegisterId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private long dateRange;

	public String getEmployeeName() {
		return (null == employeeName) ? "" : employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDescription() {
		return (null == description) ? "" : description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public long getDateRange() {
		return dateRange;
	}

	public void setDateRange(long dateRange) {
		this.dateRange = dateRange;
	}

}
