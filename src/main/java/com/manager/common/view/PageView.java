package com.manager.common.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PageView<T>  implements Serializable{
	
	 
	
	private int defaultPageSize = 10;
	
	private int draw;//上面提到了，Datatables发送的draw是多少那么服务器就返回多少。这里注意，作者出于安全的考虑，强烈要求把这个转换为整数后再返回，而不是纯粹的接受然后返回，这是 为了防止跨站脚本（XSS）攻击。

	private int recordsTotal	;//即没有过滤的记录数（数据库里总共记录数）

	private int recordsFiltered	;//过滤后的记录数（如果有接收到前台的过滤条件，则返回的是过滤后的记录数）

	private ArrayList<T> data;//表中中需要显示的数据。这是一个对象数组，也可以只是数组，区别在于 纯数组前台就不需要用 columns绑定数据，会自动按照顺序去显示 ，而对象数组则需要使用 columns绑定数据才能正常显示。 注意这个 data的名称可以由 ajaxDT 的 ajax.dataSrcDT 控制

	private String error;//可选。你可以定义一个错误来描述服务器出了问题后的友好提
	
	private int pageNo;
	
	private int pageSize;
	 
	
	private HashMap<String,String>  orderMap;
	
	private HashMap<String,String>  searchMap;
	
	private List<T> aaData;
	 

	public List<T> getAaData() {
		return aaData;
	}

	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}

 
	public HashMap<String, String> getOrderMap() {
		return orderMap;
	}

	public void setOrderMap(HashMap<String, String> orderMap) {
		this.orderMap = orderMap;
	}

	public HashMap<String, String> getSearchMap() {
		return searchMap;
	}

	public void setSearchMap(HashMap<String, String> searchMap) {
		this.searchMap = searchMap;
	}

	public int getDefaultPageSize() {
		return defaultPageSize;
	}

	public void setDefaultPageSize(int defaultPageSize) {
		this.defaultPageSize = defaultPageSize;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public ArrayList<T> getData() {
		return data;
	}

	public void setData(ArrayList<T> data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
 
}
