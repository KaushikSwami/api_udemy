package restassured.udemy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import files.Payload;


public class Add_Place {
	
	// firstly we need to hit the end point
	
	// four commonly used methods to communicate with the api
	// GET , POST , PUT , DELETE
	
	// GET - used to retrive some info from the server
	// POST - used to send data to the server
	// PUT - update the data
	// DELETE - delete the info
	
	public static String newAddress="bkoil,trichy";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		// in given() we have to pass all the input details
		
		Map<String,String> parameters=new HashMap<String,String>();
		parameters.put("key", "qaclick123");
		
	Response post_response = RestAssured.given().log().all().queryParams(parameters).accept(ContentType.JSON).body(Payload.add_place())
		
		// in when() we have to give what kind of HTTP request we need to give and the resource inside the http request 
		.when().post("/maps/api/place/add/json");
	
	post_response.prettyPrint();
		
		
	
	JsonPath js=post_response.jsonPath();
	String place_id = js.get("place_id");
	System.out.println("the place id is : " + place_id );
	
	Response put_response = RestAssured.given().log().all().queryParams(parameters).accept(ContentType.JSON).body(chaining.Payload.put_place())
			.when().put("maps/api/place/update/json");
			
	
	JsonPath js_1=put_response.jsonPath();
	String message_address = js_1.get("msg");
	System.out.println(message_address);
	
	Response response_new = RestAssured.given().log().all().queryParams(parameters).queryParam("place_id",place_id ).accept(ContentType.JSON)
			.when().get("/maps/api/place/get/json");
	
	JsonPath js_2=response_new.jsonPath();
	String changed_address = js_2.get("address");
	System.out.println("the changed address is : " + changed_address);
	Assert.assertEquals(changed_address, newAddress);
	
	
	
	


		
	

	}

}
