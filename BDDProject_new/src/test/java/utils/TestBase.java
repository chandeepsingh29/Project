package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties property;
	
	public TestBase()
	{
		try
		{
			property = new Properties();
			FileInputStream fis = new FileInputStream("/Users/csin15/eclipse-workspace/BDDProject/src/test/java/config/config.properties");
			property.load(fis);
			
		}catch (IOException e)
		{
			e.getMessage();
		}
		
	}

	public static void initialization()
	{
		String browserName = property.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\properties\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\properties\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "Users\\csin15\\eclipse-workspace\\BDDProject\\src\\test\\resources\\properties\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(property.getProperty("url"));
	}
}

