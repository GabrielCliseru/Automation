package cucumber.bdd;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SetupDriver {

    public static final WebDriver driver = getDriver("chrome");

    public static WebDriver getDriver(String driver) {
        if (driver.equalsIgnoreCase("firefox"))
            return new FirefoxDriver();
        else if (driver.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "target/test-classes/chromedriver.exe");
            return new ChromeDriver();
        }
        return new FirefoxDriver();
    }

}
