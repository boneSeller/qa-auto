package ru.aston.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@contains(@class, 'navbar-pc__icon--basket')")
    private WebElement cart;

    private By listOfPrice = By.xpath("//div[@class='basket-list__accordion accordion']//div[@class='list-item__price-wallet']");
    private By listOfNames = By.className("good-info__good-name");
    private By totalPrice = By.xpath("//p[@class='b-top__total line']/span[2]/span");

    public String getTitleOfCartPage() {
        return driver.getTitle();
    }

    public List<Integer> getPrices() {
        return driver.findElements(listOfPrice).stream()
                .map(e -> Integer.parseInt(e.getText().replace("₽", "").replace(" ", "").trim()))
                .collect(Collectors.toList());
    }

    public List<String> getNamesOfGoods() {
        return driver.findElements(listOfNames).stream()
                .map(s -> s.getText().replaceAll("\\.", "").trim())
                .sorted().collect(Collectors.toList());
    }

    public int getTotalPrice() {
        return Integer.parseInt(driver.findElement(totalPrice).getText().replace("₽", "").trim());
    }
}
