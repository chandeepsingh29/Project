package org.demo.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchResultsPage 
{
	WebDriver driver;   
	
	public SearchResultsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public SearchResultsPage verifyTitle(WebDriver driver)
	{
		Assert.assertTrue(driver.getTitle().contains("- Google Search"),"Title is not matching");
		return this;
	}
	
}
