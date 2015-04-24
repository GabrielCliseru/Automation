package cucumber.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.junit.Assert;

/**
 * Created by IEUser on 4/24/2015.
 */
public class Header extends Utils{
    @And("^language is set to \"([^\"]*)\"$")
    public void language_is_set_to(String language){
        String[] pageURL = splitURLToSections(driver.getCurrentUrl());
        Assert.assertTrue(isLanguage(pageURL,language));
    }
}
