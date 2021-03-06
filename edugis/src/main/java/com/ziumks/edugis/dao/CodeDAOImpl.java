package com.ziumks.edugis.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ziumks.edugis.dao.Code;
import com.ziumks.edugis.dao.CodeExample;
import com.ziumks.edugis.dao.CodeKey;

import java.sql.SQLException;
import java.util.List;

public class CodeDAOImpl implements CodeDAO {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	private SqlMapClient sqlMapClient;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public CodeDAOImpl(SqlMapClient sqlMapClient) {
		super();
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public int countByExample(CodeExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject("PMS_CODE.ibatorgenerated_countByExample", example);
		return count.intValue();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public int deleteByExample(CodeExample example) throws SQLException {
		int rows = sqlMapClient.delete("PMS_CODE.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public int deleteByPrimaryKey(CodeKey key) throws SQLException {
		int rows = sqlMapClient.delete("PMS_CODE.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public void insert(Code record) throws SQLException {
		sqlMapClient.insert("PMS_CODE.ibatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public void insertSelective(Code record) throws SQLException {
		sqlMapClient.insert("PMS_CODE.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public List selectByExample(CodeExample example) throws SQLException {
		List list = sqlMapClient.queryForList("PMS_CODE.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public Code selectByPrimaryKey(CodeKey key) throws SQLException {
		Code record = (Code) sqlMapClient.queryForObject("PMS_CODE.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public int updateByExampleSelective(Code record, CodeExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update("PMS_CODE.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public int updateByExample(Code record, CodeExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update("PMS_CODE.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public int updateByPrimaryKeySelective(Code record) throws SQLException {
		int rows = sqlMapClient.update("PMS_CODE.ibatorgenerated_updateByPrimaryKeySelective", record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	public int updateByPrimaryKey(Code record) throws SQLException {
		int rows = sqlMapClient.update("PMS_CODE.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table PMS.CODE
	 * @ibatorgenerated  Fri Sep 13 15:52:15 KST 2013
	 */
	private static class UpdateByExampleParms extends CodeExample {
		private Object record;

		public UpdateByExampleParms(Object record, CodeExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}