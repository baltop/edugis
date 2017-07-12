package com.ziumks.edugis.map;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziumks.common.base.BaseController;
import com.ziumks.common.base.Bus;
import com.ziumks.common.base.GisCache;
import com.ziumks.common.base.UnderBus;
import com.ziumks.common.fileup.SystemService;
import com.ziumks.common.user.UserInfo;
import com.ziumks.common.util.DateUtil;
import com.ziumks.common.util.ExcelData;
import com.ziumks.common.util.ExcelWriter;
import com.ziumks.common.util.Settings;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HouseController extends BaseController {

	private static final Logger log = LoggerFactory.getLogger(HouseController.class);

	@Resource
	private HouseService service;

	@Resource
	private SystemService systemService;
	
	
	@RequestMapping(value = "/map/pyungLv")
	public String  pyungLv(Bus paraBus, HttpServletRequest request, HttpServletResponse response) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		log.info("HouseController.pyungLv ");
		
		paraBus.set("power", paraBus.getString("power").replace('_', '+'));
		String result;
		
		// paraBus에서 user id 가 매번 변하면....
		result = getCache(paraBus.getString("power"));
		if(result != null){
			System.out.println("cache suc.+++++++++++++++++++++++++++++++++++");
		}
		if(result == null){
			System.out.println("cache fail.===================================");
			List<UnderBus> list = null;
			list = service.getPyungLv(paraBus);
	
	        result = "heatMapData = [\n";
	
	//        heatMapData = [
	//        {location: new google.maps.LatLng(37.482274,126.933668),weight: 12},
	//        new google.maps.LatLng(37.47978350584145,126.91692414617508)
	//        ];
	        
	        UnderBus item = null;
	        for( int i = 0 ; i < list.size()-1;i++){
	        	item = list.get(i);
	        	result += "{location: new google.maps.LatLng("+ item.get("lat2") +"," +item.get("lng2")+ "),weight:" + item.get("total")+"},\n";
	        }
	        item = list.get(list.size()-1);
	        result += "{location: new google.maps.LatLng("+ item.get("lat2") +"," +item.get("lng2")+ "),weight:" + item.get("total")+"}];\n";
	        setCache(paraBus.getString("power"), result);
		}
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        return null;
	}

	
	
	@RequestMapping(value = "/map/houseLv")
	public String  houseLv(Bus paraBus, HttpServletRequest request, HttpServletResponse response) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		log.info("HouseController.houseLv ");
		
		paraBus.set("power", paraBus.getString("power").replace('_', '+'));
		String result;
		
		// paraBus에서 user id 가 매번 변하면....
		result = getCache(paraBus.getString("power"));
		if(result != null){
			System.out.println("cache suc.+++++++++++++++++++++++++++++++++++");
		}
		if(result == null){
			System.out.println("cache fail.===================================");
			List<UnderBus> list = null;
			list = service.getHouseLv(paraBus);
	
	        result = "heatMapData = [\n";
	
	//        heatMapData = [
	//        {location: new google.maps.LatLng(37.482274,126.933668),weight: 12},
	//        new google.maps.LatLng(37.47978350584145,126.91692414617508)
	//        ];
	        
	        UnderBus item = null;
	        for( int i = 0 ; i < list.size()-1;i++){
	        	item = list.get(i);
	        	result += "{location: new google.maps.LatLng("+ item.get("lat2") +"," +item.get("lng2")+ "),weight:" + item.get("total")+"},\n";
	        }
	        item = list.get(list.size()-1);
	        result += "{location: new google.maps.LatLng("+ item.get("lat2") +"," +item.get("lng2")+ "),weight:" + item.get("total")+"}];\n";
	        setCache(paraBus.getString("power"), result);
		}
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        return null;
	}

	
	
}
