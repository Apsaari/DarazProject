package com.qe.daraz.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	protected WebDriver driver;
	
	public void initialization()throws Exception{
		try {	
			 System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe"); 
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			 driver.get("https://www.daraz.lk/");	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@AfterSuite
	public void tearDown() throws Exception {
		try {
			if (driver != null)
				driver.quit();
		} catch (Exception e) {
			throw e;
		}
	}
}
