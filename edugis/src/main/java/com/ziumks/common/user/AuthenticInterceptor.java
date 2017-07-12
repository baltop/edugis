package com.ziumks.common.user;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ziumks.common.base.Bus;
import com.ziumks.common.base.UnderBus;





/**
 * 인증여부 체크 인터셉터
 * 
 * @author 공통서비스 개발팀 서준식
 * @since 2011.07.01
 * @version 1.0
 * @see
 * 
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2011.07.01  서준식          최초 생성 
 *  2011.09.07  서준식          인증이 필요없는 URL을 패스하는 로직 추가
 * </pre>
 */

public class AuthenticInterceptor extends HandlerInterceptorAdapter {
	private Set<String> permittedURL;
	
	@Inject
	protected SqlMapClient dao;
	
	
	@Inject
	protected SqlMapClient daoEAMS;

	public void setPermittedURL(Set<String> permittedURL) {
		this.permittedURL = permittedURL;
	}

	/**
	 * 세션에 계정정보(LoginVO)가 있는지 여부로 인증 여부를 체크한다. 계정정보(LoginVO)가 없다면, 로그인 페이지로
	 * 이동한다.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String requestURI = request.getRequestURI(); // 요청 URI
		boolean isPermittedURL = false;

		
		
		
		//UserInfo loginVO = (UserInfo) getAuthenticatedUser();

		UserInfo loginVO = (UserInfo)  request.getSession().getAttribute("userInfo");

		
		
		if (loginVO != null) {
			System.out.println("session is alive.");
			return true;
		} else {
			String userId = request.getParameter("userId");
			String auth = request.getParameter("auth");
			
			System.out.println("user auth is "+auth);
			if( userId !=null && userId.length()>0 && auth != null && auth.length()>0){
				if( "admin".equals(userId) ){
					userId = "99104139";
				}
				Bus paraBus = new UnderBus();
				paraBus.set("userId", userId);
				paraBus.set("auth", auth);
				paraBus.set("context", request.getParameter("context"));
				Bus user = (Bus) dao.queryForObject("system.selectUserInfo", paraBus);
				UserInfo userInfo = new UserInfo();
				userInfo.setUserId(userId);
				
				
				if( "ROLE_ACT".equals(auth) || "AUTHOR_ADMIN".equals(auth)) {
					
				}
				else {
					ModelAndView modelAndView = new ModelAndView("redirect:/eams");
					throw new ModelAndViewDefiningException(modelAndView);
				}
				
				
				
				if( "ROLE_ACT".equals(auth)) {
					userInfo.setAuthority("pmsManager");
				} else {
					userInfo.setAuthority(auth);
				}
				
				
				
				userInfo.setUserName(user.getString("name"));
				userInfo.setDeptId(user.getString("trns_dprt_key"));
				userInfo.setDeptName(user.getString("dprt_name"));
				// auth로 메뉴 셀레트
				List menuList =  daoEAMS.queryForList("eams.selectEamsMenu", paraBus);

				String menu = "";

				Iterator it = menuList.iterator();
				while (it.hasNext()) {
					Bus menuItem = (Bus) it.next();
					if ("정보화사업".equals(menuItem.getString("menuNm"))) {
						menu += "<em class=\"topem\"><a href=\"#\"  title=\"정보화사업\">정보화사업</a></em>";
					} else {
						menu += "<em class=\"topem\"><a href=\"#\" onclick=\"return fn_menuClick('/" + paraBus.getString("context") + menuItem.getString("url") + "', '"
								+ menuItem.getString("prmtr") + "');\" >" + menuItem.getString("menuNm") + "</a></em>\n";
					}
				}

				userInfo.setMenu(menu);
				request.getSession().setAttribute("userInfo", userInfo);
				return true;
			}
			
			for (Iterator<String> it = this.permittedURL.iterator(); it.hasNext();) {
				String urlPattern = request.getContextPath()
						+ (String) it.next();

				if (Pattern.matches(urlPattern, requestURI)) {// 정규표현식을 이용해서 요청
																// URI가 허용된 URL에
																// 맞는지 점검함.

					return true;
				}

			}
		}
		return false;
	}
/*
 * 보는바와 같이 ServletException 을 상속받아 만든 클래스인데 그중 특이한 함수가 하나있다
getModelAndView 인데 ModelAndView 을 반환한다. 
내가 사용한 소스는 다음과 같은데 이것은  어딘가로 위의 클래스를 Exception 으로 던지는
소스이다. 그럼 과연 이놈은 어디로 가는것일까?
throw new ModelAndViewDefiningException(new ModelAndView(url));


그걸 알려면 우선 처음 웹페이지에서 호출되었을때 어떤 클래스가 그놈을 처리하는지 알아야 한다.
바로 DispatcherServlet 이다. 이놈한테 Exception 을 던지는것이다. 이놈을 소스를 까보면 알수있다. 

catch (ModelAndViewDefiningException ex) {
    logger.debug("ModelAndViewDefiningException encountered", ex);
    mv = ex.getModelAndView();
 }

DispatcherServlet  내부에 doDispatch 함수안에 exception 을 catch 하는부분이있다. 그럼 이놈은 
에 있는  getModelAndView() 함수로 어떤 view로 갈지 ModelAndView를 리턴하게 되는데 이것은
throw new ModelAndViewDefiningException(new ModelAndView(url)); 
이때 new ModelAndView(url) 넘긴 정보를 받아 doDispatch 의 리턴값으로 사용하게 되고 
원하는 페이지로 이동하게 된다.
 */
//			if(request.getParameter("loginId") !=null){
//				String loginId = request.getParameter("loginId");
//				String passwd = request.getParameter("passwd");
//				
//				// check db 
//				// if ok , seesion create
//				return true;
//			}
//			if(requestURI.contains("Popup")){
//				ModelAndView modelAndView = new ModelAndView("redirect:/LoginPop.do");
//				throw new ModelAndViewDefiningException(modelAndView);
//			}
//			else if(requestURI.contains("Excel")){
//				ModelAndView modelAndView = new ModelAndView("redirect:/shared/exError.html");
//				throw new ModelAndViewDefiningException(modelAndView);
//			}
//			else {
//				ModelAndView modelAndView = new ModelAndView("redirect:/Login.do");
//				throw new ModelAndViewDefiningException(modelAndView);
//			}
//		}
//
//	}
	
	public Object getAuthenticatedUser() {

		return RequestContextHolder.getRequestAttributes().getAttribute("userInfo", RequestAttributes.SCOPE_SESSION);

	}

	
}
