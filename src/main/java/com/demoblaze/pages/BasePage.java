package com.demoblaze.pages;

import com.demoblaze.driver.DriverManager;
import com.demoblaze.enums.WaitStrategy;
import com.demoblaze.pages.pagecomponents.homepage.LoginComponent;
import com.demoblaze.pages.pagecomponents.homepage.SignUpComponent;
import com.demoblaze.utils.AlertUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.demoblaze.utils.PageActionsHelper.click;

public class BasePage {

    @FindBy(id = "signin2")
    WebElement signUpLink;

    @FindBy(id = "login2")
    WebElement loginLink;

    @FindBy(id = "cartur")
    WebElement cartLink;

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public CartPage clickOnCart() {
        click(cartLink, WaitStrategy.VISIBLE, "Cart");
        return new CartPage();
    }

    public SignUpComponent clickSignUpLink() {
        click(signUpLink, WaitStrategy.CLICKABLE, "Sign Up");
        return new SignUpComponent();
    }

    public LoginComponent clickLoginLink() {
        click(loginLink, WaitStrategy.CLICKABLE, "Login");
        return new LoginComponent();
    }

    public String getAlertMessage() {
        return AlertUtils.getAlertText();
    }

    public void clickAcceptAlert() {
        AlertUtils.clickAcceptAlert();
    }


}
