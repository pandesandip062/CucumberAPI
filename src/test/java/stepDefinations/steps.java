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
public memberProfileEnquiry memberprofileEnq;
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
    @Then("user should get all details related with that last name")
    public void user_should_get_all_details_related_with_that_last_name() {
    getbyname.getresponse();

    }
    @Then("validate member first name & last name")
    public void validate_member_first_name_last_name() {
       getbyname.geFN_LN();
    }
    @Then("validate the member id")
    public void validate_the_member_id() {
        getbyname.getmemberid();
    }

    @Then("validate the member birth date")
    public void validate_the_member_birth_date() {
        getbyname.getbirthDate();
    }
    @Then("validate the member contact address")
    public void validate_the_member_contact_address() {
        getbyname.contactaddressPhone_Home();
        getbyname.contactaddressPhone_Mobile();
        getbyname.addresType_Mailing();
    }
    @Then("validate the member branch & close indicator value")
    public void validate_the_member_branch_close_indicator_value() {
        getbyname.brachNumber();
        getbyname.closeIndicator();

    }
    @Then("validate the status code for valid headers")
    public void validate_the_status_code_for_valid_headers() {
        getbyname.statuscode_validheaders();
    }
    @Then("validate the status code for in-valid headers")
    public void validate_the_status_code_for_in_valid_headers() {
      getbyname.statuscode_invalidHeadesr();
    }

  //******************************LOS(MemberProfileEnquiry)*******************************************************


    @When("user hits the url {string}")
    public void user_hits_the_url(String url) {
        memberprofileEnq = new memberProfileEnquiry(driver);
        memberprofileEnq.getUrl(url);

    }
    @Then("user should get all details related with memberID")
    public void user_should_get_all_details_related_with_member_id() {
    memberprofileEnq.getResponse();

    }
    @Then("validate memberid")
    public void validate_memberid() {
    memberprofileEnq.getMemberId();
    }
    @Then("validate branchNumber")
    public void validate_branch_number() {
     memberprofileEnq.branchNumber();
    }
    @Then("validate members FirstName, MiddleName & LastName")
    public void validate_members_first_name_middle_name_last_name() {
    memberprofileEnq.FN_ML_LN();
    }
    @Then("validate mambers sex,status & DOB")
    public void validate_mambers_sex_status_dob() {
    memberprofileEnq.DOB();

    }
    @Then("validate members Contact Details")
    public void validate_members_contact_details() {
     memberprofileEnq.memberContactDetails();
    }
    @Then("validate members Address Details")
    public void validate_members_address_details() {
    memberprofileEnq.memberAddressDetails();

    }
    @Then("validate memebrs empoccuptaion")
    public void validate_memebrs_empoccuptaion() {
    memberprofileEnq.empOccuption();

    }
    @Then("validate for invalidHeaders")
    public void validate_for_invalid_headers() {
    memberprofileEnq.InvalidHeaders();

    }

}


