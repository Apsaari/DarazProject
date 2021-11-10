package com.qe.daraz.TestObjects;


import java.util.ArrayList;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qe.daraz.PageObjects.MainHomePage;
import com.qe.daraz.PageObjects.SearchResultPage;
import com.qe.daraz.Util.TestBase;
import com.qe.daraz.pieceObject.TopNavPiece;


public class DarazTest extends TestBase{
	
	private TopNavPiece topNavPiece;
	private String username;
	private String password;
	
	@Parameters({"username", "password"})
	@BeforeClass
	public void beforClass(String username,String password) throws Exception{
		this.username = username;
		this.password = password;
		initialization();
		topNavPiece = new TopNavPiece(driver);
	
	}
	
	@BeforeMethod
	public void beforMethod() throws Exception{
		if (((RemoteWebDriver) driver).getSessionId() == null) {
			beforClass(username, password);
		}
	}
	
	@AfterMethod
	public void afterMethod() throws Exception{
		if (((RemoteWebDriver) driver).getSessionId() != null) {
				driver.quit();
		}
	}
	
	@Test(priority = 1,enabled = true)
	public void verifyFromTheSameStroeItemCount() throws Exception{
		try {
			topNavPiece.clickOnLoginButton().loginToTheSystem(username, password).verifyPageLoad();
			Assert.assertEquals(new MainHomePage(driver).searchProduct("watch").clickOnFirstProduct().getFromTheSameStoreItemCount(), 4,"same store item count not matched");
		} catch (Exception e) {
			throw e;
		}		
	}
	
	@Test(priority = 2,enabled = true)
	public void verifyFromTheSameStroeItemPriceRange() throws Exception{
	 int itemPrice;
	 ArrayList<Integer> prices = new ArrayList<Integer>();
		try {
			topNavPiece.clickOnLoginButton().loginToTheSystem(username, password).verifyPageLoad();
			itemPrice = new MainHomePage(driver).searchProduct("watch").getFirstItemPrice();
			prices =  new SearchResultPage(driver).clickOnFirstProduct().getFromTheSameStoreItemPrices();
			for (int i = 0; i < prices.size(); i++) {
				Assert.assertTrue(prices.get(i) > (itemPrice-500) ,"recommended items price is not in the range");
				Assert.assertTrue((itemPrice+1500) < prices.get(i) ,"recommended items price is not in the range");
			}
		} catch (Exception e) {
			throw e;
		}		
	}

}
