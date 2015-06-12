package cucumber.bdd;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by gabrielcliseru on 6/11/15.
 */
public class Deal extends UtilsDeindeal {
    Channel channel = PageFactory.initElements(driver, Channel.class);

    @When("^FunctionToSeeTheDealClass$")
    public void FunctionToSeeTheDealClass() {
    }

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


        if (driver.findElements(By.cssSelector(".add-to-cart")).size() != 0) {
            button = driver.findElement(By.cssSelector(".add-to-cart"));
            type = "single";
        } else {
            button = driver.findElement(By.cssSelector(".deal-mod-popup"));
        }


        //if it is MOD open the modal, make a list of the on-stock variants, pick a random in-stock variant
        if (type.equals("mod")) {
            I_add_a_deal_from_modal(button);
            channel.I_am_on_channel_as_an_existing_visitor("any");
            channel.I_enter_a_random_collection();

        }
        //if it is not an MOD we add to the cart until we finish the list of sizes. Then we change the size. Then we change the product
        else {
            button.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#popup-cart")));
            numberOfElementsInTheCart = driver.findElements(By.cssSelector("tr.item.active")).size();
            int sizesIterator = 0;
            int numberOfSizes = 0;
            //the cart is empty
            if (numberOfElementsInTheCart == 0) {
                //the product has sizes
                List<WebElement> sizeDropdownItems = driver.findElements(By.cssSelector("#dropDownArea .productDropDown ul li"));
                if (sizeDropdownItems.size() != 0) {
                    numberOfSizes = driver.findElements(By.cssSelector("#dropDownArea .productDropDown ul li")).size();
                    //go to the next size
                    do {
                        sizeDropdownItems.get(sizesIterator).click();
                        button.click();
                        numberOfElementsInTheCart = driver.findElements(By.cssSelector("tr.item.active")).size();
                        sizesIterator++;
                    } while (numberOfElementsInTheCart > 0 && sizesIterator < sizeDropdownItems.size());
                }
            }
            //the product does not have sizes or all the sizes have been used
            else if (sizesIterator == numberOfSizes) {
                //navigate to another channel and collection
                channel.I_am_on_channel_as_an_existing_visitor("any");
                channel.I_enter_a_random_collection();
            }
        }


        //coupon
        //product
        //mod: add to cart not out of stock mod
        //wine and gourmet
        //change product until not out of stock
        //change product size until not out of stock
    }
}
