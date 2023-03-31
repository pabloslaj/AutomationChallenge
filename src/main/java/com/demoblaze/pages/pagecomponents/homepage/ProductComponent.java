package com.demoblaze.pages.pagecomponents.homepage;

import org.openqa.selenium.By;

public class ProductComponent {

    private static final By PRODUCT_CARD = By.cssSelector(".card");
    private static final By PRODUCT_IMAGE = By.xpath("//img[@class='card-img-top img-fluid']");
    private static final By PRODUCT_NAME = By.xpath("//div[@class='card-block']//*[@class='card-title']");
    private static final By PRODUCT_PRICE = By.xpath("//p[@id='article']/preceding-sibling::h5");
    private static final By PRODUCT_DESCRIPTION = By.id("article");

    public static By getProductCardLocator() {
        return PRODUCT_CARD;
    }

    public static By getProductImageLocator() {
        return PRODUCT_IMAGE;
    }

    public static By getProductNameLocator() {
        return PRODUCT_NAME;
    }

    public static By getProductPriceLocator() {
        return PRODUCT_PRICE;
    }

    public static By getProductDescriptionLocator() {
        return PRODUCT_DESCRIPTION;
    }


}
