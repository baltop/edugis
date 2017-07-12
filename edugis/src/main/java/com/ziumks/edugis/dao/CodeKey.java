package com.ziumks.edugis.dao;

import com.ziumks.common.base.BaseDto;

public class CodeKey extends BaseDto {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column PMS.CODE.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	private String code;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column PMS.CODE.CODE_ID
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	private String codeId;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column PMS.CODE.CODE
	 * @return  the value of PMS.CODE.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public String getCode() {
		return code;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column PMS.CODE.CODE
	 * @param code  the value for PMS.CODE.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column PMS.CODE.CODE_ID
	 * @return  the value of PMS.CODE.CODE_ID
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public String getCodeId() {
		return codeId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column PMS.CODE.CODE_ID
	 * @param codeId  the value for PMS.CODE.CODE_ID
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
}