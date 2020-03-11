package org.demo.selenium.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MercuryFlightConfirmationPage {
	WebDriver driver;
	
	By btn_SecurePurchase = (By.name("buyFlights"));
	// By final_amt = (By)
	
	public MercuryFlightConfirmationPage(WebDriver driver){
		
		this.driver = driver;	
	}	
	
	public void validateMercuryFlightConfirmationPage(){
		
		if(driver.getTitle().contains("Flight Confirmation: Mercury Tours"))
		{
			System.out.println("Landed to Expected Page: " + driver.getTitle());			
		}
		else
		{
			System.out.println("Landed to Incorrect Page: " + driver.getTitle());			
		}
	}
	
public void displayTicketPrice(){
		
	System.out.println("Tickets Confirmed");
	System.out.println("Total Price (including taxes):" + "final_amt");
	
	}
}
