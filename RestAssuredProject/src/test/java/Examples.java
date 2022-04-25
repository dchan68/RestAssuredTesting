import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Examples {

	@Test
	public void test_get() {
		baseURI = "http://localhost:3000/";
		
		//basically getting http://localhost:3000/subjects?name=automation
		given()
			.param("name", "automation")
			.get("/subjects")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_post() {
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Clark");
		request.put("lastName", "Kent");
		request.put("subjectId", "1");
		
		baseURI = "http://localhost:3000/";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
	}
	
	@Test
	public void test_patch() {
		JSONObject request = new JSONObject();
		
		request.put("lastName", "Hecter");
		
		baseURI = "http://localhost:3000/";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.patch("/users/4")
		.then()
			.statusCode(201)
			.log().all();
	}
	
	@Test
	public void test_put() {
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Black");
		request.put("lastName", "Widow");
		request.put("subjectId", "1");
		
		baseURI = "http://localhost:3000/";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.put("/users/4")
		.then()
			.statusCode(201)
			.log().all();
	}
	
	@Test
	public void test_delete() {
		baseURI = "http://localhost:3000/";
		when()
			.delete("/users/4")
		.then()
			.statusCode(200);
	}
}
