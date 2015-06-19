package cucumber.bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

public class Channel extends UtilsDeindeal {
    Homepage homepage = PageFactory.initElements(driver, Homepage.class);

    @When("^I enter a random collection$")
    public int I_enter_a_random_collection() {
        List<WebElement> collectionObjects;
        Random rand = new Random();
        int i;
        String collectionID = "";
        WebElement currentElement;

        /*There are different page types, with different layouts, here we can find an array of locators and we try each
         one of them until we manage to find the one that fits. On else there is an error. It will land there when we
         introduce a new channel template*/

        String[] collectionsSelector = {"[data-tracking-type='collection']", "#collectionsWrapper li", ".productBox"};
        if (driver.findElements(By.cssSelector(collectionsSelector[0])).size() != 0) {
            collectionObjects = driver.findElements(By.cssSelector(collectionsSelector[0]));
        } else if (driver.findElements(By.cssSelector(collectionsSelector[1])).size() != 0) {
            collectionObjects = driver.findElements(By.cssSelector(collectionsSelector[1]));
        } else if (driver.findElements(By.cssSelector(collectionsSelector[2])).size() != 0) {
            collectionObjects = driver.findElements(By.cssSelector(collectionsSelector[2]));
        } else {
            Assert.assertTrue("On page " + driver.getCurrentUrl() + " there is no valid selector for I_enter_a_random_collection", 1 != 1);
            collectionObjects = null;
        }

        /*
        A random collection is picked. If it is part of the carousel the navigation dot is pressed and then the link is clicked.
        else the linked is clicked directly.
         */
        do {
            i = rand.nextInt(collectionObjects.size());
            currentElement = collectionObjects.get(i);
            collectionID = currentElement.getAttribute("data-tracking-id");

            /*
            We have the carousel with elements if the carousel element exists and the elements inside are distinct.
            If the "data-tracking-id" 's value is the same, the carousel exists without slides. This usually happens on
            staging where we don't have proper data.
             */

            ArrayList<String> dataTrackingIds = new ArrayList<String>();

            if(driver.findElements(By.cssSelector("#channelCarousel")).size() > 0){
                List<WebElement> carouselLiElements = driver.findElements(By.cssSelector("#channelCarousel li"));
                for (int liIterator = 0;liIterator<carouselLiElements.size()-1;liIterator++){
                    String trackingId = carouselLiElements.get(liIterator).getAttribute("data-tracking-id");
                    String classes = carouselLiElements.get(liIterator).getAttribute("class");
                    //the motherfucking super craptastic carousel contains cloned items. We have to drop them.
                    if (!dataTrackingIds.contains(trackingId) && !classes.contains("bx-clone")){
                        dataTrackingIds.add(trackingId);
                    }
                }
            }

            /*
            If the collection ID picked randomly is included in the list of collections from the carousel we should
            click on the collection bouble that scrolls it into view
             */
            if(dataTrackingIds.contains(collectionID)){
                //click on the pagination for showing the collection
                driver.findElements(By.cssSelector("#channelCarousel .pagination li")).get(dataTrackingIds.indexOf(collectionID)).click();
            }
        } while (!currentElement.isDisplayed() && currentElement.isEnabled());

        /*
        the script waits until the previously clicked element becomes visible and then clicks.
        At the end it returns the ID of the collection for further use
         */
        wait.until(ExpectedConditions.visibilityOf(currentElement));
        currentElement.click();
        return Integer.parseInt(collectionID);
    }

    @Given("^I am on \"([^\"]*)\" channel as an existing visitor$")
    public void I_am_on_channel_as_an_existing_visitor(String channelName) {
        if (channelName.equalsIgnoreCase("any")) {
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
            while (currentChannelName.equalsIgnoreCase("love"));

            setChannelToOpen(currentChannelName);

            chosenChannel.click();
        }
    }

    @Given("^I am on \"([^\"]*)\" channel as an existing visitor on \"([^\"]*)\"$")
    public void I_am_on_channel_as_an_existing_visitor_on(String channelName, String language) {
        if (channelName.equalsIgnoreCase("any")) {
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
            while (currentChannelName.equalsIgnoreCase("love"));

            setChannelToOpen(currentChannelName);

            chosenChannel.click();
        }
    }
}
