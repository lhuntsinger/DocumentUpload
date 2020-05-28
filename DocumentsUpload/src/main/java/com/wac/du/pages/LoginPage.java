package com.wac.du.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wac.du.base.TestBase;
import com.wac.du.helper.Waits;


public class LoginPage extends TestBase {
	
	@FindBy(id = "i0116")
	WebElement signOn;
	
	@FindBy(id = "idSIButton9")
	WebElement nxtBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
		}
	
	public boolean verifyLoginPageDisplayed() {
		
		 Waits.explicitWaitForElementVisible(signOn);
		 Boolean isDisplayed = signOn.isDisplayed();
		 return isDisplayed;
	}	
	
	
	public void enterLoginDetails() {

	   String email = prop.getProperty("developerEmail");
	   signOn.sendKeys(email);
	   log.info("Developer Email was used: " + email);
	   nxtBtn.click();
	   log.info("Next button was clicked");
	}


}
