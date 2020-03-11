package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.LoginPage;
import pages.SignOnPage;
import utils.TestBase;


public class SignOnPageSteps extends TestBase
{
	LoginPage loginPage = new LoginPage(driver);
	SignOnPage signOnPage = new SignOnPage(driver);
	
	@Given("^User opens a browser$")
	public void user_opens_a_browser() 
	{
//		System.out.println("given step1");
		TestBase.initialization();
	}

	@When("^User navigates to Mercury Tours Page$")
	public void user_navigates_to_Mercury_Tours_Page() 
	{
//		System.out.println("when step1");

		String loginTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals("Welcome: Mercury Tours",loginTitle);
	}

	@When("^User enters the invalid details$")
	public void user_enters_the_invalid_details() 
	{
//		System.out.println("when step2");
		
		signOnPage = loginPage.invalidLogin("username","password");
	}

	@Then("^User should not be able to login$")
	public void user_should_not_be_able_to_login() 
	{
//		System.out.println("Then step1");
		
		String signOnTitle = signOnPage.validateSignOnPageTitle();
		Assert.assertEquals("Sign-on: Mercury Tours",signOnTitle);
	}
	
}
