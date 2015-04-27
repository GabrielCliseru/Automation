package cucumber.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IEUser on 4/24/2015.
 */
public class Header extends Utils{
    @Before("@NavigateToAllChannels")


    @And("^language is set to \"([^\"]*)\"$")
    public void language_is_set_to(String language){
        String[] pageURL = splitURLToSections(driver.getCurrentUrl());
        if(isLanguage(pageURL,language)){
            Assert.assertTrue("Correct language",true);
        }else{
            Assert.assertTrue("Incorrect language",false);
            pageURL[3]=language;
            driver.get(arrayToString(pageURL));
        }

    }

    @Then("^I should land on \"([^\"]*)\"$")
    public void I_should_land_on(String incomingString){
        Assert.assertTrue("Landed on "+driver.getCurrentUrl()+" instead of "+incomingString,incomingString.equalsIgnoreCase(incomingString));
    }

    @When("^I click the header \"([^\"]*)\" link$")
    public void I_click_the_header_link(String linkName){
        List<WebElement> links = driver.findElements(By.cssSelector("#trustedElements a"));
        for(WebElement link : links){
                Assert.assertTrue("The links is not found",link.getText().equalsIgnoreCase(linkName));
        }
    }
}
