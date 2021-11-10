package com.qe.daraz.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qe.daraz.Util.BasePageObject;

public class SearchResultPage extends BasePageObject{

	private WebElement imgFirstProduct = driver.findElement(By.xpath("(//div[@data-tracking='product-card']//img)[1]"));
	private WebElement lblIFirsttemPrice = driver.findElement(By.xpath("(//div[@data-tracking='product-card']//span)[1]"));
	public SearchResultPage(WebDriver driver) {
		super(driver);
		
	}

	public SingleProductPage clickOnFirstProduct() throws Exception {
		try {
			imgFirstProduct.click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.invisibilityOf(imgFirstProduct));
			return new SingleProductPage(driver);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public int getFirstItemPrice() throws Exception {
		try {
			return Integer.parseInt(lblIFirsttemPrice.getText().replaceAll("Rs.", "").replaceAll(",", "").trim());
		} catch (Exception e) {
			throw e;
		}
	}
}
