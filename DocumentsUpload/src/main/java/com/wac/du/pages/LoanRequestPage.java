package com.wac.du.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wac.du.base.TestBase;
import com.wac.du.helper.Waits;

public class LoanRequestPage extends TestBase {

	@FindBy(xpath = "//li/a[@routerlink = '/history']")
	WebElement history;
	
	@FindBy(linkText = "REQUEST")
	WebElement request;
	
	@FindBy(linkText = "LOAN")
	WebElement loan;
	
	@FindBy(linkText = "TAXES")
	WebElement taxes;
	
// Application ID field elements
	@FindBy(id = "inputApplicationId")
	WebElement appId;
	
	@FindBy(xpath = "//div/input[contains(text(), ng-pristine)]")
	WebElement appIdFld;
	
	
// Name field elements for Individual, Null and Joint Borrowers
	@FindBy(id = "inputApplicantName")
	WebElement applicantName;
	
	@FindBy(xpath = "//div/div/input[@id = 'inputApplicantName' and @type = 'text']")
	WebElement applicantNameField;
	
	@FindBy(xpath = "//div/div/select[@name = 'applicant']")
	WebElement applicantPrimaryJBName;
	
	@FindBy(xpath = "//div/div/select/option[@value = '1' and  'text']")
	WebElement primaryJBNameField;
	
	@FindBy(xpath = "//div/div/select/option[contains(text(), 'Joint Secondary')]")
	WebElement applicantSecondaryJBName;
	
	@FindBy(xpath = "//div/div/select/option[@value = '2' and  'text']")
	WebElement secondaryJBNameField;
	
	
// Phone field elements 
	@FindBy(id = "inputPhone")	
	WebElement phone;
	
	@FindBy(xpath = "//div/div/input[@id='inputPhone' and @type='text']")
	WebElement phoneField;
	
	
// Email field elements	
	@FindBy(id = "inputEmail")
	WebElement email;
	
	@FindBy(xpath = "//div/div/input[@id='inputEmail' and @type = 'text']")
	WebElement emailField;
	
	
// Branch field elements	
	@FindBy(id = "inputBranch")
	WebElement branchId;
	
	@FindBy(xpath = "//div/div/input[@id='inputBranch' and @type='text']")
	WebElement branchField;
	
	
// Expiration Date field elements	
	@FindBy(id = "inputExpiration")
	WebElement expDate;
	
	@FindBy(xpath = "//div/div/input[@id='inputExpiration' and @type='text']")
	WebElement expDateField;
	
	
// Notify via SMS elements	
	@FindBy(xpath = "//div/div/label[contains(text(), ' Notify via SMS ')]")
	WebElement phoneNotifyNme;
	
	@FindBy(xpath = "//div/div/input[@id='phoneNotify' and @type='checkbox']")
	WebElement phoneNotifyChkBox;
	
// Notify via Email elements	
	@FindBy(xpath = "//div/div/label[contains(text(), ' Notify via Email ')]")
	WebElement eNotifyNme;
	
	@FindBy(xpath = "//div/div/input[@id='emailNotify' and @type='checkbox']")
	WebElement eNotifyChkBox;
	
	
// Required Documents elements	
	@FindBy(xpath = "//div/div/label[contains(text(), 'ID')]")
	WebElement reqDocIdNme;
	
	@FindBy(id = "defaultCheck1")
	WebElement idChkBox;
	
	@FindBy(id = "formsRequired1")
	WebElement nbrIdFrms;
	
	@FindBy(xpath = "//div/div/label[contains(text(), 'Social Security Card')]")
	WebElement reqDocSSCNme;
	
	@FindBy(id="defaultCheck2")
	WebElement ssCardChkBox;
	
	@FindBy(id = "formsRequired2")
	WebElement nbrSSCrdFrms;
	
	@FindBy(xpath = "//div/div/label[contains(text(), 'Proof of Income')]")
	WebElement reqDocIncomeNme;
	
	@FindBy(id="defaultCheck3")
	WebElement incomeChkBox;
	
	@FindBy(id = "formsRequired3")
	WebElement nbrIncomeFrms;
	
	@FindBy(xpath = "//div/div/label[contains(text(), 'Proof of Residence')]")
	WebElement reqDocResidenceNme;
	
	@FindBy(id="defaultCheck4")
	WebElement residenceChkBox;
	
	@FindBy(id = "formsRequired4")
	WebElement nbrResidenceFrms;
	
	@FindBy(xpath = "//div/div/label[contains(text(), 'Proof of Insurance')]")
	WebElement reqDocInsuranceNme;
	
