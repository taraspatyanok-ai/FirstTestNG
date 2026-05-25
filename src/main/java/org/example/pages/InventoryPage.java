package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class InventoryPage {
    private WebDriver driver;

    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }
    public String getProductPrice (String name){
        String xpath2GetPrice = "//div[text()='" + name + "']/ancestor::div[@class = 'inventory_item_description']//div[@class='inventory_item_price']";
        return driver.findElement(By.xpath(xpath2GetPrice)).getText();
    }

    private By shopCartButton = By.className("shopping_cart_link");

    public void addItemToCart(String itemName) {
                String dynamicId = "add-to-cart-sauce-labs-" + itemName.toLowerCase().replace(" ", "-");
        driver.findElement(By.id(dynamicId)).click();
    }
    public void clickCart() {
        driver.findElement(shopCartButton).click();
    }


}
