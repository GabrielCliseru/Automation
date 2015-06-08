package cucumber.bdd;

import com.thoughtworks.selenium.Wait;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage extends Utils {
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
//
//        Alternative troublesome way
//
//        I_should_see_new_newsletter_popup();
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#subscriptionLpPopup .skiplink")));
//        driver.findElement(By.cssSelector("#subscriptionLpPopup .skiplink")).click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#popupPlaceholder_wrapper")));
    }
}
