package chaining;
import org.testng.Assert;
import org.testng.annotations.Test;
import files.Payload;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddPlace extends BaseRequest {
	
	@Test
	public void add_place()
	{
		 Response addPlace = request.body(Payload.add_place()).when().post("/maps/api/place/add/json");
		 int statusCode = addPlace.getStatusCode();
		 Assert.assertEquals(statusCode, 200);
		 
		 JsonPath jsonPathResponse = addPlace.jsonPath();
		 place_id = jsonPathResponse.get("place_id");
		 System.out.println("the obtained place is is : " + place_id);
	}

}
