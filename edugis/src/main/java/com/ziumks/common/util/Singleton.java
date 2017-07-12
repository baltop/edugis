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

import java.util.HashMap;
import java.util.Map;


// http://dojeun.egloos.com/317858
// http://www.javaservice.net/~java/bbs/read.cgi?m=devtip&b=javatip&c=r_p&n=1028393658
/* * final 키워드를 사용하여 이 클래스로부터 상속이 불가능하도록 하였다. */
public final class Singleton {
	
	private Singleton() {
		load();
	}

	public static Singleton getInstance() {
		return SingletonHolder.singleton;
	}
	
	int p = 0;
	public static void out(){
		System.out.println("Singleton out!!!! ["+ Singleton.getInstance().p+"]");
		Singleton.getInstance().p++;
	}
	
	Map upMap = new HashMap();
	
	
	void load(){
		p=100;
	}
	
	
	// static inner class (여기도 final 키워드 사용) 를 사용하여 Singleton 클래스의
	// 객체를 생성함
	private static final class SingletonHolder {
		// 역시 이 내부에서도 static final 키워드 사용
		static final Singleton singleton = new Singleton();
	}


	
	
}
