package ototot;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ototot.Utils.DriverWraper;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class BuyingGoodsTest {
    static WebDriver driver;

    @BeforeTest
    public void preCondition() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        DriverWraper.configureDriver();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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

        

        WebElement DELIVERY_CENTR27 = driver.findElement(By.cssSelector("input#ID_DELIVERY_ID_6"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('checked','')", DELIVERY_CENTR27);
        // radio button payment terms
        final WebElement PAYMENT_WITH_VISA_SITE = driver.findElement(By.cssSelector("input#ID_PAY_SYSTEM_ID_9"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('checked','')",
                PAYMENT_WITH_VISA_SITE);
        final WebElement STREET_NAME = driver.findElement(By.cssSelector("div.row #ORDER_PROP_12"));
        STREET_NAME.sendKeys("Tester");
        final WebElement BUILD_NAME = driver.findElement(By.cssSelector("div.row #ORDER_PROP_13"));
        BUILD_NAME.sendKeys(getBuildNum());
        final WebElement BTN_ORDER = driver.findElement(By.cssSelector("a.btn.btn-primary.onCheckout"));
        BTN_ORDER.click();
        final String THANK_TEXT = driver.findElement(By.cssSelector(".thank-text")).getText();


        assertTrue(THANK_TEXT.equalsIgnoreCase("Дякуємо за замовлення!"));
        System.out.println("№ замовлення: " + getOrdrNum());


    }

    protected static final String NAME = "TestOrder";
    protected static final String E_MAIL = "test@test.com";
    protected static final String PHONE_NUM = getPhoneNum();

    public static String getPhoneNum() {

        return String.valueOf(Math.round(Math.random() * 1000000000));

    }

    public static String getBuildNum() {

        return String.valueOf(Math.round(Math.random() * 100));
    }

    public static String getOrdrNum() {

        return driver.findElement(By.cssSelector(".col-sm-6.text-dark-grey-bold.nc")).getText();
    }
}
