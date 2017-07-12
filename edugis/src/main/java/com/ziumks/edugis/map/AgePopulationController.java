package com.ziumks.edugis.map;

import java.io.BufferedReader;
import java.io.FileReader;
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

import org.apache.commons.lang.StringUtils;
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
public class AgePopulationController extends BaseController {

	private static final Logger log = LoggerFactory.getLogger(AgePopulationController.class);

	@Resource
	private AgePopulationService service;

	@Resource
	private SystemService systemService;
	
	
	
	
	@RequestMapping(value = "/map/popuSigunguLv")
	public String  popuSigunguLv(Bus paraBus, HttpServletRequest request, HttpServletResponse response) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		log.info("HouseController.houseLv ");
		
		//paraBus.set("power", paraBus.getString("power").replace('_', '+'));
		String param = paraBus.getString("power");
		String cow = "";
		boolean append = false;
		if( param.contains("s1")){
			cow += "age_0 + age_1 + age_2 + age_3 + age_4 + age_5 ";
			append = true;
		}
		if ( param.contains("s2")){
			if (append) cow += "+ ";
			cow += "age_6 + age_7 + age_8 ";
			append = true;
		}
		if ( param.contains("s3")){
			if (append) cow += "+ ";
			cow += "age_9 + age_10 + age_11 ";
			append = true;
		}
		if ( param.contains("s4")){
			if (append) cow += "+ ";
			cow += "age_12 + age_13 + age_14 ";
			append = true;
		}
		if ( param.contains("s5")){
			if (append) cow += "+ ";
			cow += "age_15 + age_16 + age_17 ";
			
		}
		if ( param.equals("range")){
			int s = paraBus.getInt("range_st");
			int e = paraBus.getInt("range_en");
			for( int i = s;i<e;i++){
			cow +=  "age_"+i + " + ";
			}
			cow += "age_"+e +" ";
		}
		//String power = StringUtils.join(p, "+");
		
		
		paraBus.set("power", cow);
		
		log.debug(paraBus.getString("power"));
		String result=null;
		
		// paraBus에서 user id 가 매번 변하면....
		result = getCache("/map/popuSigunguLv "+paraBus.getString("power"));
		if(result != null){
			System.out.println("cache suc.+++++++++++++++++++++++++++++++++++");
		}
		if(result == null){
			System.out.println("cache fail.===================================");
			List<UnderBus> list = null;
			list = service.getPopuSigunguLv(paraBus);
	
	        result = "{\"type\":\"FeatureCollection\", \"features\" : [\n";
	
	//        heatMapData = [
	//          {"type":"FeatureCollection","features":[
	//        {"type":"Feature","properties":{"code":"39020","name":"서귀포시","name_eng":"Seogwipo-si","base_year":"2012"},"geometry":{"type":"MultiPolygon","coordinates":

	        
	        UnderBus item = null;
	        for( int i = 0 ; i < list.size()-1;i++){
	        	item = list.get(i);
	        	result += "{\"type\": \"Feature\", \"properties\" : { \"code\" : \"" + item.get("code") + "\" , \"name\" : \""+ item.get("adm_name")+"\", \"total\" : \"" +item.get("re_total")+"\" }, \"geometry\" : "+item.get("geometry")+ " }, \n";
	        }
	        item = list.get(list.size()-1);
	        result += "{\"type\": \"Feature\", \"properties\" : { \"code\" : \"" + item.get("code") + "\" , \"name\" : \""+ item.get("adm_name")+"\", \"total\" : \"" +item.get("re_total")+"\" }, \"geometry\" : "+item.get("geometry")+ " } ] }\n" ;  
	        setCache("/map/popuSigunguLv "+paraBus.getString("power"), result);
		}
		
