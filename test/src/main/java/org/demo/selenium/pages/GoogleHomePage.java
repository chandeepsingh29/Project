package org.demo.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage 
{
	WebDriver driver;
   
   	By txtBox_Search = (By.cssSelector("input[title='Search']"));
	By btn_Search = (By.cssSelector("button[type='submit']"));
	
	public GoogleHomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public GoogleHomePage setSearchValue(String searchValue)
	{
		driver.findElement(txtBox_Search).sendKeys(searchValue);
		return this;
	}
	
	public GoogleHomePage clickSearch()
	{
		driver.findElement(btn_Search).click();
		return this;
	}
	
	public SearchResultsPage performGoogleSearch(String strValue){
		setSearchValue(strValue);
		clickSearch();		
		return new SearchResultsPage(driver);
	}
	
}
