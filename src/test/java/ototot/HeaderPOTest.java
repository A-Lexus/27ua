package ototot;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static ototot.HeaderPO.MAIN_LOGO;

public class HeaderPOTest extends HeaderPO{

    //HeaderPO header = new HeaderPO();
    static WebDriver driver;

    @BeforeTest
    public void preCondition() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://27.ua");
    }

    @AfterTest
    public void postCondition() {
        driver.quit();
    }


    @Test
    public void checkIsElementPresent() {
        //driver.findElement(By.cssSelector(HeaderPO.SEL_BASKET));

        Assert.assertTrue(driver.findElement(By.cssSelector(SEL_BASKET)).isDisplayed());
        System.out.println("Element basket is present.");

    }

    @DataProvider(name = "headerElementsProvider")
    public Object[][] selectElement() {
        return new Object[][]{
                {HeaderPO.MAIN_LOGO},
                {HeaderPO.SEL_PAYMENT},
                {HeaderPO.CALL_ME}

        };
    }

    @Test(dataProvider = "headerElementsProvider")
    public void checkIsElementPresentWithData(String headerElement) {

        driver.findElement(By.cssSelector(headerElement));

        Assert.assertTrue(driver.findElement(By.cssSelector(headerElement)).isDisplayed());

    }

}
