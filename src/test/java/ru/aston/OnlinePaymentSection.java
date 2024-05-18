package ru.aston;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnlinePaymentSection {
    private WebDriver driver;

    public OnlinePaymentSection(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//form[contains(@class,'opened')]//input[@class='phone']")
    private WebElement phone;

    @FindBy(xpath = "//form[contains(@class,'opened')]//input[@class='score']")
    private WebElement score;

    @FindBy(xpath = "//form[contains(@class,'opened')]//input[@class='total_rub']")
    private WebElement sum;

    @FindBy(xpath = "//form[contains(@class,'opened')]//input[@class='email']")
    private WebElement email;

    @FindBy(xpath = "//button[contains(@class,'button__default')]")
    private WebElement submit;

    @FindBy(xpath = "//button[@class='select__header']")
    private WebElement dropDownButton;

    @FindBy(className = "bepaid-iframe")
    private WebElement bepaidFrame;

    @FindBy(className = "payment-page")
    private WebElement sectionPayment;

    @FindBy(xpath = "//div[@class='pay-description__cost']/span")
    private WebElement payCostSpan;

    @FindBy(xpath = "//button[@class='colored disabled']")
    private WebElement payCostButton;

    @FindBy(xpath = "//form[@class='pay-form opened']//input")
    private List<WebElement> formInputsOfOnlineFull;

    @FindBy(xpath = "//form//div[contains(@class,'card')]//label")
    private List<WebElement> formInputsOfBePaid;

    @FindBy(className = "pay-description__text")
    private WebElement payNumberText;

    @FindBy(xpath = "//div[contains(@class, 'icons-container')]//img")
    private List<WebElement> iconsOfBePaid;

    public List<WebElement> getFormInputsOfOnlineFull() {
        return formInputsOfOnlineFull;
    }

    public List<WebElement> getFormInputsOfBePaid() {
        return formInputsOfBePaid;
    }

    public void submitFormOfOnlineFull(String phone, String sum, String email) {
        this.phone.sendKeys(phone);
        this.sum.sendKeys(sum);
        this.email.sendKeys(email);
        submit.submit();
    }

    public void chooseTypeOfPayment(String str) {
        dropDownButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.select__list")));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//p[text()='" + str + "']"))).click();
    }

    public List<String> getPlaceholders(List<WebElement> wbList) {
        List<String> list = new ArrayList<>();
        if (wbList.equals(getFormInputsOfBePaid())) {
            for (WebElement e : wbList) {
                list.add(e.getText());
            }
        } else {
            for (WebElement e : wbList) {
                list.add(e.getAttribute("placeholder"));
            }
        }
        return list;
    }

    public List<String> getPlaceholdersOfOnlineFull(String str) {
        chooseTypeOfPayment(str);
        return getPlaceholders(getFormInputsOfOnlineFull());
    }

    public void goToBePaidFrame(String str, String phone, String sum, String mail, WebDriverWait wait) {
        chooseTypeOfPayment(str);
        submitFormOfOnlineFull(phone, sum, mail);
        driver.switchTo().frame(bepaidFrame);
        wait.until(ExpectedConditions.visibilityOf(sectionPayment));
    }

    public List<String> getPlaceholdersOfBePaid(String str, String phone, String sum, String mail) {
        chooseTypeOfPayment(str);
        submitFormOfOnlineFull(phone, sum, mail);
        driver.switchTo().frame(bepaidFrame);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("app-payment-container")));
        return getPlaceholders(getFormInputsOfBePaid());
    }

    public List<String> getSum(String str, String phone, String sum, String mail, WebDriverWait wait) {
        goToBePaidFrame(str, phone, sum, mail, wait);
        return new ArrayList<>(Arrays.asList(payCostSpan.getText(),payCostButton.getText()));
    }

    public String getNumberText(String str, String phone, String sum, String mail, WebDriverWait wait) {
        goToBePaidFrame(str, phone, sum, mail, wait);
        return payNumberText.getText().substring(27);
    }

    public List<WebElement> getListOfIconsBePaid(String str, String phone, String sum, String mail, WebDriverWait wait) {
        goToBePaidFrame(str, phone, sum, mail, wait);
        return iconsOfBePaid;
    }
}
