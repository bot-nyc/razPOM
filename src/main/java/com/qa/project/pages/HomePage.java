/**
 * 
 */
package com.qa.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.project.base.BasePage;

/**
 * @author ZAMAN
 *
 */
public class HomePage extends BasePage {
	WebDriver driver;
	
	
//1. Define page objects with the help of page factory OR By locator
//2. Page actions / methods of the feature
	
	@FindBy(xpath="//a[contains(text(),'Shop')]")
	WebElement shoplink;
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement homelink;
	
//1.b create a constructor of page class and initialize all the page objects with the driver:
	public HomePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
//2. define actions/methods:
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyShoplink() {
		return shoplink.isDisplayed();
	}
	public void clickShoplink() {
		shoplink.click();
	}
		
	public boolean verifyHomePageLink() {
		return homelink.isDisplayed();
	}
	public void clickHomeLink() {
		homelink.click();
	}
}
