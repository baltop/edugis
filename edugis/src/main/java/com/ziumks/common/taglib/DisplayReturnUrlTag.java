package com.ziumks.common.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author Kim HyonSok
 * @version 1.0
 */

public class DisplayReturnUrlTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5806947407841458656L;

	/**
	 * 
	 */

	private Log log = LogFactory.getLog(getClass());

	private String option = "out";

	/**
	 * Render the specified error messages if there are any.
	 * 
	 * @exception JspException
	 *                if a JSP exception has occurred
	 */
	public int doStartTag() throws JspException {

		// Print the results to our output writer
		try {

			String outurl = ((HttpServletRequest) pageContext.getRequest())
					.getParameter("dispUrl");
			String outurl2 = ((HttpServletRequest) pageContext.getRequest())
			.getParameter("dispUrl");
			if (outurl != null) {

				if ("out".equals(option)) {
					outurl = outurl.replace('$', '&');
					outurl = outurl.replace('!', '=');
					outurl+= "&returnKey=true&dispUrl="+outurl2;
				} else {
					outurl = "&dispUrl=" + outurl;
				}
				(pageContext.getOut()).print(outurl);
			}

			log.debug(outurl);
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
		this.option = null;

	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

}