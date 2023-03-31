package com.demoblaze.driver;

import com.demoblaze.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public interface IWebDriver {
    WebDriver getDriver(BrowserType browserType);
}
