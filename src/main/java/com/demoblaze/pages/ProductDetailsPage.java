package com.demoblaze.pages;

import com.demoblaze.enums.WaitStrategy;
import com.demoblaze.pages.entity.ProductData;
import com.demoblaze.utils.AlertUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

import static com.demoblaze.utils.PageActionsHelper.click;
import static com.demoblaze.utils.PageActionsHelper.getElementText;

public class ProductDetailsPage extends BasePage {

    @FindBy(id = "imgp")
    WebElement productImage;

    @FindBy(className = "name")
    WebElement productName;

    @FindBy(className = "price-container")
    WebElement productPrice;

    @FindBy(id = "more-information")
    WebElement productDescription;

    @FindBy(css = "[onclick*='addToCart']")
    WebElement addToCartBtn;

    public boolean isImageDisplayed() {
        return Objects.nonNull(productImage);
    }

    public String getProductName() {
        return getElementText(productName, WaitStrategy.VISIBLE);
    }

    public String getProductPrice() {
        return getElementText(productPrice, WaitStrategy.VISIBLE);
    }

    public String getProductDescription() {
        return getElementText(productDescription, WaitStrategy.VISIBLE);
    }

    public void softAssertProductInformation(ProductData productCardData) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(isImageDisplayed(), productCardData.isContainImage(), "The Image is not correctly displayed");
        softAssert.assertTrue(getProductName().contains(productCardData.getProductName()), "The Name is not correctly displayed");
        softAssert.assertTrue(getProductPrice().contains(productCardData.getProductPrice()), "The Price is not correctly displayed");
        softAssert.assertTrue(getProductDescription().contains(productCardData.getProductDescription()), "The Description is not correctly displayed");
        softAssert.assertAll();
    }

    public ProductDetailsPage clickAddToCart() {
        click(addToCartBtn, WaitStrategy.VISIBLE, "Add To Cart");
        return this;
    }

}
