package APIAutomation_RestAssured.RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {

	
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
	 
 
 @Test
 public void getweatherDetails()
 {
  //Specify base URI
  RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
  
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
 
	@Test
	 void RegistrationSuccessful()
	 {
	 //Specify base URI
	  RestAssured.baseURI="http://restapi.demoqa.com/customer";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  JSONObject requestParams= new JSONObject();
	  
	  requestParams.put("FirstName","Mintu");
	  requestParams.put("LastName","Rana");
	  requestParams.put("UserName","minturana");
	  requestParams.put("Password","Mintu@123");
	  requestParams.put("Email","minturana@gmail.com");
	  
	  httpRequest.header("Content-Type","application/json");
	  
	  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
	  
	  Response response=httpRequest.request(Method.POST, "/register");
	  
	//print response in console window
	  
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode);
	  Assert.assertEquals(statusCode, 201);
	  
	  //success code validation
	  String successCode=response.jsonPath().get("SuccessCode");
	  Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	  
	 }
	 
	@Test
	 void googleMapTest()
	 {
	  
	  //Specify base URI
	  RestAssured.baseURI="https://maps.googleapis.com";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
	  
	  //print response in console window
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  //validating headers
	  String contentType=response.header("Content-Type");// capture details of Content-Type header
	  System.out.println("Content Type is:"+contentType);
	  Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
	  
	  String contentEncoding=response.header("Content-Encoding");// capture details of Content-Encoding  header
	  System.out.println("Content Encoding is:"+contentEncoding);
	  Assert.assertEquals(contentEncoding, "gzip");
	  
	 }
	 
	


	
  
}
