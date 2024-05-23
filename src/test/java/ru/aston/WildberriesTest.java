package ru.aston;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aston.pages.CartPage;
import ru.aston.pages.MainPage;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WildberriesTest {

    private WebDriver driver;
    private MainPage mainPage;
    private CartPage cartPage;
    private WebDriverWait wait;

    @BeforeAll
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.wildberries.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = PageFactory.initElements(driver, MainPage.class);
        cartPage = PageFactory.initElements(driver, CartPage.class);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

//    @AfterEach
//    private void close() {
//        driver.quit();
//    }

    @Test
    public void addToCart() {
        mainPage.clickAddToCart();
        String str = mainPage.getAmountOfGoodsInTheCart();
        assertEquals("1", str);
    }


    @Test
    public void manyAddToCart() {
        mainPage.addGoodsToCart().clickToSize();
        String amountOfGoods = mainPage.getAmountOfGoodsInTheCart();
        List<String> nameOfGoodsFromMainPage = mainPage.getNamesOfGoods(2);
        List<Integer> pricesFromMainPage = mainPage.getPrices(2);
        assertEquals("2", amountOfGoods);
        mainPage.goToCartPage();
        String title = cartPage.getTitleOfCartPage();
        assertEquals("Интернет-магазин Wildberries: широкий ассортимент товаров - скидки каждый день!", title);
        List<String> nameOfGoodsFromCartPage = cartPage.getNamesOfGoods();
        List<Integer> pricesFromCartPage = cartPage.getPrices();
        int totalPriceCartPage = cartPage.getTotalPrice();
        int totalPriceMainPage = pricesFromMainPage.stream().mapToInt(Integer::intValue).sum();
        assertEquals(nameOfGoodsFromCartPage.toString(), nameOfGoodsFromMainPage.toString());
        assertEquals(pricesFromCartPage.size(), 2);
        assertEquals(totalPriceMainPage, cartPage.getTotalPrice());
    }
}
