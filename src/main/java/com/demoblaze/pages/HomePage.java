package com.demoblaze.pages;

import br.com.six2six.fixturefactory.Fixture;
import com.demoblaze.api.fixtures.entity.UserDetailsData;
import com.demoblaze.enums.WaitStrategy;
import com.demoblaze.pages.entity.ProductData;
import com.demoblaze.utils.AlertUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.demoblaze.pages.pagecomponents.homepage.ProductComponent.*;
import static com.demoblaze.utils.PageActionsHelper.*;

public class HomePage extends BasePage {

    @FindBy(id = "nameofuser")
    WebElement welcomeLink;

    public HomePage performLogin(Map<String, String> data) {
        clickLoginLink()
                .setUserName(data.get("userName"))
                .setUserPassword(data.get("userPassword"))
                .clickLoginButton();
        return this;
    }

    public HomePage performLoginWithNonExistentUser() {
        UserDetailsData userDetails = Fixture.from(UserDetailsData.class).gimme("valid_random");
        clickLoginLink()
                .setUserName(userDetails.getUsername())
                .setUserPassword(userDetails.getPassword())
                .clickLoginButton();
        return this;
    }

    public HomePage performRegister(Map<String, String> data) {
        clickSignUpLink()
                .setUserName(data.get("userName"))
                .setUserPassword(data.get("userPassword"))
                .clickSignUpButton();
        return this;
    }

    public HomePage performRegisterWithNonExistentUser() {
        UserDetailsData userDetails = Fixture.from(UserDetailsData.class).gimme("valid_random");
        clickSignUpLink()
                .setUserName(userDetails.getUsername())
                .setUserPassword(userDetails.getPassword())
                .clickSignUpButton();
        return this;
    }

    public String getWelcomeMessage() {
        return getElementText(welcomeLink, WaitStrategy.VISIBLE);
    }

    public List<ProductData> getAllProducts() {
        List<ProductData> products = new ArrayList<>();
        List<WebElement> productElements = getAllProductElements();

        for (WebElement productElement : productElements) {
            products.add(getProductData(productElement));
        }
        return products;
    }

    public List<WebElement> getAllProductElements() {
        waitForInVisibility(loginLink);
        return getElementsUsingBy(getProductCardLocator());
    }

    public WebElement getFirstProduct() {
        return getAllProductElements().get(0);
    }

    public void softAssertProductInformation(List<ProductData> productData) {
        SoftAssert softAssert = new SoftAssert();
        for (ProductData element : productData) {
            softAssert.assertTrue(element.isContainImage(), "The product does not contain an image");
            softAssert.assertTrue(Objects.nonNull(element.getProductName()), "The product does not contain Name");
            softAssert.assertTrue(Objects.nonNull(element.getProductPrice()), "The product does not contain Price");
            softAssert.assertTrue(Objects.nonNull(element.getProductDescription()), "The product does not contain Description");
        }
        softAssert.assertAll();
    }

    public ProductDetailsPage openProductDetails(WebElement product) {
        click(product, WaitStrategy.VISIBLE, "Product");
        return new ProductDetailsPage();
    }

    public ProductData getProductData(WebElement product) {
        return new ProductData(
                Objects.nonNull(getChainElement(product, getProductImageLocator())),
                getElementText(getChainElement(product, getProductNameLocator()), WaitStrategy.NONE),
                getElementText(getChainElement(product, getProductPriceLocator()), WaitStrategy.NONE),
                getElementText(getChainElement(product, getProductDescriptionLocator()), WaitStrategy.NONE)
        );
    }
}
