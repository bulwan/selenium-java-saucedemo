package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static hooks.Hooks.driver;

public class LoginPage {

    public void logInAs(String username) {
        String PASSWORD = "secret_sauce";
        WebElement usernameInput = driver.findElement(By.cssSelector("input[placeholder='Username']"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        passwordInput.sendKeys(PASSWORD);

        By loginButtonSelector = By.className("submit-button");
        WebElement loginButton = driver.findElement(loginButtonSelector);
        loginButton.click();

    }

    public WebElement shouldBeRedirectedToProducts() {
        return driver.findElement(By.className("inventory_container"));
    }

    public WebElement shouldSeeMessage() {
        return driver.findElement(By.cssSelector("h3[data-test='error']"));
    }
}
