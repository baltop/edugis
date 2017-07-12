package com.ziumks.common.base;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.ziumks.common.user.UserInfo;

public class ComSession extends PropertyEditorSupport {

	HttpServletRequest re = null;
	public ComSession(HttpServletRequest request){
		re = request;
	}
	public void setAsText(String value) {
		try {
			UserInfo userInfo = (UserInfo)re.getSession().getAttribute("userInfo");
			String p = userInfo.getUserId();
			setValue(p);
		} catch (Exception e) {
			e.printStackTrace();
			setValue(null);
		}
	}


}