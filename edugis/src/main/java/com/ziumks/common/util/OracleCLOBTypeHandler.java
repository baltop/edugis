package com.ziumks.common.util;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import oracle.sql.CLOB;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

/**
 * 
 * <resultMap id="xmlRslt" class="essay"> <result property="content"
 * column="content" typeHandler="OracleCLOBTypeHandler"/> </resultMap>
 * 
 * <statement id="getXMLData" resultMap="xmlRslt"> select content from essay
 * </statement>
 * 
 */

public class OracleCLOBTypeHandler implements TypeHandlerCallback {
	protected static Log log = LogFactory.getLog(OracleCLOBTypeHandler.class);

	public void setParameter(PreparedStatement ps, int i, Object parameter, String jdbcType) throws SQLException {
		String value = (String) parameter;
		if (value != null) {
			CLOB clob = CLOB.createTemporary(ps.getConnection(), true, CLOB.DURATION_SESSION);
			clob.putChars(1, value.toCharArray());
			ps.setClob(i, clob);
		} else {
			ps.setString(i, null);
		}
	}

	public Object getResult(ResultSet rs, String columnName) throws SQLException {
		Clob clob = rs.getClob(columnName);
		if (rs.wasNull()) {
			return null;
		} else {
			return clob.getSubString(1, (int) clob.length());
		}
	}

	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		Clob clob = rs.getClob(columnIndex);
		if (rs.wasNull()) {
			return null;
		} else {
			return clob.getSubString(1, (int) clob.length());
		}
	}

	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		Clob clob = cs.getClob(columnIndex);
		if (cs.wasNull()) {
			return null;
		} else {
			return clob.getSubString(1, (int) clob.length());
		}
	}

	public Object valueOf(String s) {
		return s;
	}

	public void setParameter(ParameterSetter setter, Object param) throws SQLException {

		try {
			setter.setClob((Clob) param);
		} catch (SQLException e) {
			if (log.isErrorEnabled())
				log.error("Failed to set CLOB parameter");
			throw e;
		}
	}

	public Object getResult(ResultGetter getter) throws SQLException {

		Clob clob = null;
		try {
			clob = getter.getClob();
		} catch (SQLException e) {
			if (log.isErrorEnabled())
				log.error("Failed to set CLOB result property");
			throw e;
		}

		if (clob == null) {
			return null;
		} else {
			return clob.getSubString(1, (int) clob.length());
		}
	}

}