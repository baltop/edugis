package com.ziumks.common.util;

import java.io.File;
import java.io.InputStream;
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
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;

public class PostFile {

	/*
	 * httpClient 4.3 이전 방식
	 */
	public static void main(String[] args) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		httpclient.getParams().setParameter("http.protocol.content-charset", "UTF-8");

		//http://127.0.0.1:8080/pms/saveProj.do
		HttpPost httppost = new HttpPost("http://192.168.43.15:8050/kospo/cm/mgmt/mgmtInsert.do");
		File file = new File("d:/도움말.png");

		MultipartEntity mpEntity = new MultipartEntity();
		ContentBody cbFile = new FileBody(file, "application/vnd.ms-excel");
		mpEntity.addPart("file_1", cbFile);

		File file2 = new File("d:/status.png");

		ContentBody cbFile2 = new FileBody(file2, "application/vnd.ms-excel");
		mpEntity.addPart("file_2", cbFile2);
		
		
		
		ContentBody seven = new StringBody("A binary file 한글이 잘 되나 of some kind", Charset.forName("UTF-8"));
		mpEntity.addPart("subMM", seven);
		
		httppost.setEntity(mpEntity);

		System.out.println("executing request " + httppost.getRequestLine());
		
		ResponseHandler<String> handler = new BasicResponseHandler();
		HttpResponse response = httpclient.execute(httppost);
		
//		String body = handler.handleResponse(response);
//		int code = response.getStatusLine().getStatusCode();
//		
//		
//		System.out.println("response body is [" +body+"]");
		
		try {
			HttpEntity resEntity = response.getEntity();

			/*
	        JsonFactory jsonf = new JsonFactory();
	        InputStream instream = resEntity.getContent();
	        // try - finally is not strictly necessary here 
	        // but is a good practice
	        JsonParser jsonParser =null;
	        try {
	            jsonParser = jsonf.createJsonParser(instream);
	            while (jsonParser.nextToken() != null) {
	            	jsonParser.getCurrentName();
	            	
	            }
	            
	        }  finally {
	        	jsonParser.close();
	            instream.close();
	        }
			*/
			
			
			
			System.out.println(response.getStatusLine());
			
			
			if (resEntity != null) {
				System.out.println(EntityUtils.toString(resEntity));
			}
			if (resEntity != null) {
				resEntity.consumeContent();
			}
		} finally {
			httppost.releaseConnection();
		}
		httpclient.getConnectionManager().shutdown();
	}

/*
 *  httpclient 4.3 버전 방식
 * 
  public static void main(String[] args) throws Exception {

      CloseableHttpClient httpclient = HttpClients.createDefault();
      try {
          HttpPost httppost = new HttpPost("http://127.0.0.1:8080/pms/saveProj.do");

          FileBody bin = new FileBody(new File("d:/helps.png"));
          FileBody bin2 = new FileBody(new File("d:/status.png"));
          StringBody comment = new StringBody("A binary file of 한글이 된나some kind", ContentType.DEFAULT_TEXT);

          HttpEntity reqEntity = MultipartEntityBuilder.create()
                  .addPart("file_0", bin)
                  .addPart("file_0", bin2)
                  .addPart("comment", comment)
                  .build();


          httppost.setEntity(reqEntity);

          System.out.println("executing request " + httppost.getRequestLine());
          CloseableHttpResponse response = httpclient.execute(httppost);
          try {
              System.out.println("----------------------------------------");
              System.out.println(response.getStatusLine());
              HttpEntity resEntity = response.getEntity();
              if (resEntity != null) {
                  System.out.println("Response content length: " + resEntity.getContentLength());
              }
              EntityUtils.consume(resEntity);
          } finally {
              response.close();
          }
      } finally {
          httpclient.close();
      }
  }
    */
  
}