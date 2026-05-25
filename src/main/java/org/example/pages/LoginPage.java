package org.example.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//input [@id = 'user-name']")
    private WebElement usernameField;
    @FindBy(xpath = "//input [@id = 'password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input [@id = 'login-button']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String name) {
        usernameField.sendKeys(name);
    }

    public void enterPassword(String pass) {
        passwordField.sendKeys(pass);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void loginToApp(String user, String pass) {
        enterUserName(user);
        enterPassword(pass);
        clickLogin();
    }


}

