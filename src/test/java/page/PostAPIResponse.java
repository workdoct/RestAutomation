package page;

import static com.jayway.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import dataClass.DeserializationOfResponse;

public class PostAPIResponse {

	private static Response response;
	private final String uri = "http://restapi.demoqa.com/customer";

	@Test
	public void postResource() {
		RestAssured.baseURI = uri;
		RequestSpecification request =  RestAssured.given();

		JSONObject requestParams = new JSONObject();
		JSONObject requestParams1 = new JSONObject();
		requestParams.put("FirstName", "Viirender"); // Cast
		requestParams.put("LastName", "Siingh");
		requestParams.put("UserName", "siimpleuser001");
		requestParams.put("Password", "password1i");
		requestParams.put("Email",  "someuser@gmaiil.com");

		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		request.body(requestParams.toJSONString());

		// Post the request and check the response
		//response = request.post("/register");
		response = request.post("/register");

		int statusCode = response.getStatusCode();
		//Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		//Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
		
		//System.out.println(statusCode);
		//System.out.println("Response body: " + response.body().asString());
		
		//Object deserialization
		DeserializationOfResponse object = response.getBody().as(DeserializationOfResponse.class);
		System.out.println(object.FaultId);
		System.out.println(object.fault);
		
		
	}

}
