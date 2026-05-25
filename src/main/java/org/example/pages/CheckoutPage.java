package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    @FindBy(xpath = "//button[@id= 'checkout']")
    private WebElement checkoutButton;
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement zipCodeField;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;
    @FindBy(id = "finish")
    private WebElement finishButton;
    @FindBy(className = "complete-header")
    private WebElement successHeader;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkButtClick() {checkoutButton.click();}

    public void fillInfo(String fName, String lName, String zip) {
        firstNameField.sendKeys(fName);
        lastNameField.sendKeys(lName);
        zipCodeField.sendKeys(zip);
        continueButton.click();
    }

    public void finButtClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(finishButton));
        finishButton.click();
    }

        public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return successHeader.getText();
    }
}