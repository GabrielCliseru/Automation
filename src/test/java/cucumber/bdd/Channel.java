package cucumber.bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class Channel extends UtilsDeindeal {
    Homepage homepage = PageFactory.initElements(driver, Homepage.class);

    @When("^I enter a random collection$")
    public int I_enter_a_random_collection()
    {
        List<WebElement> collectionNames;
        Random rand = new Random();

        if (driver.findElements(By.cssSelector("[data-tracking-type='collection']")).size() != 0){
            collectionNames = driver.findElements(By.cssSelector("[data-tracking-type='collection']"));
        }
        else {
            collectionNames = driver.findElements(By.cssSelector("#collectionsWrapper li"));
        }

        int i = rand.nextInt(collectionNames.size());
        //pe asta l-am pus aici ca sa nu mai facem mereu operatiunea de cautare in obiectul sau, deja il folosim de 2 ori
        //mai jos
        WebElement currentElement = collectionNames.get(i);
        String collectionID = "";
        if(currentElement.isDisplayed()){
            collectionID = currentElement.getAttribute("data-tracking-id");
        }else{
//            currentElement.
        }
        currentElement.click();

        return Integer.parseInt(collectionID);
    }

    @Given("^I am on \"([^\"]*)\" channel as an existing visitor$")
    public void I_am_on_channel_as_an_existing_visitor(String channelName){
        if(channelName.equalsIgnoreCase("any")){
            homepage.I_am_on_the_homepage_as_an_existing_visitor();
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
