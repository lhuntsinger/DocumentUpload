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

public class SndReqBtnDisabledBeforeAppIDNotifyReqDocsSpecifiedTest extends TestBase {
	
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

// Test Case: Send Request button disabled before Application ID, Notification option or Required Documents specified
// Scenario: User goes to Documents Upload URL, navigates to Loan Request page and verifies that Send Request button is disabled 
// Expected Results: Loan Request page displayed and Send Request button is disabled
	
	@Test
	public void verifySndReqBtnDisabled(ITestContext ctx) {
	  
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = "24204528";
				
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
	  	
	  	
	  	log.info("*************** Start Verify Send Request Button Disabled ***************");
	  	
	  	// Verify Send Request button is disabled
	  	Boolean isDisabled = LnRqstPge.verifySndRequestBtnDisabled();
	  	softAssert.assertTrue(isDisabled);

	  	log.info("*************** End Verify Send Request Button Disabled ***************");


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
