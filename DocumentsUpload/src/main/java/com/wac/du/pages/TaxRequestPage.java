package com.wac.du.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wac.du.base.TestBase;
import com.wac.du.helper.Waits;

public class TaxRequestPage extends TestBase {

	@FindBy(linkText = "TAXES")
	WebElement taxes;
	
	@FindBy(name = "branch")
	WebElement brnch;
	
	@FindBy(id = "inputApplicantSSN")
	WebElement ssn;
	
	@FindBy(id = "inputApplicantFirstName")
	WebElement fName;
	
	@FindBy(id = "inputApplicantLastName")
	WebElement lName;
	
	@FindBy(id = "inputApplicantPhone")
	WebElement phone;
	
	@FindBy(id = "inputApplicantEmail")
	WebElement email;
	
	@FindBy(id = "inputExpiration")
	WebElement expDate;
	
	@FindBy(id = "formsRequired1")
	WebElement idForm;
	
	@FindBy(id = "formsRequired6")
	WebElement w2Form;
	
	@FindBy(id = "formsRequired7")
	WebElement misc;

	public TaxRequestPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	// Verify if Taxes Page is displayed
		public boolean verifyTaxesPageDisplayed() {
			Waits.explicitWaitForElementVisible(taxes);
			String classValue = taxes.getAttribute("class").toString();
			log.info(classValue);
			boolean isActive = classValue.contains("active");
			return isActive;
		}
	
}
