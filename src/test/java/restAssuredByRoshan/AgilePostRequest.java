package restAssuredByRoshan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import com.github.fge.jsonschema.main.cli.Main;

import day3RestAssured.Headers;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AgilePostRequest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		creatingAContact();
//		jsonReading();
//		TestNG test = new TestNG();
//		test.setTestClasses(new Class[] { AgilePostRequest.class, Headers.class });
//		test.setGroups("smoke");
//		test.setParallel(XmlSuite.ParallelMode.TESTS);
//		test.run();

	}

	public static void creatingAContact() throws FileNotFoundException {
		//File flObj = new File("\\RestAsrd\\postCreateData\\creatingPost.json");
		//InputStream inputData = new FileInputStream(flObj);
		Response res = RestAssured.given().auth().basic("roshan.yadav@wuuvo.com", "Virat@18#")
	    .when().body("\\RestAsrd\\postCreateData\\creatingPost.json")
	    //.contentType(ContentType.JSON)
		.post("https://expertviewautomation.agilecrm.com/dev/api/contacts");
		String str = res.getBody().asPrettyString();
		System.out.println("body is: " +str);
		int statusCode = res.getStatusCode();
		System.out.println("Status code:  "+ statusCode);
		long time = res.getTime();
		System.out.println("time is : "+time);
		;
	}

	public static void jsonReading() throws IOException {
		Path filepath = Paths.get("C:\\Users\\COMTECH\\eclipse-Sarita\\RestAsrd\\saritaaBooks.json");
		byte[] str = Files.readAllBytes(filepath);
		String a = new String(str);
		JSONArray jsObj = new JSONArray(a);
		JSONObject ab = jsObj.getJSONObject(1);
		// System.out.println(ab);
		String aaa = (String) ab.get("type");
		System.out.println(aaa);

	}
}
