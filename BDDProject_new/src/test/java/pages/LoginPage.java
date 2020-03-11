package pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

import utils.TestBase;

public class LoginPage extends TestBase
{
	By uName = (By.cssSelector("input[name='userName']"));
	By password = (By.cssSelector("input[name='password']"));
	By btn_signin = (By.cssSelector("input[name='login']"));
	
	public LoginPage(WebDriver driver)
	{
	TestBase.driver = driver;
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}

	public SignOnPage invalidLogin(String un, String pwd)
	{
		System.out.println("User is on Login Page");
		
		driver.findElement(uName).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(btn_signin).click();
		
		return new SignOnPage(driver);
	}
	
}
