package com.ziumks.common.util;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ziumks.common.base.Bus;

@Service
public class CronDatabase {
	@Inject
	protected SqlMapClient dao;
	
	@Inject
	protected SqlMapClient daoEAMS;
	
	// 위에 클래스명에 @Service 빠트리지말것.
	@Transactional(value = "txManager", rollbackFor = SQLException.class)
	//@Scheduled(cron="0 10 */1 * * MON-FRI")
	public void dbTransfer() throws SQLException{
		System.out.println( DateUtil.getTime());
		System.out.println("############################## cron work start !!!!!!!!!!!!!!!!!!!!!!!!  ############");
		System.out.println("############################## cron work start !!!!!!!!!!!!!!!!!!!!!!!!  ############");
		
			List systemList = daoEAMS.queryForList("eams.select_tn_asis_info_system");
			if( systemList.size() > 0 ){
				dao.delete("eams.delete_PMS_tn_asis_info_system");
				dao.startBatch();
				for( Iterator it = systemList.iterator(); it.hasNext();){
					Bus para = (Bus)it.next();
					dao.insert("eams.insert_PMS_tn_asis_info_system", para);
					
				}
				dao.executeBatch();
				//dao.commitTransaction();
			}

		System.out.println( DateUtil.getTime());
		System.out.println("############################## cron work end !!!!!!!!!!!!!!!!!!!!!!!!  ############");
		System.out.println("############################## cron work end !!!!!!!!!!!!!!!!!!!!!!!!  ############");
	}
	
	// 위에 클래스명에 @Service 빠트리지말것.
	@Transactional(value = "txManager", rollbackFor = SQLException.class)
	//@Scheduled(cron="0 20 */1 * * MON-FRI")
	public void dbTransfer2() throws SQLException{
		System.out.println( DateUtil.getTime());
		System.out.println("############################## cron work start !!!!!!!!!!!!!!!!!!!!!!!!  ############");
		System.out.println("############################## cron work start !!!!!!!!!!!!!!!!!!!!!!!!  ############");
		
			List systemList = daoEAMS.queryForList("eams.select_tn_infrm_bsns_rslt_pms");
			if( systemList.size() > 0 ){
				dao.delete("eams.delete_PMS_tn_infrm_bsns_rslt");
				dao.startBatch();
				for( Iterator it = systemList.iterator(); it.hasNext();){
					Bus para = (Bus)it.next();
					dao.insert("eams.insert_PMS_tn_infrm_bsns_rslt", para);
					
				}
				dao.executeBatch();
				//dao.commitTransaction();
			}

		System.out.println( DateUtil.getTime());
		System.out.println("############################## cron work end !!!!!!!!!!!!!!!!!!!!!!!!  ############");
		System.out.println("############################## cron work end !!!!!!!!!!!!!!!!!!!!!!!!  ############");
	}
	
	
}
