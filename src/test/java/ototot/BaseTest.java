package ototot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    WebDriver driver = new ChromeDriver();

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

    /*public void addToCartAnyProduct() {
        driver.findElement(By.cssSelector(""))
        productDetails.addAnyPack();
    }

    public void addToCartProductByIndex(int index) {
        productsList.openProduct(index);
        productDetails.addAnyPack();
    }*/

    //Ищем продукт и выбираем индекс продукта, который будет куплен
    public void searchAndBuy(String product, int index){
        driver.findElement(By.cssSelector(".search__input #title-search-input"))
                .sendKeys(product);
        driver.findElement(By.cssSelector("#bottom-sticky>div:nth-child("+index+")")).click();

    }

}
