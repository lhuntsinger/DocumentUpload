package com.wac.du.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wac.du.base.TestBase;
import com.wac.du.pages.HistoryPage;
import com.wac.du.pages.LoanRequestPage;
import com.wac.du.pages.LoginPage;
import com.wac.du.pages.TaxRequestPage;
import com.wac.du.util.PractiTest;

public class RequestAnyDocForNullBrwrByEmailTest extends TestBase {
	
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

// Test Case: Request Any Document for Null Borrower by Email
// Scenario: User goes to Documents Upload URL, navigates to Loan Request page, enters Application ID for Null Borrower, 
// 			 verifies Notify via Email option is selected, selects ID from Required Documents 
// 			 and selects Send Request button
// Expected Results: Email for Null Borrower should receive email with Upload Document link for ID
	
	@Test
	public void reqAnyDocForNullBrwrByEmail(ITestContext ctx) {
	  
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = "24740165";
				
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
		  
	
		log.info("*************** Start Verify Loan Request Page Displayed ***************");
		  
		// Click the REQUEST Link on HISTORY page
		LnRqstPge.clickRequest();

	  	
	  	// Verify that LOAN Page is displayed after clicking REQUEST link
	  	Boolean isActive1 = LnRqstPge.verifyLoanRequestPageDisplayed();

	  	Assert.assertTrue(isActive1);
	  	
	  	log.info("*************** End Verify Loan Request Page Displayed ***************");
	  	
	  	
	  	log.info("*************** Start of Enter Null Borrower Application ID ***************");
	  	
	  	// Enter Application ID data
	  	LnRqstPge.enterNullAppId();
	  	
	  			  	
	  	log.info("*************** End of Enter Null Borrower Application ID ***************");
	  	
	  	
	  	log.info("*************** Start of Verify Loan Applicant Name ***************");
	  	
	  	// Verify Loan Application Name
	  	String lnName = LnRqstPge.checkName();
	  	softAssert.assertEquals(lnName, "Null Borrower");
	  	
	  	log.info("**************** End of Verify Loan Applicant Name ***************");
	  	
	  	
	  	log.info("*************** Start of Verify Loan Applicant Phone ***************");
	  	
	  	// Verify Loan Application Phone
	  	String lnPhone = LnRqstPge.checkPhone();
	  	softAssert.assertEquals(lnPhone, "9123654780");
	  	
	  	log.info("*************** End of Verify Loan Applicant Phone ***************");
	  	
	  	
	  	log.info("*************** Start of Verify Loan Applicant Email ***************");
	  	
	  	// Verify Loan Application Email
	  	String lnEmail = LnRqstPge.checkEmail();
	  	softAssert.assertEquals(lnEmail, "test2@worldacceptance.com");
	  	
	  	log.info("*************** End of Verify Loan Applicant Email ***************");
	  	
	  	
	  	log.info("*************** Start of Verify Loan Branch ***************");
	  	
	  	// Verify Loan Branch
	  	String lnBranch = LnRqstPge.checkBranch();
	  	softAssert.assertEquals(lnBranch, "0377 - Mauldin");
	  	
	  	log.info("*************** End of Verify Loan Branch ***************");
	  	
	  	
	  	log.info("*************** Start of Verify Expiration Date ***************");
	  	
	  	// Verify Loan Expiration Date
	  	String lnExpDate = LnRqstPge.checkExpDate();
	  	softAssert.assertEquals(lnExpDate, "May 7, 2020");
	  	
	  	log.info("*************** End of Verify Expiration Date ***************");
	  	
	  	
	  	log.info("*************** Start Verify Notify via Email option visible ***************");
	  	
	  	// Verify Notify via Email check box is displayed
	  	Boolean isDisplayed = LnRqstPge.checkEmailNotify();
	  	softAssert.assertTrue(isDisplayed);
	  		  	
	  	log.info("*************** End Verify Notify via Email option visible ***************");
	  	
	  	
	  	log.info("*************** Start Verify Required Doc ID visible ***************");
	  	
	  	// Verify ID is listed under Required Documents
	  	Boolean isDisplayed1 = LnRqstPge.checkReqDocId();
	  	softAssert.assertTrue(isDisplayed1);
	  	
	  	log.info("*************** End Verify Required Doc ID visible ***************");
	  	
	  	
	  	log.info("*************** Start Verify Notify via Email Check Box Selected ***************");
	  	
	  	// Check that Notify via Email check box is selected
	  	LnRqstPge.checkNotifyChkBoxSelected();
	  		  	
	  	log.info("*************** End Verify Notify via Email Check Box Selected ***************");
	  	
	  	
	  	log.info("*************** Start Verify ID Doc Selected ***************");
	  	
	  	// Select ID document under Required Documents
	  	LnRqstPge.clickIdChkBox();
	  	
	  	log.info("*************** End Verify ID Doc Selected ***************");
	  	
	  	
	  	log.info("*************** Start Verify Send Request button Selected ***************");
	  	
	  	// Select the Send Request button
	  	LnRqstPge.clickSndReqBtn();
	  	
	  	log.info("*************** End Verify Send Request button Selected ***************");
	  	

	  	log.info("*************** Start Verify History Page Displayed ***************");
	  	
		// Verify History page is displayed and active
	  	Boolean isActive2 =  HstryPge.verifyHistoryPageDisplayed();
		if (isActive2 == true) {
			log.info("History page is displayed");
		}
		else 
		{
			log.info("History page DID NOT display");
		}
		softAssert.assertTrue(isActive2);
	  	
		log.info("*************** End Verify History Page Displayed ***************");
		
		
		log.info("*************** Start Select ID on History page ***************");
		
		// Select the Null Borrower Loan ID link on History page
		HstryPge.clickNullLoanId();
		
		log.info("*************** End Select ID on History page ***************");
		
		
		log.info("*************** Start Verify Notification message ***************");
		
		// Check Notifications(s) message displayed
		HstryPge.checkNotificationMsg();
				
		log.info("*************** End Verify Notiication message ***************");


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
