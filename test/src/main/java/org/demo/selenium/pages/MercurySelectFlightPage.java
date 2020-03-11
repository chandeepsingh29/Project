package org.demo.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MercurySelectFlightPage {
	WebDriver driver;

	By lbl_HeaderMsg = (By.xpath("//td/font[contains(text(),'Select your departure')]"));
	By btn_Continue = (By.name("reserveFlights"));
	
	public MercurySelectFlightPage(WebDriver driver){
		
		this.driver = driver;	
	}	
	
	public void validateMercurySelectFlightPage(){
		
		if(driver.getTitle().contains("Select a Flight: Mercury Tours"))
		{
			System.out.println("Landed to Expected Page: " + driver.getTitle());			
		}
		else
		{
			System.out.println("Landed to Incorrect Page: " + driver.getTitle());			
		}
	}

	public void verifyFlightPage(){			
			if(driver.findElement(lbl_HeaderMsg)!= null){
					System.out.println("User is on Select Flight page ");
			}
	}	

	public MercuryBookFlightPage clickContinue(){
		driver.findElement(btn_Continue).click();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new MercuryBookFlightPage(driver);
	}
	
		
}
