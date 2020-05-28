package com.wac.du.helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wac.du.base.TestBase;

public class Waits extends TestBase {
	
	
	public static void explicitWaitForElementToBeClickable(WebElement element ) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));	
	}
	
	public static void explicitWaitForElementAttributeValue(WebElement element, String attribute, String value ) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}
	
	public static void explicitWaitForElementVisible(WebElement element ) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void explicitWaitForAttributeNotEmpty(WebElement element, String attribute) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
	}

}
