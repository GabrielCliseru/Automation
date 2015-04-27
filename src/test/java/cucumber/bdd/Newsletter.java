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
import org.openqa.selenium.support.PageFactory;

public class Newsletter extends Utils {
    Homepage Homepage = PageFactory.initElements(driver, Homepage.class);
    Newsletter Newsletter = PageFactory.initElements(driver, Newsletter.class);

    @When("^I enter a new email in the newsletter$")
    public void I_enter_a_new_email_in_the_newsletter(){
        WebElement newsletterInput = driver.findElement(By.cssSelector("#subscription_email"));
        newEmailAddress = generateEmailAddress();
        newsletterInput.sendKeys(newEmailAddress);
    }

    @And("^I save the selected city$")
    public void I_save_the_selected_city(){
        cityName = driver.findElement(By.cssSelector("#subscription_stadt>div>span")).getText();
        cityNameID = driver.findElement(By.cssSelector("#subscription_stadt>div>span")).getAttribute("data-id");
    }

    @And("^I push on register$")
    public void I_push_on_register(){
        WebElement newsletterButton = driver.findElement(By.id("subscribeNow"));
        newsletterButton.click();
    }

    @Then("^the newsletter disappear$")
    public void the_newsletter_disappear(){
        while(driver.findElement(By.id("popupPlaceholder")).isDisplayed()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertFalse("newsletter container visible", driver.findElement(By.id("popupPlaceholder")).isDisplayed());
    }

    //TODO: make myAccount/Newsletter a parameter
    @And("^I have the right city ticked in myAccount/Newsletter$")
    public void I_have_the_right_city_ticked_in_myAccount_Newsletter(){
        //TODO: Actually get the city that is selected
        driver.navigate().to("http://www.deindeal.ch/de/account/newsletter");
    }

    @And("^I sign in to the newsletter with a new email address from the new user popup$")
    public void I_sign_in_to_the_newsletter_with_a_new_email_address_from_the_new_user_popup(){
        Homepage.I_am_on_the_page_for_the_first_time("http://www.deindeal.ch");
        Newsletter.I_enter_a_new_email_in_the_newsletter();
        Newsletter.I_push_on_register();
        Newsletter.the_newsletter_disappear();
        Newsletter.I_save_the_selected_city();
    }
}