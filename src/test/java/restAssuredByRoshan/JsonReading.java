package restAssuredByRoshan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonObject;

public class JsonReading {

	public static void main(String[] args) throws IOException {
		//jsonReadPath();
		//customData();
		//randomNumberGenerate();
		randomEmailGenerate();
	}
	
	public static void randomEmailGenerate() throws IOException {
		Path pathObj=	Paths.get("C:\\Users\\COMTECH\\eclipse-Sarita\\RestAsrd\\postCreateData\\creatingPost.json");
		byte[] byteObj=Files.readAllBytes(pathObj);
		String str= new String(byteObj);
		JSONObject jsnObj=new JSONObject(str);
		JSONArray jsAry=	jsnObj.getJSONArray("properties");
		JSONObject  inArry =	jsAry.getJSONObject(2);
		String strObj=(String) inArry.getString("value");
		
		System.out.println("before change :  "+strObj);

		String generateEmail= RandomStringUtils.random(5).toLowerCase();
		JSONObject emailObj=inArry.put("value",generateEmail);
		
		System.out.println("after change :  "+emailObj.getString("value"));

	}
	
	public static void randomNumberGenerate() {
		int length =10;
		boolean useLetters=true;
		boolean useNumbers= true;
		String generateString =RandomStringUtils.random(length,useLetters,useNumbers);
		System.out.println(generateString);
	}
	
	public static void customData() throws IOException {
	 
		Path pathObj=	Paths.get("C:\\Users\\COMTECH\\eclipse-Sarita\\RestAsrd\\postCreateData\\creatingPost.json");
		byte[] byteObj=Files.readAllBytes(pathObj);
		String str= new String(byteObj);
		JSONObject jsnObj=new JSONObject(str);
		
		String strObj=(String) jsnObj.getString("lead_score");
		System.out.println("before change :  "+strObj);
		JSONObject jsNewObj=jsnObj.put("lead_score","90");
		System.out.println("after change :  "+jsNewObj.getString("lead_score"));

		
	}
	
	public static void jsonReadPath() throws IOException {
	Path pathObj=	Paths.get("C:\\Users\\COMTECH\\eclipse-Sarita\\RestAsrd\\postCreateData\\creatingPost.json");
	byte[] byteObj=Files.readAllBytes(pathObj);
	String str= new String(byteObj);
	JSONObject jsnObj=new JSONObject(str);
	String strObj=(String) jsnObj.getString("lead_score");
	System.out.println(strObj);
	JSONArray jsArray=jsnObj.getJSONArray("properties");
     
	for(int i=0;i<jsArray.length();i++) {
	JSONObject jsObj=jsArray.getJSONObject(i);
	System.out.println(jsObj);
	//String jObj=jsObj.getString("value");
	//System.out.println(jObj);
	}
	}
}
