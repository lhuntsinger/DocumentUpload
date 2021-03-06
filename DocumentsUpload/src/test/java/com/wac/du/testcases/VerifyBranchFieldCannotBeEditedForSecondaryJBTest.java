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

public class VerifyBranchFieldCannotBeEditedForSecondaryJBTest extends TestBase {
	
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
 
// Test Case: Verify that Branch field cannot be edited for Secondary Joint Borrower
// Scenario: User goes to Documents Upload URL, enters Joint Borrower Application ID, verifies applicant Branch information,
//			 verifies that Branch field cannot be edited
// Expected Results: Branch field cannot be edited

	
	  @Test
	  public void verifyBranchNotEditableForSecondaryJointBorrower(ITestContext ctx) {
		  
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
		String instance = "24846453";
					
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
		  	
		  	
		  log.info("*************** Start Select Secondary Joint Borrower Name ***************");
		  	
		  // Select Secondary Borrower name from drop down
		  String lnName = LnRqstPge.checkSecondaryJBName();
		  softAssert.assertEquals(lnName, "Joint Secondary");
		  	
		  log.info("*************** End Select Secondary Joint Borrower Name ***************");
		  	
		  	
 		  log.info("*************** Start Verify Secondary Joint Borrower Branch ***************");
		  	
		  // Verify Secondary Joint Borrower Branch
		  String lnBranch = LnRqstPge.checkBranch();
		  softAssert.assertEquals(lnBranch, "0377 - Mauldin");
		  	
		  log.info("*************** End Verify Secondary Joint Borrower Branch ***************");
		  	
		  	
		  log.info("*************** Start Verify Branch Field Not Editable ***************");
		  	
		  // Verify Branch field cannot be edited
		  Boolean isDisabled = LnRqstPge.verifyBranchNotEditable();
		  softAssert.assertTrue(isDisabled);
		  	
		  log.info("*************** End Verify Branch Field Not Editable ***************");
		  	
		  			
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
