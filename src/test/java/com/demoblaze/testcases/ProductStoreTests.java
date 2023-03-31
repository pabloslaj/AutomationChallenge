package com.demoblaze.testcases;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.entity.ProductData;
import com.demoblaze.testcases.utils.TokenUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public final class ProductStoreTests extends BaseTest {

    private HomePage homePage;

    private ProductStoreTests() {
    }

    @BeforeMethod
    public void init() {
        TokenUtils.randomRegisterAndSetCookie();
        homePage = new HomePage();
    }

    @Test
    public void tc_prod_store_001(Map<String, String> data) {
        // Get all the displayed products
        List<ProductData> productData = homePage.getAllProducts();

        // Soft assert if each product contains all the relevant information:
        homePage.softAssertProductInformation(productData);
    }

    @Test
    public void tc_prod_store_002(Map<String, String> data) {
        // Get the first displayed product:
        WebElement product = homePage.getFirstProduct();

        // Get all the relevant information of the product:
        ProductData productCardData = homePage.getProductData(product);

        // Open the product details and compare if the information from the cart is present on the details:
        homePage.openProductDetails(product)
                .softAssertProductInformation(productCardData);
    }
}
