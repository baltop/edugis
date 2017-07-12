package com.ziumks.edugis.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import com.ziumks.common.base.BaseService;
import com.ziumks.common.base.Bus;
import com.ziumks.common.base.CiBus;
import com.ziumks.common.base.UnderBus;
import com.ziumks.common.util.Settings;





@Service
public class CodeService  extends BaseService {
	
	private static final Logger log = LoggerFactory.getLogger(CodeService.class);


	

	@SuppressWarnings("unchecked")
	public List<UnderBus> listCode(Bus para) throws SQLException {
		log.info("CodeService.listCode ");
		List<UnderBus> list = dao.queryForList("system.listCode",para);
		return list;
	}



	public Integer insertCode(Bus paraBus) throws SQLException  {
		log.info("CodeService.insertCode ");
		Integer ret = null;
		try {
			if( dao.update("system.updateCode", paraBus) <1 ){
				dao.insert("system.insertCode", paraBus);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
				throw e;
		}
		Settings.load();
		return ret;
		
	}



}
