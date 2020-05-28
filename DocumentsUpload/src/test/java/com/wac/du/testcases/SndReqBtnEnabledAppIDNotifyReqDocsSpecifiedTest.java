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

public class SndReqBtnEnabledAppIDNotifyReqDocsSpecifiedTest extends TestBase {
	
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
 
// Test Case: Send Request button enabled when Application ID entered, Notification option and Required Documents specified
// Scenario: User goes to Documents Upload URL, navigates to Loan Request page, enters Application ID, selects 
// 			 Notification option and selects any Required Documents	
// Expected Results: Loan Request page displayed, Application ID entered, Notify option selected, 
//				     any Required Documents selected and Send Request button enabled
	
	  @Test
	  public void verifySndReqBtnEnabledAppIDNotifyReqDocsSpecified(ITestContext ctx) {
		  
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
		String instance = "24739009";
					
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
		  Boolean isActive2 = LnRqstPge.verifyLoanRequestPageDisplayed();

		  Assert.assertTrue(isActive2);
		  	
		  log.info("*************** End Verify Loan Request Page Displayed ***************");
		  	
		  	
		  log.info("*************** Start of Enter Application ID ***************");
		  	
		  // Enter Application ID data
		  LnRqstPge.enterAppId();
		  	
		  log.info("*************** End of Enter Application ID ***************");
		  	
		  	
		  log.info("*************** Start Verify Notify via Email option visible ***************");
		  	
		  // Verify Notify via Email check box is displayed
		  Boolean isDisplayed = LnRqstPge.checkEmailNotify();
		  softAssert.assertTrue(isDisplayed);
		  		  	
		  log.info("*************** End Verify Notify via Email option visible ***************");

		  
		  log.info("*************** Start Verify Notify via Email Check Box Selected ***************");
		  	
		  // Check that Notify via Email check box is selected
		  LnRqstPge.checkNotifyChkBoxSelected();
		  		  	
		  log.info("*************** End Verify Notify via Email Check Box Selected ***************");
	

		  log.info("*************** Start Verify Send Request Button Enabled ***************");
		  	
		  // Verify Send Request button is disabled
		  Boolean isEnabled = LnRqstPge.verifySndRequestBtnEnabled();
		  softAssert.assertTrue(isEnabled);

		  log.info("*************** End Verify Send Request Button Enabled ***************");
		  	
			  			
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
