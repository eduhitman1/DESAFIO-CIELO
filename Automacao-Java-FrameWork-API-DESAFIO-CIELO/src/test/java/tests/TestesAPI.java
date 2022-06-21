package tests;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.json.Json;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class TestesAPI {

	
	@org.junit.Test
	public void GetRequest() {
	Response response = get("https://webservice.toscacloud.com/training/swagger/docs/v1");
	
    System.out.println(response.getStatusCode());
    System.out.println(response.getBody().asString());
    
    int statusCode = response.getStatusCode();
    
    Assert.assertEquals(statusCode, 200);
    
   }
	
	
	@org.junit.Test
	public void GetResquest2() {

	baseURI = "https://webservice.toscacloud.com";	
	given()
	.get("/training/swagger/docs/v1")
	.then()
	.statusCode(200)
	.body("info.title", equalTo("Tricentis.Demo.Swagger")).log().all();
   
	}
	
	
	
	@org.junit.Test
	public void PostResquest1() {
     Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Id", "1");
		map.put("Name", "eduardo");
		map.put("Description", "test");
		
		System.out.println(map);			
	}
	
	
		@org.junit.Test
	public void PutResquest1() {	
		
		JSONObject request = new JSONObject();
		
	
		request.put("Name", "eduardo");
		request.put("Description", "test");
		
		System.out.println(request.toJSONString());
		 	
		 	
		baseURI = "https://webservice.toscacloud.com/training/";	
		
	given()
	.header("Content-type","application/json")
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(request.toJSONString()).when().post("/api/Coffees").then().statusCode(201).log().all();
			
	}
	
	
	
	

	
}
