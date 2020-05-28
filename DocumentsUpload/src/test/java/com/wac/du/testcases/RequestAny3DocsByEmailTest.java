package com.wac.du.testcases;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.wac.du.base.TestBase;
import com.wac.du.pages.HistoryPage;
import com.wac.du.pages.LoginPage;
import com.wac.du.pages.LoanRequestPage;
import com.wac.du.pages.TaxRequestPage;
import com.wac.du.util.PractiTest;

public class RequestAny3DocsByEmailTest extends TestBase {
	
	LoginPage LogPge;
	HistoryPage HstryPge;
	LoanRequestPage LnRqstPge;
	TaxRequestPage TxRqstPge;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		LogPge = new LoginPage();
		HstryPge = new HistoryPage();
		LnRqstPge = new LoanRequestPage();
		TxRqstPge = new TaxRequestPage();
		
// Check for Login and enter credentials
		Boolean isDisplayed = LogPge.verifyLoginPageDisplayed();
		  if (isDisplayed == true) {
			  LogPge.enterLoginDetails();
			  log.info("Logged in the user");
		  }
		  else 
		  {
			  log.info("Login page DID NOT display");
		  }

		
	}
 
// Test Case: Request any three documents by Email for Individual Borrower
// Scenario: User goes to Documents Upload URL, enters Individual Application ID, verifies applicant information,
//			 verifies Notify option, verifies documents listed under Required Documents,
//			 selects any three documents and selects Send Request button	
// Expected Results: Email for requested three documents is received and matches the request
	
	  @Test
	  public void verifyRequestAny3DocsByEmail(ITestContext ctx) {
		  
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
		String instance = "24887455";
					
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
			
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
		
		SoftAssert softAssert = new SoftAssert();
		  
		 log.info("********************* Start of History Page Test ******************");
		 		 
		 Boolean isActive =  HstryPge.verifyHistoryPageDisplayed();
		  if (isActive == true) {
			  log.info("History page is displayed");
		  }
		  else 
		  {
			  log.info("History page DID NOT display");
		  }
		  
		  Assert.assertTrue(isActive);
		  
		  log.info("********************* End of History Page Test ******************");
		  
		  
		  log.info("*************** Start of Loan Request Page Test ***************");
	  
		  // Click the REQUEST link on HISTORY page
		  LnRqstPge.clickRequest();
		  	
		  // Verify that LOAN Page is displayed after clicking REQUEST link
		  Boolean isActive2 = LnRqstPge.verifyLoanRequestPageDisplayed();

		  Assert.assertTrue(isActive2);
		  	
		  log.info("*************** End of Loan Request Page Test ***************");
		  	
		  	
		  log.info("*************** Start Enter Individual Borrower Application ID ***************");
		  	
		  // Enter Individual Borrower Application ID data
		  LnRqstPge.enterAppId();
		  			  			  	
		  log.info("*************** End Enter Individual Borrower Application ID ***************");
		  	
		  	
		  log.info("*************** Start Verify Individual Borrower Name ***************");
		  	
		  // Verify Loan Applicant Name
		  String lnName = LnRqstPge.checkName();
		  softAssert.assertEquals(lnName, "Lee Tester");
		  	
		  log.info("**************** End Verify Individual Borrower Name ***************");
		  	
		  	
		  log.info("*************** Start Verify Individual Borrower Phone ***************");
		  	
		  // Verify Loan Applicant Phone
		  String lnPhone = LnRqstPge.checkPhone();
		  softAssert.assertEquals(lnPhone, "9876543210");
		  	
		  log.info("*************** End Verify Individual Borrower Phone ***************");
		  	
		  	
		  log.info("*************** Start Verify Individual Borrower Email ***************");
		  	
		  // Verify Loan Applicant Email
		  String lnEmail = LnRqstPge.checkEmail();
		  softAssert.assertEquals(lnEmail, "lee.huntsinger@worldacceptance.com");
		  	
		  log.info("*************** End Verify Individual Borrower Email ***************");
		  	
		  	
		  log.info("*************** Start Verify Individual Borrower Branch ***************");
		  	
		  // Verify Loan Branch
		  String lnBranch = LnRqstPge.checkBranch();
		  softAssert.assertEquals(lnBranch, "0377 - Mauldin");
		  	
		  log.info("*************** End Verify Individual Borrower Branch ***************");
		  	
		  	
		  log.info("*************** Start Verify Expiration Date ***************");
		  	
		  // Verify Loan Expiration Date
		  String lnExpDate = LnRqstPge.checkExpDate();
		  softAssert.assertEquals(lnExpDate, "May 14, 2020");
		  	
		  log.info("*************** End Verify Expiration Date ***************");
		  	
		  	
		  log.info("*************** Start Verify ID doc is visible ***************");
		  	
		  // Verify ID is listed under Required Documents
		  Boolean isDisplayed = LnRqstPge.checkReqDocId();
		  softAssert.assertTrue(isDisplayed);
		  	
		  log.info("*************** End Verify ID doc is visible ***************");
		  	
		  	
		  log.info("*************** Start Verify Social Security Card doc is visible ***************");
		  	
		  // Verify Social Security Card is listed under Required Documents
		  Boolean isDisplayed1 = LnRqstPge.checkReqDocSSC();
		  softAssert.assertTrue(isDisplayed1);
		  	
		  log.info("*************** End of Verify Social Security Card doc is visible ***************");
		  	
		  	
		  log.info("*************** Start Verify Proof of Income doc is visible ***************");
		  	
		  // Verify Proof of Income is listed under Required Documents
		  Boolean isDisplayed2 = LnRqstPge.checkReqDocIncome();
		  softAssert.assertTrue(isDisplayed2);
		  	
		  log.info("*************** End Verify Proof of Income doc is visible ***************");
		  	
		  	
		  log.info("*************** Start Verify Proof of Residence doc is visible ***************");
		  	
		  // Verify Proof of Residence is listed under Required Documents
		  Boolean isDisplayed3 = LnRqstPge.checkReqDocResidence();
		  softAssert.assertTrue(isDisplayed3);
		  	
		  log.info("*************** End of Verify Proof of Residence doc is visible ***************");
		  	
		  	
		  log.info("*************** Start Verify Proof of Insurance doc is visible ***************");
		  	
		  // Verify Proof of Insurance is listed under Required Documents
		  Boolean isDisplayed4 = LnRqstPge.checkReqDocInsurance();
		  softAssert.assertTrue(isDisplayed4);
		  	
		  log.info("*************** End Verify Proof of Insurance doc is visible ***************");
		  	
		  	
		  log.info("*************** Start Verify Notify via Email option is visible ***************");
		  	
		  // Verify Notify via Email check box is displayed
		  Boolean isDisplayed6 = LnRqstPge.checkEmailNotify();
		  softAssert.assertTrue(isDisplayed6);
		  		  	
		  log.info("*************** End Verify Notify via Email option is visible ***************");
		  	
		  	
		  log.info("*************** Start Verify Notify via Email Check Box is Selected ***************");
		  	
		  // Check the Notify via Email check box is selected
		  LnRqstPge.checkNotifyChkBoxSelected();
		  	
		  log.info("*************** End Verify Notify via Email Check Box is Selected ***************");
		  	
		  	
		  log.info("*************** Start Verify ID Doc Selected ***************");
		  	
		  // Select ID document under Required Documents
		  LnRqstPge.clickIdChkBox();
		  	
		  log.info("*************** End Verify ID Doc Selected ***************");
		  	
		  	
		  log.info("*************** Start Verify Proof of Income Doc Selected ***************");
		  	
		  // Select Proof of Income document under Required Documents
		  LnRqstPge.clickIncomeChkBox();
		  	
		  log.info("*************** End Verify Proof of Income Doc Selected ***************");
		  	
		  	
		  log.info("*************** Start Verify Proof of Insurance Doc Selected ***************");
		  	
		  // Select Proof of Insurance document under Required Documents
		  LnRqstPge.clickInsuranceChkBox();
		  	
		  log.info("*************** End Verify Proof of Insurance Doc Selected ***************");

		  	
		  log.info("*************** Start Verify Send Request button Selected ***************");
		  	
		  // Check the Send Request button is selected
		  LnRqstPge.clickSndReqBtn();
		  	
		  log.info("*************** End Verify Send Request button Selected ***************");
		  	

		  log.info("*************** Start Verify History Page Displayed ***************");
		  	
		  // Verify History page is displayed and active
		  Boolean isActive3 =  HstryPge.verifyHistoryPageDisplayed();
		  if (isActive3 == true) {
			  log.info("History page is displayed");
		  }
		  else 
		  {
			  log.info("History page DID NOT display");
		  }
		  softAssert.assertTrue(isActive3);
		  	
		  log.info("*************** End Verify History Page Displayed ***************");

		  			
	  }
	  	  
	  
	  @AfterMethod
	  public void tearDown(ITestContext ctx, ITestResult rlt) throws Exception {
			
			
			String instance = ctx.getCurrentXmlTest().getParameter("InstanceId");
			String date = ctx.getCurrentXmlTest().getParameter("Date");
			String testName = rlt.getMethod().getMethodName();
			String failureReason = "";
			String screenShot = testName + "_" + date + ".png";
			int result = 3;
			
	    if (rlt.getStatus() == ITestResult.SUCCESS)
	    {
	    	result = 0;
	    	PractiTest.runWithAttachments(instance, result, screenShot, failureReason);
	    	
	    } 
	    
	    else if (rlt.getStatus() == ITestResult.FAILURE)
	    {
	  	failureReason = rlt.getThrowable().toString();
	    	result = 1;
	    	PractiTest.runWithAttachments(instance, result, screenShot, failureReason);
	    	
	    }
	    
	    else if (rlt.getStatus() == ITestResult.SKIP)
	    {
	    	result = 2;
	    }
			
			//Close the browser
			driver.close();
	    }	
	
}
