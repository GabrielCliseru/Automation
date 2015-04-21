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

public class Utils extends SetupDriver {

    String cityName,cityNameID;

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
