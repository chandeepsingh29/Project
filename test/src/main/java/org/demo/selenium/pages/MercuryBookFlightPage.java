package org.demo.selenium.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MercuryBookFlightPage {
	WebDriver driver;
	
	By btn_Continue = (By.xpath("buyFlights"));
	
	
	public MercuryBookFlightPage(WebDriver driver){
		
		this.driver = driver;	
	}	
	
	public void validateMercuryBookFlightPage(){
		
		if(driver.getTitle().contains("Book a Flight: Mercury Tours"))
		{
			System.out.println("Landed to Expected Page: " + driver.getTitle());			
		}
		else
		{
			System.out.println("Landed to Incorrect Page: " + driver.getTitle());			
		}
	}

	public MercuryFlightConfirmationPage clickContinue(){
		driver.findElement(btn_Continue).click();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new MercuryFlightConfirmationPage(driver);
	}
	
}
