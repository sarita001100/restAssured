package com.api.testing;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BesicTesting {
	@Test
	public static void main(String[] args) {
		
	     HashMap map= new HashMap ();
	     map.put("state", "up");
	     map.put("name", "Sarita");
	     map.put("house", "Green");
		
		Response rp= RestAssured.given()
		.get("https://simple-books-api.glitch.me/books");
		
		
		int statusCode= rp.getStatusCode();
	//	 assertEquals(statusCode, 200);
		System.out.println(statusCode);
	//	long responseTime= rp.getTime();
	//	assertEquals(responseTime, 9543);
		
	String body= rp.getBody().asString();
	System.out.println(body);
	//JSONObject obj= new JSONObject(body);
	//System.out.println(obj.getString("type"));
		
	    
		
		
		 
	}
	

}
