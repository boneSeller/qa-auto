package ru.aston;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class OnlinePaymentSection {
    private WebDriver driver;

    public OnlinePaymentSection(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='pay__wrapper']/h2")
    private WebElement onlinePayment;
    @FindBy(xpath = "//div[@class='pay__partners']/ul/li")
    private List<WebElement> listOfIcons;

    @FindBy(xpath = "//a[text()='Подробнее о сервисе']")
    private WebElement linkToService;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement phone;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement sum;

    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement email;

    @FindBy(xpath = "//button[contains(@class,'button__default')]")
    private WebElement submit;

    public String getTitleOnlinePayment() {
        return onlinePayment.getText().replace("\n", " ");
    }

    public List<String> listOfIcons() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.className("pay__partners")));
        return listOfIcons.stream().map(x -> x.findElement(By.xpath("./img")).getAttribute("alt")).collect(Collectors.toList());
    }

    public String getTitleOflinkToService() {
        linkToService.click();
        return driver.getTitle();
    }

    public Boolean isDisplayedPaymentForm(String phone, String sum, String email) {
        this.phone.sendKeys(phone);
        this.sum.sendKeys(sum);
        this.email.sendKeys(email);
        submit.submit();
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@class='bepaid-app']")))).isDisplayed();
    }
}
