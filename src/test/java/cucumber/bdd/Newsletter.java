package cucumber.bdd;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Newsletter extends Utils {
    @When("^I enter a new email in the newsletter$")
    public void I_enter_a_new_email_in_the_newsletter(){
        WebElement newsletterInput = driver.findElement(By.cssSelector("#subscription_email"));
        newsletterInput.sendKeys("cosmin.uta@deindeal.ch");
    }

    @And("^I save the selected city$")
    public void I_save_the_selected_city(){
        // Express the Regexp above with the code you wish you had
        cityName = driver.findElement(By.cssSelector("#subscription_stadt>div>span")).getText();
        cityNameID = driver.findElement(By.cssSelector("#subscription_stadt>div>span")).getAttribute("data-id");
    }

    @And("^I push on register$")
    public void I_push_on_register(){
        WebElement newsletterButton = driver.findElement(By.id("subscribeNow"));
        newsletterButton.click();
    }

    @Then("^the newsletter dissappear$")
    public void the_newsletter_dissappear(){

        while(driver.findElement(By.id("popupPlaceholder")).isDisplayed()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertFalse("newsletter container visible", driver.findElement(By.id("popupPlaceholder")).isDisplayed());
    }

    @And("^I have the right city ticked in myAccount/Newsletter$")
    public void I_have_the_right_city_ticked_in_myAccount_Newsletter(){

    }
}