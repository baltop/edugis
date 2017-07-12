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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MultiMethodServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

	protected abstract void genericService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        genericService(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        genericService(request,response);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        genericService(request,response);
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        genericService(request,response);
    }
}

