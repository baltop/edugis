/**
 * Created on Dec 19, 2011
 *
 * Copyright 2011 Kim Hyon-Sok. All rights reserved.
 * PRIVATE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ziumks.common.util;

import java.util.List;

/**
 * 지정하지 않으면 아래 디폴트 값으로 셋팅됨.
 * setDataList는 반드시 set해야 함.
 * 엑셀파일 기본값. 디폴드: fileName - data.xls, startRow - 2, startCol - 1
 * 
 * @author baltop@gmail.c
 */
@SuppressWarnings("rawtypes")
public class ExcelData {
	

	
	private String template = "blank.xls";
	private String sheetName = "sheet1";
	private String fileName = "data";

	private int startRow = 2;
	private int startCol = 1;
	private String items = "";

	private List dataList;
	// 미구현 
	private String[][] header;
	
	public ExcelData(){
		
	}
	
	public ExcelData( String outFileName, String templateName, int startRow, int startCol){
		this.fileName = outFileName;
		this.template = templateName;
		this.startRow = startRow;
		this.startCol = startCol;
	}
	
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String[][] getHeader() {
		return header;
	}
	public void setHeader(String[][] header) {
		this.header = header;
	}
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getStartRow() {
		if( startRow < 1) startRow = 1;
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getStartCol() {
		if(startCol < 1) startCol = 1;
		return startCol;
	}
	public void setStartCol(int startCol) {
		this.startCol = startCol;
	}
	public List getDataList() {
		return dataList;
	}
	public void setDataList(List dataList) {
		this.dataList = dataList;
	}
}
