package restAssuredByRoshan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class AllApiMethods {

	String str="C:\\Users\\COMTECH\\eclipse-Sarita\\RestAsrd\\postCreateData\\creatingPost.json";
	 String name="roshan.yadav@wuuvo.com";
	 String password ="Virat@18#";
	 String url="https://expertviewautomation.agilecrm.com/dev/api/contacts";
	 String geturl="https://expertviewautomation.agilecrm.com/dev/api/contacts?page_size=2";

    @Test
	public  void postMethod() throws IOException {
		Path pathObj = Paths.get(str);
		byte[] byteObj = Files.readAllBytes(pathObj);
		String str = new String(byteObj);
		JSONObject jsnObj = new JSONObject(str);
		JSONArray jsAry = jsnObj.getJSONArray("properties");
		JSONObject inArry = jsAry.getJSONObject(2);

		JSONObject actualFirstName = jsAry.getJSONObject(0);
		System.out.println(actualFirstName.getString("name"));

		JSONObject actualLastName = jsAry.getJSONObject(1);
		System.out.println(actualLastName.getString("name"));

		JSONObject actualEmailName = jsAry.getJSONObject(2);
		System.out.println(actualEmailName.getString("value"));

		String strObj = (String) inArry.getString("value");
		System.out.println("Before the email:  " + strObj);

		String custommail = "sam" + RandomStringUtils.randomAlphabetic(6) + "@1secmail";
		System.out.println(custommail);

		JSONObject jsonObj = inArry.put("value", custommail);
		System.out.println("After the email:  " + jsonObj.get("value"));

		// File flObj= new File("postCreateData\\creatingPost.json");
		// InputStream inputObj= new FileInputStream(flObj);
		Response res = given().auth().basic(name,password).when()
		.body(jsnObj.toString()).contentType(ContentType.JSON)
		.post(url);
		res.then().log().all();
//		int statusCode = res.statusCode();
//		System.out.println("Status code:  " + statusCode);
//		long time = res.getTime();
//		System.out.println("time is : " + time);
//		String strOb = res.body().asPrettyString();
//		System.out.println("body is: " + strOb);

		JSONObject expectedFirstName = jsAry.getJSONObject(0);
		System.out.println(expectedFirstName.getString("name"));

		JSONObject expectedLastName = jsAry.getJSONObject(1);
		System.out.println(expectedLastName.getString("name"));

		JSONObject expectedEmailName = jsAry.getJSONObject(2);
		System.out.println(expectedEmailName.getString("value"));

		if (actualFirstName.equals(expectedFirstName)) {
			System.out.println("firstName is matched test case is passed");
		} else {
			System.out.println("firstName is not matched test case is failed");
		}

		if (actualLastName.equals(expectedLastName)) {
			System.out.println("lastName is matched test case is passed");
		} else {
			System.out.println("lastName is not matched test case is failed");
		}
		if (actualEmailName.equals(expectedEmailName)) {
			System.out.println("emailName is matched test case is passed");
		} else {
			System.out.println("emailName is not matched test case is failed");
		}
		
		
	}

	public static void validateDataOnlyDigit(Long data) {
		try {
			Long.valueOf(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
@Test

	public  void getMethod() throws IOException {
	
//	    RestAssured.baseURI =
//		 "https://expertviewautomation.agilecrm.com/dev/api/contacts";

		Response rsp = given().auth().basic(name,password).when()
				.contentType(ContentType.JSON).accept(ContentType.JSON)
				.get(geturl);
		
		int statusCode = rsp.statusCode();
		System.out.println("Status code:  " + statusCode);
		long time = rsp.getTime();
		System.out.println("time is : " + time);
		String strObj = rsp.body().asPrettyString();
	//	System.out.println("getMethod passed " + strObj);
		
		JSONArray jsObj = new JSONArray();
		JSONObject jsobjarr= jsObj.getJSONObject(0);
		String a= jsobjarr.toString();
		System.out.println(a);
	//	jsobjarr.getLong()
		Long Id = jsobjarr.getLong("id");
		validateDataOnlyDigit(Id);
		if (Id.toString().length() == 16) {
			System.out.println("Id contains only 16 digit, test case is passed");
		} else {
			System.out.println("Id contains does not 16 digit, test case is failed");
		}
	}
@Test
	public void updateMethod() throws IOException {
	Path pathObj=	Paths.get("C:\\Users\\COMTECH\\eclipse-Sarita\\RestAsrd\\postCreateData\\creatingPost.json");
	 byte[] bytObj= Files.readAllBytes(pathObj);
	String strObj= new String(bytObj);
	System.out.println(strObj);
	JSONObject jsObj = new JSONObject(strObj);
	JSONArray jsArray=jsObj.getJSONArray("properties");
	JSONObject jsnObj= jsArray.getJSONObject(0);
	JSONObject obj=	jsnObj.put("name","sammy");
	//System.out.println("data :"+obj);
		Response res= given().auth().basic(name,password).when().body(jsnObj.toString()).contentType(ContentType.JSON)
				.put(url);
				res.then().log().all();
		
		
	}
}
