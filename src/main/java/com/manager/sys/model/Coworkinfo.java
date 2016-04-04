/**
 * 
 */
package com.manager.sys.model;

import java.math.BigDecimal;

/**
 * @author baiyp
 *
 */
public class Coworkinfo extends BaseEntity {
	
	//合同编号
	private String contract_no;
	
	//任务项目名称
	private String work_name;
	
	//工期
	private int  work_days;
	
	//作业起始时间
	private long start_time;
	
	//交易金额
	private BigDecimal contract_sum;
	
	//任务类型
	private int work_type;
	
	//加工地点 城市
	private String work_place;
	
	private String remark;
	
	
	//加工资质
	private String work_qualification;
	
	//发包方id
	private int work_owner_id;
	
	
	
	//发包方名称
	private String work_owner_name;
	
	
	//接包方id
	private int work_contractor_id;
	
	//承包方名称
	private String work_contractor_name;
	
	//中标时间
	private long win_time;
	
	//当前整体进度百分比
	private String progress_percent;
	
 
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	//任务ID主键
	private int task_id; 
	
	
	
	public int getWork_type() {
		return work_type;
	}

	public void setWork_type(int work_type) {
		this.work_type = work_type;
	}

	public BigDecimal getContract_sum() {
		return contract_sum;
	}

	public void setContract_sum(BigDecimal contract_sum) {
		this.contract_sum = contract_sum;
	}

	public String getContract_no() {
		return contract_no;
	}

	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}

	public String getWork_name() {
		return work_name;
	}

	public void setWork_name(String work_name) {
		this.work_name = work_name;
	}

	public int getWork_days() {
		return work_days;
	}

	public void setWork_days(int work_days) {
		this.work_days = work_days;
	}
 
	public long getStart_time() {
		return start_time;
	}

	public void setStart_time(long start_time) {
		this.start_time = start_time;
	}

	 

	public String getWork_place() {
		return work_place;
	}

	public void setWork_place(String work_place) {
		this.work_place = work_place;
	}

	public String getWork_qualification() {
		return work_qualification;
	}

	public void setWork_qualification(String work_qualification) {
		this.work_qualification = work_qualification;
	}

 
	public int getWork_owner_id() {
		return work_owner_id;
	}

	public void setWork_owner_id(int work_owner_id) {
		this.work_owner_id = work_owner_id;
	}

	public int getWork_contractor_id() {
		return work_contractor_id;
	}

	public void setWork_contractor_id(int work_contractor_id) {
		this.work_contractor_id = work_contractor_id;
	}

	public String getWork_owner_name() {
		return work_owner_name;
	}

	public void setWork_owner_name(String work_owner_name) {
		this.work_owner_name = work_owner_name;
	}
 

	public String getWork_contractor_name() {
		return work_contractor_name;
	}

	public void setWork_contractor_name(String work_contractor_name) {
		this.work_contractor_name = work_contractor_name;
	}

	public String getProgress_percent() {
		return progress_percent;
	}

	public void setProgress_percent(String progress_percent) {
		this.progress_percent = progress_percent;
	}

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public long getWin_time() {
		return win_time;
	}

	public void setWin_time(long win_time) {
		this.win_time = win_time;
	}
 
}
