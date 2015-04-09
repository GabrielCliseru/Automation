package cucumber.bdd;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.concurrent.TimeUnit;

/**
 * Created by Gabi on 11/30/2014.
 */
public class BaseClass extends SetupDriver {

    @Before
    public void setup() {
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                driver.quit();
            }
        });
    }

    @After
    public void tearDown() {

    }
}
