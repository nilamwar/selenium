package com.stepdefenation.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.pages.OrangeHrmLoginPage;
import com.reports.ExtentManager;
import com.resource.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginTest extends BaseTest{
	OrangeHrmLoginPage loginPage;
	ExtentTest test;
	 @Given("the user is on the OrangeHRM login page")
	    public void the_user_is_on_the_orange_hrm_login_page() {  
		 loginPage = new OrangeHrmLoginPage(driver);
		 test = ExtentManager.createTest("Login Test - Invalid Login");
	     test.info("Navigated to login page");
	    }

	    @When("the user enters username {string} and password {string}")
	    public void the_user_enters_username_and_password(String username, String password) {
	        loginPage.setValue(username, password); // Set username and password on login page
	        test.info("Entered username: " + username + " and password: " + password);
	    }

	    @When("clicks the login button")
	    public void clicks_the_login_button() {
	        loginPage.clickOnBtn(); // Click on login button
	        test.info("Clicked on login button");
	    }

	    @Then("the error message {string} should be displayed")
	    public void the_error_message_should_be_displayed(String expectedMsg) {
	        String actualMessage = loginPage.getInvalidErrorMessage(); // Get the error message after login attempt
	        Assert.assertTrue(actualMessage.contains(expectedMsg), "Expected error message not found! Actual: " + actualMessage);
	        test.info("Correct error message displayed: " + actualMessage);
	    }
	    @Then("the error message {string} should be displayed")
	    public void the_message_should_be_displayed(String expectedMsg) {
	        String actualMessage = loginPage.getInvalidErrorMessage(); // Get the error message after login attempt
	        Assert.assertTrue(actualMessage.contains(expectedMsg), "Expected error message not found! Actual: " + actualMessage);
	        test.info("Correct error message displayed: " + actualMessage);
	    } 
	}