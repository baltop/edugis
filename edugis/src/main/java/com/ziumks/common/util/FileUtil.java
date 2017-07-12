/**
 * Created on Dec 19, 2011
 *
 * Copyright 2011 Kim Hyon-Sok. All rights reserved.
 * PRIVATE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ziumks.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 * File Managing 및 File I/O 관련 유틸리티 메소드 모음
 */
public class FileUtil {

	/**
	 * 지정한 파일의 BufferedReader 를 생성하여 리턴함.
	 * 
	 * @param fileName
	 * @return BufferedInputStream
	 */
	public static BufferedInputStream getBufferedStream(String fileName) throws IOException{
		return new BufferedInputStream(new FileInputStream(fileName));
	}

	/**
	 * 지정한 파일의 PrintStream 를 생성하여 리턴함.
	 * 
	 * @param fileName
	 * @param append
	 * @return PrintStream
	 */
	public static PrintStream getPrintStream(String fileName, boolean append) throws IOException{
		return new PrintStream(new FileOutputStream(fileName,append));
	}

	/**
	 * 지정한 파일의 Text Data 를 String 으로 만들어 리턴함.
	 * 
	 * @param fileName
	 * @return String
	 */
	public static String getTextData(String fileName) throws IOException{
		BufferedInputStream rd = getBufferedStream(fileName);
		StringBuffer sb = new StringBuffer();
		int c = 0;
		while ((c = rd.read()) != -1) {
			sb.append((char)c);
		}
		
		rd.close();
		return sb.toString();
	}
	
	/**
	 * Encoding 변환으로 파일을 생성한다.
	 * @param fileName
	 * @param text
	 * @throws IOException
	 */
	public static void setTextData(String fileName, String text) throws IOException {
		setTextData(fileName, text, "EUC-KR");
	}
	
	/**
	 * 파일에 데이터를 기록한다.
	 * @param fileName 파일명
	 * @param text 기록할 데이터
	 * @throws IOException
	 */
	public static void setTextData(String fileName, String text, String encoding) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), encoding));
		
		try {
			bw.write(text);
		} catch (IOException ie) {
			
		} finally {
			bw.flush();
			bw.close();
		}
	}
	
	/**
	 * 상대 경로에 있는 파일을 읽어온다.
	 * @param fileName 상대 경로에 해당되는 파일명
	 * @return 파일 내용을 읽어온 정보
	 * @throws IOException
	 */
	public static String getFileTextByAbstract(String fileName) throws IOException {
		StringBuffer str = new StringBuffer();

		try {
			InputStream inputStream =
				FileUtil.class.getResourceAsStream(fileName);
	
			BufferedReader input =
				new BufferedReader(new InputStreamReader(inputStream));
	
			String strLine;
			
			while ((strLine = input.readLine()) != null) {
				str.append(strLine);
				str.append("\n");
			}
			
			if (input != null)
				input.close();
			if (inputStream != null)
				inputStream.close();
		} catch (IOException ie) {
			throw ie;	
		}
		
		return str.toString();
	}
	
	/**
	 * 파일 복사
	 * @param source
	 * @param target
	 * @throws IOException
	 */
	public static void copyFile(String source, String target) throws IOException {
	    File file = new File(source);
	    byte[] buf = new byte[(int) file.length()];
	    
	    FileInputStream fis = new FileInputStream(file);
	    
	    int i = 0, j = 0;
	    while ((i = fis.read()) != -1) {
	        buf[j] = (byte) i;
	        j++;
	    }
	    fis.close();

	    FileOutputStream fos = new FileOutputStream(target);
	    fos.write(buf);
	    fos.close();
	}	
	
	/**
	 * 폴더 및 하위 파일 모두 복사한다. (단, 폴더 내부의 폴더는 복사하지 않는다.)
	 * @param source
	 * @param target
	 * @param folderName
	 * @throws IOException
	 */
	public static void copyFolder(String source, String target, String folderName) throws IOException {
		String srcPath = source + File.separator + folderName;
		String tarPath = target + File.separator + folderName;
		
		File file = new File(srcPath);
		if (file.isDirectory()) {
			File[] subFiles = file.listFiles();
			
			if (subFiles.length > 0) {
				File tarDir = new File(tarPath);
				
				if (!tarDir.exists()) tarDir.mkdirs();
				for (int i = 0; i < subFiles.length; i++) {
					copyFile(srcPath + File.separator + subFiles[i].getName(),
							tarPath + File.separator + subFiles[i].getName());
				}
			}
		}
	}
	
	/**
	 * 폴더 및 폴더 내부의 파일을 복사한다.
	 * @param source
	 * @param target
	 * @throws IOException
	 */
	public static void copyFolder(String source, String target) throws IOException {
		File src = new File(source);
		File[] subs = src.listFiles();
		
		try {
			if (subs.length > 0) {
				for (int i = 0; i < subs.length; i++) {
					String targetFile = target + File.separator + subs[i].getName();
					
					if (subs[i].isDirectory()) {
						File tar = new File(targetFile);
						tar.mkdirs();
						copyFolder(subs[i].toString(), targetFile);
					} else {
						copyFile(subs[i].toString(), targetFile);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 폴더를 삭제한다.
	 * @param folder
	 * @throws IOException
	 */
	public static void removeFolder(String folder) throws IOException {
		File dir = new File (folder);
		
		if (dir.isDirectory()) {
			File[] subFiles = dir.listFiles();
			
			if (subFiles.length == 0) {
				dir.delete();
			}
		}
	}
}