package com.ziumks.edugis.user;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.ziumks.common.base.BaseService;
import com.ziumks.common.base.Bus;


@Service
public class UserManagementService  extends BaseService {
	protected static final Log logger = LogFactory.getLog(UserManagementService.class);
	

	
	public List getUserList(Bus paraBus) throws SQLException{
		logger.debug("[UserManagementService start][getUserList]");
		List<Bus> list = dao.queryForList("system.getUserList", paraBus);
		logger.debug("[UserManagementService end][getUserList]");
		return list;
	}
	public List getUserStatuscode(Bus paraBus) throws SQLException{
		logger.debug("[UserManagementService start][getUserStatuscode]");
		List<Bus> list2 = dao.queryForList("sysmanage.getUserStatuscode", paraBus);
		logger.debug("[UserManagementService end][getUserStatuscode]");
		return list2;
	}
	
	//checkedidfordel 안에는 값:,값:,값:, 이러한 형태로 들어있다.  그러므로 : 을 제거하고 , 을 기준으로 나누어 넣는다. 
	public void deleteUser(Bus paraBus) throws SQLException{
		logger.debug("[UserManagementService start][deleteUser]");
		
		String [] delId =((String)paraBus.get("checkedidfordel")).replace(":", "").split(",");

		for (int i=0; i<delId.length ; i++){
			dao.delete("sysmanage.deleteUser", delId[i]);
		}
		logger.debug("[UserManagementService end][deleteUser]");
	}
	
	public void setUser(Bus paraBus) throws SQLException{
		logger.debug("[UserManagementService start][deleteUser]");
		//sqlMap.insert("sysmanage.insertUser", paraBus);
		System.out.println("ok");
	}
	

	
}
