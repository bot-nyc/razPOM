package com.qa.project.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.project.base.BasePage;
import com.qa.project.commonUtilily.commonWait;
import com.qa.project.commonUtilily.constants;
import com.qa.project.pages.HomePage;

public class HomePageTest {
	
	BasePage basepage;
	WebDriver driver;
	Properties prop;
	HomePage homepage;
	
	@BeforeMethod
	public void setup() {
		basepage = new BasePage();
		driver = basepage.initialize_driver();
		prop = basepage.initialize_properties();
		driver.get(prop.getProperty("url"));
		homepage = new HomePage(driver);
	}
	
	@Test(priority=0)
	public void verifyHomePageTitleTest() {
		String title = homepage.getHomePageTitle();
		System.out.println("Title of the home page is "+title);
		Assert.assertEquals(title, constants.HOMEPAGE_TITLE,"Title is not correct");
		Assert.assertTrue(homepage.verifyShoplink(), "Shop link not visible");
		homepage.clickShoplink();
		commonWait.shortWait();
		homepage.clickHomeLink();
		
		
	}
	@Test(priority=1,enabled=false)
	public void clickshoplinkTest() {
	  homepage.verifyShoplink();
	  homepage.clickShoplink();
	}
	@Test(priority=2,enabled=false)
	public void clickshopTest() {
		homepage.clickShoplink();
	}
	
	
	
	
	@AfterMethod
	public void teardown() {
		//driver.quit();
	}

}
