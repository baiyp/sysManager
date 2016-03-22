package com.manager.sys.model;

public class Account extends BaseEntity {
	
	private String username;
	
	private String password;
	
	private int user_type;//用戶類別
	
	private int  user_level;//用戶等級
	
	private int register_date;//註冊時間
	
	private int Audit_status;//0：普通会员、1：未审核、2：审核通过、审核未通过
	
	private int user_mode;//

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public int getUser_level() {
		return user_level;
	}

	public void setUser_level(int user_level) {
		this.user_level = user_level;
	}

	public int getRegister_date() {
		return register_date;
	}

	public void setRegister_date(int register_date) {
		this.register_date = register_date;
	}

	public int getAudit_status() {
		return Audit_status;
	}

	public void setAudit_status(int audit_status) {
		Audit_status = audit_status;
	}

	public int getUser_mode() {
		return user_mode;
	}

	public void setUser_mode(int user_mode) {
		this.user_mode = user_mode;
	}
	
 
}
