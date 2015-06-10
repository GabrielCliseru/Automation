package cucumber.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homepage extends UtilsDeindeal {
    @Given("^I am on the \"([^\"]*)\" page for the first time$")
    public void I_am_on_the_page_for_the_first_time(String pageURL){
        driver.get(pageURL);
        Assert.assertTrue("Title should start with Deindeal", driver.getTitle().startsWith("DeinDeal"));
    }

    @Then("^I should see new newsletter popup$")
    public void I_should_see_new_newsletter_popup(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("subscriptionLpPopup")));
    }

    @And("^I save the city$")
    public void I_save_the_city(){
        // Express the Regexp above with the code you wish you had
        cityName = driver.findElement(By.cssSelector("#subscription_stadt>div>span")).getText();
        cityNameID = driver.findElement(By.cssSelector("#subscription_stadt>div>span")).getAttribute("data-id");
    }

    @And("^I have the right city ticked in \"([^\"]*)\"$")
    public void I_have_the_right_city_ticked_in(String arg1) throws Throwable {
        //TODO: Implement the check
        throw new PendingException();
    }

    @Given("^I am on the homepage on \"([^\"]*)\"$")
    public void I_am_on_the_homepage_on(String language){
        driver.get("http://www.deindeal.ch/"+language.toLowerCase());
    }

    @Given("^I am on the homepage as an existing visitor$")
    public void I_am_on_the_homepage_as_an_existing_visitor(){
        driver.get("http://www.deindeal.ch/de/?src=newsletter");
    }

    @Given("^I am on the homepage as a new visitor$")
    public void I_am_on_the_homepage_a_new_visitor(){
        driver.get("http://www.deindeal.ch/de/");
    }

    @Given("^I am on the homepage as an existing visitor on \"([^\"]*)\"$")
    public void I_am_on_the_homepage_as_an_existing_visitor_on(String language){
        driver.get("http://www.deindeal.ch/"+language+"/?src=newsletter");
    }

    @Then("^I should land on homepage$")
    public void I_should_land_on_homepage(){
        String currentLink = driver.getCurrentUrl();
        String homepageLink = "http://www.deindeal.ch/";
        Assert.assertTrue("Expected to be on homepage, but landed on "+currentLink, currentLink.contains(homepageLink));
    }
}
