package cucumber.bdd;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;


public class UtilsDeindeal extends SetupDriver {

    public String cityName,cityNameID;
    public Properties errorMessages = readErrorMessagesFile("errorMessages");
    String newEmailAddress = generateEmailAddress();
    String newPassword = generateString();
    WebDriverWait wait = new WebDriverWait(driver, 5);
    //This is used to store the channel to be opened
    private String channelToOpen = null;

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

    public String getChannelToOpen() {
        return channelToOpen;
    }

    public void setChannelToOpen(String channelToOpen) {
        this.channelToOpen = channelToOpen;
    }

    public Properties readErrorMessagesFile(String fileName){
        Properties propFile = new Properties();
        InputStream input = null;
        String file = "target/test-classes/"+fileName+".properties";
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // load a properties file
        try {
            Reader reader = null;
            if (input != null) {
                reader = new InputStreamReader(input, "UTF-8");
            }
            propFile.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return propFile;
    }

    public void NavigateToAllChannels(){

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

    public String generateString(){
        String randomString = "";

        int i;
        Random r = new Random();
        for (i = 0; i < 10; i++) {
            char c = (char) (r.nextInt(26) + 'a');
            randomString += c;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return randomString;
    }

    public String generateEmailAddress() {
        String s1, s2, s3;
        s1 = generateString();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        Date date = new Date();
        s2 = dateFormat.format(date);
        s3 = "@deindeal.ch";
        return s1+s2+s3;
    }

    public void openSection(String section) {
        driver.findElement(By.linkText(section)).click();
    }

    public String[] splitURLToSections(String URL){
        String[] listOfURLSections;
        listOfURLSections = URL.split("/");
        return listOfURLSections;
    }

    public String arrayToString(String[] incomingArray){
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < incomingArray.length; i++) {
            result.append( incomingArray[i] );
        }
        return result.toString();
    }

    public boolean isLanguage(String[] sections, String expectedLanguage){
        //todo: actually debug this crap
        return sections[3].equalsIgnoreCase(expectedLanguage);
    }

    public void Util_I_should_not_see_the_popup(String pageType){
        if(pageType.equalsIgnoreCase("login")){
            while(driver.findElement(By.id("popupPlaceholder")).isDisplayed()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            org.junit.Assert.assertFalse("newsletter container visible", driver.findElement(By.id("popupPlaceholder")).isDisplayed());
        }if(pageType.equalsIgnoreCase("new page")){
            if (driver.findElement(By.cssSelector("#popupPlaceholder_wrapper")).isDisplayed()){
                driver.findElement(By.cssSelector("#subscriptionLpPopup .skiplink")).click();
            }
        }
    }
}
