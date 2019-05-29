package com.urban.serviceability;


import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.*;

import junit.framework.Assert;

import org.testng.annotations.Test;
import java.util.HashMap;


public class GetRequest {
	
	// Get request with parameters and then assert status code and response text 
	
	@Test
	public static void jhing(){
		
		String url = "http://172.20.3.227:8187/v1/items/serviceability";
		
		HashMap<String, String> header1 = new HashMap<String, String> ();
		header1.put("Content-Type","application/json");
		
		String test = given()
			.urlEncodingEnabled(false)
			.log().all()
			.headers(header1)
			.parameter("items[][sku]", "FNSGFR11MH30001")
			.parameter("zipcode", "560071")
			.when()
			.get(url)
			.then()
			.log().all()
			.assertThat().statusCode(200)
			.extract().asString();
		
		Assert.assertTrue(test.contains("FNSGFR11MH30001"));
		Assert.assertTrue(test.contains("Bangalore"));
	}
	
//	POST request with json body and then assert status code
	
	@Test
	public static void jhingalala(){
		
		String url = "http://172.20.3.227:8187/v1/items/serviceability";
		
		HashMap<String, String> header1 = new HashMap<String, String> ();
		header1.put("Content-Type","application/json");
		
		given()
			.urlEncodingEnabled(false)
			.log().all()
			.headers(header1)
			.parameter("items[][sku]", "FNSGFR11MH30001")
			.parameter("zipcode", "560071")
			.body("{\"status\":\"success\",\"test\":\"exam\"}")
			.when()
			.post(url)
			.then()
			.log().all()
			.assertThat().statusCode(200);
		
	}
	
//	Get request with parameters and then assert status code and assert one parameter value
	@Test
	public static void jhing2(){
		
		String url = "http://172.20.3.227:8187/v1/items/serviceability";
		
		HashMap<String, String> header1 = new HashMap<String, String> ();
		header1.put("Content-Type","application/json");
		
		String test = given()
			.urlEncodingEnabled(false)
			.log().all()
			.headers(header1)
			.parameter("items[][sku]", "FNSGFR11MH30001")
			.parameter("zipcode", "560071")
			.when()
			.get(url)
			.then()
			.log().all()
			.assertThat()
			.extract()
			.path("status");
		
		System.out.println("response is: " + test);
		
		Assert.assertTrue(test.contains("test"));
	}
	

}
