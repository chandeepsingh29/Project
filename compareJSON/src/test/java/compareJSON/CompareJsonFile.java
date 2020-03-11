package compareJSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;


public class CompareJsonFile 
{
	@Test
	public void method1() throws Throwable
	{	
		HashMap<Object, Object> hashmap1 = new HashMap<>();
		HashMap<Object, Object> hashmap2 = new HashMap<>();
		
        JSONParser jsonParser = new JSONParser(); 
        
        try
        {
        	//Storing key value pair of JsonFile1 in HashMap
        	Object obj1 = jsonParser.parse(new FileReader("File1.json"));
        	
            JSONObject jsonObject =  (JSONObject) obj1;     
          
            for(Object key : jsonObject.keySet())
            {
            	hashmap1.put(key, jsonObject.get(key));
            }
            System.out.println("hashmap1: " + hashmap1);  

            
            //Storing key value pair of JsonFile2 in HashMap
            Object obj2 = jsonParser.parse(new FileReader("File2.json"));
            JSONObject jsonObject2 =  (JSONObject) obj2; 
            for(Object key : jsonObject2.keySet())
            {
            	hashmap2.put(key, jsonObject2.get(key));
            }
            System.out.println("hashmap2: " + hashmap2);

            
            System.out.println("\nBelow are the elements present in both json:");
            for(Object key : hashmap1.keySet())
            {
         
            	if(hashmap2.containsKey(key))
            	{
            		System.out.println('\n');
            		System.out.println(key.toString() + ":");
            		
            		String value1  = hashmap1.get(key).toString();
            		System.out.println(value1);

            		String value2 = hashmap2.get(key).toString();
            		System.out.println(value2);  
            		
            		if(value1.equals(value2))
            		{
            			System.out.println("Values are same");
            		}else 
            		{
            			System.out.println("Values are different");
            		}
            	}else 
            	{
            		System.out.println(key.toString() + " is not present in hashmap 2");
            	}
            	
            }
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        catch (ParseException e) 
        {
            e.printStackTrace();
        }
	}

}
