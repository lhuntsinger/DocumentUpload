package com.wac.du.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.wac.du.base.TestBase;

public class PractiTest extends TestBase {
	
	public static void runWithAttachments(String instance, int result, String screenshot, String failureReason) throws Exception {
		
	    final String uri = "https://api.practitest.com/api/v2/projects/14574/runs.json";
	    final String developerEmail = prop.getProperty("developerEmail");
	    final String apiToken = prop.getProperty("apiToken");
	    String filePath = "C:\\workspace\\DocumentsUpload\\screenshots\\"+screenshot;
	    String json_str;
	   	
    	if(failureReason.length() > 250) {
    		failureReason = failureReason.substring(0, 250);
    	}
	    failureReason = failureReason.replace("\n", " ");
	        byte[] encoding = Base64.encodeBase64((developerEmail + ":" + apiToken).getBytes());

	        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	        	       
	        if (result == 1) {
	        	
	        json_str =  "{\"data\" : " + 
	        "{\"attributes\" : {\"instance-id\": "+instance+", \"exit-code\": "+result+", \"automated-execution-output\": \""+failureReason+"\"}, " +
	        "\"files\": { \"data\": [{ \"filename\": \""+screenshot+"\", \"content_encoded\": \"" +filenameToBase64(filePath)+ "\"}]} } }"; 
	        }
	        
	        else {
	        	
		    json_str = "{\"data\" : {\"attributes\" : {" +
			       "\"instance-id\": " +instance+ "," +
			       "\"exit-code\": "+result+"} } }";
	        	
	        }

	        HttpPost request = new HttpPost(uri);
	        request.setEntity(new StringEntity(json_str));
	        request.setHeader("Authorization", "Basic " + new String(encoding));
	        request.addHeader("content-type", "application/json");


	        System.out.println("executing request " + request.getURI());

	        try {
	        // Create a response handler
	            HttpResponse response = httpClient.execute(request);
	            int statusCode = response.getStatusLine().getStatusCode();
	            HttpEntity entity = response.getEntity();
	            String responseBody = EntityUtils.toString(entity);
	            if (statusCode == 200) {
	                System.out.println("SUCCESS: " + responseBody);
	            } else {
	                System.out.println("ERROR: " + statusCode + ": " + responseBody);
	            }
	        } catch (Throwable e) {
	            e.printStackTrace();
	        }

	        System.out.println("----------------------------------------");

	        // When HttpClient instance is no longer needed,
	        // shut down the connection manager to ensure
	        // immediate deallocation of all system resources
	        httpClient.close();
	    }


	    private static String filenameToBase64(String fileName){
	      File originalFile = new File(fileName);
	      String encodedBase64 = null;
	      try {
	          FileInputStream fileInputStreamReader = new FileInputStream(originalFile);
	          byte[] bytes = new byte[(int)originalFile.length()];
	          fileInputStreamReader.read(bytes);
	          encodedBase64 = new String(Base64.encodeBase64(bytes));
	          fileInputStreamReader.close();
	      } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	      return encodedBase64;
	    }

}
