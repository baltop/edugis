package com.ziumks.edugis.user;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.ziumks.common.base.Constants;
import com.ziumks.common.base.BaseController;
import com.ziumks.common.base.Bus;
import com.ziumks.common.base.UnderBus;

@Controller
public class UserManageController extends BaseController {
	
	@Resource
	private UserManagementService umService;

	/*@Resource(name = "messageSource")
	MessageSource messageSource;*/

	/** log */
	protected static final Log logger = LogFactory.getLog(UserManageController.class);

	// 유저 목록 불러오기
	@RequestMapping(value = "/getUserList")
	public String getUserList(
			Bus paraBus,
			HttpServletRequest request,
	        Model model) throws Exception {
		
		logger.debug("#############[getUserList Start]#############");
		logger.debug("[UserManageController start]");
		
		try{
			
			List<UnderBus> empUserList = null;
			List<UnderBus> empStatusCode = null;
			
			paraBus.put("pageEnd", paraBus.get("pageend"));
		    paraBus.put("pageStart", (Integer) paraBus.get("pagestart"));
		    
			// empStatusCode = umService.getUserStatuscode(paraBus);
			empUserList = umService.getUserList(paraBus);
			
			logger.debug(empUserList.size());
			logger.debug("#############[getUserList End]#############");
			
			//request.setAttribute("list2", empStatusCode);
			request.setAttribute("list", empUserList);
			request.setAttribute("totalcount", empUserList.get(0).get("totalcount"));
			    
			request.setAttribute("startpagenum",(Integer) paraBus.get("startpagenum",1)); 
			request.setAttribute("rPage", paraBus.get("rpage",1));

		}catch(Exception e){
			logger.debug("error ="+e);
		}
		
		return "/system/UserManage";
	}
	
	// parabus 를 이용하려면 jsp 에서 name 이 대문자로 되어 있더라도 컨트롤러에서는 소문자로 적어야 한다. 
	@RequestMapping(value = "/deleteUser")
	public String deleteUser(
			Bus paraBus, 
			HttpServletRequest request,
			Model model
			){
		System.out.println("delete 다");
		// logger.debug("#############[deleteUser Start]#############");
        try{
		umService.deleteUser(paraBus);
        }catch(Exception e){
        	logger.debug("#############SQL ERROR#############"+e);
        	
        }
		
		return "forward:/getUserList.do";
	}
	
	@RequestMapping(value ="/resisterUser")
	public String moveToResisterView(
			Bus paraBus,
			HttpServletRequest request,
			Model model
			){
		logger.debug("#############[resisterUser Start]#############");
		System.out.println(paraBus.get("emplyr_id"));
		
		try {
			umService.setUser(paraBus);
		} catch (SQLException e) {
			logger.debug("#############SQL ERROR#############"+e);
		}
		
		return "forward:/getUserList.do";
	}
	@RequestMapping(value ="/updateUser")
	public String moveToUpdateView(
			Bus paraBus,
			HttpServletRequest request,
			Model model
			){
		logger.debug("move to updatePage");
		return "/sym/userUpdatePage";
				
	}
}
