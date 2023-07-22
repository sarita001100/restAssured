package com.api.testing;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class UtilityRestAssured {

	
	public static void main(String[] args) {
		UtilityRestAssured util=	new UtilityRestAssured();
		//util.postApi("https://api.imgur.com/oauth2/token");
		util.getAccountImages("https://api.imgur.com/3/account/me/images");
	}
	public void getApi(String url) {
	Response rsp=RestAssured.given().header("Authorization", "Client-Idbd80a028572edc6").when().get(url);
	int code= rsp.getStatusCode();
	System.out.println(code);
	if(code==200) {
	String a=	rsp.getBody().asPrettyString();
	      JSONObject s=  new JSONObject(a);
	   int aa=  s.getJSONObject("data").getInt("id");
	      System.out.println(aa);
	}
	//long t= 34444;
	//rsp.time(Matchers.lessThan(t));
		
	}
	
    public void getAccountImages(String url) {
	Response rsp=	RestAssured.given().header("Authorization","Bearer 90427ee29671bdec02ec3e6a606e1bbe72ec3691").when()
		.get(url);
	int code=	rsp.statusCode();
	System.out.println(code);
	if(code==200) {
	String sa=	rsp.getBody().asPrettyString();
	JSONObject jsObj=	new JSONObject(sa);
//	for(int i=0;i<jsObj.getJSONArray("data").length();i++) {
//	String id=	jsObj.getJSONArray("data").getJSONObject(i).get("title").toString();
//	System.out.println(id);
	//}
	 JSONArray arr= jsObj.getJSONArray("data")  ;  
	 JSONObject js= arr.getJSONObject(0);
	String a= js.getString("account_url").toString();
	System.out.println(a);
	
	}
}
	
	
	public void postApi(String url) {
		
	Map map=	new HashMap();
	map.put("refresh_token","3673a79c759cd8cd2ce4689f4ba0f1f2dd170fab");
	map.put("client_id","bd80a028572edc6");
	map.put("client_secret","735a2d1d068cc2e38764dda1959446af86acfc37");
	map.put("grant_type","refresh_token");
		Response rsp=RestAssured.given().formParams(map).post(url);
		int code= rsp.getStatusCode();
		System.out.println(code);
		if(code==200) {
		String a=	rsp.getBody().asPrettyString();
		String aa=  new JSONObject(a).getString("token_type"
				+ "");
		    System.out.println(aa);  
		    
		}}
}
