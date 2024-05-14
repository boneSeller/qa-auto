package ru.aston;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlinePaymentSectionTest {
    private static WebDriver driver;
    JavascriptExecutor js;
    private static OnlinePaymentSection onlinePaymentSection;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        if(driver.findElement(By.xpath("//div[@class='cookie__wrapper']")).isDisplayed()) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='cookie__wrapper']")));
            WebElement element = wait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='cookie-agree']")));
            element.click();
        }
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//section[@class='pay']")));
        onlinePaymentSection = PageFactory.initElements(driver, OnlinePaymentSection.class);
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    @Test
    public void checkTheNameOfTheBlock() {
        String actual = onlinePaymentSection.getTitleOnlinePayment();
        String expected = "Онлайн пополнение без комиссии";
        assertEquals(expected, actual);
    }

    @Test
    public void checkLogo() {
        List<String> expected = new ArrayList<>(Arrays.asList("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт", "МИР"));
        assertEquals(expected.toString(), onlinePaymentSection.listOfIcons().toString());
    }

    @Test
    public void checkMoreAboutService() {
        assertEquals("Порядок оплаты и безопасность интернет платежей", onlinePaymentSection.getTitleOflinkToService());
    }

    @Test
    public void checkSubmitForm() {
        assertEquals(true, onlinePaymentSection.isDisplayedPaymentForm("297777777", "12", "ivan@mail.ru"));
    }
}
