package com.demoblaze.testcases;

import com.demoblaze.driver.Driver;
import com.demoblaze.driver.DriverManager;
import com.demoblaze.utils.FixtureUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Map;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {

    }

    @AfterSuite
    public void afterSuite() {

    }

    @BeforeMethod
    protected void setUp(Object[] data) {
        Map<String, String> map = (Map<String, String>) data[0];
        Driver.initDriver(map.get("browser"));
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().navigate().refresh();
        FixtureUtils.loadFixtures();
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }

}
