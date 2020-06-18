package chaining;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class EditPlace extends BaseRequest{
	
	@Test
	public void edit_place()
	{
		System.out.println(place_id);
		Response editPlace = request.body(Payload.put_place())
		.when().put("/maps/api/place/update/json");
		
		JsonPath js_1=editPlace.jsonPath();
		String message_address = js_1.get("msg");
		System.out.println(message_address);
		
	}

}
