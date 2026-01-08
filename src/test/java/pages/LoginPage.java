package pages;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void logInAs(String username) {
        String PASSWORD = "secret_sauce";
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Username']")));
        usernameInput.sendKeys(username);

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Password']")));
        passwordInput.sendKeys(PASSWORD);

        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-test='login-button']")));
        loginButton.click();

    }

    public WebElement shouldBeRedirectedToProducts() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_container")));
    }

    public WebElement shouldSeeMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']")));
    }
}
