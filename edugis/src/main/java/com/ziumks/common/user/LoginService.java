package com.ziumks.common.user;

import java.sql.SQLException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ziumks.common.base.BaseService;
import com.ziumks.common.base.CiBus;


@Service("loginService")
public class LoginService extends BaseService{

	

	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);



	
	public UserInfo actionLogin(UserInfo userInfo) {
		logger.debug("WsWsWsWsWsWs");
		try {
			List<CiBus> list = dao.queryForList("code.allcode");
			for( CiBus dbItem : list){
				System.out.println(dbItem.get("id"));
				if(dbItem.get("id") == userInfo.getUserId()){
					return userInfo;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	    
    }
	public UserInfo actionLogin1(String id) throws SQLException{
		logger.debug("LoginService_actionLogin1");
		UserInfo userInfo = (UserInfo)dao.queryForObject("base.selectUserById",id);
		return userInfo;
	}
	
	public List actionBbsList(String bbs_id) throws SQLException {
		logger.debug("LoginService_actionBbsList");
	
		List<CiBus> list = dao.queryForList("base.selectBbsHome",bbs_id);
		
		return list;
	}


}
