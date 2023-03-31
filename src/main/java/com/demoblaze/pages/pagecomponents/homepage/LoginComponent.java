package com.demoblaze.pages.pagecomponents.homepage;

import com.demoblaze.enums.WaitStrategy;
import org.openqa.selenium.By;

import static com.demoblaze.utils.PageActionsHelper.click;
import static com.demoblaze.utils.PageActionsHelper.sendKeys;

public class LoginComponent {

    private static final By USER_INPUT_NAME = By.xpath("//input[@id='loginusername']");
    private static final By USER_INPUT_PASSWORD = By.xpath("//input[@id='loginpassword']");
    private static final By BTN_CLOSE = By.xpath("//button[text()='Close']");
    private static final By BTN_LOGIN = By.xpath("//button[text()='Log in']");

    public LoginComponent setUserName(String userFirstName) {
        sendKeys(USER_INPUT_NAME, userFirstName, WaitStrategy.VISIBLE, "Input User Name");
        return this;
    }

    public LoginComponent setUserPassword(String userPassword) {
        sendKeys(USER_INPUT_PASSWORD, userPassword, WaitStrategy.VISIBLE, "Input User Password");
        return this;
    }

    public LoginComponent clickCloseButton() {
        click(BTN_CLOSE, WaitStrategy.CLICKABLE, "Close Button");
        return this;
    }

    public LoginComponent clickLoginButton() {
        click(BTN_LOGIN, WaitStrategy.CLICKABLE, "Login Button");
        return this;
    }

}
