package RestApi;

import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;


public class FirstApiCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Pending -
		//extent report - Request /Response 
		//Assertion
		//Listener
		
		
		// Validate if add place api is working as expected
		// given when then method
		
		//given -  all input details
		//when - submit the api , resource , http method
		//then validate the response
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Rahul Shetty Academy\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://rahulshettyacademy.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"").when().post("maps/api/place/add/json")
				.then().log().all().assertThat().statusCode(200);
	}

}
