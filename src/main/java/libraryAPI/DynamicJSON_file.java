package libraryAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DynamicJSON_file {
	
	public String id;

	@Test
	public void add_book() throws IOException
	{
		
		RestAssured.baseURI="http://216.10.245.166";
		Response post_book = RestAssured
		.given().log().all().header("Content-Type","application/json").body(generateResource("./json_values/addbookDetails.json"))
		.when().post("/Library/Addbook.php");
		int statusCode = post_book.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
	
		
		JsonPath jsonPathResponse = post_book.jsonPath();
		String message = jsonPathResponse.get("Msg");
		id = jsonPathResponse.get("ID");
		System.out.println("the message is : " + message);
		System.out.println("the id is : " + id);
	}
	
	public static String generateResource(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}
		
		

}
