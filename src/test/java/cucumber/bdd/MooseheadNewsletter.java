package cucumber.bdd;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MooseheadNewsletter extends UtilsDeindeal {

    @When("^I navigate to the \"([^\"]*)\" section$")
    public void I_navigate_to_the_section(String sectionName){
        driver.findElement(By.linkText(sectionName)).click();
    }


    @And("^I look for \"([^\"]*)\"$")
    public void I_look_for(String emailAddress){
        WebElement searchInput = driver.findElement(By.id("search"));
        searchInput.sendKeys("cosmin.uta@deindeal.ch");
        WebElement searchButton = driver.findElement(By.cssSelector("[type='submit']"));
        searchButton.click();
    }

    @And("^I edit the user's \"([^\"]*)\" details$")
    public void I_edit_the_user_s_details(String sectionType){
        if(sectionType.equalsIgnoreCase("newsletter")){
            WebElement editButton = driver.findElement(By.cssSelector("a[href$=\"edit\"]"));
            editButton.click();
        }
    }

    @Then("^I should see the cities in which the user is subscribed$")
    public void I_should_see_the_cities_in_which_the_user_is_subscribed(){
        List<WebElement> subscriptionStatusList = driver.findElements(By.cssSelector("option:checked"));
        Boolean newsletterSubscritionTest=false;
        int validationsCounter=0,i=0;
        List<WebElement> channelName = driver.findElements(By.cssSelector("label[for^='channel']"));
        WebElement channelNameArray[] = channelName.toArray(new WebElement[channelName.size()]);
        for(WebElement option:subscriptionStatusList){
            if(option.getText().equals("subscribe")){

                if (validationsCounter == 0){
                    if(channelNameArray[i].getText().equalsIgnoreCase(cityName)){
                        newsletterSubscritionTest = true;
                    }
                }else{
                    newsletterSubscritionTest = false;
                }
                validationsCounter++;
            }
            i++;
        }
        Assert.assertTrue("Subscribed to too many newsletters", newsletterSubscritionTest);
    }
}
