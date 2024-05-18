package ru.aston;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlinePaymentSectionTest {
    private static WebDriver driver;
    JavascriptExecutor js;
    private static OnlinePaymentSection onlinePaymentSection;
    private static WebDriverWait wait;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        if (driver.findElement(By.xpath("//div[@class='cookie__wrapper']")).isDisplayed()) {
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

    @ParameterizedTest
    @CsvSource(value = {"Услуги связи,Номер телефона",
            "Домашний интернет,Номер абонента",
            "Рассрочка,Номер счета на 44",
            "Задолженность,Номер счета на 2073"}, ignoreLeadingAndTrailingWhitespace = true)
    public void checkPlaceholders(String str, String expectedString) {
        List<String> expected = new ArrayList<>(Arrays.asList(expectedString, "Сумма", "E-mail для отправки чека"));
        assertTrue(expected.equals(onlinePaymentSection.getPlaceholdersOfOnlineFull(str)));
    }

    @ParameterizedTest
    @CsvSource(value = {"Услуги связи, 297777777, 12, ivan@mail.ru"}, ignoreLeadingAndTrailingWhitespace = true)
    public void checkSumOnBePaid(String str, String num, String sum, String mail) {
        List<String> actual = onlinePaymentSection.getSum(str, num, sum, mail, wait);
        assertTrue(actual.get(0).contains("12.00"));
        assertTrue(actual.get(1).contains("12.00"));
    }

    @ParameterizedTest
    @CsvSource(value = {"Услуги связи, 297777777, 12, ivan@mail.ru"}, ignoreLeadingAndTrailingWhitespace = true)
    public void checkNumberOnBePaid(String str, String num, String sum, String mail) {
        assertEquals("375297777777", onlinePaymentSection.getNumberText(str, num, sum, mail, wait));
    }

    @ParameterizedTest
    @CsvSource(value = {"Услуги связи, 297777777, 12, ivan@mail.ru"}, ignoreLeadingAndTrailingWhitespace = true)
    public void checkPlaceholdersOnBePaid(String str, String num, String sum, String mail) {
        List<String> expected = new ArrayList<>(Arrays.asList("Номер карты", "Срок действия", "CVC", "Имя держателя (как на карте)"));
        assertTrue(expected.equals(onlinePaymentSection.getPlaceholdersOfBePaid(str, num, sum, mail)));
    }

    @ParameterizedTest
    @CsvSource(value = {"Услуги связи, 297777777, 12, ivan@mail.ru"}, ignoreLeadingAndTrailingWhitespace = true)
    public void checkIconsOfBePaid(String str, String num, String sum, String mail) {
        assertTrue(onlinePaymentSection.getListOfIconsBePaid(str, num, sum, mail, wait).size() == 5);
    }
}
