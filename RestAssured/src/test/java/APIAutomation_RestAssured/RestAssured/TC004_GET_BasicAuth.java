package APIAutomation_RestAssured.RestAssured;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC004_GET_BasicAuth {
	@Test
	 public void AuthrozationTest()
	 {
	  //Specify base URI
	  RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
	  PreemptiveBasicAuthScheme authScheme =new PreemptiveBasicAuthScheme();
	  authScheme.setUserName("ToolsQA");
	  authScheme.setPassword("TestPassword");
	  RestAssured.authentication=authScheme;
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"/Hyderabad");
	  
	  //print response in console window
	  
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode);
	  Assert.assertEquals(statusCode, 200);
	  
	  //status line verification
	  String statusLine=response.getStatusLine();
	  System.out.println("Status line is:"+statusLine);
	  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	  
	 }

}
