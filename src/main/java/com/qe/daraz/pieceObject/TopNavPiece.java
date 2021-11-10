package com.qe.daraz.pieceObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qe.daraz.PageObjects.LoginPage;
import com.qe.daraz.Util.BasePageObject;

public class TopNavPiece extends BasePageObject{

	private WebElement lblLogin = driver.findElement(By.id("anonLogin"));
	public TopNavPiece(WebDriver driver) {
		super(driver);
	}

	public LoginPage clickOnLoginButton() throws Exception {
		try {
			lblLogin.click();
			return new LoginPage(driver);
		} catch (Exception e) {
			throw e;
		}
	}
}
