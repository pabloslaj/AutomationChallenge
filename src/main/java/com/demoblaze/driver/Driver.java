package com.demoblaze.driver;

import com.demoblaze.driver.entity.WebDriverData;
import com.demoblaze.driver.factory.DriverFactory;
import com.demoblaze.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static com.demoblaze.config.factory.ConfigFactory.getConfig;

public final class Driver {

    private Driver() {
    }

    public static void initDriver(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {
            WebDriverData driverData = new WebDriverData(BrowserType.valueOf(browser.trim().toUpperCase()));

            WebDriver driver = DriverFactory
                    .getDriver(getConfig().runMode())
                    .getDriver(driverData.getBrowserType());

            DriverManager.setDriver(driver);
            loadURL();
        }
    }

    public static void loadURL() {
        DriverManager.getDriver().get(getConfig().webUrl());
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }


}
