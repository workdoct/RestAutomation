package page;

import static com.jayway.restassured.RestAssured.*;
import java.util.Scanner;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;
import  com.jayway.restassured.response.Response;

import dataClass.Posts;
import utilities.CustomiseException;

public class RestOperationUsingNodeJSServer {

	private static Response response;
	private final String uri = "http://localhost:3000";


	@Test
	private void callMethod() {
		patchRequest();
		getResponse();
	}

	public void getResponse() {
		response = given()
				.when()
				.get(uri+ "/posts");
		System.out.println("Response is " + response.asString());
	}

	public void postResponse() {
		String id, author,title ;
		Scanner sc = new Scanner(System.in);
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

	public void postResponseUsingObject(){

		Scanner sc = new Scanner(System.in);
		Posts post =  new Posts(); 

		try {
			System.out.println("Enter ID : ");
			post.setID(sc.next());

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

	public void putRequest() {

		String sID ;
		Scanner sc = new Scanner(System.in);
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
	
	public void patchRequest() {

		String sID ;
		String author;
		Scanner sc = new Scanner(System.in);
		Posts post =  new Posts(); 

		try {
			System.out.println("Enter ID : ");	//Enter the Id of record you want to change
			sID = sc.next();
			post.setID(sID);

			System.out.println("Enter author : "); //Updated value
			author = sc.next();

			/*System.out.println("Enter title : "); //Updated title
			post.setTitle(sc.next());*/


		}catch(CustomiseException e) {
			throw new CustomiseException("Enter correct string");
		}finally {
			sc.close();
		}

		response = given()
		.body("\""+author+"\"")
		.when()
		.contentType(ContentType.JSON)
		.patch(uri+ "/posts/"+sID);

		System.out.println(response.asString());
	}

}
