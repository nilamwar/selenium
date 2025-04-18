package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resource.WaitUtils;

public class OrangeHrmLoginPage {
	WebDriver driver;

	public OrangeHrmLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passWord;

	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement loginBtn;

	@FindBy(xpath = "//span[text()='Required']") // Error message for empty fields
	private WebElement errorMessage;

	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	private   WebElement invalidcredErrorMessage ;
	    
	public void setValue(String str, String password) {
		WaitUtils.waitForElementToBeVisible(driver, userName, 20).sendKeys(str);
		WaitUtils.waitForElementToBeVisible(driver, passWord, 20).sendKeys(password);
	}

	public void clickOnBtn() {
		WaitUtils.waitForElementToBeClickable(driver, loginBtn, 20).click();
	}

	public String getErrorMessage() {
		return WaitUtils.waitForElementToBeVisible(driver, errorMessage, 20).getText();
	}
	
	public String getInvalidErrorMessage() {
		return WaitUtils.waitForElementToBeVisible(driver, invalidcredErrorMessage, 20).getText();
	}
}