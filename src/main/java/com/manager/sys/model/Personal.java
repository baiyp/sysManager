/**
 * 
 */
package com.manager.sys.model;

/**
 * @author baiyp
 *
 */
public class Personal extends BaseEntity {
	
	private String username;
	
	private String password;
	
	private int user_type;//用戶類別
	
	private int  user_level;//用戶等級
	
	private int register_date;//註冊時間
	
	private int audit_status;//0：普通会员、1：未审核、2：审核通过、审核未通过
	
	private int user_mode;//

	private String full_name;//姓名
	
	private String id_number;//ID_number
	
	private long date_birth;//出生日期
	
	private int sex;//性別 0 男 1女
	
	private String residence_address;//现居住地址
	
	private String email;//電子郵箱
	
	
	private String diploma;//学历
	
	private String graduate_institutions;//毕业院校
	
	private String profession;//所学专业
	
	private long graduation_time;//毕业时间_UTC时间
	
	
	private String work_unit;//工作单位
	
	
	private String positional_titles;//职称
	
	private String certificate;//资格证书
	
	
	private long working_year;//工作年份
	
	
	private String deposit_bank;//开户银行
	
	
	private String bank_account;//银行账户
	
	private String payment_mode;//在线支付方式
	
	private String remarks;//备注说明
	
	private String work_title;//职务
	
	private String salary;//月薪
	
	private String pay_account;//在线支付账号
	
	
	

	public String getId_number() {
		return id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public String getResidence_address() {
		return residence_address;
	}

	public void setResidence_address(String residence_address) {
		this.residence_address = residence_address;
	}

	
	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	 

	

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	 

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiploma() {
		return diploma;
	}

	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}

	public String getGraduate_institutions() {
		return graduate_institutions;
	}

	public void setGraduate_institutions(String graduate_institutions) {
		this.graduate_institutions = graduate_institutions;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	

	public long getDate_birth() {
		return date_birth;
	}

	public void setDate_birth(long date_birth) {
		this.date_birth = date_birth;
	}

	public long getGraduation_time() {
		return graduation_time;
	}

	public void setGraduation_time(long graduation_time) {
		this.graduation_time = graduation_time;
	}

	public long getWorking_year() {
		return working_year;
	}

	public void setWorking_year(long working_year) {
		this.working_year = working_year;
	}

	public String getWork_unit() {
		return work_unit;
	}

	public void setWork_unit(String work_unit) {
		this.work_unit = work_unit;
	}

	public String getPositional_titles() {
		return positional_titles;
	}

	public void setPositional_titles(String positional_titles) {
		this.positional_titles = positional_titles;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

 

	public String getDeposit_bank() {
		return deposit_bank;
	}

	public void setDeposit_bank(String deposit_bank) {
		this.deposit_bank = deposit_bank;
	}

	public String getBank_account() {
		return bank_account;
	}

	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getWork_title() {
		return work_title;
	}

	public void setWork_title(String work_title) {
		this.work_title = work_title;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getPay_account() {
		return pay_account;
	}

	public void setPay_account(String pay_account) {
		this.pay_account = pay_account;
	}

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
		return audit_status;
	}

	public void setAudit_status(int audit_status) {
		this.audit_status = audit_status;
	}

	public int getUser_mode() {
		return user_mode;
	}

	public void setUser_mode(int user_mode) {
		this.user_mode = user_mode;
	}
	 

}
