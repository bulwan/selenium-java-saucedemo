package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static hooks.Hooks.driver;

public class BasePage {

    public void clickButton(String buttonText) {
        buttonText = buttonText.toLowerCase();
        WebElement button = driver.findElement(By.xpath("//*[@id='" + buttonText + "']"));
        button.click();
    }

    public void enterFormWith(String label, String value) {
        WebElement usernameInput = driver.findElement(By.cssSelector("input[placeholder='" + label + "']"));
        usernameInput.sendKeys(value);
    }
}
