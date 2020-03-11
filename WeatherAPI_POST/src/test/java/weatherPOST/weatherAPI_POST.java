package weatherPOST;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class weatherAPI_POST {

		    @Test
		    public void test() {
		        String requestBody = "{\n" +
		                "   \"time_period\":{\n" +
		                "      \"start\":{\n" +
		                "         \"expression\":\"after\",\n" +
		                "         \"amount\":132000000\n" +
		                "      },\n" +
		                "      \"end\":{\n" +
		                "         \"expression\":\"after\",\n" +
		                "         \"amount\":432000000\n" +
		                "      }\n" +
		                "   }\n" +
		                "}";

		        RestAssured.baseURI = "http://api.openweathermap.org/data/3.0/triggers";
		        RequestSpecification requestSpecification = RestAssured.given();
		        requestSpecification.header("Content-Type", "application/json");
		        requestSpecification.body(requestBody);
		        requestSpecification.queryParam("appid", "1bea400ab3c188a35e3ae11b83a98707");
		        Response response = requestSpecification.post();

		        String successCode = response.jsonPath().get("SuccessCode");
		        System.out.println("Status Code is : " + response.statusCode());
		        System.out.println("Response body: " + response.body().asString());
		        
		        Assert.assertEquals(response.statusCode(), 201);
	
		    }
}





























		
		
//		
//		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
//		RequestSpecification httpRequest = RestAssured.given();
//		Response response = httpRequest.request(Method.POST,"/register");
//		
//		JSONObject requestParams = new JSONObject();
//	
//		requestParams.put("FirstName","Chandeep");
//		requestParams.put("LastName","Singh");
//		requestParams.put("UserName","csingh");
//	  
//		Object key = requestParams.keySet();
//		System.out.println(key.toString());
//
//
//		httpRequest.header("Content-Type", "application/json");
//		httpRequest.body(requestParams.toJSONString());
//  
////	  	Response response = request.post("/register");
//		
//		String responseBody = response.getBody().asString();
//		
//		int statusCode = response.getStatusCode();
//		System.out.println("The status code received is " + statusCode);
//
//		Assert.assertEquals(statusCode, 400);
//		String successCode = response.jsonPath().get("SuccessCode");
//		
//		}
//	}
//

