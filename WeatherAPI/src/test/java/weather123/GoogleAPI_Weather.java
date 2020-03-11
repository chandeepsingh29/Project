package weather123;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GoogleAPI_Weather 
{
	String cityname[];
	String Temp[];
	
	public String[] GetWeatherDetails(String[] city)
	{
		cityname = city;
		Temp = new String[cityname.length];
				
		for (int i = 0; i<cityname.length ; i++)
		{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,cityname[i]);
		
		String responseBody = response.getBody().asString();
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Correct status code returned");
		
		System.out.println("Response Body is = " + responseBody);
		Assert.assertEquals(responseBody.contains(cityname[i]), true, "Resonse body contains " + cityname[i]);
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		Temp[i] = jsonPathEvaluator.get("Temperature");
		String getCity = jsonPathEvaluator.get("City");
		
		Assert.assertEquals(getCity, cityname[i], "Correct city name received in the Response");
		System.out.println("Temperature of " + cityname[i] + " = " + Temp[i]);
		
		}

		return (Temp);
	}
	
}
