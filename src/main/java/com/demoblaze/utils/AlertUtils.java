package com.demoblaze.utils;

import com.demoblaze.constants.FrameworkConstants;
import com.demoblaze.driver.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class AlertUtils {

    private AlertUtils() {
    }

    public static String getAlertText() {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait()).ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
        Alert alert = DriverManager.getDriver().switchTo().alert();
        return alert.getText();
    }

    public static void clickAcceptAlert() {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait()).ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
        Alert alert = DriverManager.getDriver().switchTo().alert();
        alert.accept();
    }
}
