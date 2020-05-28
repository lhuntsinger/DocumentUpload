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

public class VerifyPhoneFieldCannotBeEditedForPrimaryJBTest extends TestBase {
	
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
 
// Test Case: Verify that Phone field cannot be edited for Primary Joint Borrower
// Scenario: User goes to Documents Upload URL, enters Joint Borrower Application ID, verifies applicant Phone information,
//			 verifies that Phone field cannot be edited
// Expected Results: Phone field cannot be edited

	
	  @Test
	  public void verifyPhoneNotEditableForPrimaryJointBorrower(ITestContext ctx) {
		  
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
		String instance = "24836883";
					
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
		  	
		  	
		  log.info("*************** Start of Enter Joint Borrower Application ID ***************");
		  	
		  // Enter Joint Borrower Application ID data
		  LnRqstPge.enterJointAppId();
		  	
		  log.info("*************** End of Enter Joint Borrower Application ID ***************");
		  	
		  	
		  log.info("*************** Start Verify Primary Joint Borrower Phone ***************");
		  	
		  // Verify Primary Joint Borrower Phone is visible
		  String lnPhone = LnRqstPge.checkPhone();
		  softAssert.assertEquals(lnPhone, "9876543210");
		  	
		  log.info("*************** End Verify Primary Joint Borrower Phone ***************");
		  	
		  	
		  log.info("*************** Start Verify Phone Field Not Editable ***************");
		  	
		  // Verify Phone field cannot be edited
		  Boolean isDisabled = LnRqstPge.verifyPhoneNotEditable();
		  softAssert.assertTrue(isDisabled);
		  	
		  log.info("*************** End Verify Phone Field Not Editable ***************");
		  	
		  			
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
