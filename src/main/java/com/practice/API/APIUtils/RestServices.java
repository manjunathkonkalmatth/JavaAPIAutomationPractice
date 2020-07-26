package com.practice.API.APIUtils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.util.HashMap;

public class RestServices {

	public static Response getRequest(String URL, HashMap<String, String> headers,String payLoad) {
		if(payLoad.equals(""))
			return given().headers(headers).when().get(URL);
		else
			return given().headers(headers).body(payLoad).when().get(URL);
	}
	
	public static Response putRequest(String URL, HashMap<String, String> headers,String payLoad) {
		if(payLoad.equals(""))
			return given().headers(headers).when().put(URL);
		else
			return given().headers(headers).body(payLoad).when().put(URL);
	}
	
	public static Response postRequest(String URL, HashMap<String, String> headers,String payLoad) {
		if(payLoad.equals(""))
			return given().headers(headers).when().post(URL);
		else
			return given().headers(headers).body(payLoad).when().post(URL);
	}
	
	public static Response patchRequest(String URL, HashMap<String, String> headers,String payLoad) {
		if(payLoad.equals(""))
			return given().headers(headers).when().patch(URL);
		else
			return given().headers(headers).body(payLoad).when().patch(URL);
	}
	
	public static Response deleteRequest(String URL, HashMap<String, String> headers,String payLoad) {
		if(payLoad.equals(""))
			return given().headers(headers).when().delete(URL);
		else
			return given().headers(headers).body(payLoad).when().delete(URL);
	}
	
	public static Response headRequest(String URL, HashMap<String, String> headers,String payLoad) {
		if(payLoad.equals(""))
			return given().headers(headers).when().head(URL);
		else
			return given().headers(headers).body(payLoad).when().head(URL);
	}
	
	public static HashMap<String,String> getHeadersFromMapString(String headers){
		HashMap<String, String> map = new HashMap<String, String>();
		return map;
	}
	
//	Services without header
	public static Response getRequest(String URL,String payLoad) {
		if(payLoad.equals(""))
			return given().when().get(URL);
		else
			return given().body(payLoad).when().get(URL);
	}
	
	
	public static Response postRequest(String URL,String payLoad) {
		if(payLoad.equals(""))
			return given().when().post(URL);
		else
			return given().body(payLoad).when().post(URL);
	}
}
