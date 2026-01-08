package pages;


import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void clickButton(String buttonText) {
        buttonText = buttonText.toLowerCase();
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id(buttonText)));
        button.click();
    }

    public void enterFormWith(String label, String value) {
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='" + label + "']")));
        usernameInput.sendKeys(value);
    }
}
