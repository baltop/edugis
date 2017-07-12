package com.ziumks.edugis.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ziumks.common.base.BaseController;
import com.ziumks.common.base.Bus;
import com.ziumks.common.base.UnderBus;
import com.ziumks.common.fileup.SystemService;
import com.ziumks.common.user.UserInfo;
import com.ziumks.common.util.DateUtil;
import com.ziumks.common.util.ExcelData;
import com.ziumks.common.util.ExcelWriter;
import com.ziumks.common.util.Settings;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CodeController extends BaseController {

	private static final Logger log = LoggerFactory.getLogger(CodeController.class);

	@Resource
	private CodeService service;

	@Resource
	private SystemService systemService;

	@RequestMapping(value = "/system/listCode")
	public String listCode(Bus paraBus, HttpServletRequest request) throws SQLException {
		log.info("CodeController.listCode ");

		List<UnderBus> list = null;
		paraBus.check("sortColumn", "id, sort_order, code ");  //code_id, sort_order, code 
		paraBus.check("sortOrder", "desc");
		
		list = service.listCode(paraBus);

		request.setAttribute("list", list);

		return "system/listCode";
	}

	@RequestMapping(value = "/system/saveCode")
	public String saveCode(Bus paraBus, HttpServletRequest request) throws SQLException {
		log.info("CodeController.saveCode ");

			service.insertCode(paraBus);

			request.setAttribute("resultMsg", "정상적으로 저장되었습니다.");
			return "forward:/system/listCode.do";
	}

}
