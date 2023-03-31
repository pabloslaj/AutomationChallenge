package com.demoblaze.driver;

import com.demoblaze.driver.factory.local.LocalDriverFactory;
import com.demoblaze.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public class LocalWebDriverImpl implements IWebDriver {

    @Override
    public WebDriver getDriver(BrowserType browserType) {
        return LocalDriverFactory.getDriver(browserType);
    }

}
