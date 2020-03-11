package org.demo.selenium.test;

import java.util.Properties;

import org.demo.selenium.pages.MercuryBookFlightPage;
import org.demo.selenium.pages.MercuryFindFlightPage;
import org.demo.selenium.pages.MercuryFlightConfirmationPage;
import org.demo.selenium.pages.MercuryLoginPage;
import org.demo.selenium.pages.MercurySelectFlightPage;
import org.demo.selenium.utils.DriverManager;
import org.demo.selenium.utils.TestUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * Testcase for MercuryTest
 */
public class MercuryTestJunit
{
	static WebDriver driver;
	String strLoginID, strPassword;
	static Properties property;
	
	@BeforeClass
   public static void launchapp() 
   {
		property = TestUtilities.loadConfigProperties();
		//Invokes browser
		System.out.println("in launch app:" +  property.getProperty("browser"));
		driver = DriverManager.getDriverInstance(property.getProperty("browser"), 20);

		//Embed WebDriver listeners into the driver		
		driver.get(property.getProperty("url"));   
   }
   
//   @Test
//   public void ValidLoginToMercury() throws InterruptedException
//   {
//	   driver = DriverManager.getDriver();	
//	   strLoginID ="mercury"; strPassword ="mercury";
//	   MercuryLoginPage loginPage = new MercuryLoginPage(driver);
//	   MercuryFindFlightPage mercuryFindFlightPage = new MercuryFindFlightPage(driver);
//	   mercuryFindFlightPage = loginPage.performMercuryLogin(strLoginID, strPassword);
//	   
//	   WebDriverWait wait = new WebDriverWait(driver, 20);
//	   wait.until(ExpectedConditions.titleIs("Find a Flight: Mercury Tours:"));
//	   
//	   mercuryFindFlightPage.validateMercuryFindFlightPage();
//   }
 
   @Test
   public void BookFlight() throws InterruptedException
   {
	   driver = DriverManager.getDriver();	
	   WebDriverWait wait = new WebDriverWait(driver, 20);
	   
	   strLoginID ="mercury"; strPassword ="mercury";

	   MercuryLoginPage loginPage = new MercuryLoginPage(driver);
	   MercuryFindFlightPage mercuryFindFlightPage = new MercuryFindFlightPage(driver);
	   
	   wait.until(ExpectedConditions.titleIs("Welcome: Mercury Tours"));
	   mercuryFindFlightPage = loginPage.performMercuryLogin(strLoginID, strPassword);
	   
	   wait.until(ExpectedConditions.titleIs("Find a Flight: Mercury Tours:"));
	   mercuryFindFlightPage.validateMercuryFindFlightPage();
	   
	   mercuryFindFlightPage.selectFlightType("oneway");
	   mercuryFindFlightPage.selectPassengers("1");
	   mercuryFindFlightPage.selectDepartFrom("London");
	   mercuryFindFlightPage.selectDepartTo("Paris");
	   mercuryFindFlightPage.selectServiceClass("Coach");
	   
	   MercurySelectFlightPage mercurySelectFlightPage = new MercurySelectFlightPage(driver);
	   mercurySelectFlightPage = mercuryFindFlightPage.clickContinue();
	   
	   wait.until(ExpectedConditions.titleIs("Select a Flight: Mercury Tours"));
	   mercurySelectFlightPage.validateMercurySelectFlightPage();	
	   mercurySelectFlightPage.verifyFlightPage();
	   
	   MercuryBookFlightPage mercuryBookFlightPage = new MercuryBookFlightPage(driver);
	   mercuryBookFlightPage = mercurySelectFlightPage.clickContinue();
	   wait.until(ExpectedConditions.titleIs("Book a Flight: Mercury Tours"));
	   mercuryBookFlightPage.validateMercuryBookFlightPage();
	   	   
	   System.out.println("Hogai Book123");
	   
	   MercuryFlightConfirmationPage mercuryFlightConfirmationPage = new MercuryFlightConfirmationPage(driver);
	   mercuryFlightConfirmationPage = mercuryBookFlightPage.clickContinue();
	   wait.until(ExpectedConditions.titleIs("Flight Confirmation: Mercury Tours"));
	   mercuryFlightConfirmationPage.validateMercuryFlightConfirmationPage();
	   mercuryFlightConfirmationPage.displayTicketPrice();  
	   
	   System.out.println("Hogai Book");
	   
	}


   @AfterClass
	public static void killMethod() {
		DriverManager.killDriverInstance();

	}
   
}
