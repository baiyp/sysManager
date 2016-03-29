package com.manager.sys.model;

public class Task extends BaseEntity {
	
	private String enterprise_name;
	
	private String taskTypeName;
	
	private int endtime;
	
	private String title;
	
	
	private String content;
	
	private String time;
	
	private int edit_time;
	
	private int review;
	
	private int view_count;
	
	private int bid_count;
	
	private int flag;

	public String getEnterprise_name() {
		return enterprise_name;
	}

	public void setEnterprise_name(String enterprise_name) {
		this.enterprise_name = enterprise_name;
	}

	public String getTaskTypeName() {
		return taskTypeName;
	}

	public void setTaskTypeName(String taskTypeName) {
		this.taskTypeName = taskTypeName;
	}

	public int getEndtime() {
		return endtime;
	}

	public void setEndtime(int endtime) {
		this.endtime = endtime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getEdit_time() {
		return edit_time;
	}

	public void setEdit_time(int edit_time) {
		this.edit_time = edit_time;
	}

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public int getView_count() {
		return view_count;
	}

	public void setView_count(int view_count) {
		this.view_count = view_count;
	}

	public int getBid_count() {
		return bid_count;
	}

	public void setBid_count(int bid_count) {
		this.bid_count = bid_count;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
 

}
