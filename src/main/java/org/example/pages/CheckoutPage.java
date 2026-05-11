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

    // Метод для перевірки результату (Assert)
    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return successHeader.getText();
    }
}