package cucumber.bdd;

import cucumber.api.java.en.Given;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by gabrielcliseru on 6/10/15.
 */
public class Checkout extends UtilsDeindeal {
    Channel channel = PageFactory.initElements(driver, Channel.class);
    Deal deal = PageFactory.initElements(driver, Deal.class);
    @Given("^I am on the checkout page$")
    public void I_am_on_the_checkout_page(){
        channel.I_am_on_channel_as_an_existing_visitor("any");
        channel.I_enter_a_random_collection();
        deal.I_add_the_deal_to_the_cart();
    }
}
