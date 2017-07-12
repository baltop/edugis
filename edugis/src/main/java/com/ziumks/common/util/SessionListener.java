package com.ziumks.common.util;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;




//http://tong.nate.com/mrsono0/31721748 참고 

public class SessionListener implements HttpSessionBindingListener {
	private static SessionListener	sessionListener	= null;
	private static Hashtable		loginUsers		= new Hashtable();
	private static Hashtable        loginIps        = new Hashtable();

	private SessionListener() {
		super();
	}

	public static synchronized SessionListener getInstance() {
		if (sessionListener == null) {
			sessionListener = new SessionListener();
		}
		return sessionListener;
	}
	
	//해당 세션에 이미 로그인 되있는지 체크
	public boolean isLogin(String sessionID) {
		boolean isLogin = false;
		Enumeration e = loginUsers.keys();
		String key = "";
		while (e.hasMoreElements()) {
			key = (String) e.nextElement();
			if (sessionID.equals(key)) {
				isLogin = true;
			}
		}
		return isLogin;
	}

	//중복 로그인 막기 위해 아이디 사용중인지 체크
	public boolean isUsing(String userID) {
		boolean isUsing = false;
		Enumeration e = loginUsers.keys();
		HttpSession session = null;
		while (e.hasMoreElements()) {
			session = (HttpSession) e.nextElement();
			if (userID.equals(loginUsers.get(session))) {
				isUsing = true;
			}
		}
		return isUsing;
	}
	
	
	//해당 아이디가 사용되고 있는 session을 반환하는 함수
	public HttpSession getSession(String userId){
		Enumeration e = loginUsers.keys();
		Enumeration elements = loginUsers.elements();
		String key="";
		HttpSession session = null;
		while (e.hasMoreElements()) {
			session = (HttpSession)e.nextElement();
			if (userId.equals(loginUsers.get(session))) {
				return session;
			}
		}
		return session;
	}
	

	//세션 생성
	public void setSession(HttpSession session, String userID) {
		loginUsers.put(session,userID);
		session.setAttribute("login", this.getInstance());
	}
	 
	
	//세션 끊기(parameter UserId)
	public void removeLoginUser(String userId){
		Enumeration e = loginUsers.keys();
		Enumeration elements = loginUsers.elements();
		String key="";
		HttpSession session = null;
		while (e.hasMoreElements()) {
			session = (HttpSession)e.nextElement();
			if (userId.equals(loginUsers.get(session))) {
				//loginUsers.remove(session);
				session.invalidate();
			}
		}
		System.out.println(userId+" 로그아웃");
	}
	
	//접속한 아이디에 대한 ip adress 생성
	public void setIpAddr(HttpSession session,String ipadress) {
		loginIps.put(session,ipadress);
	}
	
	//해당 아이디가 접속한 ip address를 찾아서 반환하는 함수
	public String getIpAddr(HttpSession session){
		Enumeration e = loginIps.keys();
		Enumeration elements = loginIps.elements();
		String IpAddr="";
		HttpSession session2 = null;
		while (e.hasMoreElements()) {
			session2 = (HttpSession)e.nextElement();
			if (session.equals(session2)) {
				IpAddr = (String)loginIps.get(session2);
				return IpAddr;
			}
		}
		return IpAddr;
	}

	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

	public void valueUnbound(HttpSessionBindingEvent event) {

		loginUsers.remove(event.getSession());
	}

	//세션 ID로 로긴된 ID 구분
	public String getUserID(String sessionID) {
		return (String) loginUsers.get(sessionID);
	}

	//현재 접속자수
	public int getUserCount() {
		return loginUsers.size();
	}
}
