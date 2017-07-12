package com.ziumks.common.taglib;

import java.util.Enumeration;

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

public class DisplayTagHrefTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -73210423262323689L;
	private Log log = LogFactory.getLog(getClass());

	/**
	 * Render the specified error messages if there are any.
	 * 
	 * @exception JspException
	 *                      if a JSP exception has occurred
	 */
	public int doStartTag() throws JspException {

		// Print the results to our output writer
		try {
			
			String saveUrl = "&dispUrl=$method=list";
			String saveUrl2 = "&dispUrl=";
			HttpServletRequest request = ((HttpServletRequest) pageContext	.getRequest());
			
			if(request.getParameter("returnKey")==null){	 
				Enumeration org = request.getParameterNames();
				while(org.hasMoreElements()){
					String names = (String)org.nextElement();
					if ("method".equals(names)) continue;
					saveUrl += "$"+names+"="+request.getParameter(names);
				}							
				(pageContext.getOut()).print(saveUrl);
				log.debug(saveUrl);
			}else{
				saveUrl2 += ((HttpServletRequest) pageContext.getRequest())
					.getParameter("dispUrl");
				(pageContext.getOut()).print(saveUrl2);
				log.debug(saveUrl2);
			}
			
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