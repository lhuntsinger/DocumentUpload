package com.wac.du.helper;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.wac.du.base.TestBase;

public class TakeScreenShot extends TestBase {
	
	public static void takeScreenshot(String testName, String date) throws IOException {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String destination = currentDir + "\\screenshots\\" + testName + "_" + date + ".png" ;
        File finalDestination = new File(destination);
		FileUtils.copyFile(scrFile, finalDestination);
	}

}
