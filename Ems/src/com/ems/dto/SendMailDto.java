package com.ems.dto;

public class SendMailDto {

	private String from, to, subject, text, userName, passWord;

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

	private int feedbackId;

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFrom() {
		return (null == from) ? "" : from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return (null == to) ? "" : to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return (null == subject) ? "" : subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return (null == text) ? "" : text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
