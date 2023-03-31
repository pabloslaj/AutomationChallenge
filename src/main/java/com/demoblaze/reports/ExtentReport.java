package com.demoblaze.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.demoblaze.constants.FrameworkConstants;
import com.demoblaze.utils.DateUtil;

import java.io.File;
import java.util.Objects;

public final class ExtentReport {

    private static ExtentReports extentReport;

    private ExtentReport() {
    }

    public static void initReport() {
        if (Objects.isNull(extentReport)) {
            extentReport = new ExtentReports();
            String path = createReportFolder();
            ExtentSparkReporter sparkReporterAll = new ExtentSparkReporter(path + "All_Tests.html");
            ExtentSparkReporter sparkReporterFailed = new ExtentSparkReporter(path + "Failed_Tests.html");
            ExtentSparkReporter sparkReporterSkipped = new ExtentSparkReporter(path + "Skipped_Tests.html");

            sparkReporterFailed.filter().statusFilter().as(new Status[]{Status.FAIL}).apply();
            sparkReporterSkipped.filter().statusFilter().as(new Status[]{Status.SKIP, Status.WARNING}).apply();

            sparkReporterAll.config().setTheme(Theme.DARK);
            sparkReporterAll.config().setReportName("Automation Report");
            sparkReporterAll.viewConfigurer()
                    .viewOrder()
                    .as(new ViewName[]{
                            ViewName.DASHBOARD,
                            ViewName.TEST,
                            ViewName.CATEGORY,
                            ViewName.AUTHOR,
                            ViewName.DEVICE,
                            ViewName.EXCEPTION,
                            ViewName.LOG
                    })
                    .apply();
            extentReport.attachReporter(sparkReporterAll, sparkReporterFailed, sparkReporterSkipped);
        }
    }

    public static void flushReport() {
        if (Objects.nonNull(extentReport)) {
            extentReport.flush();
        }
        ExtentManager.unload();
    }

    public static void createTest(String testCaseName, String description) {
        ExtentTest test = extentReport.createTest(testCaseName, description);
        ExtentManager.setTest(test);
    }

    public static void addGroups(String[] groups) {
        for (String group : groups) {
            ExtentManager.getTest().assignCategory(group);
        }
    }

    public static void addClassGroup(String name) {
        ExtentManager.getTest().assignCategory(name);
    }

    private static String createReportFolder() {
        String path = FrameworkConstants.getExtentReportFilePath() + "/" + DateUtil.getActualDateAndTime() + "/";
        File theDir = new File(path);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        return path;
    }


}
