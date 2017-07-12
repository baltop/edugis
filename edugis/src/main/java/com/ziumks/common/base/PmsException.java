package com.ziumks.common.base;

import org.springframework.dao.DataAccessException;

public class PmsException extends DataAccessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2393824217910840776L;

	/**
	 * Constructor for RecoverableDataAccessException.
	 * @param msg the detail message
	 */
	public PmsException(String msg) {
		super(msg);
	}

	/**
	 * Constructor for RecoverableDataAccessException.
	 * @param msg the detail message
	 * @param cause the root cause (usually from using a underlying
	 * data access API such as JDBC)
	 */
	public PmsException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
