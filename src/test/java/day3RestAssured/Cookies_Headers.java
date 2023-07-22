package day3RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies_Headers {

//	@Test
	void testCookies() {
		given()
		.when()
		.get("https://www.google.com")
		.then()
		.cookie("AEC", "AUEFqZfI2mPyUTS4Pmr7NWyQRMfXEmMCAf82DXADZEYlze8ZdEVY1935jA")
		.log()
		.all();
	}
	
//	@Test
	void testSingleCookies() {
		Response res= given()
		.when()
		.get("https://www.google.com");
	String cookies_value =res.getCookie("AEC");  
	System.out.println("value of cookies   "+cookies_value);
		}
	
	@Test
	void multipleCookies() {
		Response res= given()
		.when()
		.get("https://www.google.com");
	Map <String,String> cookies_value =res.getCookies(); 
	for(String k:cookies_value.keySet()) {
	String	cookies= res.getCookie(k);
	System.out.println(k+"   "+cookies);
}
		}
}
