package com.ziumks.edugis.system;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ziumks.common.base.BaseService;





@Service
public class Code2Service  extends BaseService {
	
	private static final Logger log = LoggerFactory.getLogger(Code2Service.class);


	

	@SuppressWarnings("unchecked")
	public List<Code> listCode(Code code) throws SQLException {
		log.info("CodeService.listCode ");
		
		List<Code> list = dao.queryForList("xo.listCode",code);
		return list;
	}



	public Integer insertCode(Code paraBus) throws SQLException  {
		log.info("CodeService.insertCode ");
		Integer ret = null;
//		try {
//			if( dao.update("xo.updateCode", paraBus) <1 ){
//				dao.insert("xo.insertCode", paraBus);
//			}
//		}
//		catch (SQLException e){
//			e.printStackTrace();
//				throw e;
//		}
//		Settings.load();
		return ret;
		
	}



}
