package com.ziumks.common.base;

import java.util.List;

import org.springframework.dao.DataAccessException;

public class PmsExcelException extends RuntimeException {


	private List errorList= null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -657765762762947679L;

	/**
	 * Constructor for RecoverableDataAccessException.
	 * @param msg the detail message
	 */
	public PmsExcelException(String msg) {
		super(msg);
	}

	/**
	 * Constructor for RecoverableDataAccessException.
	 * @param msg the detail message
	 * @param cause the root cause (usually from using a underlying
	 * data access API such as JDBC)
	 */
	public PmsExcelException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public PmsExcelException(List errorList) {
		this.errorList = errorList;
	}
	
	public List getErrorList(){
		return errorList;
	}
}
