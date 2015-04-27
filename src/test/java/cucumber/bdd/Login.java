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
        if(pageType.equalsIgnoreCase("login")){
            while(driver.findElement(By.id("popupPlaceholder")).isDisplayed()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Assert.assertFalse("newsletter container visible", driver.findElement(By.id("popupPlaceholder")).isDisplayed());
        }if(pageType.equalsIgnoreCase("new page")){
            if (driver.findElement(By.cssSelector("#popupPlaceholder_wrapper")).isDisplayed()){
                driver.findElement(By.cssSelector("#subscriptionLpPopup .actions a")).click();
            }
        }
    }
}
