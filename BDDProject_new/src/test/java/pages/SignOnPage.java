package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.TestBase;

public class SignOnPage extends TestBase
{

	@FindBy(xpath="//img(src='/images/masts/mast_signon.gif')")
	WebElement signOn;

	public SignOnPage(WebDriver driver)
	{
	TestBase.driver = driver;
	}

	public String validateSignOnPageTitle()
	{
		System.out.println("Unsuccessful Login: User is on Sign On Page");
		return driver.getTitle();		
	}
	
}
