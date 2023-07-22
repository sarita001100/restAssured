package day5ParsingXMLResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingXMLResponse {
//@Test
	void testXMLResponse() {
		given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1").then().statusCode(200)
				.header("Content-Type", "application/xml; charset=utf-8")
				.body("TravelerinformationResponse.page", equalTo("1"))
				.body("TravelerinformationResponse.travelers.Travelerinformation[0].id", equalTo("11133"))
				.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer")).log()
				.all();
	}

	// second Approach
	@Test
	void testXMLResponseWithAssertion() {
		Response res = given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		String travel = res.xmlPath().get("TravelerinformationResponse.page").toString();

		Assert.assertEquals("pageNo", "1");
		String travelName = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name")
				.toString();
		Assert.assertEquals(travelName,"Developer");

	}

}
