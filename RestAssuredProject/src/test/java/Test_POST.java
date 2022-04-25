import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test_POST {
	@Test
	public void test_1_post() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Bobby");
		map.put("job", "Teacher");
		System.out.println(map);
		JSONObject request = new JSONObject(map);
//		remove map from JSONObject parameter and uncomment the 2 lines below will yield same result
//		request.put("name", "Bobby");
//		request.put("job", "Teacher");
		System.out.println(request);
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)
			.body(request.toJSONString()) //for POST methods, it requires a body since it needs data to pass to server to CREATE
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201);
	}
	
	@Test
	public void test_2_put() {

		JSONObject request = new JSONObject();

		request.put("name", "Bobby");
		request.put("job", "Teacher");
		System.out.println(request);
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)
			.body(request.toJSONString()) //for POST methods, it requires a body since it needs data to pass to server to CREATE
		.when()
			.put("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_3_patch() {

		JSONObject request = new JSONObject();

		request.put("name", "Bobby");
		request.put("job", "Teacher");
		System.out.println(request);
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)
			.body(request.toJSONString()) 
		.when()
			.patch("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_4_delete() {

		given()
			.delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(204)
			.log().all();
	}
}
