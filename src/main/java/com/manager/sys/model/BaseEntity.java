package com.manager.sys.model;


public class BaseEntity {

    protected Integer id;
    
    protected int del_Flag;
    
    protected String create_Date;
    
    protected String update_Date;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return (this.id == null);
    }

	public int getDel_Flag() {
		return del_Flag;
	}

	public void setDel_Flag(int del_Flag) {
		this.del_Flag = del_Flag;
	}

	public String getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(String create_Date) {
		this.create_Date = create_Date;
	}

	public String getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(String update_Date) {
		this.update_Date = update_Date;
	}

}
