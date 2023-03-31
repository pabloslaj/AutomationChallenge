package com.demoblaze.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public class ExtentManager {

    private ExtentManager() {
    }

    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    static ExtentTest getTest() {
        return extentTestThreadLocal.get();
    }

    static void setTest(ExtentTest test) {
        if (Objects.nonNull(test)) {
            extentTestThreadLocal.set(test);
        }
    }

    static void unload() {
        extentTestThreadLocal.remove();
    }
}
