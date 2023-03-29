package stepDefinations;

import PageObjectModule.GetAccounts;
import PageObjectModule.addBiller;
import PageObjectModule.postTokenASAAP;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;

public class steps {
public WebDriver driver;
public GetAccounts getaccount;
public addBiller biller ;

public postTokenASAAP postToken;


    @Given("when launch the url {string}")
    public void when_launch_the_url(String url) {
        RestAssured.useRelaxedHTTPSValidation();
        getaccount = new GetAccounts(driver);
        getaccount.Getaccountsapi(url);

    }
    @Then("api should return the response value")
    public void api_should_return_the_response_value() {
       getaccount.response();
    }


    @Given("when user launch the url {string}")
    public void when_user_launch_the_url(String url) {
        RestAssured.useRelaxedHTTPSValidation();
        biller = new addBiller(driver);
        biller.launch_url(url);
    }
    @Then("post the payload")
    public void post_the_payload() {
   biller.payload();
    }

    @Then("post the response and validate the body")
    public void post_the_response_and_validate_the_body() {

    }
    @Given("when launch the url1 {string}")
    public void when_launch_the_url1(String url1) {

        postToken = new postTokenASAAP(driver);
        postToken.geturl(url1);
    }
    @Then("api should return the token value with endpoint url2 {string}")
    public void api_should_return_the_token_value_with_endpoint_url2(String url2) {
        postToken.payload1(url2);

    }



}
