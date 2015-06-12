package cucumber.bdd;

import cucumber.api.PendingException;
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

    @When("^I click the DeinDeal logo$")
    public void I_click_the_DeinDeal_logo() throws Throwable {
        WebElement DeinDealLogo = driver.findElement(By.id("logo"));
        DeinDealLogo.click();
    }

    @Then("^I should see \"([^\"]*)\" and \"([^\"]*)\"$")
    public void I_should_see_and(String search_hint_text, String search_button)  {
        WebElement searchBox = driver.findElement(By.id("search-box"));
        WebElement searchButton = driver.findElement(By.id("search-button"));
        Assert.assertTrue("The text from the search box is wrong",searchBox.getAttribute("placeholder").equals(search_hint_text));
        Assert.assertTrue("The text from the search button is wrong",searchButton.getText().equals(search_button));
    }

    @And("^I see \"([^\"]*)\"$")
    public void I_see(String search_hint_text) {
        WebElement searchBox = driver.findElement(By.id("search-box"));
        Assert.assertTrue("The text from the search box is wrong",searchBox.getAttribute("placeholder").equals(search_hint_text));
    }

    @When("^I click the \"([^\"]*)\"$")
    public void I_click_the(String arg1)  {
        WebElement searchButton = driver.findElement(By.id("search-button"));
        searchButton.click();
    }

    @And("^the login/register button is named \"([^\"]*)\"$")
    public void the_login_register_button_is_named(String login_button) {
        WebElement loginButton = driver.findElement(By.className("lnk-login"));
        Assert.assertTrue("The message on login/register button is wrong",loginButton.getText().equals(login_button));
    }

    @When("^I click on the login/register button$")
    public void I_click_on_the_login_register_button() throws Throwable {
        WebElement loginButton = driver.findElement(By.className("lnk-login"));
        loginButton.click();
    }

    @Then("^I should see the login pop up$")
    public void I_should_see_the_login_pop_up() {
        WebElement loginPopUp = driver.findElement(By.id("popup-login"));
        Assert.assertTrue("Login popup is not displayed",loginPopUp.isDisplayed());
    }
}
