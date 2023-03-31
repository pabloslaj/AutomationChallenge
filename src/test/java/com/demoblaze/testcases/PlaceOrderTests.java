package com.demoblaze.testcases;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.ProductDetailsPage;
import com.demoblaze.testcases.utils.TokenUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public final class PlaceOrderTests extends BaseTest {

    private HomePage homePage;
    private ProductDetailsPage productDetailsPage;

    private PlaceOrderTests() {
    }

    @BeforeMethod
    public void init() {
        TokenUtils.randomRegisterAndSetCookie();
        homePage = new HomePage();
    }

    @Test
    public void tc_place_order_001(Map<String, String> data) {
        // Get first displayed product:
        WebElement product = homePage.getFirstProduct();

        // Open the product details and add it to cart:
        productDetailsPage = homePage
                .openProductDetails(product)
                .clickAddToCart();

        // Accept the alert;
        productDetailsPage.clickAcceptAlert();

        // Open the cart, complete the data and create the Order:
        boolean orderSuccess = productDetailsPage
                .clickOnCart()
                .performPlaceOrderWithRandomData()
                .orderWasCompleted();

        // Check if the order was Completed
        Assert.assertTrue(orderSuccess, "The order was not completed");
    }

    @Test
    public void tc_place_order_002(Map<String, String> data) {
        // Get first displayed product:
        WebElement product = homePage.getFirstProduct();

        // Open the product details and add it to cart:
        productDetailsPage = homePage
                .openProductDetails(product)
                .clickAddToCart();

        // Accept the alert:
        productDetailsPage.clickAcceptAlert();

        // Open the cart and click on create order without complete the data fields:
        productDetailsPage
                .clickOnCart()
                .clickOnPlaceOrder()
                .clickPurchaseButton();

        // Get the alert message
        String alertMessage = productDetailsPage.getAlertMessage();

        // Compare is the message is as expected:
        Assert.assertEquals(alertMessage, data.get("alertMessage"), "The Alert message is not as expected");
    }


}
