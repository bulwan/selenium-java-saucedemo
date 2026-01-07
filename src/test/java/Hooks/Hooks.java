package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Hooks {
    private static final String PAGE_URL = "https://www.saucedemo.com/";
    public static WebDriver driver;

    @Before
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("guest");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(chromeOptions);
        driver.get(PAGE_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
