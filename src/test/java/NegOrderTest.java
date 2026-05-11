import org.example.pages.CheckoutPage;
import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegOrderTest extends BaseTest {
    @DataProvider(name = "productsProvider")
    public Object[][] getProducts() {
        return new Object[][]{
                {"backpack"},    // Перший запуск
                //  {"bike-light"},  // Другий запуск
                //  {"bolt-t-shirt"}, // Третій запуск
                // {"fleece-jacket"} // Четвертий пуск
        };
    }

    @Test(dataProvider = "productsProvider")
    public void testUnSuccessfulPurchase(String product) {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.loginToApp("error_user", "secret_sauce");

        inventoryPage.addItemToCart(product);
        inventoryPage.clickCart();

        checkoutPage.checkButtClick();
        checkoutPage.fillInfo("Ivan", "Ivanov", "101110");
        checkoutPage.finButtClick();

        String actualMessage = checkoutPage.getSuccessMessage();
        Assert.assertEquals(actualMessage, "Thank you for your order!", "Помилка: Текст успіху не знайдено!");


    }
}


