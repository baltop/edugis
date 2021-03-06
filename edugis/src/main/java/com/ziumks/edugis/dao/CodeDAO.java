package com.ziumks.edugis.dao;

import com.ziumks.edugis.dao.Code;
import com.ziumks.edugis.dao.CodeExample;
import com.ziumks.edugis.dao.CodeKey;

import java.sql.SQLException;
import java.util.List;

public interface CodeDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	int countByExample(CodeExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	int deleteByExample(CodeExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	int deleteByPrimaryKey(CodeKey key) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	void insert(Code record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	void insertSelective(Code record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	List selectByExample(CodeExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	Code selectByPrimaryKey(CodeKey key) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	int updateByExampleSelective(Code record, CodeExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	int updateByExample(Code record, CodeExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	int updateByPrimaryKeySelective(Code record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	int updateByPrimaryKey(Code record) throws SQLException;
}