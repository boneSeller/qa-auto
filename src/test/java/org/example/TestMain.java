package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestMain {

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.quit();
        System.out.println("Тест");
    }
}
