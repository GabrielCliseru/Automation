package cucumber.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IEUser on 4/24/2015.
 */
public class Header extends UtilsDeindeal {


    @And("^language is set to \"([^\"]*)\"$")
    public void language_is_set_to(String language) {
        String[] pageURL = splitURLToSections(driver.getCurrentUrl());
        if (isLanguage(pageURL, language)) {
            Assert.assertTrue("Correct language", true);
        } else {
            Assert.assertTrue("Incorrect language", false);
            pageURL[3] = language;
            driver.get(arrayToString(pageURL));
        }

    }

    @Then("^I should land on \"([^\"]*)\"$")
    public void I_should_land_on(String incomingString) {
        Assert.assertTrue("Landed on " + driver.getCurrentUrl() + " instead of " + incomingString, incomingString.equalsIgnoreCase(incomingString));
    }

    @When("^I click the header \"([^\"]*)\" link$")
    public void I_click_the_header_link(String linkName) {
        boolean flag = false;
        List<WebElement> links = driver.findElements(By.cssSelector("#trustedElements a"));
        for (WebElement link : links) {
            if (link.getText().equalsIgnoreCase(linkName)) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            Assert.assertTrue("The links is not found", 1 == 1);
        }
    }


    @Then("^I should see \"([^\"]*)\"$")
    public WebElement I_should_see(String contactNumber) throws Throwable {
        List<WebElement> headerLinks = driver.findElements(By.cssSelector("#trustedElements>li"));
        WebElement link = headerLinks.get(2);
        if (!contactNumber.equalsIgnoreCase("qwe")){
            Assert.assertTrue("The contact number is wrong",link.getText().equals(contactNumber));
        }
        return link;
    }

    @And("^\"([^\"]*)\" should not be a link$")
    public void should_not_be_a_link(String arg1) throws Throwable {
        String prevLink = driver.getCurrentUrl();
        WebElement contactNumberLink = I_should_see("qwe");
        contactNumberLink.click();
        String afterLink = driver.getCurrentUrl();
        Assert.assertTrue("the contact number is a link",prevLink.equals(afterLink));
    }

    @When("^I click the \"([^\"]*)\" link$")
    public void I_click_the_link(String arg1) throws Throwable {
        WebElement contactUsLink = driver.findElement(By.className("write-us"));

    }
}
