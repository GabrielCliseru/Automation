package cucumber.bdd;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SetupDriver{

    public static final WebDriver driver = getDriver("chrome");

    public static WebDriver getDriver(String driver) {
        if (driver.equalsIgnoreCase("firefox"))
            return new FirefoxDriver();
        else if (driver.equalsIgnoreCase("chrome")) {
            String OS = System.getProperty("os.name").toLowerCase();

            System.out.printf(OS);

            if(OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0 ){
                System.setProperty("webdriver.chrome.driver", "target/test-classes/chromedriver");
            }else if(OS.contains("mac") ){
                System.setProperty("webdriver.chrome.driver", "target/test-classes/chromedriver-mac");
            }else{
                System.setProperty("webdriver.chrome.driver", "target/test-classes/chromedriver.exe");
            }
            WebDriver webdriverOut = new ChromeDriver();
            webdriverOut.manage().window().maximize();
            return webdriverOut;
        }
        return new FirefoxDriver();
    }

}
