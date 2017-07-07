package ototot;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class POFooterTests {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void clickContacts(){
        driver.get("https://27.ua");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".icon-contacts"));

        Assert.assertTrue(driver.findElement(By.cssSelector(".icon-contacts")).isDisplayed());
    }

}
