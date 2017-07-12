package com.ziumks.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

  public static void main(String[] args) {
  /*
   * call method and pass as an argument path of excel file to read.
   * Please make sure path of excel file is correct otherwise it will
   * throw FileNotFound Exception.
   */
  InputStream inputStream = null;
  try {
              InputStream ex = new FileInputStream("D:" + File.separator + "home"
                                      + File.separator + "proj_up.xls");
              ExcelReader el = new ExcelReader();
              List<Map<Integer,String>> list = el.readExcel(ex);
              
              int row = 0;
              for ( Map<Integer,String> para : list){
            	  System.out.println("============================== row is " + row++);
            	  for ( int i = 0; i <42 ; i++ ){
            		  System.out.println(""+i);
            		  System.out.println(para.get(i));
            	  }
            	  
              }
              
              
  } catch (Exception e) {
              e.printStackTrace();
  } finally {
              /*
               * Close File Input Stream
               */
              try {
                          if (inputStream != null) {
                                      inputStream.close();
                          }
              } catch (IOException ex) {
                          ex.printStackTrace();
              }
  }

}	
	
	

	
	
    // Excel 97~2003(.xls) 파일처리
    public List<Map<Integer,String>> readExcel( InputStream excel ) throws IOException, InvalidFormatException {
        // check file
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:MM:ss");
        
        // http://poi.apache.org/apidocs/index.html?overview-summary.html
        // http://poi.apache.org/apidocs/org/apache/poi/hssf/usermodel/HSSFWorkbook.html
        
        List<Map<Integer,String>> list = new ArrayList<Map<Integer,String>>();
        
        
        
        
        Workbook wb = WorkbookFactory.create(excel);
        try {
            for( int i=0; i<wb.getNumberOfSheets(); i++ ) {
                for( Row row : wb.getSheetAt(i) ) {
                	Map<Integer, String> para = new HashMap<Integer, String>();
                    for( Cell cell : row ) {
                    	
                    	Integer ind = cell.getColumnIndex();
                        switch( cell.getCellType() ) {
                            case HSSFCell.CELL_TYPE_STRING:
                                para.put(ind,  cell.getRichStringCellValue().getString() );
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                if( HSSFDateUtil.isCellDateFormatted(cell) ) {
                                    java.util.Date dateValue = cell.getDateCellValue();
                                    Integer year = dateValue.getYear(); // or getYear
                                    if (year != -1) para.put(ind,  dateFormat.format(dateValue) );
                                    else para.put(ind,  timeFormat.format(dateValue) );
                                }
                                else {
                                    para.put(ind,  ""+Double.valueOf( cell.getNumericCellValue() ).intValue() );
                                }
                                break;
                            case HSSFCell.CELL_TYPE_FORMULA:
                                // cell.getCellFormula();  
                            	break;
                            case HSSFCell.CELL_TYPE_BOOLEAN:
                                // cell.getBooleanCellValue();  
                            	break;
                            case HSSFCell.CELL_TYPE_ERROR:
                                para.put(ind,  "ERROR_"+ cell.getErrorCellValue());  
                                break;
                            case HSSFCell.CELL_TYPE_BLANK: 
                            	para.put(ind, "");
                            	break;
                            default: break;
                        }
                    }
                    list.add(para);
                }
            }
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
        return list;
    }
    
	
	
}
