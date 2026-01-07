package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Hooks.Hooks.driver;

import java.time.Duration;
import java.util.List;

public class ProductsPage {
    public boolean isCartEmpty() {
        List<WebElement> cartIndicator = driver.findElements(By.className("shopping_cart_badge"));
        return cartIndicator.isEmpty();

    }

    public WebElement shouldCartIndicatorShows() {
        return driver.findElement(By.className("shopping_cart_badge"));

    }

    public void changeCartContent(String productName, boolean isInCart) {
        productName = productName.toLowerCase().replace(' ', '-');
        By productButtonSelector;
        if (isInCart) {
            productButtonSelector = By.cssSelector("button[data-test='remove-" + productName + "']");
        } else {
            productButtonSelector = By.cssSelector("button[data-test='add-to-cart-" + productName + "']");
        }
        WebElement productButton = driver.findElement(productButtonSelector);
        productButton.click();
    }

    public void openCartPage() {
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
    }

    public WebElement isProductInCart(String productName) {
        return driver.findElement(By.xpath("//div[text() ='" + productName + "' and @class='inventory_item_name']"));

    }

    public WebElement isThankYoupage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Thank you for your order!']")));
    }
}
