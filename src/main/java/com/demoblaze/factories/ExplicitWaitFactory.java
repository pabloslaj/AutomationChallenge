package com.demoblaze.factories;

import com.demoblaze.constants.FrameworkConstants;
import com.demoblaze.driver.DriverManager;
import com.demoblaze.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() {
    }

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, WebElement element) {
        WebElement webElement = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            webElement = explicitlyWaitForElementToBeClickable(element);
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            webElement = explicitlyWaitForElementToBePresent(element);
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            webElement = explicitlyWaitForElementToBeVisible(element);
        } else if (waitStrategy == WaitStrategy.NONE) {
            webElement = element;
        }
        return webElement;
    }

    public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {
        WebElement element = null;
        if (waitstrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitstrategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitstrategy == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitstrategy == WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(by);
        }
        return element;
    }

    private static WebElement explicitlyWaitForElementToBeClickable(WebElement element) {
        return new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    private static WebElement explicitlyWaitForElementToBePresent(WebElement element) {
        return new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(ExpectedConditions.presenceOfElementLocated((By) element));
    }

    private static WebElement explicitlyWaitForElementToBeVisible(WebElement element) {
        return new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(ExpectedConditions.visibilityOf(element));
    }
}
