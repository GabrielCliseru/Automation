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


    @Given("^I am on the \"([^\"]*)\" page for the first time$")
    public void I_am_on_the_page_for_the_first_time(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
