package cucumber.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.List;

public class Utils extends SetupDriver {
    Login StagingLogin = PageFactory.initElements(driver, Login.class);
    Homepage Homepage = PageFactory.initElements(driver, Homepage.class);
    MooseheadLogin MooseheadLogin = PageFactory.initElements(driver, MooseheadLogin.class);
    MooseheadNewsletter MooseheadNewsletter = PageFactory.initElements(driver, MooseheadNewsletter.class);
    Newsletter Newsletter = PageFactory.initElements(driver, Newsletter.class);

    String cityName,cityNameID,newEmailAddress,newPassword;

    public void I_navigate_to_channel(String channelName) {
        List<WebElement> channelNames = driver.findElements(By.cssSelector("ul.channels>li>a"));
        for (WebElement channel : channelNames) {
            if (channel.getText().trim().equalsIgnoreCase(channelName)) {
                channel.click();
                break;
            } else if (channelNames.indexOf(channel) == (channelNames.size() - 1)) {
                Assert.assertTrue("Channel does not exist", 1 == 1);
            }
        }
    }

    public String generateEmailAddress() {
        String s1, s2, s3;
        s1 = "";
        int i;
        Random r = new Random();
        for (i = 0; i < 10; i++) {
            char c = (char) (r.nextInt(26) + 'a');
            s1 += c;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        Date date = new Date();
        s2 = dateFormat.format(date);
        s3 = "@deindeal.ch";
        return s1+s2+s3;
    }

    public void openSection(String section) {
        driver.findElement(By.linkText(section)).click();
    }



    public static void mouseActions(WebElement element, String link) throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
        while (!driver.findElement(By.linkText(link)).isDisplayed()) {
            Thread.sleep(250);
        }
        driver.findElement(By.linkText(link)).click();
    }

    public static void mouseActions(String link1, String link2) throws InterruptedException {
        WebElement element = driver.findElement(By.linkText(link1));
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
        while (!driver.findElement(By.linkText(link1)).isDisplayed()) {
            Thread.sleep(250);
        }
        driver.findElement(By.linkText(link2)).click();
    }


    @Given("^I login into staging \"([^\"]*)\"$")
    public void I_login_into_staging(String stagingNumber){
        String stg;
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
    }
}
