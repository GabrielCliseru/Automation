package cucumber.bdd;

        import cucumber.api.PendingException;
        import cucumber.api.java.en.And;
        import cucumber.api.java.en.Given;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;

        import java.util.List;
        import java.util.Random;

public class Channel extends Utils {

    @When("^I enter a \"([^\"]*)\" collection$")
    public int I_enter_a_collection(String arg1)
    {
        if (arg1.equalsIgnoreCase("random")){
            List<WebElement> collectionNames = driver.findElements(By.cssSelector("data-tracking-type='collection'"));
            Random rand = new Random();
            int i = rand.nextInt(collectionNames.size());
            //pe asta l-am pus aici ca sa nu mai facem mereu operatiunea de cautare in obiectul sau, deja il folosim de 2 ori
            //mai jos
            WebElement currentElement = collectionNames.get(i);
            String collectionID = currentElement.getAttribute("data-tracking-id");
            currentElement.click();
            return Integer.parseInt(collectionID);
        }else{
            return 0;
        }
    }


}
