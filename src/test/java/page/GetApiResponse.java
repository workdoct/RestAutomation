package page;

import org.apache.http.util.EntityUtils;
import org.jbehave.core.annotations.Then;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;

import dataClass.Data;
import utilities.CustomiseException;

import static com.jayway.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class GetApiResponse {

	private static Response res; 


	@Test
	public void callMethod() {
		getRequestWithCityName();
		/*getResponseByID(convertToString(getParameterFromResponse("id")));
		System.out.println(getParameterFromResponse("id"));
		verifyStatusCode(200);*/

		printResponse();
	}

	public Map<String, String> getHeadersNameAndValue() {
		Map <String, String> map = new HashMap<String, String>();
		for(Header hd : res.getHeaders()) {
			map.put(hd.getName(), hd.getValue());
		}
		return map;
	}

	public int getStatusCode() {
		return res.statusCode();
	}

	public void getRequestWithCityName() {
		res=	given()
				.param("q", Data.city)
				.param("appid", Data.appID)
				.when().
				get(Data.baseURI);
	}

	public void verifyStatusCode(int statusCode) {

		try {
			res.
			then().
			assertThat().
			statusCode(statusCode);

		}catch(NullPointerException e) {
			throw new CustomiseException("Response is null");
		}
	}

	public void getResponseByID(String ID) {
		res=	given()
				.param("id", ID)
				.param("appid", "fbd1138dba66b58f48b6e394206fc526")
				.when().
				get(Data.baseURI);
	}

	public Object getParameterFromResponse(String jsonPath) {

		return	res.
				then().
				contentType(ContentType.JSON).
				extract().
				path(jsonPath);
	}

	public String convertToString(Object ob) {
		if(ob instanceof Integer) {
			return Integer.toString((Integer)ob);
		}

		return "";
	}

	public void printResponse() {
		try {
			System.out.println(res.asString());
		}catch(NullPointerException e) {
			throw new CustomiseException("Response is null");
		}
	}

	public void convertToJsonObject() {
		/*String response_string=EntityUtils.toString(res.getEntity(),"UTF-8");
		JSONObject obj=new JSONObject(response_string);
		System.out.println("Response JSON is"+obj);*/
	} 

}
