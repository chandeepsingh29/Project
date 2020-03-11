package weather123;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestCreateUser 
{
	public void f() throws IOException
	{
		private final String CONTEXT_PATH = "/mobile-app-ws";
		
		
		void setUp() throws Exception
		{
			RestAssured.baseURI = "http://localhost";
			RestAssured.port = 8080;
					
		}
		
		@Test
		final void testCreateUser()
		{
			List <Map<String , Object>> userAddress = new ArrayList<>();
			
			Map<String , Object> shippingAddress = new HashMap<>();
			
			shippingAddress.put("City","Delhi");
			shippingAddress.put("Countr","India");
			shippingAddress.put("PinCode","110010");
			
			userAddress.add(shippingAddress);
			
			Map<String , Object> userDetails = new HashMap<>();
		  
			userDetails.put("FirstName","Chandeep");
			userDetails.put("LastName","Singh");
			
		given.contentType("application/json").
		accept("application/json").
		body(userDetails).
		when().
		post(CONTEXT_PATH + "/users").
		then().
		statusCode(200).
		contentType("application/json");
		extract().
		reposnse();

		String userID = response.jsonPath().getString("userID");
		assertNotNull(userId);
		
		}
			
	}
}