package cucumber.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login extends Utils {
    @When("^I click the Sign In button$")
    public void I_click_the_Sign_In_button(){
        WebElement LoginRegisterButton = driver.findElement(By.className("lnk-login"));
        LoginRegisterButton.click();
    }

    @And("^I enter the \"([^\"]*)\" and \"([^\"]*)\"$")
    public void I_enter_the_and(String userName, String password){
        WebElement signInUser = driver.findElement(By.id("sign_in_email"));
        WebElement signInPassword = driver.findElement(By.id("sign_in_password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        if(userName.equalsIgnoreCase("random")){
            signInUser.sendKeys(newEmailAddress);
            signInPassword.sendKeys(newPassword);
        }else{
            signInUser.sendKeys(userName);
            signInPassword.sendKeys(password);
        }
        loginButton.click();
    }

    @Then("^I should not see the \"([^\"]*)\" popup$")
    public void I_should_not_see_the_popup(String pageType){
        Util_I_should_not_see_the_popup(pageType);
    }

    @Then("^I should see the \"([^\"]*)\" alert$")
    public void I_should_see_the_alert(String propertiesCommonPart){
        String containingText = driver.findElement(By.cssSelector(errorMessages.getProperty(propertiesCommonPart+"_loc"))).getText();
        Assert.assertTrue("The error messages do not match",containingText.equalsIgnoreCase(errorMessages.getProperty(propertiesCommonPart+"_msg")));
    }
}
