package WeatherAPI;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Api {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://api.openweathermap.org";
		
		Map<String,String> parameters=new HashMap<String,String>();
		parameters.put("q","chennai");
		parameters.put("appid", "9357be8341ede19dcf37432e0c487838");
		Response response = RestAssured.given().log().all().params(parameters).accept(ContentType.JSON)
				                       .when().get("/data/2.5/weather");
		
		JsonPath jsonPathResponse = response.jsonPath();
		int id = jsonPathResponse.get("sys.id");
		String country = jsonPathResponse.get("sys.country");
		String city_name = jsonPathResponse.get("name");
		
		String weather_desc = jsonPathResponse.get("weather["+0+"].description");
		
		System.out.println("the id is : " + id);
		System.out.println("the country name is : " + country);
		System.out.println("the city name is : " + city_name);
		System.out.println("the weather description is : " + weather_desc);
		
		
	}

}
