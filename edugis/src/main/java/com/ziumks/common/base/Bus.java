/**
 * Created on Dec 19, 2011
 *
 * Copyright 2011 Kim Hyon-Sok. All rights reserved.
 * PRIVATE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ziumks.common.base;

import java.util.Map;

/**
 * @author pado
 *
 */
public interface Bus  {
	/**
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(String key);

	/**
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public Object get(String key);
	public Object get(Object key);
	public Object get(String key, Object defaultValue);
	public void check(String key, Object object);
	
	public String getString(String key);

	public int getInt(String key);

	public long getLong(String key);

	public float getFloat(String key);

	public double getDouble(String key);

	/**
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public Object put(String key, Object value);
	public Object set(String key, Object value);


	/**
	 * @see java.util.Map#putAll(java.util.Map)
	 */
    public void putAll(Map<String, Object> m);

	/**
	 * @see java.util.Map#remove(java.lang.ObjecT)
	 */
	public Object remove(String key);


}