package cucumber.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class Homepage extends SetupDriver {

    @Given("^I am on the homepage$")
    public void i_am_on_the_homepage(){
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://deindeal.ch");
    }


}
