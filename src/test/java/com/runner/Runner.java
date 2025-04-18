package com.runner;

import org.testng.annotations.Listeners;

import com.reports.TestListener;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(TestListener.class)
@CucumberOptions(features = "src/main/java/resources", // Correct path for feature file
		glue = "com.stepdefenation.loginpage", // Correct glue path for step definitions
		plugin = { "pretty", "html:target/cucumber-reports.html",
				"json:target/cucumber.json" }, dryRun = false, monochrome = true)
public class Runner extends AbstractTestNGCucumberTests {
	
}