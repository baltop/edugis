package com.ziumks.edugis.system;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ziumks.common.base.BaseController;
import com.ziumks.common.fileup.SystemService;

/**
 * ibatis ibator로 생성한 Code.java를 이용한 빈 dto 테스트용
 */
@Controller
public class Code2Controller extends BaseController {

	private static final Logger log = LoggerFactory.getLogger(Code2Controller.class);

	@Resource
	private Code2Service service;

	@Resource
	private SystemService systemService;

	@RequestMapping(value = "/xo/listCode")
	public String listCode(Code code, HttpServletRequest request, Model model) throws SQLException {
		log.info("Code2Controller.listCode ");

		List<Code> list = null;

		list = service.listCode(code);

		request.setAttribute("list", list);

		return "system/listCode2";
	}

	@RequestMapping(value = "/xo/saveCode")
	public String saveCode(Code code, HttpServletRequest request, Model model) throws SQLException {
		log.info("Code2Controller.saveCode ");


		service.insertCode(code);

		request.setAttribute("resultMsg", "정상적으로 저장되었습니다.");
		return "forward:/xo/listCode.do";
	}

}
