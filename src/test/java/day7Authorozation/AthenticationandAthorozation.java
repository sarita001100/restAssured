package day7Authorozation;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class AthenticationandAthorozation {

	//@Test (priority=1)
	void testAuthentication() {
		given().auth().basic("postman","password")
		.when().get("http://postman.echo.com/basic-auth")
		.then().statusCode(200)
		.header("Postman-Token", "<calculated when request is sent>")
		//.body("authenticated",equalTo(true))
		;
	}
	
	//@Test (priority=2)
	void testDigest() {
		given().auth().digest("postman","password")
		.when().get("http://postman.echo.com/basic-auth")
		.then().statusCode(200)
		//.header("Postman-Token", "<calculated when request is sent>")
		.body("authenticated",equalTo(true))
		;
	}
	//@Test (priority=3)
	void testpreemptive() {
		given().auth().preemptive().basic("postman","password")
		.when().get("http://postman.echo.com/basic-auth")
		.then().statusCode(200)
		.header("Postman-Token", "<calculated when request is sent>")
		//.body("authenticated",equalTo(true))
		;
	}
	
	@Test(priority=4)
	void testBearerToken() {
		String bearerToken="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";
		
		given().header("Authorization","Bearer"+bearerToken)
		.when().get("https://api.github.com/user/repos")
		.then().statusCode(200);
		
	}
	
	
}
