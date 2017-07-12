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
public class HouseService  extends BaseService {
	
	private static final Logger log = LoggerFactory.getLogger(HouseService.class);



	@SuppressWarnings("unchecked")
	public List<UnderBus> getPyungLv(Bus para) throws SQLException {
		// pyung -> db : a_
		List<UnderBus> list = dao.queryForList( "system.pyungLv",para);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<UnderBus> getHouseLv(Bus para) throws SQLException {
		// house price -> db : p_
		List<UnderBus> list = dao.queryForList( "system.houseLv",para);
		return list;
	}


}
