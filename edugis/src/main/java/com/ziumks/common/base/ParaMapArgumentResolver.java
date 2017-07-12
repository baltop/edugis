/**
 * Created on Dec 19, 2011
 *
 * Copyright 2011 Kim Hyon-Sok. All rights reserved.
 * PRIVATE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ziumks.common.base;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import com.ziumks.common.filter.HTMLInputFilter;
import com.ziumks.common.user.UserInfo;

public class ParaMapArgumentResolver implements WebArgumentResolver {

	/**
	 * Controller의 메소드 argument에 commandMap이라는 Map 객체가 있다면 HTTP request 객체에 있는
	 * 파라미터이름과 값을 commandMap에 담아 returng한다. 배열인 파라미터 값은 배열로 Map에 저장한다.
	 * 
	 * @param methodParameter
	 *            - 메소드 파라미터의 타입,인덱스등의 정보
	 * @param webRequest
	 *            - web request 객체
	 * @return argument에 commandMap(java.util.Map)이 있으면 commandMap, 없으면
	 *         <code>UNRESOLVED</code>.
	 * @exception Exception
	 */
	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {

		Class<?> clazz = methodParameter.getParameterType();
		String paramName = methodParameter.getParameterName();

		if (clazz.equals(Bus.class) && paramName.equals("paraBus")) {

			Bus paraBus = new UnderBus();
			HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
			Enumeration<?> enumeration = request.getParameterNames();

			while (enumeration.hasMoreElements()) {
				String key = (String) enumeration.nextElement();
				String[] values = request.getParameterValues(key);
				if (values != null) {
					if( values.length>1){
						for(int i = 0; i<values.length;i++){
							values[i] = new HTMLInputFilter().filter( values[i] );
						}
						paraBus.put(key, values);
					}
					else {
						String input =  new HTMLInputFilter().filter( values[0] );
						paraBus.put(key, input );
					}
				}
			}
			UserInfo loginVO = (UserInfo) request.getSession().getAttribute("userInfo");
			if (loginVO != null) {
				paraBus.put("register_id", loginVO.getUserId());
				paraBus.put("register_name", loginVO.getUserName());
				paraBus.put("register_dept_id", loginVO.getDeptId());
				paraBus.put("register_dept_name", loginVO.getDeptName());
				paraBus.put("register_auth", loginVO.getAuthority());
				paraBus.put("update_id", loginVO.getUserId());
			}

			String param_curPage = request.getParameter("curPage");
			String param_pageSize = request.getParameter("pageSize");
			if (param_pageSize == null || "".equals(param_pageSize)) {
				param_pageSize = "15";
			}

			int pageSize = 15;
			try {
				pageSize = Integer.parseInt(param_pageSize);
				int curPage = Integer.parseInt(param_curPage);

				paraBus.put("pageSize", pageSize);
				paraBus.put("pageStart", ((curPage - 1) * pageSize));
				paraBus.put("pageEnd", curPage * pageSize);

				paraBus.put("curPage", curPage);
			} catch (Exception e) {
				paraBus.put("pageSize", pageSize);
				paraBus.put("pageStart", 0);
				paraBus.put("pageEnd", pageSize);
			}

			if ("excel".equals(request.getParameter("subMethod"))) {
				paraBus.put("pageSize", "100000000000");
				paraBus.put("pageStart", "0");
				paraBus.put("pageEnd", "1000000000");
			}

			return paraBus;

		}
		return UNRESOLVED;
	}
}
