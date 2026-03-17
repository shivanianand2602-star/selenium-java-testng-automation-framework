package com.ui.pojo;

public class User {

	private String emailAddress;
	private String password;
	private String expectedName;

	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getExpectedName() {
		return expectedName;
	}
	public void setExpectedName(String expectedName) {
		this.expectedName = expectedName;
	}
	public User(String emailAddress, String password, String expectedName) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
		this.expectedName = expectedName;
	}
	@Override
	public String toString() {
		return "User [emailAddress=" + emailAddress + ", password=" + password + ", expectedName=" + expectedName + "]";
	}
}
