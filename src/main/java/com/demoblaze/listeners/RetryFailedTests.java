package com.demoblaze.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static com.demoblaze.config.factory.ConfigFactory.getConfig;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false;
        if (getConfig().retryFailedTests()) {
            value = count < retries;
            count++;
        }
        return value;
    }
}
