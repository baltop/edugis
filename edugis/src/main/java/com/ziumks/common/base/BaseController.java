/**
 * Copyright 2012 baltop.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ziumks.common.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.hibernate.EhCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.ziumks.common.user.UserInfo;

public class BaseController extends org.springframework.web.servlet.mvc.AbstractController {
	private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    private static final CacheManager cacheManager;
    
    static // realy static? 2
    {
         
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceAsStream = contextClassLoader.getResourceAsStream("cache/ehcache.xml");
        cacheManager = CacheManager.create(resourceAsStream);
    }
	
	protected Cache gisCache;
	
	public BaseController(){
		
		gisCache = cacheManager.getCache("gis");
	}

    public void setCache(String key, String retStr)
    {

        Element element = new Element(key, retStr);
         
        gisCache.put(element);
        
    }
     

    public String getCache(String key)
    {
        Element element = gisCache.get(key);
        if (element != null)
        {
             
            return (String) element.getObjectValue();
        }
         
        return null;
    }

	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}

	@ExceptionHandler(PmsException.class)
	public String pmsExceptionHandler(PmsException e, HttpServletRequest request) {
		log.error("============== Exception", e.fillInStackTrace());
		request.setAttribute("msg", e.getMessage());
		
		request.setAttribute("detail", "사업관리 시스템 에러");
		return "loginError";
	}
	
	
	
	@ExceptionHandler(PmsExcelException.class)
	public String pmsExcelExceptionHandler(PmsExcelException e, HttpServletRequest request) {
		request.setAttribute("errorList", e.getErrorList());
		request.setAttribute("errorStatus", "yes");
		return "proj/excelupError";
	}
	
	
	@ExceptionHandler(Exception.class)
	public String generalExceptionHandler(Exception e, HttpServletRequest request) {
		log.error("============== Exception", e.fillInStackTrace());
		request.setAttribute("msg", e.getMessage());
		request.setAttribute("detail", "시스템 에러 발생");
		return "loginError";
	}
	
	
	/**
	 * sql error 처리
	 * 
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(SQLException.class)
	public String dataAccessExceptionHandler(SQLException e, HttpServletRequest request) {
		log.error("============== sql Exception", e.fillInStackTrace());
		request.setAttribute("msg", e.getMessage());
		request.setAttribute("detail", "DB sql 에러");
		return "loginError";
	}

	/**
	 * 주로 파일 업로드 혹은 엑셀 다운로드 에러 처리
	 * 
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(IOException.class)
	public String ioExceptionHandler(IOException e, HttpServletRequest request) {
		log.error("============== IOException", e.fillInStackTrace());
		request.setAttribute("msg", e.getMessage());
		request.setAttribute("detail", "파일업로드 혹은 엑셀 다운로드에서 파일 io exception 발생");

		return "fileError";
	}

	/**
	 * 주로 파일 업로드 혹은 엑셀 다운로드 에러 처리
	 * 
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(FileNotFoundException.class)
	public String ioExceptionHandler(FileNotFoundException e, HttpServletRequest request) {
		log.error("============== FileNotFoundException", e.fillInStackTrace());
		request.setAttribute("msg", e.getMessage());
		request.setAttribute("detail", "파일업로드에서 FileNotFoundException 발생");

		return "fileError";
	}



	@InitBinder
	protected void initBinder(HttpServletRequest request, WebDataBinder binder) throws Exception {

		
		Object p = binder.getTarget();
		if(p instanceof BaseDto){
			BaseDto baseDto = (BaseDto)p;
			baseDto.setRegisterId( ((UserInfo) request.getSession().getAttribute("userInfo")).getUserId() );
		}
		
		
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

	
	
	
	
}
