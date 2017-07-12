package com.ziumks.common.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Kim HyonSok
 * @version 1.0
 */

public class UrlBaseTag extends TagSupport {

	private Log log = LogFactory.getLog(getClass());
	
	private static String webContext = null;

	/**
	 * Render the specified error messages if there are any.
	 * 
	 * @exception JspException
	 *                      if a JSP exception has occurred
	 */
	public int doStartTag() throws JspException {

		// Print the results to our output writer
		try {
			if (webContext == null){
				webContext = ((HttpServletRequest) pageContext
						.getRequest()).getContextPath();
			}
			
			(pageContext.getOut()).print(webContext);
		} catch (java.io.IOException ioe) {
			throw new JspException();
		}
		// Continue processing this page
		return (EVAL_BODY_INCLUDE);

	}

	/**
	 * Release any acquired resources.
	 */
	public void release() {

		super.release();

	}

}