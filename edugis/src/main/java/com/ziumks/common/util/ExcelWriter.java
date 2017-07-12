/**
 * Created on Dec 19, 2011
 *
 * Copyright 2011 Kim Hyon-Sok. All rights reserved.
 * PRIVATE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ziumks.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 * Writes the report to the output stream
 * 
 * @author khs
 */
public class ExcelWriter {

	// private static Logger logger = Logger.getLogger(ExcelWriter.class);
	

	@SuppressWarnings("rawtypes")
	public  void write(HttpServletRequest request, HttpServletResponse response, ExcelData data) throws IOException {
		
		InputStream fis = ExcelWriter.class.getResourceAsStream("/excel/"+data.getTemplate());
		if( fis == null ) {
			fis = ExcelWriter.class.getResourceAsStream("/excel/blank.xls");
		}
		HSSFWorkbook wb = new HSSFWorkbook(fis);        
		fis.close();

		HSSFSheet worksheet = wb.getSheetAt(0);
		
		int startRowIndex = data.getStartRow()-1;
		int startColIndex = data.getStartCol()-1;
		// Create cell style for the body
		HSSFCellStyle bodyCellStyleCenter = worksheet.getWorkbook().createCellStyle();
		bodyCellStyleCenter.setAlignment(CellStyle.ALIGN_CENTER);
		bodyCellStyleCenter.setWrapText(true);
		
		HSSFCellStyle bodyCellStyleLeft = worksheet.getWorkbook().createCellStyle();
		bodyCellStyleLeft.setAlignment(CellStyle.ALIGN_LEFT);
		bodyCellStyleLeft.setWrapText(true);
		
		String str = data.getItems();
		// space가 몇개이던 상관없이 스페이스, 스페이스인 경우.  자른 후에 트림할 필요가 없도록 하기 위해 
		List<String> items = Arrays.asList(str.split("\\s*,\\s*"));		
		
		
		List datasource = data.getDataList();
		
		int i=startRowIndex; 
		
		Iterator it = datasource.iterator();
		
		// 리펙토링 필요. 겁나 느릴것 같은 instanceof의 반복 사용을 수정할 방안?
		while ( it.hasNext()){
			Map dataItem = (Map)it.next();
			HSSFRow row = worksheet.createRow((short) i);
			for( int j = 0; j < items.size(); j++){
				HSSFCell cell1 = row.createCell(startColIndex+j);
				Object obj = dataItem.get(items.get(j));
				if(obj instanceof String) {
					cell1.setCellValue( (String)obj);
					cell1.setCellStyle(bodyCellStyleLeft);
				}
				else if ( obj instanceof BigDecimal){
					cell1.setCellValue( ((BigDecimal)obj).doubleValue() );
				}
				else if ( obj instanceof Integer ){
					cell1.setCellValue( ((Integer)obj).doubleValue() );
				}
				else if ( obj instanceof Double){
					cell1.setCellValue( ((Double)obj).doubleValue() );
				}
				else if ( obj instanceof Long ){
					cell1.setCellValue( ((Long)obj).doubleValue() );
				}
				else if ( obj instanceof Float ){
					cell1.setCellValue( ((Float)obj).doubleValue() );
				}
				else if ( obj instanceof java.sql.Date ){
					cell1.setCellValue( ((java.util.Date)obj) );
					cell1.setCellStyle(bodyCellStyleCenter);
				}
			}
			i++;
		}
		
	

			
			//  http://omnibuscode.com/xe/6209
			
			String browser = getBrowser(request);
			
			// 귀찮으면 IE만 지원하고 그럴경우에 써라.
			//fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
			//response.setHeader("Content-Disposition", "inline; filename=" + fileName);
			response.setHeader("Content-Disposition", getDisposition(data.getFileName()+".xls", browser)); 
			// Make sure to set the correct content type
			response.setContentType("application/vnd.ms-excel");
			//response.setContentType("TEXT/HTML; charset=KSC5601");
			//7. Write to the output stream
			// Retrieve the output stream
			ServletOutputStream outputStream = response.getOutputStream();
			// Write to the output stream
			worksheet.getWorkbook().write(outputStream);
			// Flush the stream
			outputStream.flush();


	}
	
    private static String getBrowser(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        if (header.indexOf("MSIE") > -1) {
            return "MSIE";
        } else if (header.indexOf("Chrome") > -1) {
            return "Chrome";
        } else if (header.indexOf("Opera") > -1) {
            return "Opera";
        }
        return "Firefox";
    }
    
    private static String getDisposition(String filename, String browser) throws UnsupportedEncodingException{
        String dispositionPrefix = "attachment;filename=";
        String encodedFilename = null;
        if (browser.equals("MSIE")) {
            encodedFilename = URLEncoder.encode(filename, "UTF-8")
                    .replaceAll("\\+", "%20");
        } else if (browser.equals("Firefox")) {
            encodedFilename =
         "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
        } else if (browser.equals("Opera")) {
            encodedFilename =
         "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
        } else if (browser.equals("Chrome")) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < filename.length(); i++) {
                char c = filename.charAt(i);
                if (c > '~') {
                    sb.append(URLEncoder.encode("" + c, "UTF-8"));
                } else {
                    sb.append(c);
                }
            }
            encodedFilename = sb.toString();
        } else {
            throw new RuntimeException("Not supported browser");
        }
        return dispositionPrefix + encodedFilename;
    }
}
