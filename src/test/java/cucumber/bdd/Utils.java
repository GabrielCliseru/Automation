package cucumber.bdd;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.List;

/**
 * Created by Setek on 11/30/2014.
 */
public class Utils extends SetupDriver {

    public int I_enter_a_collection() {
        List<WebElement> collectionNames = driver.findElements(By.cssSelector("data-tracking-type='collection'"));
        Random rand = new Random();
        int i = rand.nextInt(collectionNames.size());
        //pe asta l-am pus aici ca sa nu mai facem mereu operatiunea de cautare in obiectul sau, deja il folosim de 2 ori
        //mai jos
        WebElement currentElement = collectionNames.get(i);
        String collectionID = currentElement.getAttribute("data-tracking-id");
        currentElement.click();
        return Integer.parseInt(collectionID);
    }

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
        String composedEmailAddress = s1 + s2 + s3;
        return composedEmailAddress;
    }

    public void openSection(String section) {
        driver.findElement(By.linkText(section)).click();
    }

    public void loginMoosehead() {
        driver.navigate().to("http://www.deindeal.ch/admins/sign_in");
        WebElement adminEmailInput = driver.findElement(By.id("admin_email"));
        adminEmailInput.sendKeys("cosmin.uta@deindeal.ch");

        WebElement adminPasswordInput = driver.findElement(By.id("admin_password"));
        adminPasswordInput.sendKeys("CUcu1989");

        WebElement adminButtonInput = driver.findElement(By.className("blue"));
        adminButtonInput.click();
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
}
