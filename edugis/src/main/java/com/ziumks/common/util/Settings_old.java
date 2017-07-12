package com.ziumks.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 프로퍼티에 대한 유티리티 클래스
 * 
 * @author 김현석
 * 
 */
public class Settings_old implements FileChangeListener {

	private static String propFile = "eams.properties";

	private transient static Log log = LogFactory.getLog(Settings_old.class);

	private static Settings_old instance;

	private long checkPeriod = 2000;

	private Properties base = new Properties();

	public static String get(String key) {
		// convenience method as shortcut for:
		return Hangul.convertUTF(getInstance().getSetting(key)).trim();
	}

	public static String get(String key, String def) {
		// convenience method as shortcut for:
		if (getInstance().getSetting(key) == null) {
			return def;
		}
		return Hangul.convertUTF(getInstance().getSetting(key));
	}

	public synchronized static Settings_old refresh() {
		instance = null;
		return getInstance();

	}

	private Settings_old() {
		// private constructor
	}

	private Settings_old(String baseFile) throws IOException {
		// needed???
		load(baseFile);

	}

	public synchronized static Settings_old getInstance() {
		if (instance == null) {
			try {

				instance = new Settings_old(propFile);
				

			} catch (IOException e) {
				log.debug(e.toString());
			}
		}
		return instance;
	}

	public synchronized void load(String name) throws IOException {
		InputStream is = null;

		try {
//			if (log.isTraceEnabled()) {
//				log.trace("  Loading resource '" + name + "'");
//			}
//			ClassLoader classLoader = Thread.currentThread()
//					.getContextClassLoader();
//			if (classLoader == null) {
//			
			ClassLoader classLoader = this.getClass().getClassLoader();
			
			is = classLoader.getResourceAsStream(name);
			if (is != null) {

				base.load(is);
				is.close();

			}
			setCheckPeriod();
			if (log.isTraceEnabled()) {
				log.trace("  Loading resource completed");
			}
		} catch (Throwable t) {
			log.error("loadLocale()", t);
			if (is != null) {
				try {
					is.close();
				} catch (Throwable u) {

				}
			}
		}

	}

	public String getSetting(String key) {

		String value = null;

		value = base.getProperty(key);
		return value;
	}

	public void fileChanged(String fileName) {
		try {
			load(propFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized void setCheckPeriod() {

		// 리로드를 할려면 톰갯의 리로드옵션을 false로 한 후 프로덕션 모드에서 아래 코멘트를 지우세요.
		
//		try {
//			FileMonitor.getInstance().addFileChangeListener(this, propFile,
//					checkPeriod);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
	}

	public static void main(String[] args) {
		// testing main
		System.out.println("start");
		getInstance();

		System.out.println("test value:"
				+ Settings_old.getInstance().getSetting("eams.user.pro"));
	}

}
