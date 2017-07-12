/*
 * Created on 2005. 3. 15.
 *
 *
 * Copyright 2005 Shinhan Financial Group. All rights reserved.
 * Copyright 2005 FistGlobal. All rights reserved.
 * SFG PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ziumks.common.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AjaxServlet extends MultiMethodServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

	protected void genericService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	
		System.out.println("character "+ request.getCharacterEncoding());
		//request.setCharacterEncoding("utf-8");
		System.out.println("character2 "+ request.getCharacterEncoding());
		System.out.println(request.getQueryString());
		System.out.println("Start QuerysAction.listObjectType");
		System.out.println(request.getParameter("otId"));
		 
		String otId = request.getParameter("otId");
		System.out.println(otId);
		String pp = java.net.URLDecoder.decode(otId, "EUC-KR");
		System.out.println(pp);
		byte [] otIdbyte = otId.getBytes("EUC-KR");
		otId = new String(otIdbyte, "utf-8");
		System.out.println(otId);    	
    	
    	

	    
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected Map getParamMapForPage(HttpServletRequest request,
			String tableId, int pageSize) {

		Map para = null;

		Enumeration org = request.getParameterNames();
		para = new HashMap();
		while(org.hasMoreElements()){
			String names = (String)org.nextElement();
			para.put(names, request.getParameter(names));
			
		}

		return para;

	}

}

