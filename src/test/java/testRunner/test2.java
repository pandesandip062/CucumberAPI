package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/postTokenASSAP.feature",
        glue="stepDefinations",
        dryRun = false,
        plugin = {"pretty","json:test-output"}
)
public class test2 {
}
