package com.ziumks.common.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 공통적으로 필요한 숫자관련 유틸리티
 */
public class NumberUtil
{
	/**
	 * 주어진 숫자를 주어진 조건에 따라 포멧팅된 String 을 구함.
	 * <pre>
	 * (예)
	 *	double num = 123456.70;
	 *	String str = NumberUtil.formatNumber(num,7,1,2,2,true);
	 *	<< str = "123,456.70" >>
	 *
	 *	double num = 123456.70;
	 *	String str = NumberUtil.formatNumber(num,7,7,2,1,true);
	 *	<< str = "0,123,456.70" >>
	 *
	 *	double num = 123456.70;
	 *	String str = NumberUtil.formatNumber(num,7,7,1,1,true);
	 *	<< str = "0,123,456.7" >>
	 *
	 * </pre>
	 * @param num 대상 숫자값
	 * @param maxIntegerDigits 정수부 최대 자릿수
	 * @param minIntegerDigits 정수부 최소 자릿수
	 * @param maxFractionDigits 소수부 최대 자릿수
	 * @param minFractionDigits 소수부 최소 자릿수
	 * @param groupingUsed 콤마 사용여부
	 * @return 포멧딩된 숫자
	 */
	public static String formatNumber(double num, 
	                               int maxIntegerDigits, int minIntegerDigits, 
	                               int maxFractionDigits, int minFractionDigits, 
	                               boolean groupingUsed){
		NumberFormat myFormat = NumberFormat.getInstance();
		myFormat.setMaximumIntegerDigits(maxIntegerDigits);
		myFormat.setMinimumIntegerDigits(minIntegerDigits);
		myFormat.setMaximumFractionDigits(maxFractionDigits);
		myFormat.setMinimumFractionDigits(maxFractionDigits);
		myFormat.setGroupingUsed(groupingUsed);
		return myFormat.format(num);
	}

	/**
	 * 주어진 숫자를 주어진 패턴에 따라 포멧팅된 String 을 구함.
	 * <pre>
	 * (예)
	 *	double num = 123456.70;
	 *	String str = NumberUtil.formatNumber(num,"#,##0.00");
	 *	<< str = "123,456.70" >>
	 * </pre>
	 * @param num 대상 숫자값
	 * @param pattern 페턴, 페턴에 대한 자세한 내용은 java.text.DecimalFormat API 문서를 참조
	 * @return 포멧딩된 숫자
	 */
	public static String formatNumber(double num, String pattern){
		DecimalFormat myFormat = new DecimalFormat(pattern);
		return myFormat.format(num);
	}
	
	public static String formatNumber(String num, String pattern){
		try{
			double db = Double.parseDouble(num);
			DecimalFormat myFormat = new DecimalFormat(pattern);
			return myFormat.format(db);
		}catch(Exception e){
			//System.out.println(e);
			return "";
		}
		
	}

	/**
	 * 주어진 숫자를 가지고 주어진 길이만큼의 문자열을 생성.
	 * <pre>
	 * (예)
	 *	double num = 123;
	 *	System.out.println(NumberUtil.fitNumber(num,7,2));
	 *	출력 = "00123.00"
	 *
	 *	double num = 123.45;
	 *	System.out.println(NumberUtil.fitNumber(num,6,4));
	 *	출력 = "23.4500"
	 * </pre>
	 * @param num 대상 숫자값(String형)
	 * @param size 숫자의 길이, 오라클의 Number type 길이 정의방법과 
	 *              동일함, 문자열 type 임
	 * @return 포멧딩된 숫자
	 */
	public static String fitNumber(double num, int totDigits, 
		int frctDigits) throws Exception {
			
		if (totDigits < frctDigits){
			throw new Exception("invalid parameter value (totDigits < frctDigits)");
		}
		int intDigits = totDigits - frctDigits;
		return formatNumber(num, intDigits, intDigits, 
							 frctDigits, frctDigits, false);
	}

	/**
	 * 주어진 문자열 값이 정수값인지 검증.
	 * <pre>
	 * (예)
	 *	String num = "123";
	 *	System.out.println(NumberUtil.isInteger(num));
	 *	출력 = "true"
	 *
	 *	String num = "abc";
	 *	System.out.println(NumberUtil.isInteger(num));
	 *	출력 = "false"
	 * </pre>
	 * @param value 검증할 문자열
	 * @return 정수이면 true, 아니면 false
	 */
	public static boolean isInteger(String value){
		try{
			new Integer(value);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * 주어진 문자열 값이 실수값인지 검증.
	 * <p>
	 * <pre>
	 * (예)
	 *	String num = "123.45";
	 *	System.out.println(NumberUtil.isDouble(num));
	 *	출력 = "true"
	 *
	 *	String num = "abc";
	 *	System.out.println(NumberUtil.isDouble(num));
	 *	출력 = "false"
	 * </pre>
	 * @param value 검증할 문자열
	 * @return 실수이면 true, 아니면 false
	 */
	public static boolean isDouble(String value){
		try{
			new Double(value);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public static long toLong(Long value) {
		return value.longValue();
	}

	public static int toInt (Integer value) {
		return value.intValue();
	}
	
	
	public static int totalPage( int totalcount, int pagesize){
		return totalcount % pagesize == 0? totalcount/pagesize : totalcount/pagesize +1;
	}
	
}
