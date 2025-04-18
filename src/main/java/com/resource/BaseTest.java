package com.resource;

import com.aventstack.extentreports.ExtentTest;

import Reports.ExtentManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTest {

	 public static WebDriver driver;
	    public static ExtentTest test;

	    // Launch browser and initialize WebDriver
	    
	    public void launchBrowser() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Optionally set implicit wait
	     // Navigate to login page 
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    }

	    public WebDriver getDriver() {
	        return driver;
	    }

	    // Close browser after the test
	    public void closeBrowser() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	    // Capture screenshot in case of failure for Extent Reports
	    public String captureScreenshot(String testName) {
	        try {
	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	            String screenshotPath = "E:/selenium/Screenshots/" + testName + "_" + timestamp + ".png";
	            FileUtils.copyFile(src, new File(screenshotPath));
	            return screenshotPath;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	}