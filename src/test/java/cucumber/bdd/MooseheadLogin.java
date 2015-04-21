package cucumber.bdd;

import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;
import java.io.*;

public class MooseheadLogin extends Utils {
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