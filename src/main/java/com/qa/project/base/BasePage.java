package com.qa.project.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	
	public WebDriver initialize_driver() {
		
		driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public Properties initialize_properties() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\faiso\\eclipse-workspace\\ZamanMaven\\src\\main\\java"
																		+"\\com\\qa\\project\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	

}
