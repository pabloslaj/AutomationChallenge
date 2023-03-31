package com.demoblaze.pages;

import br.com.six2six.fixturefactory.Fixture;
import com.demoblaze.constants.FrameworkConstants;
import com.demoblaze.driver.DriverManager;
import com.demoblaze.enums.WaitStrategy;
import com.demoblaze.pages.entity.PlaceOrderData;
import com.demoblaze.pages.pagecomponents.cartpage.PlaceOrderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

import static com.demoblaze.utils.PageActionsHelper.*;

public class CartPage extends BasePage {

    @FindBy(xpath = "//button[@data-target='#orderModal']")
    WebElement buttonPlaceOrder;

    @FindBy(css = "div.sweet-alert.showSweetAlert.visible")
    WebElement modalPurchaseOk;

    private final By ROWS = By.className("success");

    private WebElement getRow(String productName) {
        List<WebElement> rows = getElementsUsingBy(ROWS);
        WebElement productAdded = null;
        int i = 0;
        while (i < rows.size() && Objects.isNull(productAdded)) {
            productAdded = getChainElement(rows.get(i), By.xpath("//td[contains(text(), '" + productName + "')]"));
        }
        return Objects.nonNull(productAdded) ? rows.get(i) : null;
    }

    public CartPage deleteProduct(String productName) {
        WebElement row = getRow(productName);
        WebElement delete = getChainElement(row, By.xpath("//td/a[contains(text(), 'Delete')]"));
        click(delete, WaitStrategy.VISIBLE, "Remove Item");
        return this;
    }

    public boolean isProductOnCart(String productName, boolean expected) {
        boolean asExpected = false;
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait());
        try {
            wait.until(waitToLoadProduct(productName, expected));
            asExpected = true;
        } catch (Exception e) {
            // The product wasn't found in the expected state, so isProductFound remains false
        }
        return asExpected;
    }

    private ExpectedCondition<Boolean> waitToLoadProduct(String productName, boolean present) {
        return new ExpectedCondition<>() {

            @Override
            public Boolean apply(WebDriver driver) {
                return Objects.nonNull(getRow(productName)) == present;
            }

            @Override
            public String toString() {
                return "Product isn't present ";
            }
        };
    }

    public PlaceOrderComponent clickOnPlaceOrder() {
        click(buttonPlaceOrder, WaitStrategy.CLICKABLE, "Button Place Order");
        return new PlaceOrderComponent();
    }

    public CartPage performPlaceOrderWithRandomData() {
        PlaceOrderData placeOrderData = Fixture.from(PlaceOrderData.class).gimme("valid_random");
        clickOnPlaceOrder()
                .setUserName(placeOrderData.getUserName())
                .setUserCountry(placeOrderData.getCountry())
                .setUserCity(placeOrderData.getCity())
                .setUserCard(placeOrderData.getCreditCard())
                .setUserMonth(placeOrderData.getMonth())
                .setUserYear(placeOrderData.getYear())
                .clickPurchaseButton();
        return this;
    }

    public boolean orderWasCompleted() {
        return Objects.nonNull(waitForVisibility(modalPurchaseOk));
    }

}
