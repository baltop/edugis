package com.ziumks.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AuthFilter implements Filter {
	public static String LOGIN_KEY = "loggedIn"; 

//	@SuppressWarnings("rawtypes")
//    private Set extensions;

	private String loginAction; 

	private String loginPage;
	
	private String noAuthPage;
	
	private String noSessionPage;
	
	protected FilterConfig filterConfig = null;

	private Log log = LogFactory.getLog(this.getClass());

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		request.setCharacterEncoding("utf-8");
		String servletPath = "";
		
		if(req.getParameter("method")==null){
			servletPath = req.getServletPath();
		}else{
			servletPath = req.getServletPath()+"?method="+req.getParameter("method");
			if(req.getServletPath().equals("/bbs.do")){
				servletPath = servletPath + "&boardSeq="+req.getParameter("boardSeq");
			}
		}
		String conPath = req.getContextPath();
		String uri = req.getRequestURI();

//		HttpSession session = req.getSession();
		//UserInfo userInfo = (UserInfo) session.getAttribute(Constants.USER_KEY);
		log.debug("conPath "+conPath+"    servletPath  "+servletPath+"    uri "+uri);
		
		// 로그인 페이지로 가는중이면 그냥 보내줌
		if (servletPath.equals(loginAction) || servletPath.equals(loginPage)
				|| servletPath.equals(noAuthPage) || servletPath.equals("/")
				|| servletPath.startsWith("/intro") 
				|| servletPath.startsWith("/edu")
				|| servletPath.startsWith("/conference")
				|| servletPath.equals(noSessionPage)
				|| servletPath.startsWith("/community/download.jsp")
				|| servletPath.startsWith("/newshistory.do?method=receiveConfirm")
				|| servletPath.indexOf("method=checkCaptcha") > 0
				|| servletPath.indexOf("method=listIntroBiz") > 0
				|| servletPath.indexOf("password.jsp") > 0
				|| servletPath.indexOf("&boardSeq=100") > 0
				|| servletPath.indexOf("&boardSeq=1000") > 0
				|| servletPath.indexOf("&boardSeq=200") > 0
				|| servletPath.indexOf("&boardSeq=300") > 0
				|| servletPath.indexOf("&boardSeq=910") > 0
				|| servletPath.indexOf("applynewsletter") > 0
				|| servletPath.indexOf("method=qAndA") > 0
				|| servletPath.startsWith("/pds") ) {
			chain.doFilter(req, res);
		} 
		// 일반페이지로 가는데 userInfo가 세션에 없으면 로그아웃으로 간주
//		else if (userInfo == null) {				   
//			if(req.getParameter("isPop")==null){
//				log.debug("세션끊김!"); 
//				res.sendRedirect(req.getContextPath() + loginPage);
//			}else{
//				log.debug("세션끊김 팝업");
//				res.sendRedirect(req.getContextPath() + noSessionPage);
//			}
//		}
		else if ( servletPath.startsWith("/upload/p") ||  servletPath.startsWith("/upload/r") ){
			return;
		}
		else {
			//권한은 우선은 버튼으로 대체함 나중에 생각할 여지.....
			chain.doFilter(req, res);
		
		} 
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
        		
		loginAction = filterConfig.getInitParameter("loginAction");
		loginPage = filterConfig.getInitParameter("loginPage");
		noAuthPage = filterConfig.getInitParameter("noAuthPage");
		noSessionPage = filterConfig.getInitParameter("noSessionPage");
		
	}

	public void destroy() {
	}
	

    /**
     * ���͸� ���´�.
     * @return
     */
    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    /**
     * ���͸� �����Ѵ�.
     * @param cfg
     */
    public void setFilterConfig(FilterConfig cfg) {
        filterConfig = cfg;
    }	
}
