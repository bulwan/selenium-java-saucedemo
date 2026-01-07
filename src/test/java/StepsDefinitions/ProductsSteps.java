package StepsDefinitions;

import Pages.ProductsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductsSteps {
    ProductsPage productsPage = new ProductsPage();

    @Then("I shouldn't see cart indicator")
    public void isCartEmpty() {
        Assert.assertTrue(productsPage.isCartEmpty());
    }

    @Then("I should see {string} indicator")
    public void iShouldSeeIndicator(String number) {
        Assert.assertEquals(number, productsPage.shouldCartIndicatorShows().getText());
    }

    @When("I add {string} to the cart")
    public void iAddToTheCart(String productName) {
        productsPage.changeCartContent(productName, false);
    }

    @When("I remove {string} from the cart")
    public void iRemoveFromTheCart(String productName) {
        productsPage.changeCartContent(productName, true);
    }

    @And("I go to the cart")
    public void iGoToTheCart() {
        productsPage.openCartPage();
    }

    @Then("Product {string} is in cart")
    public void isProductIsInCart(String productName) {
        Assert.assertTrue(productsPage.isProductInCart(productName).isDisplayed());
    }

    @Then("I see Thank you page")
    public void iSeeThankYouPage() {
        Assert.assertTrue(productsPage.isThankYoupage().isDisplayed());
    }
}
