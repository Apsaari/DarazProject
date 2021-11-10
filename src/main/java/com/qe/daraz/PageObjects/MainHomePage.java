package com.qe.daraz.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qe.daraz.Util.BasePageObject;

public class MainHomePage extends BasePageObject{
	
	private WebElement lblDarazMall = driver.findElement(By.xpath("//div[@class='text-wrap text-top' and text()='DarazMall']"));
	private WebElement txtSearchBox = driver.findElement(By.id("q"));
	private WebElement icnSearch = driver.findElement(By.xpath("//button[text()='SEARCH']"));
	
	public MainHomePage(WebDriver driver) {
		super(driver);
		
	}
	
	public void verifyPageLoad() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(lblDarazMall));
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public SearchResultPage searchProduct(String searchKeyword) throws Exception {
		try {
			txtSearchBox.sendKeys(searchKeyword);
			icnSearch.click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.invisibilityOf(lblDarazMall));
			return new SearchResultPage(driver);
		} catch (Exception e) {
			throw e;
		}
	}
	



}
