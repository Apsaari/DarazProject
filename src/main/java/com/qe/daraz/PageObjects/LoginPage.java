package com.qe.daraz.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qe.daraz.Util.BasePageObject;

public class LoginPage extends BasePageObject {
	
	private WebElement txtUsername = driver.findElement(By.xpath("//input[@type = 'text']"));
    private	WebElement txtPassword = driver.findElement(By.xpath("//input[@type = 'password']"));
	private WebElement btnLogin = driver.findElement(By.xpath("//button[@type = 'submit']"));

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public MainHomePage loginToTheSystem(String username , String password) throws Exception {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(txtUsername));
			txtUsername.sendKeys(username);
			txtPassword.sendKeys(password);
			btnLogin.click();
			wait.until(ExpectedConditions.invisibilityOf(txtUsername));
			return new MainHomePage(driver);
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	

}
