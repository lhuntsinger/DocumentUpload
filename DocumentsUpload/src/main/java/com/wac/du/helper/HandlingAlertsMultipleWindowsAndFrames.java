package com.wac.du.helper;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.wac.du.base.TestBase;

public class HandlingAlertsMultipleWindowsAndFrames extends TestBase {

	public static void verifyAlertMsg(String alertMsg) {
		String altMsg = driver.switchTo().alert().getText();
		Assert.assertEquals(altMsg, alertMsg, "The expected and actual alert msg are different");
		log.info("The actual alert msg is : " +altMsg+ "The expected alert msg is: " +alertMsg);
	}
	
	public static void acceptAlert() {
		driver.switchTo().alert().accept();
		log.info("Accepted alert");
	}
	
	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();
		log.info("dismissed alert");
	}
	
	public static void sendInfoToAlert(String message) {
		
		driver.switchTo().alert().sendKeys(message);
		log.info("The message sent to the alert was: " +message);
		
	}
	
	public static boolean isAlertDisplayed() {
		    boolean foundAlert = false;
		    WebDriverWait wait = new WebDriverWait(driver, 10);
		    try {
		        wait.until(ExpectedConditions.alertIsPresent());
		        foundAlert = true;
		    } catch (TimeoutException eTO) {
		        foundAlert = false;
		    }
		    return foundAlert;
	}
	
	public static void switchWindow(String session) {
		
		driver.switchTo().window(session);
		
	}
	
	
	public static void switchWindow() {
		
		String MainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();		
        Iterator<String> i1 = s1.iterator();
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		    
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);	                                                                                                           
	
            }		
        }		
		
	}
	
}
