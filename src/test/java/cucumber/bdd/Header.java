package cucumber.bdd;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        String URL = driver.getCurrentUrl();
        String URLtoTest = "http://www.deindeal.ch"+incomingString;
        Assert.assertTrue("Landed on " + URL + " instead of " + URLtoTest, URLtoTest.equalsIgnoreCase(URL));
    }

    @When("^I click the header \"([^\"]*)\" link$")
    public void I_click_the_header_link(String linkName) {
        boolean flag = false;
        List<WebElement> links = driver.findElements(By.cssSelector("#trustedElements a"));
        for (WebElement link : links) {
            if (link.getText().equalsIgnoreCase(linkName)) {
                link.click();
                flag = true;
                break;
            }
        }

        if (!flag) {
            Assert.assertFalse("The link is not found", 1 == 1);
        }
    }


    @Then("^I should see \"([^\"]*)\"$")
    public WebElement I_should_see(String contactNumber){
        List<WebElement> headerLinks = driver.findElements(By.cssSelector("#trustedElements>li"));
        WebElement link = headerLinks.get(2);
        Assert.assertTrue("The contact number is wrong",link.getText().equals(contactNumber));
        return link;
    }

    @And("^\"([^\"]*)\" should not be a link$")
    public void should_not_be_a_link(String incomingText){
        String prevLink = driver.getCurrentUrl();
        WebElement contactNumberLink = null;
        contactNumberLink = I_should_see(incomingText);
        contactNumberLink.click();
        String afterLink = driver.getCurrentUrl();
        Assert.assertTrue("The contact number is a link",prevLink.equals(afterLink));
    }

    @When("^I click the \"([^\"]*)\" link$")
    public void I_click_the_link(String arg1) throws Throwable {
        WebElement contactUsLink = driver.findElement(By.className("write-us"));

    }
}
