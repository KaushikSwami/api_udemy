package jira;

public class Payload {
	public static String create_issue_payload()
	{
		return"{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\":\"RES\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \"blank screen issue\",\r\n" + 
				"       \"description\": \"Steps to repro: 1 install and launch the app\",\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"}";
		
	}

}
