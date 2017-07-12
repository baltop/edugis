package com.ziumks.edugis.map;

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
public class AgePopulationService  extends BaseService {
	
	private static final Logger log = LoggerFactory.getLogger(AgePopulationService.class);



	@SuppressWarnings("unchecked")
	public List<UnderBus> getPopuSigunguLv(Bus para) throws SQLException {

		List<UnderBus> list = dao.queryForList( "system.popuSigunguLv",para);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<UnderBus> getPopuSeoulLv(Bus para) throws SQLException {

		List<UnderBus> list = dao.queryForList( "system.popuSeoulLv",para);
		return list;
	}

	public List<UnderBus> getTest(Bus para) throws SQLException {
		List<UnderBus> list = dao.queryForList( "system.kmltest",para);
		return list;
	}

	public List<UnderBus> getTest2(Bus para) throws SQLException {
		List<UnderBus> list = dao.queryForList( "system.kmltest2",para);
		return list;
	}



	public List<UnderBus> getClean(Bus para) throws SQLException {
		List<UnderBus> list = dao.queryForList( "system.jsonclean",para);
		return list;
	}

}
