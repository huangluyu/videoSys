package com.hly.videosys2.entity;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private String username;
	private String password;
	private String realName;
	private String email;
	private String mobilePhoneNum;
	private Integer userAuthority;
	private String money;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String username) {
		this.username = username;
	}

	/** full constructor */
	public Userinfo(String username, String password, String realName,
			String email, String mobilePhoneNum, Integer userAuthority,
			String money) {
		this.username = username;
		this.password = password;
		this.realName = realName;
		this.email = email;
		this.mobilePhoneNum = mobilePhoneNum;
		this.userAuthority = userAuthority;
		this.money = money;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhoneNum() {
		return this.mobilePhoneNum;
	}

	public void setMobilePhoneNum(String mobilePhoneNum) {
		this.mobilePhoneNum = mobilePhoneNum;
	}

	public Integer getUserAuthority() {
		return this.userAuthority;
	}

	public void setUserAuthority(Integer userAuthority) {
		this.userAuthority = userAuthority;
	}

	public String getMoney() {
		return this.money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

}