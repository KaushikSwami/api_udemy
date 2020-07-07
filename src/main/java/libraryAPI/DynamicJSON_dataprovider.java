package libraryAPI;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DynamicJSON_dataprovider {
	
	public String id;

	
	@Test(dataProvider="booksData")
	public void add_book(String isbn,String aisle,String name)
	{
		
		RestAssured.baseURI="http://216.10.245.166";
		Response post_book = RestAssured
		.given().log().all().header("Content-Type","application/json").body(Payload_new.add_book(isbn,aisle,name))
		.when().post("/Library/Addbook.php");
		int statusCode = post_book.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
	
		
		JsonPath jsonPathResponse = post_book.jsonPath();
		String message = jsonPathResponse.get("Msg");
		id = jsonPathResponse.get("ID");
		System.out.println("the message is : " + message);
		System.out.println("the id is : " + id);
		
		
	}
	
	@DataProvider(name="booksData")
	public Object[][] getData()
	{
		return new Object[][] {{"asdzxc","90909090","kauhsik"},{"zxcasd","80808080","venkat"},{"qweasd","707070","babbi"}};
	}
	

}