		// result = result.replaceAll("'", "\"");
		System.out.println("result");
		response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        return null;
	}

	
	
	@RequestMapping(value = "/map/popuSeoulLv")
	public String  popuSeoulLv(Bus paraBus, HttpServletRequest request, HttpServletResponse response) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		log.info("HouseController.houseLv ");
		
		//paraBus.set("power", paraBus.getString("power").replace('_', '+'));
		String param = paraBus.getString("power");
		String cow = "";
		boolean append = false;
		if( param.contains("s1")){
			cow += "age_0 + age_1 + age_2 + age_3 + age_4 + age_5 ";
			append = true;
		}
		if ( param.contains("s2")){
			if (append) cow += "+ ";
			cow += "age_6 + age_7 + age_8 ";
			append = true;
		}
		if ( param.contains("s3")){
			if (append) cow += "+ ";
			cow += "age_9 + age_10 + age_11 ";
			append = true;
		}
		if ( param.contains("s4")){
			if (append) cow += "+ ";
			cow += "age_12 + age_13 + age_14 ";
			append = true;
		}
		if ( param.contains("s5")){
			if (append) cow += "+ ";
			cow += "age_15 + age_16 + age_17 ";
			
		}
		
		if ( param.equals("range")){
			int s = paraBus.getInt("range_st");
			int e = paraBus.getInt("range_en");
			for( int i = s;i<e;i++){
			cow +=  "age_"+i + " + ";
			}
			cow += "age_"+e +" ";
		}
		
		//String power = StringUtils.join(p, "+");
		
		
		paraBus.set("power", cow);
		
		log.debug(paraBus.getString("power"));
		String result=null;
		
		// paraBus에서 user id 가 매번 변하면....
		result = getCache("/map/popuSeoulLv "+paraBus.getString("power"));
		if(result != null){
			System.out.println("cache suc.+++++++++++++++++++++++++++++++++++");
		}
		if(result == null){
			System.out.println("cache fail.===================================");
			List<UnderBus> list = null;
			list = service.getPopuSeoulLv(paraBus);
	
	        result = "{\"type\":\"FeatureCollection\", \"features\" : [\n";
	
	//        heatMapData = [
	//          {"type":"FeatureCollection","features":[
	//        {"type":"Feature","properties":{"code":"39020","name":"서귀포시","name_eng":"Seogwipo-si","base_year":"2012"},"geometry":{"type":"MultiPolygon","coordinates":

	        
	        UnderBus item = null;
	        for( int i = 0 ; i < list.size()-1;i++){
	        	item = list.get(i);
	        	result += "{\"type\": \"Feature\", \"properties\" : { \"code\" : \"" + item.get("code") + "\" , \"name\" : \""+ item.get("adm_name")+"\", \"total\" : \"" +item.get("re_total")+"\" }, \"geometry\" : "+item.get("geometry")+ " }, \n";
	        }
	        item = list.get(list.size()-1);
	        result += "{\"type\": \"Feature\", \"properties\" : { \"code\" : \"" + item.get("code") + "\" , \"name\" : \""+ item.get("adm_name")+"\", \"total\" : \"" +item.get("re_total")+"\" }, \"geometry\" : "+item.get("geometry")+ " } ] }\n" ;  
	        setCache("/map/popuSeoulLv "+paraBus.getString("power"), result);
		}
		
		// result = result.replaceAll("'", "\"");
		System.out.println("result");
		response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        return null;
	}


	@RequestMapping(value = "/map/test")
	public String  test(Bus paraBus, HttpServletRequest request, HttpServletResponse response) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		log.info("HouseController.houseLv ");
		
		
		
			List<UnderBus> list = null;
			list = service.getTest(paraBus);
			PrintWriter writer = new PrintWriter("/Users/pump/temp/the-file-name.txt", "UTF-8");

			
			String name;
			String code;
			String geo;
			int ind;
			int pnd;
			String op[];
			for( int i = 0 ; i<list.size(); i++){
				Bus item = (Bus)list.get(i);
				name = item.getString("name");
				code = item.getString("code");
				geo = item.getString("geometry");
				ind = geo.indexOf("nates>");
				geo = geo.substring(ind+6, geo.length());
				pnd = geo.indexOf("</coordi");
				if (pnd > 0){
					geo = geo.substring(0, pnd);
				}
				System.out.println(name+", "+code+", "+geo);
				op = geo.split(" ");
				for (int p = 0; p < op.length; p++){
					writer.println(name+", "+code+", "+ p+", "+op[p]);
				}
			}
		
			writer.close();
        return null;
	}

	@RequestMapping(value = "/map/kmlPull")
	public String  test2(Bus paraBus, HttpServletRequest request, HttpServletResponse response) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		log.info("HouseController.houseLv ");
		
		
			//FileReader reader = new FileReader("/Users/pump/temp/11_sigungun_2p.json");

			BufferedReader br = new BufferedReader(new FileReader("/Users/pump/temp/11_sigungun_2p.json"));
			String everything;
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();

		        while (line != null) {
		            sb.append(line);
		            sb.append("\n");
		            line = br.readLine();
		        }
		        everything = sb.toString();
		    } finally {
		        br.close();
		    }
			
			System.out.println(everything);
			response.setCharacterEncoding("UTF-8");
	        PrintWriter out = response.getWriter();
	        out.print(everything);
	        out.flush();
        return null;
	}


	
}
