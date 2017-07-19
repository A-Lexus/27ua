package ototot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ototot.Utils.DriverWraper;

import java.util.concurrent.TimeUnit;


public class BuyingGoodsTest {
    WebDriver driver;

    @BeforeTest
    public void preCondition() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        DriverWraper.configureDriver();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("https://27.ua");
    }


    //@AfterTest
    public void postCondition() {
        driver.quit();
    }


    @Test
    public void buyGoodsFromSearchPanel() {
        driver.findElement(By.cssSelector(".input__icon .icon-search")).click();
        driver.findElement(By.id("title-search-input"))
                .sendKeys("Умывальник", Keys.ENTER);
        driver.findElement(By.cssSelector("#bottom-sticky>div:nth-child(1)>.naillCategoryName"))
                .click();
        driver.findElement(By.cssSelector(".managementShoping .buy-button")).click();
        driver.findElement(By.cssSelector(".yellow-button.order-button")).click();
        driver.findElement(By.cssSelector(".btn-buy-overlay")).click();
        driver.findElement(By.cssSelector("input#ORDER_PROP_9")).sendKeys(NAME);
        driver.findElement(By.cssSelector("input#ORDER_PROP_7")).sendKeys(PHONE_NUM);
        driver.findElement(By.cssSelector("input#ORDER_PROP_8")).sendKeys(E_MAIL);




    }

protected static final String NAME = "Name";
protected static final String E_MAIL = "test@test.com";
protected static final String PHONE_NUM = getPhoneNum();

    public static String getPhoneNum() {

        return String.valueOf(Math.round(Math.random()*1000000000));
    }
}
