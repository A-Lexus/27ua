/*
package ototot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.omg.CORBA.ORB.init;

public class ConfigurationManager {

    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        ConfigurationManager.driver = driver;
    }

    private static  ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if(driver.get()==null) setDriver();
        return driver.get();
    }

    public static void setDriver(){
        ConfigurationManager.driver.set(configureDriver(init()));
    }

    private static WebDriver init() {
        String browserName = System.getProperty("browser") != null ?System.getProperty("browser"):
                "chrome";

        ClassLoader classLoader = ConfigurationManager.class.getClassLoader();
        String browserDriverFilePath = new File(classLoader.getResource("./drivers/"+browserName
                + "driver").getFile()).getAbsolutePath();

        switch (browserName) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", browserDriverFilePath);
                return new FirefoxDriver();
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", browserDriverFilePath);
                return new ChromeDriver();
            }
            case "phantom": {
                System.setProperty("phantomjs.binary.path", browserDriverFilePath);
                return new PhantomJSDriver();
            }
            case "edge":
                return new EdgeDriver();
        }
        return new ChromeDriver();
    }

    private static WebDriver configureDriver(WebDriver driver) {
//        getDriver().manage().window().maximize();
//        getDriver().manage().window().();
        driver.manage().timeouts().implicitlyWait(new Long(getProp("implicitWait")), TimeUnit.SECONDS);
        return driver;
    }


}
*/
