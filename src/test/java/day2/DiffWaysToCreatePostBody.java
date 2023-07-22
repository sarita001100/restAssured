package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class DiffWaysToCreatePostBody {

	/*
	 * Different ways to create POST request
	 * 1) Post request body using HashMap
	 * 2) Post request body creation using Org.json 
	 * 3) Post request body creation using POJO class
	 * 4) Post request using external json file data
      */
	// * 1) Post request body using HashMap
	
	@Test (priority=1)
	void testpostusingHashmap() {
		HashMap data=new HashMap();
		data.put("name","Smith");
		data.put("locatoin","India");
		String courseArr[]= {"Java","Selenium"};
		data.put("Course", courseArr);
		
		given()
		.contentType("application/json").body(data)
		.when().post("http://localhost:3000/students")
		
		.then().statusCode(500)
		.body("name",equalTo("Smith"))
		.body("locatoin",equalTo("India"))
		.body("Course[0]",equalTo("Java"))
		.body("Course[1]",equalTo("Selenium"))
        .header("Content-Type","application/json;charset=utf-8")
		.log().all();
		}
@Test(priority=2)
	void testDelete() {
		given()
		.when()
		.delete("http://localhost:3000/students/3")
		.then()
		.statusCode(404)
		;
	}
	
	
}
