package com.ziumks.common.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class TestRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List oo = Settings.get("COM013");
		System.out.println(oo);
		Iterator it = oo.iterator();
		while(it.hasNext()){
			String para[] = (String[])it.next();
			System.out.println("output is [" + para[0] + "] value [" + para[1] + "]");
		}
	}
}


///* excel sample for test*/
//
//public class ExcelReader {
//    public void readExcel(InputStream myxls) {
//                try {
//                            /* 
//                             * Declare Excel Sheet Variables 
//                             */
//                            HSSFWorkbook workbook = new HSSFWorkbook(myxls);
//                            HSSFRow row;
//                            HSSFCell cell;
//
//                            if (workbook != null) {
//                                        HSSFSheet sheet = workbook.getSheetAt(0);
//                                        int noOfRows = sheet.getPhysicalNumberOfRows();
//                                        HSSFCell nameCell = null, designationCell = null;
//                                        HSSFCell countryCell = null;
//                                        HSSFCell dobCell = null, salaryCell = null;
//                                        String name = "", designation = "", country = "";
//                                        String dob = "", salary = "";
//                                        for (int i = 1; i < noOfRows; i++) {
//                                                    row = sheet.getRow(i);
//                                                    nameCell = row.getCell(0);
//                                                    designationCell = row.getCell(1);
//                                                    countryCell = row.getCell(2);
//                                                    dobCell = row.getCell(3);
//                                                    salaryCell = row.getCell(4);
//
//                                                    /* 
//                                                     * Get Cell Value 
//                                                     */
//                                                    name = this.getValue(nameCell, 
//                                                          nameCell.getCellType(),"name");
//
//                                                    designation = this.getValue(designationCell,
//                                                          designationCell.getCellType(), "designation");
//
//                                                    country = this.getValue(countryCell, 
//                                                          countryCell.getCellType(), "country");
//
//                                                    dob = this.getValue(dobCell, 
//                                                          dobCell.getCellType(), "dob");
//
//                                                    salary = this.getValue(salaryCell,
//                                                                            salaryCell.getCellType(), "salary");
//
//                                                    System.out.println("name :" + name);
//                                                    System.out.println("designation :" + designation);
//                                                    System.out.println("country :" + country);
//                                                    System.out.println("dob :" + dob);
//                                                    System.out.println("salary :" + salary);
//                                        }
//                            } else {
//                                        System.out.println("Could not read the Excel File.");
//                            }
//                } catch (Exception e) {
//                            e.printStackTrace();
//                }
//    }
//
//    public static String toDDMonYYYY(Date date) {
//                if (date == null)
//                            return "";
//                Calendar cal = new GregorianCalendar();
//                cal.setTime(date);
//                return "" + cal.get(Calendar.DAY_OF_MONTH) + "-"
//                                        + getMonShortName(cal.get(Calendar.MONTH)) + "-"
//                                        + cal.get(Calendar.YEAR);
//    }
//
//    public String getValue(HSSFCell cell_name, int celltype, String cellInfo) {
//                String cell_value = "";
//                switch (celltype) {
//                case HSSFCell.CELL_TYPE_NUMERIC:
//                            if ("dob".equals(cellInfo)) {
//                                        cell_value = toDDMonYYYY(cell_name.getDateCellValue());
//                            } else {
//                                        cell_value = String.valueOf(cell_name.getNumericCellValue());
//                            }
//                            break;
//                case HSSFCell.CELL_TYPE_STRING:
//                            cell_value = String.valueOf(
//                               cell_name.getRichStringCellValue().toString()).replaceAll(
//                                                    ",", "").trim();
//                            break;
//                case HSSFCell.CELL_TYPE_BLANK:
//                            cell_value = "";
//                            break;
//                default:
//                            cell_value = "";
//                }
//                return cell_value;
//    }
//
//    public static String getMonShortName(int month) {
//                String mon = "";
//                switch (month) {
//                case Calendar.JANUARY:
//                            mon = "Jan";
//                            break;
//                case Calendar.FEBRUARY:
//                            mon = "Feb";
//                            break;
//                case Calendar.MARCH:
//                            mon = "Mar";
//                            break;
//                case Calendar.APRIL:
//                            mon = "Apr";
//                            break;
//                case Calendar.MAY:
//                            mon = "May";
//                            break;
//                case Calendar.JUNE:
//                            mon = "Jun";
//                            break;
//                case Calendar.JULY:
//                            mon = "Jul";
//                            break;
//                case Calendar.AUGUST:
//                            mon = "Aug";
//                            break;
//                case Calendar.SEPTEMBER:
//                            mon = "Sep";
//                            break;
//                case Calendar.OCTOBER:
//                            mon = "Oct";
//                            break;
//                case Calendar.NOVEMBER:
//                            mon = "Nov";
//                            break;
//                case Calendar.DECEMBER:
//                            mon = "Dec";
//                            break;
//                }
//                return mon;
//    }
//
//    public static void main(String[] args) {
//                /*
//                 * call method and pass as an argument path of excel file to read.
//                 * Please make sure path of excel file is correct otherwise it will
//                 * throw FileNotFound Exception.
//                 */
//                InputStream inputStream = null;
//                try {
//                            inputStream = new FileInputStream("C:" + File.separator + "files"
//                                                    + File.separator + "SampleExcel.xls");
//                            new ExcelReader().readExcel(inputStream);
//                } catch (Exception e) {
//                            e.printStackTrace();
//                } finally {
//                            /*
//                             * Close File Input Stream
//                             */
//                            try {
//                                        if (inputStream != null) {
//                                                    inputStream.close();
//                                        }
//                            } catch (IOException ex) {
//                                        ex.printStackTrace();
//                            }
//                }
//
//    }
//}
//

