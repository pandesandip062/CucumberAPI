package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/LOSMenberEnquiry.feature",
        glue="stepDefinations",
        dryRun = false,
        plugin = {"pretty","html:.//test-outpu/cucmber.html"}
)
public class GetMemberProfileInquiryTest {
}
