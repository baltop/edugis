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

import oracle.sql.CLOB;

/**
 * A Map that converts all keys to lowercase Strings for case insensitive
 * lookups. This is needed for the toMap() implementation because databases
 * don't consistenly handle the casing of column names.
 */
public class UnderBus extends HashMap<String, Object> implements Bus, Serializable {

	/**
     * 
     */


	/**
	 * 
	 */
	private static final long serialVersionUID = -5840280526223088508L;

	 


	 
	
	
	
	/**
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(String key) {
		key = key.toLowerCase().trim();
		return super.containsKey(key);
	}

	/**
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public Object get(String key) {
		key = key.toLowerCase().trim();
		return super.get(key);
		
	}
	
	public Object get(Object key) {
		key = key.toString().toLowerCase().trim();
		return super.get(key);
	}

	public Object get(String key, Object defaultValue) {
		key = key.toLowerCase().trim();
		Object obj = super.get(key);

		if (obj == null) {
			return defaultValue;
		}
		return obj;
	}

	public void check(String key, Object de) {
		key = key.toLowerCase().trim();
		if (get(key) == null)
			super.put(key, de);
	}

	public List<String> getList(String key) {
		key = key.toLowerCase().trim();
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

	public String getString(String key) {
		key = key.toLowerCase().trim();
		Object obj = super.get(key);
		if (obj != null) {
			return obj.toString();
		}
		return "";
	}

	public int getInt(String key) {
		key = key.toLowerCase().trim();
		Object op = super.get(key);
		 if (op instanceof Integer) {
			return ((Integer) (op)).intValue();
		} else if (op instanceof BigDecimal) {
			return ((BigDecimal) (op)).intValue();
		} else if (op instanceof Long) {
			return ((Long) (op)).intValue();
		} else if (op instanceof Float) {
			return ((Float) (op)).intValue();
		} else if (op instanceof Double) {
			return ((Double) (op)).intValue();
		} else if (op instanceof String) {
			int re = 0;
			try {
				re = Integer.parseInt((String)op);
			} catch (NumberFormatException e) {
				re = 0;
				e.printStackTrace();
			}
			return re;
		} else {
			return 0;
		}
	}

	public long getLong(String key) {
		key = key.toLowerCase().trim();
		Object op = super.get(key);
		if (op instanceof Long) {
			return ((Long) (op)).longValue();
		} else if (op instanceof BigDecimal) {
			return ((BigDecimal) (op)).longValue();
		} else if (op instanceof Integer) {
			return ((Integer) (op)).intValue();
		} else if (op instanceof Float) {
			return ((Float) (op)).longValue();
		} else if (op instanceof Double) {
			return ((Double) (op)).longValue();
		} else if (op instanceof String) {
			long re = 0;
			try {
				re = Long.parseLong((String)op);
			} catch (NumberFormatException e) {
				re = 0;
				e.printStackTrace();
			}
			return re;
		} else {
			return 0;
		}

	}

	public float getFloat(String key) {
		key = key.toLowerCase().trim();
		Object op = super.get(key);
		if (op instanceof Float) {
			return ((Float) (op)).floatValue();
		} else if (op instanceof Double) {
			return ((Double) (op)).floatValue();
		} else if (op instanceof String) {
			float re = 0;
			try {
				re = Float.parseFloat((String)op);
			} catch (NumberFormatException e) {
				re = 0;
				e.printStackTrace();
			}
			return re;
		} else {
			return 0;
		}
	}

	public double getDouble(String key) {
		key = key.toLowerCase().trim();
		Object op = super.get(key);
		if (op instanceof Double) {
			return ((Double) (op)).doubleValue();
		} else if (op instanceof Float) {
			return ((Float) (op)).doubleValue();
		} else if (op instanceof String) {
			double re = 0;
			try {
				re = Double.parseDouble((String)op);
			} catch (NumberFormatException e) {
				re = 0;
				e.printStackTrace();
			}
			return re;
		} else {
			return 0;
		}
	}

	/**
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public Object put(String key, Object value) {
		//user_id     userId
		
		//return super.put(StringUtil.removeCharacter(key.toString().toLowerCase().trim(),'_'), value);
		if( value !=null && value instanceof CLOB){
			try {
				String temp = null;
				temp = ((CLOB)value).getSubString(1, (int) ((CLOB)value).length());
				return super.put(key.toLowerCase().trim(), temp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return super.put(key.toLowerCase().trim(), value);

		//		java.util.regex.Pattern patt = java.util.regex.Pattern.compile("\\_(\\w)");
		//		java.util.regex.Matcher m = patt.matcher(key.toString().toLowerCase());
		//		StringBuffer sb = new StringBuffer(key.toString().length());
		//		while (m.find()) {
		//		  String text = m.group(1);
		//		  text = text.toUpperCase();
		//		  m.appendReplacement(sb, java.util.regex.Matcher.quoteReplacement(text));
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void putAll(Map m) {
		Iterator<String> iter = m.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			Object value = m.get(key);
			this.put(key, value);
		}
	}

	/**
	 * @see java.util.Map#remove(java.lang.ObjecT)
	 */
	public Object remove(String key) {
		key = key.toLowerCase().trim();
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

	@Override
	public String toString() {
		String str = "";
		Iterator<String> it = super.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
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