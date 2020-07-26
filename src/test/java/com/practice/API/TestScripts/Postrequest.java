package com.practice.API.TestScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.practice.API.APIUtils.RestServices;

import io.restassured.response.Response;

public class Postrequest {
	
	Response response;
	String BaseURL = "https://reqres.in/";
	String PayLoad = "{\n" + 
			"    \"name\": \"morpheus\",\n" + 
			"    \"job\": \"leader\"\n" + 
			"}";
	
	@BeforeClass
	public void postRequest() {
		response = RestServices.postRequest(BaseURL + "api/users", PayLoad);
		System.out.println(response.body().asString());
		
	}
	@Test
	public void test_StatsCode() {
		Reporter.log(response.asString());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201, "Recived response code is "+ statusCode);
		Reporter.log("Recieved status code" + statusCode);
	}
	
	@Test
	public void test_ValidateUser() {
		String id = response.body().jsonPath().get("id").toString();
		System.out.println("id is "+ id );
		System.out.println(BaseURL+"api/users/"+id);
		response = RestServices.getRequest(BaseURL+"api/users/"+id,"");
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getBody().asString());
		
		
	}

}
