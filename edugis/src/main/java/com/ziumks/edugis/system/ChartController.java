package com.ziumks.edugis.system;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziumks.common.base.BaseController;
import com.ziumks.common.base.Bus;
import com.ziumks.common.base.UnderBus;
import com.ziumks.common.fileup.SystemService;
import com.ziumks.common.util.Settings;


/**
 * Handles requests for the application home page.
 */
@Controller
public class ChartController extends BaseController {

	private static final Logger log = LoggerFactory.getLogger(ChartController.class);

	@Resource
	private ChartService service;



	/**
	 * 년도별 시행계획 건수 차트
	 * @param paraBus      
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/chart/chartByYear")
	public String byYear(Bus paraBus, HttpServletRequest request) throws SQLException {
		log.info("ChartController.byYear ");

		List<UnderBus> list = null;

		list = service.chartByYear(paraBus);
		

		request.setAttribute("list", list);

		return "chart/chartByYear";
	}

	
	/**
	 * 중장기 별 시행계획 건수
	 * @param paraBus  
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/chart/chartByPlan")
	public String chartByPlan(Bus paraBus, HttpServletRequest request) throws SQLException {
		log.info("ChartController.chartByPlan ");

		List<UnderBus> list = null;

		list = service.chartByPlan(paraBus);
		

		request.setAttribute("list", list);

		return "chart/chartByPlan";
	}
	
	
	/**
	 * 올해 연간시행계획 중에서 진행단계별 갯수
	 * @param paraBus  
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/chart/chartByStatus")
	public String chartByStatus(Bus paraBus, HttpServletRequest request) throws SQLException {
		log.info("ChartController.chartByStatus ");

		List<UnderBus> list = null;

		list = service.chartByStatus(paraBus);
		

		request.setAttribute("list", list);

		return "chart/chartByStatus";
	}
	
	
}
