/**
 * Copyright 2012 baltop.
 * Copyright 2012 uroinstruments co., ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ziumks.common.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.ziumks.common.base.Bus;
import com.ziumks.common.base.EaSqlConfig;
import com.ziumks.common.base.UnderBus;

public class Settings {

	private static final class SingletonHolder {
		static final Settings singleton = new Settings();
	}

	public static Settings getInstance() {
		return SingletonHolder.singleton;
	}

	private Settings() {
	};

	static HashMap<String, List<String[]>> data;

	static int p = 0;
	static List<UnderBus> qlist;

	static {
		getInstance();
		load();
	}

	public static void load() {

		try {
			qlist = (List<UnderBus>) EaSqlConfig.getSqlMapInstance().queryForList("system.allCode");
			HashMap<String, List<String[]>> total = new HashMap<String, List<String[]>>();
			String prevGroup = "";
			List<String[]> sub = new ArrayList<String[]>();
			for (UnderBus r : qlist) {


				String group = (String) r.get("code_id");
				if (!group.equals(prevGroup)) {
					sub = new ArrayList<String[]>();
					String[] item = new String[3];
					item[0] = (String) r.get("code");
					item[1] = (String) r.get("code_name");
					item[2] = (String) r.get("use_yn");

					sub.add(item);
					total.put(group, sub);

				}
				else {
					String[] item = new String[3];
					item[0] = (String) r.get("code");
					item[1] = (String) r.get("code_name");
					item[2] = (String) r.get("use_yn");
					sub.add(item);
				}
				prevGroup = group;
			}
			data = total;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	public static Map<String, Integer> sortByValue(Map<String, Integer> map) {
	    List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

	    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

	        public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
	            return (m2.getValue()).compareTo(m1.getValue());
	        }
	    });

	    Map<String, Integer> result = new LinkedHashMap<String, Integer>();
	    for (Map.Entry<String, Integer> entry : list) {
	        result.put(entry.getKey(), entry.getValue());
	    }
	    return result;
	}
	*/

	public static void out() {
		List<String[]> pop = (List<String[]>) data.get("COM013");
		System.out.println("StaticHelperClass [" + pop + "]");
		System.out.println("StaticHelperClass [" + p++ + "]");
		System.out.println("StaticHelperClass [" + qlist.get(0) + "]");

	}

	public static List<String[]> get(String code) {
		if (data == null || data.get(code) == null) {
			return null;
		}
		return (List<String[]>) data.get(code);
	}

	public static String getValue(String code, String key) {
		if (data == null || data.get(code) == null) {
			return "해당코드가 없습니다.";
		}
		List<String[]> temp = (List<String[]>) data.get(code);

		Iterator<String[]> it = temp.iterator();
		while (it.hasNext()) {
			String[] item = it.next();

			if (item[0].equals(key)) {
				return item[1];
			}
		}

		return "코드는 있으나 키가 없습니다.";
	}
	public static String getValue2(String code, String key) {
		if (data == null || data.get(code) == null) {
			return "해당코드가 없습니다.";
		}
		List<String[]> temp = (List<String[]>) data.get(code);

		Iterator<String[]> it = temp.iterator();
		while (it.hasNext()) {
			String[] item = it.next();

			if (item[0].equals(key)) {
				return item[1];
			}
		}

		return "";
	}
	/*
	 * 코드값을 밸류값으로 바꾸어준다.  
	 * list :  디비에서 가져온 리스트
	 * code : code_id
	 * param : 디비필드명 즉 리스트안의 아이템안의 key
	 */
	@SuppressWarnings("rawtypes")
	public static List keyToValue(List list, String code, String param) {
		if (list == null) {
			return null;
		}
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Bus temp = (Bus) it.next();
			try {
				temp.put("tr_" + param,
				        Settings.getValue2(code, "" + temp.get(param)));
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return list;
	}
	

	public static Bus keyToValue(Bus temp, String code, String param) {

			try {
				temp.put("tr_" + param,
				        Settings.getValue(code, "" + temp.get(param)));
			} catch (Exception e) {
				e.printStackTrace();

			}
			return temp;
	}

}
