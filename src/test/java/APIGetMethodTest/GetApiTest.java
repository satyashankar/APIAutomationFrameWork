package APIGetMethodTest;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import client.RestClient;


public class GetApiTest extends BasePage {
	
	
	String serviceUrl;
	String apiUrl;
	String URL; 
	RestClient restClient;
	
	public GetApiTest() throws IOException {
		super();		
	}
	  
	

	@BeforeMethod
	public void setUP() {
		
		serviceUrl = prop.getProperty("serviceUrl");
		apiUrl= prop.getProperty("apiUrl");
		URL = serviceUrl+apiUrl;	
		
	}
	
	@Test
	public void getAPItest() throws IOException {
		restClient =new RestClient();
		restClient.get(URL);
		
	}
}
