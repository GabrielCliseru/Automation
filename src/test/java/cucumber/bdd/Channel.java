package cucumber.bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class Channel extends UtilsDeindeal {
    Homepage homepage = PageFactory.initElements(driver, Homepage.class);

    @When("^I enter a random collection$")
    public int I_enter_a_random_collection()
    {
        List<WebElement> collectionObjects;
        Random rand = new Random();
        int i;
        String collectionID = "";
        WebElement currentElement;

        /*There are different page types, with different layouts, here we can find an array of locators and we try each
        // one of them until we manage to find the one that fits. On else there is an error. It will land there when we
         introduce a new channel template*/

        String[] collectionsSelector = {"[data-tracking-type='collection']", "#collectionsWrapper li",".productBox"};
        if (driver.findElements(By.cssSelector(collectionsSelector[0])).size() != 0){
            collectionObjects = driver.findElements(By.cssSelector(collectionsSelector[0]));
        }else if(driver.findElements(By.cssSelector(collectionsSelector[1])).size() != 0){
            collectionObjects = driver.findElements(By.cssSelector(collectionsSelector[1]));
        }else if(driver.findElements(By.cssSelector(collectionsSelector[2])).size() != 0){
            collectionObjects = driver.findElements(By.cssSelector(collectionsSelector[2]));
        }else {
            Assert.assertTrue("On page " + driver.getCurrentUrl() + " there is no valid selector for I_enter_a_random_collection", 1 != 1);
            collectionObjects = null;
        }

        do {
            i = rand.nextInt(collectionObjects.size());
            currentElement = collectionObjects.get(i);
            collectionID = currentElement.getAttribute("data-tracking-id");
            //TODO: put a new condition here for the channels without carousels
            if (i>=3&&i<=5){
                if (i==3){
                    driver.findElements(By.cssSelector("#channelCarousel .pagination li")).get(0).click();
                }if (i==4){
                    driver.findElements(By.cssSelector("#channelCarousel .pagination li")).get(1).click();
                }else{
                    driver.findElements(By.cssSelector("#channelCarousel .pagination li")).get(2).click();
                }
            }
        }while(!currentElement.isDisplayed()&&currentElement.isEnabled());
        wait.until(ExpectedConditions.visibilityOf(currentElement));
        currentElement.click();
        return Integer.parseInt(collectionID);
    }

    @Given("^I am on \"([^\"]*)\" channel as an existing visitor$")
    public void I_am_on_channel_as_an_existing_visitor(String channelName){
        if(channelName.equalsIgnoreCase("any")){
            homepage.I_am_on_the_homepage_as_an_existing_visitor();
            List<WebElement> channels = driver.findElements(By.cssSelector(".channels li"));
            Random rand = new Random();
            int i;
            WebElement chosenChannel;
            String currentChannelName;

            do {
                i = rand.nextInt(channels.size());
                chosenChannel = channels.get(i);
                currentChannelName = chosenChannel.getAttribute("data-subdomain");
            }
            while(currentChannelName.equalsIgnoreCase("love"));

            setChannelToOpen(currentChannelName);

            chosenChannel.click();
        }
    }

    @Given("^I am on \"([^\"]*)\" channel as an existing visitor on \"([^\"]*)\"$")
    public void I_am_on_channel_as_an_existing_visitor_on(String channelName, String language){
        if(channelName.equalsIgnoreCase("any")){
            homepage.I_am_on_the_homepage_as_an_existing_visitor_on(language);
            List<WebElement> channels = driver.findElements(By.cssSelector(".channel-item"));
            Random rand = new Random();
            int i = rand.nextInt(channels.size());
            WebElement chosenChannel;
            String currentChannelName;

            do {
                chosenChannel = channels.get(i);
                currentChannelName = chosenChannel.getAttribute("data-subdomain");
            }
            while(currentChannelName.equalsIgnoreCase("love"));

            setChannelToOpen(currentChannelName);

            chosenChannel.click();
        }
    }
}
