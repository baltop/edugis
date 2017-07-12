package com.ziumks.common.base;

import java.util.Date;

public class BaseDto {
	
	private Integer totalCnt;
	
    private String registerId;
    
    private Date registerDate;
    
    private String updateId;
    
    private Date updateDate;

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(Integer totalCnt) {
		this.totalCnt = totalCnt;
	}

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
    	System.out.println("seiowsldkfjweoijslfkjseoifjsofjslisfgjsfjsl");
        this.registerId = registerId;
    }



	
}
