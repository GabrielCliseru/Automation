package cucumber.bdd;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by gabrielcliseru on 6/11/15.
 */
public class Deal extends UtilsDeindeal {
    Channel channel = PageFactory.initElements(driver, Channel.class);

    public void I_add_a_deal_from_modal(WebElement button) {
        int i = 0;
        int numberOfElementsInTheCart = 0;

        button.click();
        List<WebElement> variants = driver.findElements(By.cssSelector(".buy-now-btn"));
        do {
            variants.get(i).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#popup-mod")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#popup-cart")));
            i++;

            numberOfElementsInTheCart = driver.findElements(By.cssSelector("tr.item.active")).size();
        } while (numberOfElementsInTheCart != 0 && i < variants.size());
    }

    @And("^I add the deal to the cart$")
    public void I_add_the_deal_to_the_cart() {
        WebElement button;
        String type = "mod";
        int numberOfElementsInTheCart;

        /*
        After the user clicks on a collection from the channel page he might end up on the collection page or not.
        We have to take him to the deal page by entering a random collection
         */
        if(isCollectionPage()) enterRandomCollectionFromCollectionPage();

        if (driver.findElements(By.cssSelector(".add-to-cart")).size() != 0) {
            button = driver.findElement(By.cssSelector(".add-to-cart"));
            type = "single";
        } else {
            button = driver.findElement(By.cssSelector(".deal-mod-popup"));
        }



        if (driver.findElements(By.cssSelector(".options.productDropDown")).size() > 0){
            /*
                Create a list of all the variants still in stock
                Shuffle the variant IDs
                Get the IDs 1 by 1 and try to add them to the cart until 1 has been added.
                    Alert the system if we couldn't add it but we should and move forward
            */
            String selectVariantSelector;
            if (type.equals("mod")) {
                selectVariantSelector = ".buy-now-btn";
            }else{
                selectVariantSelector = ".options .dropdownList li";
                //We need to open the drop down selector first, for MOD it should be opened since the previous click
                driver.findElement(By.cssSelector(".productDropDown .press")).click();
            }
            ArrayList<WebElement> allTheVariants = ((ArrayList<WebElement>) driver.findElements(By.cssSelector(selectVariantSelector)));
            Collections.shuffle(allTheVariants);

            WebElement currentVariant;
            //note, some of the products might have sizes that are hidden, we should scroll to them before clicking on them
            for (int i = 0; i < allTheVariants.size(); i++) {
                currentVariant = allTheVariants.get(i);
                if(currentVariant.isDisplayed()){
                    currentVariant.click();
                }else{
                    //scroll back and forth trick
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", currentVariant);
                    WebElement detailsWrapper = driver.findElement(By.cssSelector("#detailsWrapper"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", detailsWrapper);
                    wait.until(ExpectedConditions.visibilityOf(detailsWrapper));
                    currentVariant.click();
                }
            }
            /*
            click the add to cart button
            */
            button.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#popup-cart")));
            numberOfElementsInTheCart = driver.findElements(By.cssSelector("tr.item.active")).size();
        }
    }
}
