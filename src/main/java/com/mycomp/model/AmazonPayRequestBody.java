package com.mycomp.model;

public class AmazonPayRequestBody {

	private String userName;
	private String mobile;
	private String accountNumber;
	
	
	public AmazonPayRequestBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AmazonPayRequestBody(String userName, String mobile, String accountNumber) {
		super();
		this.userName = userName;
		this.mobile = mobile;
		this.accountNumber = accountNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}
