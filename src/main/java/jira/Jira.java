package jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Jira {
	public static RequestSpecification request;
	public int statusCode;
	public static String created_jira_key;


	@Test
	public void test()
	{
		RestAssured.baseURI="https://babbikaush.atlassian.net/rest/api/2/issue";
		RestAssured.authentication=	RestAssured.preemptive().basic("kaushbabbi@gmail.com","4p8vz6ok7IAPE3VJMEEuC0F4");
		
		request = RestAssured.given().log().all().contentType(ContentType.JSON);
		Response response_create = request
				.body(Payload.create_issue_payload())
				.post();
				
				statusCode = response_create.getStatusCode();
				System.out.println(statusCode);
				
				JsonPath jsonPathResponse = response_create.jsonPath();
				
				jsonPathResponse.prettyPrint();
				created_jira_key = jsonPathResponse.get("key");
				System.out.println("the created jira is : " + created_jira_key);
				
	}

}
