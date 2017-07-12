/**
 * Created on Dec 19, 2011
 *
 * Copyright 2011 Kim Hyon-Sok. All rights reserved.
 * PRIVATE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ziumks.common.taglib;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;



/** Logs a debug message to the current commons.logging category.
  *
  * @author <a href="mailto:joeo@epesh.com">Joseph Ottinger</a>
  * @author <a href="mailto:jstrachan@apache.org">James Strachan</a>
  */

public class DebugTag extends LoggerTag {
    

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected boolean isEnabled(Logger logCategory) {
        return logCategory.isDebugEnabled();
    }

    protected void log(Logger logCategory, String message) {
    	message += "  [" + ((HttpServletRequest) pageContext
				.getRequest()).getRequestURI() + "]";
    	((HttpServletRequest) pageContext.getRequest()).setAttribute("jspName", ((HttpServletRequest) pageContext
				.getRequest()).getRequestURI());
        logCategory.debug(message);
    }
}

