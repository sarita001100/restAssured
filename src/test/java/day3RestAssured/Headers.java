package day3RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;


public class Headers {

	//@Test
	void testHeaders() {
		given()
		.when()
		.get("https://www.googal.com/")
		.then()
		.header("Content-Type","text/html; charset=ISO-8859-1")
		.header("Content-Encoding","gzip")
		.header("Server","gws");
	}
	
	//@Test
	void testSingleHeaders() {
		Response res=given()
		.when()
		.get("https://www.googal.com/");
		String header=res.getHeader("Content-Type");
		System.out.println("the value of headres is   "+header);
		}
	
	@Test
	void testMultipleHeaders() {
		Response rest=given()
		.when()
		.get("https://www.googal.com/");
		io.restassured.http.Headers header_value = rest.getHeaders();
		for(Header hd:header_value) {
		System.out.println(hd.getName()+"  "+hd.getValue());
		}
	}
}
