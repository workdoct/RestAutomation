package page;

import static com.jayway.restassured.RestAssured.*;
import java.util.Scanner;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;
import  com.jayway.restassured.response.Response;

import dataClass.Info;
import dataClass.PostForComplexObject;
import dataClass.Posts;
import utilities.CustomiseException;

public class RestOperationUsingNodeJSServer {

	private static Response response;
	private final String uri = "http://localhost:3000";
	Scanner sc = new Scanner(System.in);


	@Test
	private void callMethod() {
		//postResponseUsingArray();
		 deleteRequest();
		// postResponseUsingComplexObject();
		// postResponseUsingObject();
		// deleteRequest();
		// patchRequest();
		 getResponse();
		// putRequest();

	}

	private void getResponse() {
		response = given()
				.when()
				.get(uri+ "/posts");
		System.out.println("Response is " + response.asString());
	}

	private void postResponse() {
		String id, author,title ;
		try {
			System.out.println("Enter ID : ");
			id= sc.next();
			System.out.println("Enter author : ");
			author= sc.next();
			System.out.println("Enter title : ");
			title= sc.next();
		}catch(CustomiseException e) {
			throw new CustomiseException("Enter correct string");
		}finally {
			sc.close();
		}

		given()
		.body("{\"id\":"+id+","+ "\"title\":\""+title+"\","+ "\"author\": \""+author+"\"}")
		.when()
		.contentType(ContentType.JSON)
		.post(uri+ "/posts");
	}

	private void postResponseUsingObject(){

		Posts post =  new Posts(); 

		try {
			System.out.println("Enter ID : ");
			post.setID(sc.nextLine());

			System.out.println("Enter author : ");
			post.setAuthor(sc.nextLine());

			System.out.println("Enter title : ");
			post.setTitle(sc.nextLine());


		}catch(CustomiseException e) {
			throw new CustomiseException("Enter correct string");
		}finally {
			sc.close();
		}

		response = given()
				.body(post)
				.when()
				.contentType(ContentType.JSON)
				.post(uri+ "/posts");

	}

	private void putRequest() {

		String sID ;
		Posts post =  new Posts(); 

		try {
			System.out.println("Enter ID : ");	//Enter the Id of record you want to change
			sID = sc.next();
			post.setID(sID);

			System.out.println("Enter author : "); //Updated value
			post.setAuthor(sc.next());

			System.out.println("Enter title : "); //Updated title
			post.setTitle(sc.next());


		}catch(CustomiseException e) {
			throw new CustomiseException("Enter correct string");
		}finally {
			sc.close();
		}

		response = given()
				.body(post)
				.when()
				.contentType(ContentType.JSON)
				.put(uri+ "/posts/"+sID);

		System.out.println(response.asString());
	}

	private void patchRequest() {

		String sID ;
		String author;

		try {
			System.out.println("Enter ID : ");	//Enter the Id of record you want to change
			sID = sc.next();

			System.out.println("Enter author : "); //Updated value
			author = sc.next();

		}catch(CustomiseException e) {
			throw new CustomiseException("Enter correct string");
		}finally {
			sc.close();
		}

		response = given()
				.body(" { \"author\" : \""+author+"\"}")
				.when()
				.contentType(ContentType.JSON)
				.patch(uri+ "/posts/"+sID);

		System.out.println(response.asString());
	}

	private void deleteRequest() {

		String sID ;

		try {
			System.out.println("Enter ID : ");	//Enter the Id of record you want to change
			sID = sc.next();

		}catch(CustomiseException e) {
			throw new CustomiseException("Enter correct string");
		}finally {
			sc.close();
		}

		response = given()
				.when()
				.delete(uri+ "/posts/"+sID);
		System.out.println(response.asString());
	}

	private void postResponseUsingComplexObject() {
		
		PostForComplexObject post =  new PostForComplexObject(); 
		Info info = new Info();
		try {
			System.out.println("Enter ID : ");
			post.setID(sc.nextLine());

			System.out.println("Enter author : ");
			post.setAuthor(sc.nextLine());

			System.out.println("Enter title : ");
			post.setTitle(sc.nextLine());

			System.out.println("Enter email : ");
			info.setEmail(sc.nextLine());

			System.out.println("Enter phone : ");
			info.setPhone(sc.nextLine());

			post.setInfo(info);

		}catch(CustomiseException e) {
			throw new CustomiseException("Enter correct string");
		}finally {
			sc.close();
		}

		response = given()
				.body(post)
				.when()
				.contentType(ContentType.JSON)
				.post(uri+ "/posts");
		
		System.out.println("Response  : " + response.asString());
	}

	private void postResponseUsingArray() {
		
		PostForComplexObject post =  new PostForComplexObject(); 
		Info info = new Info();
		Info info1 = new Info();
		try {
			System.out.println("Enter ID : ");
			post.setID(sc.nextLine());

			System.out.println("Enter author : ");
			post.setAuthor(sc.nextLine());

			System.out.println("Enter title : ");
			post.setTitle(sc.nextLine());

			System.out.println("Enter email : ");
			info.setEmail(sc.nextLine());

			System.out.println("Enter phone : ");
			info.setPhone(sc.nextLine());
			
			System.out.println("Enter email : ");
			info1.setEmail(sc.nextLine());

			System.out.println("Enter phone : ");
			info1.setPhone(sc.nextLine());

			post.setInfo(new Info[] {info,info1} );

		}catch(CustomiseException e) {
			throw new CustomiseException("Enter correct string");
		}finally {
			sc.close();
		}

		response = given()
				.body(post)
				.when()
				.contentType(ContentType.JSON)
				.post(uri+ "/posts");
		
		System.out.println("Response  : " + response.asString());
	}
}


