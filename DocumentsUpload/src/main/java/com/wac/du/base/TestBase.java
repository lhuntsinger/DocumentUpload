package com.wac.du.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.wac.du.base.TestBase;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = Logger.getLogger(TestBase.class);
	public static final String workingDir=System.getProperty("user.dir");
	
	
public TestBase() {
	
			try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(workingDir+"\\src\\main\\java\\com\\wac\\du\\config\\config.properties");
			prop.load(ip);		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}

public static void initialization() {
	
	log.info("*********************Starting up initialization**************************");
	
	
	
	String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\AutomationDownloads\\WebDrivers\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("Chrome browser launched");
	} 
	else if(browserName.equals("firefox")){
		System.setProperty("webdriver.chrome.driver", "C:\\AutomationDownloads\\WebDrivers\\FirefoxDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		log.info("Firefox browser launched");
	}
	
	driver.manage().window().maximize();
	log.info("Window Maximized");
	driver.manage().deleteAllCookies();
	log.info("Deleted all cookies");
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	log.info("Page load timeout is setup 30 seconds");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	log.info("Setting up implicit wait time out for 60 seconds");
	
	driver.get(prop.getProperty("url"));
	log.info("Launching the URL " +prop.getProperty("url"));
	
	
	log.info("*********************Completed initialization**************************");

}
}


