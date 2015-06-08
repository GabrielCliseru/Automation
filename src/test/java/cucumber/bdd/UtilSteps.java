package cucumber.bdd;

import cucumber.api.java.en.Given;
import org.openqa.selenium.By;

/**
 * Created by IEUser on 4/27/2015.
 */
public class UtilSteps extends UtilsDeindeal {
    @Given("^I navigate to staging \"([^\"]*)\"$")
    public String I_navigate_to_staging(String stagingNumber){
        String stg="";
        if(stagingNumber.equalsIgnoreCase("1")){
            stg = "moosehead-edge.com";
        }if(stagingNumber.equalsIgnoreCase("2")){
            stg = "moosedev.net";
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
}
