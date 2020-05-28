package com.wac.du.testcases;

import org.testng.annotations.Test;

import com.wac.du.base.TestBase;
import com.wac.du.pages.LoginPage;
import com.wac.du.pages.HistoryPage;
import com.wac.du.util.PractiTest;

import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;


public class HistoryTestCases extends TestBase {
	
	LoginPage LogPge;
	HistoryPage HstryPge;
  
  @BeforeMethod
  public void setUp() {
	 initialization();
	 LogPge = new LoginPage();
	 HstryPge = new HistoryPage();
	 
	 Boolean isDisplayed = LogPge.verifyLoginPageDisplayed();
	  if (isDisplayed == true) {
		  LogPge.enterLoginDetails();
		  log.info("Logged in the user");
	  }
	  else 
	  {
		  log.info("Login page is not displayed");
	  }
	 
	 
	 
  }
  

  // Test Case: Launch Documents Upload
  // Scenario: User goes to Documents Upload url
  // Expected Results: Documents Upload History page is displayed
  @Test
  public void launchDUPge(ITestContext ctx) {
	  
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = "23504894";
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
	  
	  log.info("********************* Start of Test ******************");
	  
	  Boolean isActive =  HstryPge.verifyHistoryPageDisplayed();
	  if (isActive == true) {
		  log.info("History page is displayed");
	  }
	  else 
	  {
		  log.info("History page is not displayed");
	  }
	  
	  Assert.assertTrue(isActive);
	  
	  log.info("********************* End of Test ******************");
	  
	 
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
