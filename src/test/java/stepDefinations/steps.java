package stepDefinations;

import PageObjectModule.*;
import Utilities.baseClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;


public class steps  {
public WebDriver driver;
public GetAccounts getaccount;
public addBiller biller ;
public putParty PT;
public Logger logger;
public GetPartybyID getparty;

public GetPartybyName getbyname;

public postTokenASAAP postToken;
@Before
 public void setup(){

    logger = Logger.getLogger("CucumberAPI");
    PropertyConfigurator.configure("log4j.properties");
    RestAssured.useRelaxedHTTPSValidation();
}


    @Given("when launch the url {string}")
    public void when_launch_the_url(String url) {

        getaccount = new GetAccounts(driver);
        getaccount.Getaccountsapi(url);

        logger.info("******************URl launched **************");
    }
    @Then("api should return the response value")
    public void api_should_return_the_response_value()
    {
        getaccount.response();
    }


    @Given("when user launch the url {string}")
    public void when_user_launch_the_url(String url) {

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
      // ---------------------------------PutParty method-------------------------------------------------------------


    @Given("generate access token")
    public void generate_access_token() {

        PT = new putParty(driver);
        PT.gettoken();
        logger.info("*****************Access Token Created  ***********************");
    }
    @When("user launches the url  {string}")
    public void user_launches_the_url(String url) {

        PT.getURl(url);
        logger.info("******************URl launched **************");

    }
    @Then("provide required data which needs to update")
    public void provide_required_data_which_needs_to_update() {

        PT.updateData();

        logger.info("************** record updated ******************");
    }
    @Then("user get the success message of records upated")
    public void user_get_the_success_message_of_records_upated() {
       PT.statusMessage();

       logger.info("************ status message verified **********************");
    }
    @Then("validate the status code for created which {int}")
    public void validate_the_status_code_for_created_which(Integer int1) {
        PT.statusCode();

        logger.info("******************* status code verified ********************");
    }

    //---------------------GetPartybyId-------------------------------------------------

    @When("user launch the url {string}")
    public void user_launch_the_url(String url) {
        getparty = new GetPartybyID(driver);
        getparty.getURL(url);

    }
    @Then("user should get all edtails realtd to that id")
    public void user_should_get_all_edtails_realtd_to_that_id() {

    getparty.getResponse();


    }

    //************************** GetPartyByLLastName**********************************************//

    @Given("create a access token to access")
    public void create_a_access_token_to_access() {
        getbyname= new GetPartybyName(driver);
        getbyname.gettoken();

    }
    @When("user hit the user send the url3 {string}")
    public void user_hit_the_user_send_the_url3(String url) {
      getbyname.geturl(url);

    }
    @Then("user should get all dtails related with that last name")
    public void user_should_get_all_dtails_related_with_that_last_name() {
    getbyname.getresponse();

    }



}


