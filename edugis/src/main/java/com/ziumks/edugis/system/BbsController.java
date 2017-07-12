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
public class BbsController extends BaseController {

	private static final Logger log = LoggerFactory.getLogger(BbsController.class);

	@Resource
	private BbsService service;

	@Resource
	private SystemService systemService;

	/**
	 * 게시판 목록 보기
	 * @param paraBus      bbs_id가 미리 셋팅되어야 함.
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/system/listBbs")
	public String listBbs(Bus paraBus, HttpServletRequest request) throws SQLException {
		log.info("BbsController.listBbs ");

		List<UnderBus> list = null;

		list = service.listBbs(paraBus);
		// 사용자 아이디를 사용자 명으로 변환  tr_register_id에 사용자 명이 들어 있음.
		Settings.keyToValue(list, "users", "register_id");

		request.setAttribute("list", list);

		return "system/listBbs";
	}

	/**
	 * 게시판 스레드 보기
	 * @param paraBus
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/system/viewBbs")
	public String viewBbs(Bus paraBus, HttpServletRequest request) throws SQLException {
		log.info("BbsController.viewBbs ");

		UnderBus item = null;
		List files = null;

		item = service.selectBbs(paraBus);
		item.put("tr_register_id", Settings.getValue("users", item.getString("register_id")));
		files = systemService.listFiles(paraBus, "thread_id", "bbs");

		request.setAttribute("item", item);
		request.setAttribute("files", files);
		return "system/viewBbs";
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/system/formBbs")
	public String formBbs(Bus paraBus, HttpServletRequest request) throws SQLException {
		log.info("BbsController.formBbs ");
		log.info(paraBus.getString("subMethod"));

		if ("insert".equals(paraBus.getString("subMethod"))) {
			return "system/viewBbs";
		}

		Map item = null;
		List files = null;

		item = service.selectBbs(paraBus);
		files = systemService.listFiles(paraBus, "thread_id", "bbs");

		request.setAttribute("item", item);
		request.setAttribute("files", files);
		return "system/viewBbs";
	}

	/**
	 * 게시물 저장
	 * @param paraBus
	 * @param request
	 * @return
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@RequestMapping(value = "/system/saveBbs")
	public String saveBbs(Bus paraBus, HttpServletRequest request) throws SQLException, FileNotFoundException, IOException {
		log.info("BbsController.saveBbs ");
		log.info(paraBus.getString("subMethod"));

		// 신규 인서트시 아니면 업데이트로 간주
		if ("".equals(paraBus.getString("thread_id"))) {

			Integer ob = service.insertBbs(paraBus);
			System.out.println("primary key[" + ob + "]");
			paraBus.put("ref_id", ob);
			paraBus.put("ref_group", "bbs");
			systemService.saveUpFile(paraBus, request);

			request.setAttribute("resultMsg", "정상적으로 저장되었습니다.");
			return "forward:/system/listBbs.do";
		} else {
			try {
				service.updateBbs(paraBus);
				paraBus.put("ref_group", "bbs");
				paraBus.put("ref_id", paraBus.get("thread_id"));
				systemService.saveUpFile(paraBus, request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("resultMsg", "정상적으로 저장되었습니다.");
		return "forward:/system/viewBbs.do";
	}

	/**
	 * 게시물 삭제
	 * @param paraBus
	 * @param request
	 * @return
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@RequestMapping(value = "/system/deleteBbs")
	public String deleteBbs(Bus paraBus, HttpServletRequest request) throws SQLException, FileNotFoundException, IOException {
		log.info("BbsController.deleteBbs ");

		service.deleteBbs(paraBus);
		systemService.deleteFiles(paraBus, "thread_id");
		request.setAttribute("resultMsg", "정상적으로 삭제되었습니다.");
		return "forward:/system/listBbs.do";
	}
	
	

	@RequestMapping(value = "/xo/listBbs")
	@ResponseBody
	public Map<String, Object> listBbsJson(Bus paraBus, HttpServletRequest request) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		log.info("BbsController.listBbsJson ");

		// jquery.grid 에서 json으로 받음.
		Map<String, Object> ret = new HashMap<String, Object>();
		
		
		// 이부분은 ParamapArgumentResolver.java 에서 처리해야 맞음.
		int pagesize = paraBus.getInt("pageSize");
		pagesize = pagesize==0 ? 10 : pagesize;
		int page = paraBus.getInt("page")  ;
		page = page+1;
		
		paraBus.put("pageStart", ((page - 1) * pagesize));
		paraBus.put("pageEnd", page * pagesize);
		
		// 소팅관련
		paraBus.check("sortColumn", "code_id");
		paraBus.check("sortOrder", "desc");
		paraBus.check("bbs_id", 3001 );
		
		List<UnderBus> list = service.listBbs(paraBus);

		
		// 아래 값으로 넣어주면 됨.
		ret.put("currentPage", list);

		ret.put("page",   paraBus.getInt("page"));
		// DB 리턴값이 없을때
		if( list.size() == 0 ){
			ret.put("totalRows", 0 );
		}
		else {
			ret.put("totalRows",  ((UnderBus)list.get(0)).getInt("totalCnt"));
		}
		ret.put("records", list.size());




		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(System.out, ret);
		return ret;
	}
	
	
}
