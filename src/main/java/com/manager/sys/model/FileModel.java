package com.manager.sys.model;

import java.io.Serializable;

public class FileModel implements Serializable {
	
	
	private static final long serialVersionUID = 7964950152782381235L;  
	
	private static final String DOWN_FILE_PATH = "http://localhost:8899/sysManager/upload/";
	
	private long fileSize = 0;//文件大小
	
	private String newFileName = "";//文件新名字
	
	private String downFileUrL = "";//文件路径
	
	private String oldFileName = "";//旧文件名
	
	private String fileType = "";//文件类型
	
	private String deleteUrl = ""; //删除请求地址
	
	private String thumbnailUrl = "";//默认图片信息
	
	
	private String deleteType = "";//删除类型 默认:delete
	
	
	private String fileErrorMessage = "";
	

	public long getFileSize() {
		
		return fileSize;
	}
 

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
 


	public String getNewFileName() {
		return newFileName;
	}
 



	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}
 
	public String getDownFileUrL() {
		return downFileUrL;
	}


	public void setDownFileUrL(String downFileUrL) {
		this.downFileUrL = downFileUrL;
	}


	public String getOldFileName() {
		return oldFileName;
	}
 


	public void setOldFileName(String oldFileName) {
		this.oldFileName = oldFileName;
	}

 

	public String getFileType() {
		return fileType;
	}
  
 

	public static String getDownFilePath() {
		return DOWN_FILE_PATH;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
 
	public String getDeleteUrl() {
		return deleteUrl;
	}


	public void setDeleteUrl(String deleteUrl) {
		this.deleteUrl = deleteUrl;
	}


	public String getThumbnailUrl() {
		return thumbnailUrl;
	}


	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}


	public String getDeleteType() {
		return deleteType;
	}


	public void setDeleteType(String deleteType) {
		this.deleteType = deleteType;
	}


	public String getFileErrorMessage() {
		return fileErrorMessage;
	}


	public void setFileErrorMessage(String fileErrorMessage) {
		this.fileErrorMessage = fileErrorMessage;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
