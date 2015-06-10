package cucumber.bdd;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Created by IEUser on 4/27/2015.
 */
public class UtilSteps extends UtilsDeindeal {
    @Given("^I navigate to staging \"([^\"]*)\"$")
    public String I_navigate_to_staging(String stagingNumber){
        String stg="";
        if(stagingNumber.equalsIgnoreCase("1")){
            stg = "moosedev1.net";
        }if(stagingNumber.equalsIgnoreCase("2")){
            stg = "moosedev2.net";
        }if(stagingNumber.equalsIgnoreCase("3")){
            stg = "moosedev3.net";
        }if(stagingNumber.equalsIgnoreCase("4")){
            stg = "moosedev4.net";
        }if(stagingNumber.equalsIgnoreCase("5")){
            stg = "moosedev5.net";
        }
        driver.navigate().to("www://"+stg);
        return stg;
    }

    @Given("^I login into staging \"([^\"]*)\"$")
    public void I_login_into_staging(String stagingNumber){
        driver.navigate().to("www://"+I_navigate_to_staging(stagingNumber));
        driver.findElement(By.id("admin_email")).sendKeys("gabriel.cliseru@deindeal.ch");
        driver.findElement(By.id("admin_password")).sendKeys("qweASD123");
        driver.findElement(By.id("admin_remember_me")).click();
    }

    @When("^I select the \"([^\"]*)\" language$")
    public void I_select_the_language(String language){
        WebElement langElem = driver.findElement(By.cssSelector("." + language.toLowerCase()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", langElem);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        langElem.click();
    }

    @Then("^I should see \"([^\"]*)\" selected$")
    public void I_should_see_selected(String language){
        String color = driver.findElement(By.cssSelector("."+language.toLowerCase())).getCssValue("color");
        Assert.assertTrue("The language text is not highlighted",color.equalsIgnoreCase("rgba(47, 47, 47, 1)"));
    }

    @And("^channel url is set to \"([^\"]*)\"$")
    public void channel_url_is_set_to(String language){
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue("The url does not contain the desired language", currentURL.contains(language.toLowerCase()));
        Assert.assertTrue("After the language change the channel has not been kept",currentURL.contains(channelToOpen));
    }
}
