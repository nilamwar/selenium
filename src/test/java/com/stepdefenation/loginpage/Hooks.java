package com.stepdefenation.loginpage;


import com.reports.ExtentManager;
import com.resource.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

	// Called before each scenario
    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentManager.getInstance(); // Initialize the report
        test = ExtentManager.createTest(scenario.getName()); // Create a new test node in Extent report
        launchBrowser(); // Launch the browser before the scenario starts
    }

    // Called after each scenario
    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = captureScreenshot(scenario.getName().replaceAll(" ", "_"));
            test.fail("Scenario Failed: " + scenario.getName());
            try {
                test.addScreenCaptureFromPath(screenshotPath); // Add screenshot to report if scenario failed
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            test.pass("Scenario Passed: " + scenario.getName());
        }

        closeBrowser(); // Close the browser after the scenario
        ExtentManager.flushReport(); // Write the report after scenario completion
    }
}