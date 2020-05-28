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

public class RequestSocialSecCardDocByEmailTest extends TestBase {
	
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

// Test Case: Request Social Security Card Document by Email for Individual Borrower
// Scenario: User goes to Documents Upload URL, navigates to Loan Request page, enters Individual Borrower Application ID, 
// 			 verifies Notify via Email option is selected, selects Social Security Card from Required Documents 
// 			 and selects Send Request button
// Expected Results: Email should be received with Upload Document link for Social Security Card
	
	@Test
	public void requestSSCDocByEmail(ITestContext ctx) {
	  
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = "24695582";
				
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
	  	
	  	
	  	log.info("*************** Start of Enter Application ID ***************");
	  	
	  	// Enter Individual Borrower Application ID data
	  	LnRqstPge.enterAppId();
	  	
	  			  	
	  	log.info("*************** End of Enter Application ID ***************");
	  	
	  	
	  	log.info("*************** Start of Verify Loan Applicant Name ***************");
	  	
	  	// Verify Loan Applicant Name
	  	String lnName = LnRqstPge.checkName();
	  	softAssert.assertEquals(lnName, "Lee Tester");
	  	
	  	log.info("**************** End of Verify Loan Applicant Name ***************");
	  	
	  	
	  	log.info("*************** Start of Verify Loan Applicant Phone ***************");
	  	
	  	// Verify Loan Applicant Phone
	  	String lnPhone = LnRqstPge.checkPhone();
	  	softAssert.assertEquals(lnPhone, "9876543210");
	  	
	  	log.info("*************** End of Verify Loan Applicant Phone ***************");
	  	
	  	
	  	log.info("*************** Start of Verify Loan Applicant Email ***************");
	  	
	  	// Verify Loan Applicant Email
	  	String lnEmail = LnRqstPge.checkEmail();
	  	softAssert.assertEquals(lnEmail, "lee.huntsinger@worldacceptance.com");
	  	
	  	log.info("*************** End of Verify Loan Applicant Email ***************");
	  	
	  	
	  	log.info("*************** Start of Verify Loan Branch ***************");
	  	
	  	// Verify Loan Branch
	  	String lnBranch = LnRqstPge.checkBranch();
	  	softAssert.assertEquals(lnBranch, "0377 - Mauldin");
	  	
	  	log.info("*************** End of Verify Loan Branch ***************");
	  	
	  	
	  	log.info("*************** Start of Verify Expiration Date ***************");
	  	
	  	// Verify Loan Expiration Date
	  	String lnExpDate = LnRqstPge.checkExpDate();
	  	softAssert.assertEquals(lnExpDate, "May 5, 2020");
	  	
	  	log.info("*************** End of Verify Expiration Date ***************");
	  	
	  	
	  	log.info("*************** Start Verify Notify via Email option visible ***************");
	  	
	  	// Verify Notify via Email check box is displayed
	  	Boolean isDisplayed = LnRqstPge.checkEmailNotify();
	  	softAssert.assertTrue(isDisplayed);
	  		  	
	  	log.info("*************** End Verify Notify via Email option visible ***************");
	  	
	  	
	  	log.info("*************** Start Verify Social Security Card Doc is visible ***************");
	  	
	  	// Verify Social Security Card is listed under Required Documents
	  	Boolean isDisplayed1 = LnRqstPge.checkReqDocSSC();
	  	softAssert.assertTrue(isDisplayed1);
	  	
	  	log.info("*************** End Verify Social Security Card Doc is visible ***************");
	  	
	  	
	  	log.info("*************** Start Verify Notify via Email Check Box Selected ***************");
	  	
	  	// Check that Notify via Email check box is selected
	  	LnRqstPge.checkNotifyChkBoxSelected();
	  		  	
	  	log.info("*************** End Verify Notify via Email Check Box Selected ***************");
	  	
	  	
	  	log.info("*************** Start Verify Social Security Card Doc Selected ***************");
	  	
	  	// Select Social Security Card document under Required Documents
	  	LnRqstPge.clickSSCChkBox();
	  	
	  	log.info("*************** End Verify Social Security Card Doc Selected ***************");
	  	
	  	
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
		
		// Select the ID link on History page
		HstryPge.clickLoanId();
		
		log.info("*************** End Select ID on History page ***************");
		
		
		log.info("*************** Start Verify Notification message ***************");
		
		// Check Notifications(s) message displayed
		HstryPge.checkNotificationMsg();
				
		log.info("*************** End Verify Notiication message ***************");

		
		log.info("*************** Start Select ID on History page ***************");
		
		// Select the ID link on History page
		HstryPge.clickLoanId();
		
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
