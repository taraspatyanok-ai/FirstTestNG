import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-features=PasswordLeakDetection");
        options.addArguments("--disable-save-password-bubble");

        // НАЛАШТУВАННЯ ДЛЯ GITHUB ACTIONS (БЕЗГОЛОВИЙ РЕЖИМ)
        options.addArguments("--headless=new"); // Запуск без графічного вікна
        options.addArguments("--no-sandbox"); // Обхід обмежень безпеки Linux-контейнера
        options.addArguments("--disable-dev-shm-usage"); // Запобігає падінню через брак пам'яті в Docker
        options.addArguments("--window-size=1920,1080"); // Задаємо віртуальний екран, щоб елементи не злітали

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
