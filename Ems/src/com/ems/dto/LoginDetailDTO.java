package com.ems.dto;

public class LoginDetailDTO {

	private int id;
	private String userName, passWord, userType;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return (null == userName) ? "" : userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return (null == passWord) ? "" : passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
