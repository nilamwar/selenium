package com.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    private String getCurrentTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("\n====== 📘 Test Suite Started: " + context.getName() + " at " + getCurrentTime() + " ======");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("====== 📕 Test Suite Finished: " + context.getName() + " at " + getCurrentTime() + " ======\n");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("🚀 STARTED: " + result.getMethod().getMethodName() + " at " + getCurrentTime());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ PASSED: " + result.getMethod().getMethodName() + " at " + getCurrentTime());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ FAILED: " + result.getMethod().getMethodName() + " at " + getCurrentTime());
        if (result.getThrowable() != null) {
            System.out.println("🔍 REASON: " + result.getThrowable().getMessage());
        }
        // Optional: Take screenshot on failure if using Selenium
        // ScreenshotUtils.captureScreenshot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⚠️ SKIPPED: " + result.getMethod().getMethodName() + " at " + getCurrentTime());
        if (result.getThrowable() != null) {
            System.out.println("🔍 REASON: " + result.getThrowable().getMessage());
        }
    }
}
