import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // 1. Автоматично підтягуємо драйвер Chrome
        WebDriverManager.chromedriver().setup();

        // 2. Запускаємо браузер
        driver = new ChromeDriver();

        // 3. Налаштування: на весь екран та очікування елементів (щоб тест не падав відразу)
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 4. Переходимо на сайт
        driver.get("https://www.saucedemo.com");
    }

    @AfterMethod
    public void tearDown() {
        // 5. Закриваємо браузер після кожного тесту
        if (driver != null) {
            driver.quit();
        }
    }
}
}
