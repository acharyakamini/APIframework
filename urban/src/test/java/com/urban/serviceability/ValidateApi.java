package com.urban.serviceability;

import java.util.HashMap;
import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.*;
import com.jayway.restassured.specification.RequestSpecification;

import junit.framework.Assert;

import org.testng.annotations.Test;

public class ValidateApi {
	
	@Test
	public static void warranty(){
		String url1 = "http://172.20.3.227:8187/v1/policy";
		HashMap<String,String> parameter1 = new HashMap<String, String>();
		parameter1.put("item_category", "A");
		parameter1.put("type", "cancellation");
		
		        String str=given()
					.urlEncodingEnabled(false)
					.log().all()
					.params(parameter1)
					.when()
					.get(url1)
					.then()
					.log().all()
					.assertThat().statusCode(200)
					.extract().asString();
		        
		        Assert.assertTrue(str.contains("cancellation"));
		        
					
		
		
		
	}

}
