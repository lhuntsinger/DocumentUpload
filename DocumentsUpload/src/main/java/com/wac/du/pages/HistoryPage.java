package com.wac.du.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wac.du.base.TestBase;
import com.wac.du.helper.Waits;




public class HistoryPage extends TestBase {
	
	@FindBy(xpath = "//li/a[@routerlink = '/history']")
	WebElement history;
	
	@FindBy(linkText = "REQUEST")
	WebElement request;
	
	@FindBy(linkText = "48201")
	WebElement loanId;
	
	@FindBy(linkText = "48701")
	WebElement loanNullId;
	
	@FindBy(linkText = "48700")
	WebElement loanJointId;
	
	@FindBy(xpath = "//th[contains(text(), 'ID')]")
	WebElement id;
	
	@FindBy(xpath = "//div/div/p[contains(text(), 'Sending')]")
	WebElement msgSendNotification;
	
	@FindBy(xpath = "//div/label[contains(text(), 'Notification')]")
	WebElement lblNotification;
	
	
	public HistoryPage(){
		PageFactory.initElements(driver, this);
		}
	
	public boolean verifyHistoryPageDisplayed() {
		Waits.explicitWaitForElementVisible(id);
		Waits.explicitWaitForElementVisible(history);
		String classValue = history.getAttribute("class").toString();
		log.info(classValue);
		boolean isActive = classValue.contains("active");
		return isActive;
		
	}
	
	public HistoryPage clickLoanId() {
		loanId.click();
		log.info("Individual Borrower Loan ID selected");
		return new HistoryPage();
	}
	
	public HistoryPage clickNullLoanId() {
		loanNullId.click();
		log.info("Null Borrower Loan ID selected");
		return new HistoryPage();
	}
	
	public HistoryPage clickJointLoanId() {
		loanJointId.click();
		log.info("Joint Borrower Loan ID selected");
		return new HistoryPage();
	}


	
	public String checkNotificationMsg() {
		String strSend = msgSendNotification.getText();
		if (strSend.contains("Sending")) {
			log.info("Document Request Email is still in process of being sent");
		}
		else if (strSend.contains("Sent"))
		{
			log.info("Document Request Email has been sent");
		}
		return strSend;
	}
	
	
}
