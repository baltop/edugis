/**
 * Created on Dec 19, 2011
 *
 * Copyright 2011 Kim Hyon-Sok. All rights reserved.
 * PRIVATE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ziumks.common.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.ziumks.common.util.StringUtil;

import oracle.sql.CLOB;

/**
 * A Map that converts all keys to lowercase Strings for case insensitive
 * lookups. This is needed for the toMap() implementation because databases
 * don't consistenly handle the casing of column names.
 */
@SuppressWarnings("rawtypes")
public class CiBus extends HashMap<String, Object> implements Bus, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2842877277470561984L;


	/**
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(String key) {
		return super.containsKey(key);
	}

	/**
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public Object get(String key) {
		key = StringUtil.removeCharacter(key.toLowerCase().trim(),'_');
		Object obj = super.get(key);
		return obj;
	}

	public Object get(Object key) {
		key = StringUtil.removeCharacter(key.toString().toLowerCase().trim(),'_');
		return super.get(key);
	}
	
	public Object get(String key, Object defaultValue) {
		key = StringUtil.removeCharacter(key.toLowerCase().trim(),'_');
		Object obj = super.get(key);
		if (obj == null) {
			return defaultValue;
		}
		return obj;
	}

	public void check(String key, Object object) {
		key = StringUtil.removeCharacter(key.toLowerCase().trim(),'_');
		if (get(key) == null)
			super.put(key, object);
	}

	public String getString(String key) {
		key = StringUtil.removeCharacter(key.toLowerCase().trim(),'_');
		Object obj = super.get(key);
		if (obj != null) {
			return obj.toString();
		}

		return "";
	}

	public int getInt(String key) {
		key = StringUtil.removeCharacter(key.toLowerCase().trim(),'_');
		Object op = super.get(key);
		if (op instanceof BigDecimal) {
			return ((BigDecimal) (op)).intValue();
		} else if (op instanceof Integer) {
			return ((Integer) (op)).intValue();
		} else {
			return 0;
		}
	}

	public long getLong(String key) {
		key = StringUtil.removeCharacter(key.toLowerCase().trim(),'_');
		Object op = super.get(key);
		if (op instanceof BigDecimal) {
			return ((BigDecimal) (op)).longValue();
		} else if (op instanceof Long) {
			return ((Long) (op)).longValue();
		} else {
			return 0;
		}

	}

	public float getFloat(String key) {
		key = StringUtil.removeCharacter(key.toLowerCase().trim(),'_');
		Object op = super.get(key);
		if (op instanceof Float) {
			return ((Float) (op)).floatValue();
		} else {
			return 0;
		}
	}

	public double getDouble(String key) {
		key = StringUtil.removeCharacter(key.toLowerCase().trim(),'_');
		Object op = super.get(key);
		if (op instanceof Double) {
			return ((Double) (op)).doubleValue();
		} else {
			return 0;
		}

	}
	public List<String> getList(String key) {
		key = StringUtil.removeCharacter(key.toLowerCase().trim(),'_');
		Object obj = super.get(key);
		if (obj == null) {
			return new ArrayList<String>();
		}
		else if (obj instanceof String) {
			List<String> list = new ArrayList<String>();
			list.add((String) obj);
			return list;
		}
		else if (obj instanceof String[]) {
			return Arrays.asList((String[]) obj);
		}
		return new ArrayList<String>();
	}
	/**
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */

	public Object put(String key, Object value) {

		if( value !=null && value instanceof CLOB){
			try {
				String temp = null;
				temp = ((CLOB)value).getSubString(1, (int) ((CLOB)value).length());
				return super.put(StringUtil.removeCharacter(key.toLowerCase().trim(),'_'), temp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return super.put(StringUtil.removeCharacter(key.toLowerCase().trim(),'_'), value);
//		java.util.regex.Pattern patt = java.util.regex.Pattern
//		        .compile("\\_(\\w)");
//		java.util.regex.Matcher m = patt.matcher(key.toLowerCase());
//		StringBuffer sb = new StringBuffer(key.length());
//		while (m.find()) {
//			String text = m.group(1);
//			text = text.toUpperCase();
//			m.appendReplacement(sb,
//			        java.util.regex.Matcher.quoteReplacement(text));
//		}
//		m.appendTail(sb);
//		return (super.put(sb.toString(), value));

	}

	public Object set(String key, Object value) {
		return put(key, value);
	}

	/**
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	public void putAll(Map m) {
		Iterator iter = m.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			Object value = m.get(key);
			this.put(key, value);
		}
	}

	/**
	 * @see java.util.Map#remove(java.lang.ObjecT)
	 */
	public Object remove(String key) {
		return super.remove(key);
	}

	public static String getStringForCLOB(CLOB clob) {

		try {
			return clob.getSubString(1, (int) clob.length());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String toString() {
		String str = "";
		Iterator it = super.keySet().iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object value = super.get(key);
			String op = "";
			if (value instanceof String[]) {
				for (int r = 0; r < ((String[]) value).length; r++) {
					op += ((String[]) value)[r];
				}
			}
			else {
				if (value == null)
					value = "empty object.";
				op = value.toString();
			}

			str += "[" + key + " > " + op + "]";
		}

		return str;
	}

}