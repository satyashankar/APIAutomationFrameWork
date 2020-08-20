package APIGetMethodTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Util.Util;
import client.RestClient;


public class GetApiTest extends BasePage {
	
	
	String serviceUrl;
	String apiUrl;
	String URL; 
	RestClient restClient;
	CloseableHttpResponse response;
	Util util;
	
	public GetApiTest() throws IOException {
		super();		
	}
	  
	

	@BeforeMethod
	public void setUP() {
		
		serviceUrl = prop.getProperty("serviceUrl");
		apiUrl= prop.getProperty("apiUrl");
		URL = serviceUrl+apiUrl;	
		
	}
	
	@Test(enabled=true)
	public void getAPItest() throws IOException {
		restClient =new RestClient();
	    response = restClient.get(URL);
		
	    //status code
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200,"statuscode is not matched");
		
		//JSON response string		
		String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");		
		JSONObject responseJson = new JSONObject(responseBody);
		System.out.println("responseBody----"+responseBody);
		
		// validating page_vaalue
		String perPageValue=util.getValueByJPath(responseJson, "/per_page");
		System.out.println(perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 6);
		
		//validating page
		String totalPages=util.getValueByJPath(responseJson, "/total_pages");
		System.out.println(totalPages);
		Assert.assertEquals(Integer.parseInt(totalPages), 2);
		
		// validation jason array objects
		String lastname = util.getValueByJPath(responseJson, "/data[0]/last_name");
		String id = util.getValueByJPath(responseJson, "/data[0]/id");
		String avatar = util.getValueByJPath(responseJson, "/data[0]/avatar");
		String firstName = util.getValueByJPath(responseJson, "/data[0]/first_name");
		System.out.println(lastname);
		System.out.println(id);
		System.out.println(avatar);		
		
		// header
		Header headerArray[] = response.getAllHeaders();
		HashMap<String,String> allHeaders= new HashMap<String,String>();
		
		for(Header header:headerArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("response JSON from api  ::"+allHeaders);
		
	}
	@Test
	public void getAPItestWithHeader() throws IOException {
		restClient =new RestClient();
		
		HashMap<String,String> headerMap = new HashMap<String,String>();
		headerMap.put("Cookie", "__cfduid=d72768bac79b17fed6561c55f8627d7471597947622/json");
		headerMap.put("Postman-Token", "<calculated when request is sent>/json");
		
	    response = restClient.get(URL, headerMap);
		
	    //status code
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200,"statuscode is not matched");
		
		//JSON response string		
		String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");		
		JSONObject responseJson = new JSONObject(responseBody);
		System.out.println("responseBody----"+responseBody);
		
		// validating page_vaalue
		String perPageValue=util.getValueByJPath(responseJson, "/per_page");
		System.out.println(perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 6);
		
		//validating page
		String totalPages=util.getValueByJPath(responseJson, "/total_pages");
		System.out.println(totalPages);
		Assert.assertEquals(Integer.parseInt(totalPages), 2);
		
		// validation jason array objects
		String lastname = util.getValueByJPath(responseJson, "/data[0]/last_name");
		String id = util.getValueByJPath(responseJson, "/data[0]/id");
		String avatar = util.getValueByJPath(responseJson, "/data[0]/avatar");
		String firstName = util.getValueByJPath(responseJson, "/data[0]/first_name");
		System.out.println(lastname);
		System.out.println(id);
		System.out.println(avatar);		
		
		// header
		Header headerArray[] = response.getAllHeaders();
		HashMap<String,String> allHeaders= new HashMap<String,String>();
		
		for(Header header:headerArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("response JSON from api  ::"+allHeaders);
		
	}
}
