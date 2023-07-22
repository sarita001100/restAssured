package restAssuredByRoshan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class RA_Methods {

	public static void mains() {
		ValidatableResponse response = RestAssured.given().auth().oauth2("").when().multiPart(new File(""))
				.formParam("name", "xyz").post("").then();
		response.statusCode(200);
		long time = 400;
		response.time(Matchers.lessThanOrEqualTo(time), TimeUnit.MILLISECONDS);

	}

	public static void jsnreading() {
		io.restassured.response.Response rsp = RestAssured.given().get("https://simple-books-api.glitch.me/books");
		String str = rsp.getBody().asPrettyString();
		// System.out.println(str);
		JSONArray jsonArrayObj = new JSONArray(str);
		JSONObject jsobj = jsonArrayObj.getJSONObject(3);
		String key = (String) jsobj.get("name");
//		System.out.println(key);
		String full = jsobj.toString();
		System.out.println(full);
		// JSONObject jsobj= new JSONObject(str);
		// JSONArray jsonarrayobj= jsobj.getJSONArray("students");
	}

	public static void postMethod() {

		Map mapObj = new HashMap<String, String>();
		mapObj.put("bookId", "1");
		mapObj.put("customerName", "Sarita");
	Response res=	RestAssured.given().body(mapObj).post("https://simple-books-api.glitch.me/orders");

	
	
	}

	public static void main(String[] args) {
		jsnreading();

	}

	public static void post() throws FileNotFoundException {
//		Map <String,String> mapObj=new	HashMap<String,String>();
//		mapObj.put("refresh_token","3673a79c759cd8cd2ce4689f4ba0f1f2dd170fab");
//		mapObj.put("client_id","bd80a028572edc6");
//		mapObj.put("client_secret","735a2d1d068cc2e38764dda1959446af86acfc37");
//		mapObj.put("grant_type","refresh_token");

		File flObj = new File("");
		InputStream strObj = new FileInputStream(flObj);
		RestAssured.given().auth().basic("", "").when().body("\\TestNG\\postData\\postNameData.json");

	}

}
