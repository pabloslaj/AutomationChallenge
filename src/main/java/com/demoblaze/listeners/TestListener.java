package com.demoblaze.listeners;


import com.demoblaze.reports.ExtentReport;
import org.testng.*;

import static com.demoblaze.enums.LogType.*;
import static com.demoblaze.reports.FrameworkLogger.log;

public class TestListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite iSuite) {
        try {
            ExtentReport.initReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite iSuite) {
        try {
            ExtentReport.flushReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentReport.createTest(iTestResult.getMethod().getMethodName(), iTestResult.getMethod().getDescription());
        ExtentReport.addGroups(iTestResult.getMethod().getGroups());
        ExtentReport.addClassGroup(iTestResult.getMethod().getRealClass().getName().replace("com.magento.testcases.", ""));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log(PASS, String.format("[%s] - Passed", iTestResult.getMethod().getMethodName()));
        try {
            ExtentReport.flushReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log(FAIL, iTestResult.getMethod().getMethodName() + " is Failed " + "<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occurred: Click to see"
                + "</font>" + "</b >" + "</summary>" + iTestResult.getThrowable().toString().replaceAll(",", "<br>")
                + "</details>" + " \n");
        try {
            ExtentReport.flushReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log(SKIP, iTestResult.getMethod().getMethodName() + " is Skipped " + "<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occurred: Click to see"
                + "</font>" + "</b >" + "</summary>" + iTestResult.getThrowable().toString().replaceAll(",", "<br>")
                + "</details>" + " \n");
        try {
            ExtentReport.flushReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}
