package com.demoblaze.testcases;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.ProductDetailsPage;
import com.demoblaze.testcases.utils.TokenUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public final class CartTests extends BaseTest {
    private HomePage homePage;
    private ProductDetailsPage productDetailsPage;

    private CartTests() {
    }

    @BeforeMethod
    public void init() {
        TokenUtils.randomRegisterAndSetCookie();
        homePage = new HomePage();
    }

    @Test
    public void tc_cart_001(Map<String, String> data) {
        // Get first displayed product:
        WebElement product = homePage.getFirstProduct();

        // Open the product details and get the name:
        productDetailsPage = homePage.openProductDetails(product);
        String productName = productDetailsPage.getProductName();

        // Add the product to cart and accept the alert:
        productDetailsPage
                .clickAddToCart()
                .clickAcceptAlert();

        // Open the cart and return if product was added
        boolean isProductOnCheckout = productDetailsPage
                .clickOnCart()
                .isProductOnCart(productName, true);

        // Assert if product is present
        Assert.assertTrue(isProductOnCheckout, String.format("The product [%s] is not present on Cart", productName));
    }

    @Test
    public void tc_cart_002(Map<String, String> data) {
        // Get first displayed product:
        WebElement product = homePage.getFirstProduct();

        // Open the product details and get the name:
        productDetailsPage = homePage.openProductDetails(product);
        String productName = productDetailsPage.getProductName();

        // Add the product to cart and accept the alert:
        productDetailsPage
                .clickAddToCart()
                .clickAcceptAlert();

        // Open the cart, remove the product and return if product keep present
        boolean isProductOnCheckout = productDetailsPage
                .clickOnCart()
                .deleteProduct(productName)
                .isProductOnCart(productName, false);

        // Assert if product is present
        Assert.assertFalse(isProductOnCheckout, String.format("The product [%s] keep present on Cart", productName));
    }
}
