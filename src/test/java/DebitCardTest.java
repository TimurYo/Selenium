import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DebitCardTest {
    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void validForm() {
        driver.get("http://0.0.0.0:9999");
        driver.findElement(By.id("[data-test-id= name]")).sendKeys("Джон Константин");
        driver.findElement(By.id("[data-test-id= name]")).sendKeys("+79999999999");
        driver.findElement(By.id("[data-test-id= agreement]")).click();
        driver.findElement(By.id("buttom")).click();
        String expected = " Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.id("[data-test-id= order-success]")).getText();

        assertEquals(expected,actual);
    }

}
