package StepsDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("I log in as {string}")
    public void logInAs(String username) {
        loginPage.logInAs(username);
    }


    @Then("I should be redirected to the products page")
    public void iShouldBeRedirectedToProducts() {
        Assert.assertTrue(loginPage.shouldBeRedirectedToProducts().isDisplayed());
    }

    @Then("I should see {string} message")
    public void iShouldSeeMessage(String message) {
        Assert.assertEquals(message, loginPage.shouldSeeMessage().getText());

    }
}