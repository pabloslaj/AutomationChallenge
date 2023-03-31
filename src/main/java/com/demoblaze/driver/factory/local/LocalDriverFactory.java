package com.demoblaze.driver.factory.local;

import com.demoblaze.driver.manager.local.ChromeManager;
import com.demoblaze.driver.manager.local.FirefoxManager;
import com.demoblaze.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class LocalDriverFactory {

    private LocalDriverFactory() {
    }

    public static WebDriver getDriver(BrowserType browserType) {
        return browserType == BrowserType.CHROME ? ChromeManager.getDriver() : FirefoxManager.getDriver();
    }

}
