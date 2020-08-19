package client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import BasePage.BasePage;

public class RestClient extends BasePage {
	
  
//GET method
	
	

	public RestClient() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void get(String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse response = httpClient.execute(httpget);
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		
		String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
		
		
		JSONObject responseJson = new JSONObject(responseBody);
		System.out.println("responseBody----"+responseBody);
		
		Header headerArray[] = response.getAllHeaders();
		HashMap<String,String> allHeaders= new HashMap<String,String>();
		
		for(Header header:headerArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("response JSON from api  ::"+allHeaders);
		
	}
	


	

}
