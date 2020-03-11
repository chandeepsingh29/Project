package weather123;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import io.restassured.RestAssured;
//import io.restassured.http.Method;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;

public class BaseClass 
{
	
	public static void main (String args[])
	{	
		GoogleAPI_Weather A1 = new GoogleAPI_Weather();
		String temp1[] = A1.GetWeatherDetails(Read_WriteExcel.getCity("//resources//excelFiles//Weather.xlsx"));
		
		Read_WriteExcel.writeTemperature("//resources//excelFiles//Weather.xlsx",temp1);
		
	}
		
}





//	static WebDriver driver;
//	static WebDriverWait wait;
//	
//	public void initializeDriver(String browserName) 
//	
//	{
//		System.getProperty("user.dir");
//		String path = System.getProperty("user.dir");
//		
//		if (browserName.equalsIgnoreCase("Firefox")) 
//			{
//				System.setProperty("webdriver.gecko.driver", path + "\\resources\\executables\\geckodriver.exe");
//				driver = new FirefoxDriver();
//				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//			} 
//			else if (browserName.equalsIgnoreCase("chrome")) 
//			{
//				System.setProperty("webdriver.chrome.driver", path + "\\resources\\executables\\chromedriver.exe");
//				driver = new ChromeDriver();
//				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//			} 
//	}
//	
////	public void enter_URL(String URL) 
////	{
////		driver.navigate().to(URL);
////		driver.manage().window().maximize();
////	}
//	
////	public void close_Browser() 
////	{
////		driver.quit();
////	}
//	
//	public void GetWeatherDetails()
//	{
//		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
//		RequestSpecification httpRequest = RestAssured.given();
//		Response response = httpRequest.request(Method.GET,"Hyderabad");
//		
//		String responseBody = response.getBody().asString();
//		
//		String statusLine = response.getStatusLine();
//		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Correct status code returned");
//		
//		System.out.println("Response Body is = " + responseBody);
//	}
//
//}
