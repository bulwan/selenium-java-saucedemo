package StepsDefinitions;

import Pages.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.Map;

public class BaseSteps {
    BasePage basePage = new BasePage();

    @When("I click {string} button")
    public void iClickButton(String buttonText ) {
        basePage.clickButton(buttonText);
    }

    @And("I enter form with")
    public void iEnterFormWith(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : data.entrySet())
        {
            basePage.enterFormWith(entry.getKey(), entry.getValue());
        }
    }
}
