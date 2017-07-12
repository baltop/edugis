package com.ziumks.common.user;

import java.sql.SQLException;
import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ziumks.common.base.CiBus;



/**
 * 일반 로그인, 인증서 로그인을 처리하는 컨트롤러 클래스
 * 
 * @author 공통서비스 개발팀 박지욱
 * @since 2009.03.06
 * @version 1.0
 * @see
 * 
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2009.03.06  박지욱          최초 생성 
 *  2011.8.26	정진오			IncludedInfo annotation 추가
 *  2011.09.07  서준식          스프링 시큐리티 로그인 및 SSO 인증 로직을 필터로 분리
 *  2011.09.25  서준식          사용자 관리 컴포넌트 미포함에 대한 점검 로직 추가
 *  2011.09.27  서준식          인증서 로그인시 스프링 시큐리티 사용에 대한 체크 로직 추가
 *  2011.10.27  서준식          아이디 찾기 기능에서 사용자 리름 공백 제거 기능 추가
 * </pre>
 */

@Controller  //컨트롤러적용시킴
public class LoginController {


	@Resource(name = "loginService")
	private LoginService loginService;



	@Resource(name = "messageSource")
	MessageSource messageSource;

	/** log */
	protected static final Log LOG = LogFactory.getLog(LoginController.class);

	/**
	 * 로그인 화면으로 들어간다
	 * 
	 * @param vo
	 *            - 로그인후 이동할 URL이 담긴 UserInfo
	 * @return 로그인 페이지
	 * @exception Exception
	 */
	
	@RequestMapping(value = "/Login.do")
	public String loginUsrView(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		return "main/LoginUser";
	}

	/**
	 * 로그인 화면으로 들어간다
	 * 
	 * @param vo
	 *            - 로그인후 이동할 URL이 담긴 UserInfo
	 * @return 로그인 페이지
	 * @exception Exception
	 */

	@RequestMapping(value = "/LoginPop.do")
	public String loginUsrViewForPop(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		return "main/LoginUserPop";
	}

	@RequestMapping(value = "/UsrExerror.do")
	public String loginUsrViewForExcel(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		return "main/LoginUserExerror";
	}

	/**
	 * 일반(세션) 로그인을 처리한다
	 * 
	 * @param vo
	 *            - 아이디, 비밀번호가 담긴 UserInfo
	 * @param request
	 *            - 세션처리를 위한 HttpServletRequest
	 * @return result - 로그인결과(세션정보)
	 * @exception Exception
	 */
	@RequestMapping(value = "/actionLogin1.do")
	public String actionLogin1(@ModelAttribute("UserInfo") UserInfo userInfo,
			HttpServletRequest request, ModelMap model) throws Exception {
		
		UserInfo resultVO = null;
		try {
			// 1. 일반 로그인 처리
			resultVO = loginService.actionLogin(userInfo);
		} catch (Exception eee) {
			eee.printStackTrace();
		}

		if (resultVO != null && resultVO.getUserId() != null
				&& !resultVO.getUserId().equals("")) {

			// 2-1. 로그인 정보를 세션에 저장
			request.getSession().setAttribute("UserInfo", resultVO);

			// com.jieum.pola.main.HomeController home();
			//return "redirect:/main";
			return "main/Home";

		} else {

			model.addAttribute("message",
					messageSource.getMessage("fail.common.login", null, getLocale(request) ));
			
			//return "main/EgovLoginUsr";
			return "redirect:/LoginUser";
		}

	}
	
	
	@RequestMapping(value = "/actionLogin.do")
	public String actionLogin(@ModelAttribute("UserInfo") UserInfo userInfo,
	HttpServletRequest request, ModelMap model) throws Exception{
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		UserInfo user = null;
		try {
			// 1. 일반 로그인 처리
			user = loginService.actionLogin1(id);
		} catch (Exception eee) {
			eee.printStackTrace();
		}
		if(user != null && user.getUserId() != null){
			if(user.getPassword().equals(password)){ //불러오는 이름은 대소문자를 가림
				// 2-1. 로그인 정보를 세션에 저장
				request.getSession().setAttribute("UserInfo", user);
				List list = null;
				String bbs_id = "BBSMSTR_AAAAAAAAAAAA";
				try {
					// 불러올 글목록 sql서비스 연결하기
					list = loginService.actionBbsList(bbs_id);
				} catch (Exception eee) {
					eee.printStackTrace();
				}
				request.setAttribute("resultList", list);
				return "main/home";
			}
			return "main/LoginUser";
		}else{
			return "main/LoginUser";
		}
		
	}
	
	private Locale getLocale(HttpServletRequest request) {
	    
	    return request.getLocale();
    }

	/**
	 * 로그인 후 메인화면으로 들어간다
	 * 
	 * @param
	 * @return 로그인 페이지
	 * @exception Exception
	 */
//	@RequestMapping(value = "/uat/uia/actionMain.do")
//	public String actionMain(ModelMap model) throws Exception {
//
//		//UserInfo user = (UserInfo) EgovUserDetailsHelper.getAuthenticatedUser();
//
//		return "main/MainView";
//	}

	/**
	 * 로그아웃한다.
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping(value = "/actionLogout.do")
	public String actionLogout(HttpServletRequest request, ModelMap model)
			throws Exception {


		request.getSession().setAttribute("UserInfo", null);

		return "redirect:/LoginUser";
	}
	
	

}