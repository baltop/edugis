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
public class BbsService extends BaseService {

	private static final Logger log = LoggerFactory.getLogger(BbsService.class);

	@SuppressWarnings("unchecked")
	public List<UnderBus> listBbs(Bus para) throws SQLException {
		log.info("BbsService.listBbs ");
		List<UnderBus> list = dao.queryForList("system.listBbs", para);
		return list;
	}



	public UnderBus selectBbs(Bus para) throws SQLException {
		log.info("BbsService.selectBbs ");
		UnderBus item = null;
		// 글쓴이와 동일한 인물이 아닌 경우에만 셀렉트할 때 마다
		// 조회 카운트를 증가 시킴.
		// 특별히 트랜젝션을 일으킬 일이 아니지만 select for update 대신
		// 트랜젝션을 걸었음.
		try {
			dao.startTransaction();
			item = (UnderBus) dao.queryForObject("system.selectBbs", para);
			if (!para.getString("register_id").equals(item.getString("register_id"))) {
				para.put("read_count", item.getInt("read_count") + 1);
				dao.update("system.updateBbsViewCount", para);
			}
			dao.commitTransaction();
		} catch (SQLException e) {
			throw e;
		}
		dao.endTransaction();
		return item;
	}

	public Integer insertBbs(Bus paraBus) throws SQLException {
		log.info("BbsService.insertBbs ");
		return (Integer) dao.insert("system.insertBbs", paraBus);
	}

	public Integer updateBbs(Bus paraBus) throws SQLException {
		log.info("BbsService.updateBbs ");
		return dao.update("system.updateBbs", paraBus);
	}

	public void deleteBbs(Bus paraBus) throws SQLException {
		log.info("BbsService.deleteBbs ");
		dao.delete("system.deleteBbs", paraBus);
	}

}
