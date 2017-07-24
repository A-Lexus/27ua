package ototot.Utils;


public class DriverWraper {
    public static void configureDriver(){
        System.setProperty("webdriver.chrome.driver", DriverWraper.class.getResource("/drivers/chromedriver").getPath());
    }
}