	@FindBy(id="defaultCheck5")
	WebElement insuranceChkBox;
	
	@FindBy(id = "formsRequired5")
	WebElement nbrInsuranceFrms;
	
	
// Send Request button element	
	@FindBy(xpath = "//div/button[@type = 'submit']")
	WebElement sndReqBtn;
	
	
// Clear button element	
	@FindBy(xpath = "//div/button[@type = 'reset']")
	WebElement clearBtn;
	
	public LoanRequestPage() {
		PageFactory.initElements(driver, this);
	}
	
// Click the Request link
		public LoanRequestPage clickRequest() {
			request.click();
			Waits.explicitWaitForElementVisible(request);
			log.info("REQUEST link was clicked");
			return new LoanRequestPage();
		}
	
// Click the Loan link
		public LoanRequestPage clickLoan() {
			loan.click();
			log.info("LOAN link was clicked");
			return new LoanRequestPage();
		}
	
// Verify if Loan Page is displayed
		public boolean verifyLoanRequestPageDisplayed() {
			Waits.explicitWaitForElementVisible(request);
			Waits.explicitWaitForElementVisible(request);
			String classValue = request.getAttribute("class").toString();
			log.info(classValue);
			boolean isActive = classValue.contains("active");
			if (isActive == true) {
				log.info("Loan Request page is displayed");
			}
			else
			{
				log.info("Loan Request page DID NOT display");
			}
			return isActive;
		}
	
// Verify if Send Request button is disabled
		public boolean verifySndRequestBtnDisabled() {
			Waits.explicitWaitForElementVisible(request);
			String classValue = sndReqBtn.getAttribute("disabled").toString();
			log.info(classValue);
			boolean isDisabled = classValue.contains("tru");
			if (isDisabled == true) {
				log.info("Send Request button is disabled");
			}
			else
			{
				log.info("Send Request button is enabled");
			}
			return isDisabled;
		}
	
// Verify if Send Request button is enabled
		public boolean verifySndRequestBtnEnabled() {
			Waits.explicitWaitForElementVisible(loan);
			String classValue = sndReqBtn.getAttribute("disabled").toString();
			log.info(classValue);
			boolean isEnabled = classValue.contains("");
		  	if (isEnabled == true) {
		  		log.info("Send Request button is enabled");
		  	}
		  	else
		  	{
		  		log.info("Send Request button is disabled");
		  	}
			return isEnabled;
		}
	
	
// Enter Individual Borrower data into Application ID field
		public LoanRequestPage enterAppId() {
			Waits.explicitWaitForElementVisible(appId);
			appId.sendKeys("48201");
			appId.sendKeys(Keys.ENTER);
			log.info("Entered Individual Application ID data"); 
			return new LoanRequestPage();
		}
	
// Enter Null Borrower data into Application ID field
		public LoanRequestPage enterNullAppId() {
			Waits.explicitWaitForElementVisible(appId);
			appId.sendKeys("48701");
			appId.sendKeys(Keys.ENTER);
			log.info("Entered Null Borrower Application ID data"); 
			return new LoanRequestPage();
		}
	
// Enter Joint Borrower data into Application ID field
		public LoanRequestPage enterJointAppId() {
			Waits.explicitWaitForElementVisible(appId);
			appId.sendKeys("48700");
			appId.sendKeys(Keys.ENTER);
			log.info("Entered Joint Borrower Application ID data"); 
			return new LoanRequestPage();
		}
		
// Check Application ID field
		public String checkAppId() {
			Waits.explicitWaitForElementVisible(appId);
			String lnAppId = appId.getAttribute("value");
			log.info("The returned Application ID is: "+lnAppId);
			return lnAppId;
		}
	
	
// Check Name returned for Individual Borrower Application ID
		public String checkName() {
			Waits.explicitWaitForElementVisible(applicantName);
			String lnName = applicantName.getAttribute("value");
			log.info("The returned Name is: " +lnName );
			return lnName;
		}
	
// Verify that Name field is not editable
		public boolean verifyNameNotEditable() {
			applicantNameField.click();
			Boolean isDisabled = applicantNameField.isDisplayed();
			if(isDisabled == true) {
				log.info("Name field is Read Only cannot be edited");
			}
			else
			{
				log.info("Name field IS NOT Read Only can be edited");
			}
			return isDisabled;
		}	
	
	
// Check Name returned for Primary Joint Borrower
		public String checkJBName() {
			Waits.explicitWaitForElementVisible(applicantPrimaryJBName);
			String lnName = applicantPrimaryJBName.getText();
			log.info("The returned Name is: " +lnName );
			return lnName;
		}
	
// Verify that Name field for Primary Joint Borrower is not editable
		public boolean verifyPrimaryJBNameNotEditable() {
			primaryJBNameField.click();
			Boolean isDisabled = primaryJBNameField.isDisplayed();
			if(isDisabled == true) {
				log.info("Primary Joint Borrower Name field is Read Only cannot be edited");
			}
			else
			{
				log.info("Primary Joint Borrower Name field IS NOT Read Only can be edited");
			}
			return isDisabled;
		}	
	
// Select and check Name returned for Secondary Joint Borrower
		public String checkSecondaryJBName() {
			Waits.explicitWaitForElementVisible(applicantPrimaryJBName);
			applicantPrimaryJBName.click();
			applicantPrimaryJBName.sendKeys("J");
			Waits.explicitWaitForElementVisible(applicantSecondaryJBName);
			applicantPrimaryJBName.sendKeys(Keys.ENTER);
			String lnName = applicantSecondaryJBName.getText();
			log.info("The returned Name is: " +lnName );
			return lnName;
		}

// Verify that Name field for Secondary Joint Borrower is not editable
		public boolean verifySecondaryJBNameNotEditable() {
			secondaryJBNameField.click();
			Boolean isDisabled = secondaryJBNameField.isDisplayed();
			if(isDisabled == true) {
				log.info("Secondary Joint Borrower Name field is Read Only cannot be edited");
			}
			else
			{
				log.info("Secondary Joint Borrower Name field IS NOT Read Only can be edited");
			}
			return isDisabled;
		}	
		
	
// Check Phone returned for Application ID is displayed
		public String checkPhone() {
			Waits.explicitWaitForElementVisible(phone);
			String lnPhone = phone.getAttribute("value");
			log.info("The returned Phone is: " +lnPhone);
			return lnPhone;
		}
	
// Verify that Phone field is not editable
		public boolean verifyPhoneNotEditable() {
			phoneField.click();
			Boolean isDisabled = phoneField.isDisplayed();
			if(isDisabled == true) {
				log.info("Phone field is Read Only cannot be edited");
			}
			else
			{
				log.info("Phone field IS NOT Read Only can be edited");
			}
			return isDisabled;
		}
	
	
// Check Email returned for Application ID is displayed
		public String checkEmail() {
			Waits.explicitWaitForElementVisible(email);
			String lnEmail = email.getAttribute("value");
			log.info("The returned Email is: " +lnEmail);
			return lnEmail;
		}
	
// Verify that Email field is not editable
		public boolean verifyEmailNotEditable() {
			emailField.click();
			Boolean isDisabled = emailField.isDisplayed();
			if(isDisabled == true) {
				log.info("Email field is Read Only cannot be edited");
			}
			else
			{
				log.info("Email field IS NOT Read Only can be edited");
			}
			return isDisabled;
		}
	
// Verify that Notify via SMS check box is displayed
		public boolean checkSMSNotify() {
			Waits.explicitWaitForElementVisible(phoneNotifyNme);
			Boolean isDisplayed = phoneNotifyNme.isDisplayed();
			if(isDisplayed == true) {
				log.info("Notify via SMS check box is displayed");
			}
			else
			{
				log.info("Notify via SMS check box DID NOT display");
			}
			return isDisplayed;
		}
	
// Verify that Notify via Email check box is displayed
		public boolean checkEmailNotify() {
			Waits.explicitWaitForElementVisible(eNotifyNme);
			Boolean isDisplayed = eNotifyNme.isDisplayed();
			if(isDisplayed == true) {
				log.info("Notify via Email check box is displayed");
			}
			else
			{
				log.info("Notify via Email check box DID NOT display");
			}
			return isDisplayed;
		}
	
// Check Branch returned for Application ID
		public String checkBranch() {
			Waits.explicitWaitForElementVisible(branchId);
			String lnBranch = branchId.getAttribute("value");
			log.info("The returned Branch is: " +lnBranch);
			return lnBranch;
		}
	
// Verify that Branch field is not editable
		public boolean verifyBranchNotEditable() {
			branchField.click();
			Boolean isDisabled = branchField.isDisplayed();
			if(isDisabled == true) {
				log.info("Branch field is Read Only cannot be edited");
			}
			else
			{
				log.info("Branch field IS NOT Read Only can be edited");
			}
			return isDisabled;
		}
	
	
// Check Expiration Date for Application ID
		public String checkExpDate() {
			Waits.explicitWaitForElementVisible(expDate);
			String lnExpDate = expDate.getAttribute("value");
			log.info("The returned Expiration Date is: " +lnExpDate);
			return lnExpDate;
		}
	
// Verify that Expiration Date field is not editable
		public boolean verifyExpDateNotEditable() {
			expDateField.click();
			Boolean isDisabled = expDateField.isDisplayed();
			if(isDisabled == true) {
				log.info("Expiration Date field is Read Only cannot be edited");
			}
			else
			{
				log.info("Expiration Date field IS NOT Read Only can be edited");
			}
			return isDisabled;
		}
	
	
// Check ID document is listed in Required Documents
		public boolean checkReqDocId() {
			Waits.explicitWaitForElementVisible(reqDocIdNme);
			Boolean isDisplayed = reqDocIdNme.isDisplayed();
			if(isDisplayed == true) {
				log.info("ID document is visible under Required Documents");
			}
			else
			{
				log.info("ID document IS NOT visible under Required Documents");
			}
			return isDisplayed;
		}
	
// Check Social Security Card document is listed in Required Documents
		public boolean checkReqDocSSC() {
			Waits.explicitWaitForElementVisible(reqDocSSCNme);
			Boolean isDisplayed = reqDocSSCNme.isDisplayed();
			if(isDisplayed == true) {
				log.info("Social Security Card document is visible under Required Documents");
			}
			else
			{
				log.info("Social Security Card document IS NOT visible under Required Documents");
			}
			return isDisplayed;
		}
		
// Check Proof of Income document is listed in Required Documents
		public boolean checkReqDocIncome() {
			Waits.explicitWaitForElementVisible(reqDocIncomeNme);
			Boolean isDisplayed = reqDocIncomeNme.isDisplayed();
			if(isDisplayed == true) {
				log.info("Proof of Income document is visible under Required Documents");
			}
			else
			{
				log.info("Proof of Income document IS NOT visible under Required Documents");
			}
			return isDisplayed;
		}	
	
// Check Proof of Residence document is listed in Required Documents
		public boolean checkReqDocResidence() {
			Waits.explicitWaitForElementVisible(reqDocResidenceNme);
			Boolean isDisplayed = reqDocResidenceNme.isDisplayed();
			if(isDisplayed == true) {
				log.info("Proof of Residence document is visible under Required Documents");
			}
			else
			{
				log.info("Proof of Residence document IS NOT visible under Required Documents");
			}
			return isDisplayed;
		}
		
// Check Proof of Insurance document is listed in Required Documents
		public boolean checkReqDocInsurance() {
			Waits.explicitWaitForElementVisible(reqDocInsuranceNme);
			Boolean isDisplayed = reqDocInsuranceNme.isDisplayed();
			if(isDisplayed == true) {
				log.info("Proof of Insurance document is visible under Required Documents");
			}
			else
			{
				log.info("Proof of Insurance document IS NOT visible under Required Documents");
			}
			return isDisplayed;
		}	

	
	
// Select the Notify via Email check box
		public void clickNotifyChkBox() {
			eNotifyChkBox.sendKeys(Keys.SPACE);
			if (eNotifyChkBox.isSelected()) {
				log.info("Notify via Email check box was selected");
			}
			else
			{
				log.info("Notify via Email check box WAS NOT selected");
			}
		
		}	
		
// Verify the Notify via Email check box is selected (checked)
		public void checkNotifyChkBoxSelected() { 
			if (eNotifyChkBox.isSelected()) {
				log.info("Notify via Email check box is selected");
			}
			else
			{
				log.info("Notify via Email check box IS NOT selected");
			}	
			
		}
	
	
// Select the ID document check box (checked)
		public void clickIdChkBox() {
			idChkBox.sendKeys(Keys.SPACE);
			if (idChkBox.isSelected()) {
				log.info("ID check box was selected");
			}
			else
			{
				log.info("ID check box NOT selected");
			}
	    
		}
		
// Check the ID document check box (not checked)
		public void chkIdChkBox() {
			if (idChkBox.isSelected()) {
				log.info("ID check box IS checked");
			}
			else
			{
				log.info("ID check box IS NOT checked");
			}
			    
		}
		
	
// Select number of ID documents for Request
		public String selectNumOfIdDocs() {
			nbrIdFrms.sendKeys("2");
			String nbrIdDocs = nbrIdFrms.getAttribute("value");
			log.info("Number of ID documents is: " + nbrIdDocs);
			return nbrIdDocs;
		}
	
	
// Select the Social Security Card document check box (checked)
		public void clickSSCChkBox() {
			ssCardChkBox.sendKeys(Keys.SPACE);
			if (ssCardChkBox.isSelected()) {
				log.info("Social Security Card check box was selected");
			}
			else
			{
				log.info("Social Security Card check box NOT selected");
			}
	    
		}
		
// Check the Social Security Card document check box (not checked)
		public void chkSSCChkBox() {
			if (ssCardChkBox.isSelected()) {
				log.info("Social Security Card check box IS selected");
			}
			else
			{
				log.info("Social Security Card check box IS NOT selected");
			}
			    
		}
		
	
// Select number of Social Security Card documents for Request
		public String selectNumOfSSCDocs() {
			nbrSSCrdFrms.sendKeys("3");
			String nbrSSCDocs = nbrSSCrdFrms.getAttribute("value");
			log.info("Number of Social Security Card documents is: " + nbrSSCDocs);
			return nbrSSCDocs;
		}
	
	
	
// Select the Proof of Income document check box (checked)
		public void clickIncomeChkBox() {
			incomeChkBox.sendKeys(Keys.SPACE);
			if (incomeChkBox.isSelected()) {
				log.info("Proof of Income check box was selected");
			}
			else
			{
				log.info("Proof of Income check box NOT selected");
			}
	    
		}
		
// Check the Proof of Income document check box (not checked)
		public void chkIncomeChkBox() {
			if (incomeChkBox.isSelected()) {
				log.info("Proof of Income check box IS selected");
			}
			else
			{
				log.info("Proof of Income check box IS NOT selected");
			}
			    
		}
		
	
// Select number of Proof Of Income documents for Request
		public String selectNumOfPrfOfIncDocs() {
			nbrIncomeFrms.sendKeys("4");
			String nbrIncomeDocs = nbrIncomeFrms.getAttribute("value");
			log.info("Number of Proof of Income documents is: " + nbrIncomeDocs);
			return nbrIncomeDocs;
		}
	
	
	
// Select the Proof of Residence document check box (checked)
		public void clickResidenceChkBox() {
			residenceChkBox.sendKeys(Keys.SPACE);
			if (residenceChkBox.isSelected()) {
				log.info("Proof of Residence check box was selected");
			}
			else
			{
				log.info("Proof of Residence check box NOT selected");
			}
	    
		}
		
// Check the Proof of Residence document check box (not checked)
		public void chkResidenceChkBox() {
			if (residenceChkBox.isSelected()) {
				log.info("Proof of Residence check box IS selected");
			}
			else
			{
				log.info("Proof of Residence check box IS NOT selected");
			}
			    
		}
		
	
// Select number of Proof Of Residence documents for Request
		public String selectNumOfPrfOfResDocs() {
			nbrResidenceFrms.sendKeys("5");
			String nbrResidenceDocs = nbrResidenceFrms.getAttribute("value");
			log.info("Number of Proof of Income documents is: " + nbrResidenceDocs);
			return nbrResidenceDocs;
		}
	
	
	
// Select the Proof of Insurance document check box (checked)
		public void clickInsuranceChkBox() {
			insuranceChkBox.sendKeys(Keys.SPACE);
			if (insuranceChkBox.isSelected()) {
				log.info("Proof of Insurance check box was selected");
			}
			else
			{
				log.info("Proof of Insurance check box NOT selected");
			}
	    
		}
		
// Check the Proof of Insurance document check box (not checked)
		public void chkInsuranceChkBox() {
			if (insuranceChkBox.isSelected()) {
				log.info("Proof of Insurance check box was selected");
			}
			else
			{
				log.info("Proof of Insurance check box NOT selected");
			}
			    
		}
		
	
// Select number of Proof Of Insurance documents for Request
		public String selectNumOfPrfOfInsDocs() {
			nbrInsuranceFrms.sendKeys("6");
			String nbrInsuranceDocs = nbrInsuranceFrms.getAttribute("value");
			log.info("Number of Proof of Insurance documents is: " + nbrInsuranceDocs);
			return nbrInsuranceDocs;
		}
	
	
	
// Select the Send Request button
		public void clickSndReqBtn() {
			sndReqBtn.click();
			Waits.explicitWaitForElementVisible(history);
			if (history.isDisplayed()) {
				log.info("Send Request button was selected");
			}
			else
			{
				log.info("Send Request button NOT selected");
			}
	    
		}
	
// Select the Clear	option
		public void clickClearOption() {
			clearBtn.click();
			Waits.explicitWaitForElementVisible(appIdFld);
			if (appIdFld.isDisplayed()) {
				log.info("Clear option was selected");
			}
			else
			{
				log.info("Clear option NOT selected");
			}
			
		}

}
