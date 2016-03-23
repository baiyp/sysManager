package com.manager.common.view;

import java.io.Serializable;

public class JsonView implements Serializable{
	
	
	public JsonView(){
		this.success = true;
	}
	 
	//表示请求是否成功；
	private Boolean success;
	
	//返回信息
	public Object message;
	
	//返回业务逻辑返回编码
	public String messageCode;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
 
	 
}
