package org.example.pages;

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
    /*
    private By checkoutButton = By.xpath("//button[@id= 'checkout']");
    private By firstNameField = By.xpath("//input[@id = 'first-name']");
    private By lastNameField = By.xpath("//input[@id= 'last-name']");
    private By zipCodeField = By.xpath("//input[@id= 'postal-code']");
    private By continueButton = By.xpath("//input[@id= 'continue']");
    private By finishButton = By.id("finish");
    private By successHeader = By.className("complete-header"); // Додав для фінальної перевірки
     */


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
