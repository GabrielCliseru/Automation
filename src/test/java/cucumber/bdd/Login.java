package cucumber.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login extends Utils {

    @When("^I click the login button$")
    public void i_click_the_Sign_In_button() {
        driver.navigate().to("http://www.deindeal.ch/admins/sign_in");
        WebElement adminEmailInput = driver.findElement(By.id("admin_email"));
        adminEmailInput.sendKeys("cosmin.uta@deindeal.ch");

        WebElement adminPasswordInput = driver.findElement(By.id("admin_password"));
        adminPasswordInput.sendKeys("CUcu1989");

        WebElement adminButtonInput = driver.findElement(By.className("blue"));
        adminButtonInput.click();
    }
}
