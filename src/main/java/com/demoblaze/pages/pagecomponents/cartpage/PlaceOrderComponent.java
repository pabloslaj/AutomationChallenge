package com.demoblaze.pages.pagecomponents.cartpage;

import com.demoblaze.enums.WaitStrategy;
import org.openqa.selenium.By;

import static com.demoblaze.utils.PageActionsHelper.click;
import static com.demoblaze.utils.PageActionsHelper.sendKeys;

public class PlaceOrderComponent {

    private static final By USER_INPUT_NAME = By.xpath("//input[@id='name']");
    private static final By USER_INPUT_COUNTRY = By.xpath("//input[@id='country']");
    private static final By USER_INPUT_CITY = By.xpath("//input[@id='city']");
    private static final By USER_INPUT_CARD = By.xpath("//input[@id='card']");
    private static final By USER_INPUT_MONTH = By.xpath("//input[@id='month']");
    private static final By USER_INPUT_YEAR = By.xpath("//input[@id='year']");
    private static final By BTN_PURCHASE = By.xpath("//button[@onclick='purchaseOrder()']");

    public PlaceOrderComponent setUserName(String userName) {
        sendKeys(USER_INPUT_NAME, userName, WaitStrategy.VISIBLE, "Input User Name");
        return this;
    }

    public PlaceOrderComponent setUserCountry(String userCountry) {
        sendKeys(USER_INPUT_COUNTRY, userCountry, WaitStrategy.VISIBLE, "Input Country");
        return this;
    }

    public PlaceOrderComponent setUserCity(String userCity) {
        sendKeys(USER_INPUT_CITY, userCity, WaitStrategy.VISIBLE, "Input User City");
        return this;
    }

    public PlaceOrderComponent setUserCard(String userCard) {
        sendKeys(USER_INPUT_CARD, userCard, WaitStrategy.VISIBLE, "Input User Card");
        return this;
    }

    public PlaceOrderComponent setUserMonth(String userMonth) {
        sendKeys(USER_INPUT_MONTH, userMonth, WaitStrategy.VISIBLE, "Input User Month");
        return this;
    }

    public PlaceOrderComponent setUserYear(String userYear) {
        sendKeys(USER_INPUT_YEAR, userYear, WaitStrategy.VISIBLE, "Input User Year");
        return this;
    }
    
    public PlaceOrderComponent clickPurchaseButton() {
        click(BTN_PURCHASE, WaitStrategy.CLICKABLE, "Purchase Button");
        return this;
    }
}
