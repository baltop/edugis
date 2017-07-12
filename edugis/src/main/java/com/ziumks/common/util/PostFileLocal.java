package com.ziumks.common.util;


import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;



/**
 * 아래 샘플 테스트 후에 서버에 적용
 * pom.xml 파일에 아래와 같이 httpclient 4.2.1 버전과  httpmime 4.2.1 버전을 추가.
 * httpclient는 버전간 변경사항이 극심하므로 버전을 꼭 확인 할 것. 
 * 메이븐 기반 개발이 아닌 경우는 위 두개의 파일을 아파치 사이트에서 다운로드하여
 * classpath 에 추가 할 것. 
 * @author ardent  20131010
 */

/*
<dependency>
<groupId>org.apache.httpcomponents</groupId>
<artifactId>httpclient</artifactId>
<version>4.2.1</version>
</dependency>

<dependency>
<groupId>org.apache.httpcomponents</groupId>
<artifactId>httpmime</artifactId>
<version>4.2.1</version>
</dependency>
*/

public class PostFileLocal {


	public static void main(String[] args) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		httpclient.getParams().setParameter("http.protocol.content-charset", "UTF-8");

		
		// 서버 접속주소.
		HttpPost httppost = new HttpPost("http://127.0.0.1:8080/pms/saveProj.do");
		
		MultipartEntity mpEntity = new MultipartEntity();
		
		// 첫번째 첨부파일
		File file = new File("d:/도움말.png");
		// 한글파일명이 깨지지 않게 하려면 URLEncoder 사용. 서버에서 파일명을 꺼낸 후에 URLDecoder.decode( filename)
		String filename = URLEncoder.encode(file.getName());
		ContentBody cbFile = new FileBody(file, filename, "application/vnd.ms-excel", "UTF-8");
		// 스프링3.0 이전 버전은 같은 파일인풋에 여러파일 첨부하면 에러남.  file_0, file_1 하는 식으로 증가 시켜야함.
		mpEntity.addPart("file_0", cbFile);

		// 두번째 첨부파일
		File file2 = new File("d:/코마tus.png");
		String filename2 = URLEncoder.encode(file2.getName());
		ContentBody cbFile2 = new FileBody(file2, filename2, "application/vnd.ms-excel", "UTF-8");
		mpEntity.addPart("file_1", cbFile2);
		
		// 요청게시판에 파일은 열개까지 추가가능함. 
		// eams 요청게시판은 전자정부프레임워크 스프링2.5로 개발되어 있으니 위와 같이 file_0, file_1,,, 식으로 증가해서 
		// 파일을 첨부해야 함.
		
		// 요청게시판의 제목
		ContentBody mgmtName = new StringBody("A binary file 한글이 잘 되나 of some kind", Charset.forName("UTF-8"));
		mpEntity.addPart("mgmtName", mgmtName);

		// 요청게시판의 내용
		ContentBody mgmtDesc = new StringBody("요청게시판의 내용을 여기에 추가합니다.", Charset.forName("UTF-8"));
		mpEntity.addPart("mgmtDesc", mgmtDesc);
		
		// 요청게시판의 등록자 사번
		ContentBody registerUser = new StringBody("039281726", Charset.forName("UTF-8"));
		mpEntity.addPart("registerUser", registerUser);
		
		
		httppost.setEntity(mpEntity);

		System.out.println("executing request " + httppost.getRequestLine());
		
		ResponseHandler<String> handler = new BasicResponseHandler();
		HttpResponse response = httpclient.execute(httppost);
		
		String body = handler.handleResponse(response);
		int code = response.getStatusLine().getStatusCode();
		
		System.out.println("response code is [" +code+"]");
		System.out.println("response body is [" +body+"]");
		
		try {
			HttpEntity resEntity = response.getEntity();

			System.out.println(response.getStatusLine());
			
			if (resEntity != null) {
				System.out.println(EntityUtils.toString(resEntity));

				resEntity.consumeContent();
			}
		} finally {
			httppost.releaseConnection();
		}
		httpclient.getConnectionManager().shutdown();
	}

 
}