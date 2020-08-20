package client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

	public CloseableHttpResponse get (String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse response = httpClient.execute(httpget);
		
		return response;
		
	}
	
public CloseableHttpResponse get (String url, HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);//http GET request
		
		for(Map.Entry<String, String> entry: headerMap.entrySet()) {
			httpget.addHeader(entry.getKey(),entry.getValue());			
		}	
		
		CloseableHttpResponse response = httpClient.execute(httpget);		
		return response;
		
	}
	


	

}
