package cucumber.bdd;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MooseheadLogin extends UtilsDeindeal {
    @When("^I login into Moosehead$")
    public void I_click_the_Sign_In_button() {
        driver.navigate().to("http://www.deindeal.ch/admins/sign_in");
        WebElement adminEmailInput = driver.findElement(By.id("admin_email"));
        adminEmailInput.sendKeys("cosmin.uta@deindeal.ch");

        WebElement adminPasswordInput = driver.findElement(By.id("admin_password"));
        adminPasswordInput.sendKeys("CUcu1989");

        WebElement adminButtonInput = driver.findElement(By.className("blue"));
        adminButtonInput.click();
    }
}