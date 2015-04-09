package cucumber.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabi on 9/9/2014.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber-html-report",
                "json:target/cucumber-json-report",
                "junit:target/cucumber-junit-report"},
        features = "src/test/resources/features"
)

public class CukesRunner {
}
