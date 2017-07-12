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
public class PopulationController extends BaseController {

	private static final Logger log = LoggerFactory.getLogger(PopulationController.class);

	@Resource
	private PopulationService service;

	@Resource
	private SystemService systemService;

	@RequestMapping(value = "/map/incomeLevel")
	@ResponseBody
	public String  incomeLevel(Bus paraBus, HttpServletRequest request, HttpServletResponse response) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		log.info("PopulationController.incomeLevel ");
		Map<String, Object> ret = new HashMap<String, Object>();
		List<UnderBus> list = null;
		String callback = paraBus.getString("callback");
		String callto = paraBus.getString("_");
		callto = callback.split("_")[0]+"_"+callto;
		log.debug("callbakk ["+callback+"]");
		System.out.println("callbakk ["+callback+"]");
		list = service.getIncomeLevel(paraBus);

//		request.setAttribute("list", list);
//
		ret.put("result", "success");
		ret.put("currentPage", list);
		
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.writeValue(System.out, ret);
//		return ret;

        String result = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
                 result = mapper.writeValueAsString(list);
        } catch (JsonGenerationException e) {
                 e.printStackTrace();
        } catch (JsonMappingException e) {
                 e.printStackTrace();
        } catch (IOException e) {
                 e.printStackTrace();
        }
        System.out.println(result);
        String op = callback + " (" + result + ");";
        System.out.println(op);
        PrintWriter out = response.getWriter();
        out.print(op);
        return null;
	}


	
	
	@RequestMapping(value = "/map/incomeLv")
	public String  incomeLv(Bus paraBus, HttpServletRequest request, HttpServletResponse response) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		log.info("PopulationController.incomeLv ");
		//String key ="";
		paraBus.set("power", paraBus.getString("power").replace('_', '+'));
		if("small".equals(paraBus.getString("zoom"))){
			paraBus.set("lat_south", paraBus.getFloat("lat_south")-0.02);
			paraBus.set("lat_north", paraBus.getFloat("lat_north")+0.02);
			paraBus.set("lng_west", paraBus.getFloat("lng_west")-0.02);
			paraBus.set("lng_east", paraBus.getFloat("lng_east")+0.02);
			//key = " "+ paraBus.get("lat_south") + paraBus.get("lng_west");
		}
		String result=null;
//		
		// paraBus에서 user id 가 매번 변하면....
		result = getCache(paraBus.getString("power"));
		if(result != null){
			System.out.println("cache suc.+++++++++++++++++++++++++++++++++++");
		}
		if(result == null){
			System.out.println("cache fail.===================================");
			List<UnderBus> list = null;
			if("small".equals(paraBus.getString("zoom"))){
				list = service.getIncomeLvSmall(paraBus);
			}else{
				list = service.getIncomeLv(paraBus);
			}
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
	
	
	@RequestMapping(value = "/map/goomon")
	public String  goomon(Bus paraBus, HttpServletRequest request, HttpServletResponse response) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		log.info("PopulationController.goomon ");

		String result=null;
		paraBus.set("power", "goomon");
//		
//		// paraBus에서 user id 가 매번 변하면....
		result = getCache(paraBus.getString("power"));
		if(result != null){
			System.out.println("cache suc.+++++++++++++++++++++++++++++++++++");
		}
		if(result == null){
			System.out.println("cache fail.===================================");
			List<UnderBus> list = null;

			list = service.getGoomon(paraBus);
			
	        result = "{\"type\":\"FeatureCollection\", \"features\" : [\n";
	    	
	//        heatMapData = [
	//          {"type":"FeatureCollection","features":[
	//        {"type":"Feature","properties":{"code":"39020","name":"서귀포시","name_eng":"Seogwipo-si","base_year":"2012"},"geometry":{"type":"MultiPolygon","coordinates":

	        
	        UnderBus item = null;
	        for( int i = 0 ; i < list.size()-1;i++){
	        	item = list.get(i);
	        	result += "{\"type\": \"Feature\", \"properties\" : { \"name\" : \"" + item.get("name") + "\" , \"phone\" : \""+ item.get("phone")+"\", \"address\" : \"" +item.get("address")+"\" }, \"geometry\" : {\"type\" : \"Point\", \"coordinates\" : ["+item.get("lng")+ ","+ item.getDouble("lat") + "]} }, \n";
	        }
	        item = list.get(list.size()-1);
        	result += "{\"type\": \"Feature\", \"properties\" : { \"name\" : \"" + item.get("name") + "\" , \"phone\" : \""+ item.get("phone")+"\", \"address\" : \"" +item.get("address")+"\" }, \"geometry\" : {\"type\" : \"Point\", \"coordinates\" : ["+item.get("lng")+ ","+ item.getDouble("lat") + "]} } ]}, \n";
	        setCache(paraBus.getString("power"), result);
		}
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        return null;
	}
	
	@RequestMapping(value = "/map/cust")
	public String  cust(Bus paraBus, HttpServletRequest request, HttpServletResponse response) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		log.info("PopulationController.goomon ");

		String result=null;
		paraBus.set("power", "cust");
