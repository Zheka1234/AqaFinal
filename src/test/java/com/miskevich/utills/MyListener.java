package com.miskevich.utills;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    private static final Logger log = Logger.getLogger(MyListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {

        log.info("Test start: " + iTestResult.getName());

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test finish: " + iTestResult.getName());

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("Test failure: " + iTestResult.getName());

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("Test  skipped: " + iTestResult.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log.info("Test failed, but within acceptable success rate: " + iTestResult.getName());

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info("Starting test context execution: " + iTestContext.getName());


    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log.info("Ending the test context execution: " + iTestContext.getName());

    }
}
