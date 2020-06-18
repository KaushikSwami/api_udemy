package chaining;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeSuite;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {
	
	public static RequestSpecification request;
	public static String newAddress="bkoil,trichy";
	public static String place_id;
	
	@BeforeSuite
	public void initialize()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		Map<String,String> parameters=new HashMap<String,String>();
		parameters.put("key", "qaclick123");
		
		request = RestAssured.given().log().all().queryParams(parameters).accept(ContentType.JSON);
	}

}
