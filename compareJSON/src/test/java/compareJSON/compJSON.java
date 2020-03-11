package compareJSON;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class compJSON 
{
	
	@Test
	public void methodCompare() throws Throwable
	{
//		HashMap<Object, Object> hashmap1 = new HashMap<>();
//		HashMap<Object, Object> hashmap2 = new HashMap<>();
	
	    JSONParser jsonParser = new JSONParser(); 
	    
    	try (FileReader file1 = new FileReader("File1.json"))
        {
    		//Read JSON file
    		Object obj1 = jsonParser.parse("File1.json");
    		
    		JSONObject jsonObj1 =  (JSONObject) obj1;
    		
    		String name = (String) jsonObj1.get("Name");    		
    		String age = (String) jsonObj1.get("Age");
    		String city = (String) jsonObj1.get("City");    

    		System.out.println(name);
    		System.out.println(age);
    		System.out.println(city);
    		
        }   	
        

	}
}
