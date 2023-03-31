package com.demoblaze.pages.pagecomponents.homepage;

import com.demoblaze.enums.WaitStrategy;
import org.openqa.selenium.By;

import static com.demoblaze.utils.PageActionsHelper.click;
import static com.demoblaze.utils.PageActionsHelper.sendKeys;

public class SignUpComponent {
    private static final By USER_INPUT_NAME = By.id("sign-username");
    private static final By USER_INPUT_PASSWORD = By.id("sign-password");
    private static final By BTN_CLOSE = By.xpath("//button[text()='Close']");
    private static final By BTN_SIGNUP = By.xpath("//button[text()='Sign up']");

    public SignUpComponent setUserName(String userFirstName) {
        sendKeys(USER_INPUT_NAME, userFirstName, WaitStrategy.VISIBLE, "Input User Name");
        return this;
    }

    public SignUpComponent setUserPassword(String userPassword) {
        sendKeys(USER_INPUT_PASSWORD, userPassword, WaitStrategy.VISIBLE, "Input User Password");
        return this;
    }

    public SignUpComponent clickCloseButton() {
        click(BTN_CLOSE, WaitStrategy.CLICKABLE, "Close Button");
        return this;
    }

    public SignUpComponent clickSignUpButton() {
        click(BTN_SIGNUP, WaitStrategy.CLICKABLE, "Login Button");
        return this;
    }

}