//		
//		// paraBus에서 user id 가 매번 변하면....
		result = getCache(paraBus.getString("power"));
		if(result != null){
			System.out.println("cache suc.+++++++++++++++++++++++++++++++++++");
		}
		if(result == null){
			System.out.println("cache fail.===================================");
			List<UnderBus> list = null;

			list = service.getCust(paraBus);
			
	        result = "{\"type\":\"FeatureCollection\", \"features\" : [\n";
	    	
	//        heatMapData = [
	//          {"type":"FeatureCollection","features":[
	//        {"type":"Feature","properties":{"code":"39020","name":"서귀포시","name_eng":"Seogwipo-si","base_year":"2012"},"geometry":{"type":"MultiPolygon","coordinates":

	        
	        UnderBus item = null;
	        for( int i = 0 ; i < list.size()-1;i++){
	        	item = list.get(i);
	        	result += "{\"type\": \"Feature\", \"properties\" : { \"street_name\" : \"" + item.get("street_name") + "\" , \"building_no\" : \""+ item.get("building_no") +"\", \"building_sub\" : \"" +item.get("building_sub") +"\", \"customer_nm\" : \"" +item.get("customer_nm") +"\", \"order_prd1\" : \"" +item.get("order_prd1") +"\", \"order_dt1\" : \"" +item.get("order_dt1") +"\", \"order_prd2\" : \"" +item.get("order_prd2") +"\", \"order_dt2\" : \"" +item.get("order_dt2") +"\", \"order_prd3\" : \"" +item.get("order_prd3") +"\", \"order_dt3\" : \"" +item.get("order_dt3") +"\", \"order_prd4\" : \"" +item.get("order_prd4") +"\", \"order_dt4\" : \"" +item.get("order_dt4") +"\" }, \"geometry\" : {\"type\" : \"Point\", \"coordinates\" : ["+item.get("lng")+ ","+ item.getDouble("lat") + "]} }, \n";
	        }
	        item = list.get(list.size()-1);
        	result += "{\"type\": \"Feature\", \"properties\" : { \"street_name\" : \"" + item.get("street_name") + "\" , \"building_no\" : \""+ item.get("building_no") +"\", \"building_sub\" : \"" +item.get("building_sub") +"\", \"customer_nm\" : \"" +item.get("customer_nm") +"\", \"order_prd1\" : \"" +item.get("order_prd1") +"\", \"order_dt1\" : \"" +item.get("order_dt1") +"\", \"order_prd2\" : \"" +item.get("order_prd2") +"\", \"order_dt2\" : \"" +item.get("order_dt2") +"\", \"order_prd3\" : \"" +item.get("order_prd3") +"\", \"order_dt3\" : \"" +item.get("order_dt3") +"\", \"order_prd4\" : \"" +item.get("order_prd4") +"\", \"order_dt4\" : \"" +item.get("order_dt4") +"\" }, \"geometry\" : {\"type\" : \"Point\", \"coordinates\" : ["+item.get("lng")+ ","+ item.getDouble("lat") + "]} } ]}, \n";
	        setCache(paraBus.getString("power"), result);
		}
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        return null;
	}
	
}
