package ru.aston.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//a[contains(@class,'product-card__add-basket')]")
    private List<WebElement> productLinksList;

    @FindBy(xpath = "//span[@class='navbar-pc__notify']")
    private WebElement amountOfGoods;

    @FindBy(xpath = "//span[contains(@class, 'navbar-pc__icon--basket')]")
    private WebElement linkToCart;

    @FindBy(className = "popup__content")
    private WebElement popupContent;

    private By costText = By.xpath("//ins[contains(@class, 'wallet-price')]");
    private By btnText = By.className("btn-text");
    private By nameOfProduct = By.className("product-card__name");
    private By sizeOfProduct = By.className("sizes-list__item");


    public MainPage clickAddToCart() {
        driver.findElement(btnText).click();
        return this;
    }

    public MainPage addGoodsToCart() {
        driver.findElements(btnText).stream().limit(2).forEach(WebElement::click);
        return this;
    }

    public MainPage clickToSize() {
        if (popupContent.isEnabled()) {
            driver.findElement(sizeOfProduct).click();
        }
        return this;
    }

    public List<String> getNamesOfGoods(int limit) {
        List<String> list = driver.findElements(nameOfProduct).stream()
                .limit(limit).map(WebElement::getText)
                .map(s -> s.replaceAll("/", "").trim())
                .sorted()
                .collect(Collectors.toList());
        return list;
    }

    public List<Integer> getPrices(int limit) {
        List<Integer> list = driver.findElements(costText).stream()
                .limit(limit)
                .map(e -> Integer.parseInt(e.getText().replace("₽", "").replace(" ", "").trim()))
                .collect(Collectors.toList());
        Collections.reverse(list);
        return list;
    }

    public String getAmountOfGoodsInTheCart() {
        wait.until(ExpectedConditions.visibilityOf(amountOfGoods));
        return amountOfGoods.getText();
    }

    public CartPage goToCartPage() {
        linkToCart.click();
        return new CartPage(driver);
    }
}
