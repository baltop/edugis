package com.ziumks.edugis.system;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
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
public class ChartService extends BaseService {

	private static final Logger log = LoggerFactory.getLogger(ChartService.class);



	@SuppressWarnings("unchecked")
	public List<UnderBus> chartByYear(Bus para) throws SQLException {
		log.info("ChartService.chartByYear ");
		List<UnderBus> list = dao.queryForList("system.chartByYear", para);
		return list;
	}

	
	
	@SuppressWarnings("unchecked")
	public List<UnderBus> chartByPlan(Bus para) throws SQLException {
		log.info("ChartService.chartByPlan");
		List<UnderBus> list = dao.queryForList("system.chartByPlan", para);
		return list;
	}


	@SuppressWarnings("unchecked")
	public List<UnderBus> chartByStatus(Bus para) throws SQLException {
		log.info("ChartService.chartByStatus");
		List<UnderBus> list = dao.queryForList("system.chartByStatus", para);
		return list;
	}
	
	
}
