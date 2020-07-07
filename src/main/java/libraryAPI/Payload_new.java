package libraryAPI;

public class Payload_new {
	public static String add_book(String isbn,String aisle,String name)
	{
		String add= "{\r\n" + 
				"\r\n" + 
				"\"name\":\"new book\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\""+name+"\"\r\n" + 
				"}\r\n" + 
				"";
		return add;
	}

}
