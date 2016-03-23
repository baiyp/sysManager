package com.manager.common.view;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class PageView<T>  implements Serializable{
	
	
	private String sEcho;
	
	private int defaultPageSize = 10;
	
	private int iDisplayStart;
	
	private int iDisplayLength;
	
	private int iTotalRecords;
	
	private HashMap<String,String>  orderBy ;
	
	private HashMap<String,String>  search;
	
	private List<T> aaData;
	 

	public List<T> getAaData() {
		return aaData;
	}

	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public int getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public int getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public HashMap<String, String> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(HashMap<String, String> orderBy) {
		this.orderBy = orderBy;
	}

	public HashMap<String, String> getSearch() {
		return search;
	}

	public void setSearch(HashMap<String, String> search) {
		this.search = search;
	}

	public int getDefaultPageSize() {
		return defaultPageSize;
	}

	public void setDefaultPageSize(int defaultPageSize) {
		this.defaultPageSize = defaultPageSize;
	}

	public int getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	 
}
