package com.demoblaze.utils;

import com.demoblaze.constants.FrameworkConstants;
import com.demoblaze.driver.DriverManager;
import com.demoblaze.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.demoblaze.enums.LogType.EXTENT_AND_CONSOLE;
import static com.demoblaze.factories.ExplicitWaitFactory.performExplicitWait;
import static com.demoblaze.reports.FrameworkLogger.log;

public final class PageActionsHelper {

    private PageActionsHelper() {
    }

    public static void click(WebElement element, WaitStrategy waitstrategy, String elementName) {
        element = performExplicitWait(waitstrategy, element);
        element.click();
        log(EXTENT_AND_CONSOLE, String.format("The element [%s] was clicked", elementName));
    }

    public static String getElementText(WebElement element, WaitStrategy waitstrategy) {
        element = performExplicitWait(waitstrategy, element);
        return element.getText();
    }

    public static WebElement getChainElement(WebElement element, By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait());
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return element.findElement(by);
    }

    public static List<WebElement> getElementsUsingBy(By by) {
        List<WebElement> elements = null;
        try {
            elements = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (Exception e) {
            log(EXTENT_AND_CONSOLE, "Elements were not found");
        }
        return elements;
    }

    public static String getElementText(By by, WaitStrategy waitstrategy) {
        WebElement element = performExplicitWait(waitstrategy, by);
        return element.getText();
    }

    public static void click(By by, WaitStrategy waitstrategy, String elementName) {
        WebElement element = performExplicitWait(waitstrategy, by);
        element.click();
        log(EXTENT_AND_CONSOLE, String.format("The element [%s] was clicked", elementName));
    }

    public static void sendKeys(By by, String value, WaitStrategy waitstrategy, String elementName) {
        WebElement element = performExplicitWait(waitstrategy, by);
        element.click();
        element.sendKeys(value);
        log(EXTENT_AND_CONSOLE, String.format("%s was entered successfully in [%s]", value, elementName));
    }

    public static WebElement waitForInVisibility(WebElement element) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait());
        wait.until(ExpectedConditions.invisibilityOf(element));
        return element;
    }

    public static WebElement waitForVisibility(WebElement element) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait());
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

}
