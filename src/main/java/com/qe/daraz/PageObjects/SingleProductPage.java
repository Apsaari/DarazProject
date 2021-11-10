package com.qe.daraz.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qe.daraz.Util.BasePageObject;

public class SingleProductPage extends BasePageObject{

	private List<WebElement> imgFromTheSameStoreItems = driver.findElements(By.xpath("//h6[text()='From The Same Store']/..//div[@class='pdp-common-image product-image']"));
	private List<WebElement> lblFromTheSameStoreItemsPrices = driver.findElements(By.xpath("//h6[text()='From The Same Store']/..//div[@class='product-price']"));

	public SingleProductPage(WebDriver driver) {
		super(driver);
	
	}

	public int getFromTheSameStoreItemCount() throws Exception {
		try {
			return imgFromTheSameStoreItems.size();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public ArrayList<Integer> getFromTheSameStoreItemPrices() throws Exception {
		ArrayList<Integer> prices = new ArrayList<Integer>();
		try {
			for (int i = 0; i < lblFromTheSameStoreItemsPrices.size(); i++) {
				prices.add(Integer.parseInt(lblFromTheSameStoreItemsPrices.get(i).getText().replaceAll("Rs.", "").replaceAll(",","").trim()));
			}
			return prices;
		} catch (Exception e) {
			throw e;
		}
	}
}
