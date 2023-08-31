package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/LOSAddLoanBallonPayment.feature",
        glue="stepDefinations",
        dryRun = false,
        plugin = {"pretty","json:text"}
)
public class AddLoanBallonPayment1 {
}
