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
public postAccount PA1;
public GetAccounts getaccount;
public addBiller biller ;
public putParty PT;
public Logger logger;
public getpartybyId getparty;

public GetPartybyName getbyname;

public postTokenASAAP postToken;
public memberProfileEnquiry memberprofileEnq;

public putParty putparty;

public AddLoanBallonpayment addloanBallonPayment1;

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
      // ---------------------------------GetPartybyName method-------------------------------------------------------------

    @When("user hit the user send the url for getpartybyName {string}")
    public void user_hit_the_user_send_the_url_for_getpartyby_name(String url) {
    getbyname=new GetPartybyName(driver);
    getbyname.geturl(url);
    }
    @Then("user get all details related with that last name")
    public void user_get_all_details_related_with_that_last_name() {
        getbyname.getresponse();
    }
    @Then("validate the member id")
    public void validate_the_member_id() {
        getbyname.getmemberid();
    }
    @Then("validate member first name & last name")
    public void validate_member_first_name_last_name() {
        getbyname.geFN_LN();
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
        getbyname.brachNumber();

    }
    @Then("validate the member branch & close indicator value")
    public void validate_the_member_branch_close_indicator_value() {
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


    //-----------------------------------PutParty--------------------------------------------------------------
    @When("user launches the url  {string}")
    public void user_launches_the_url(String url) {

        putparty= new putParty(driver);
        putparty.getURl(url);
        logger.info("******************URl launched **************");

    }
    @Then("provide required data which needs to update")
    public void provide_required_data_which_needs_to_update() {

        putparty.updateData();

        logger.info("************** record updated ******************");
    }
    @Then("user get the success message of records upated")
    public void user_get_the_success_message_of_records_upated() {
        putparty.statusMessage();

       logger.info("************ status message verified **********************");
    }
    @Then("validate the status code for created which {int}")
    public void validate_the_status_code_for_created_which(Integer int1) {
        putparty.statusCode();

        logger.info("******************* status code verified ********************");
    }

    //---------------------GetPartybyId-------------------------------------------------

    @Given("create a access token to access")
    public void create_a_access_token_to_access() {

    }
    @When("user hit the user send the url3 {string}")
    public void user_hit_the_user_send_the_url3(String url) {

    getparty= new getpartybyId(driver);
    getparty.getURL(url);

    }
    @Then("user should get all details related with that last name")
    public void user_should_get_all_details_related_with_that_last_name() {

    getparty.getResponse();
    }
    @Then("verify the taxId of member")
    public void verify_the_tax_id_of_member() {
        getparty.taxId();
    }
    @Then("verify the taxIdType of firstName")
    public void verify_the_tax_id_type_of_first_name() {
        getparty.firstName();
    }
    @Then("verify the taxIdType of lastName")
    public void verify_the_tax_id_type_of_last_name() {
       getparty.lastName();
    }
    @Then("verify the taxIdType of birthDay")
    public void verify_the_tax_id_type_of_birth_day() {
       getparty.birthDay();
    }
    @Then("verify the taxIdType of phoneNumber")
    public void verify_the_tax_id_type_of_phone_number() {
       getparty.phoneNumber();
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
    //****************** AddLoanFor BallonPayment  ************************************//

    @Given("when user launch the url for addLoanBallonPayment {string}")
    public void when_user_launch_the_url_for_add_loan_ballon_payment(String url) {
        addloanBallonPayment1 = new AddLoanBallonpayment(driver);
        addloanBallonPayment1.getURL(url);
    }
    @When("post the payload of addLoan")
    public void post_the_payload_of_add_loan() {
        addloanBallonPayment1.getpayload();
    }
    @Then("Validate the response body")
    public void validate_the_response_body() {
        addloanBallonPayment1.statusMessage();

    }

    //*************************** PostAccount************************//


    @Given("when we launch url {string}")
    public void when_we_launch_url(String url) {
        PA1= new postAccount(driver);
        PA1.getURL(url);
    }
    @Then("sending all details required for acc creation")
    public void sending_all_details_required_for_acc_creation() {
        PA1.getResponse();
    }
    @Then("validate for the acc creation")
    public void validate_for_the_acc_creation() {
    PA1.validate();
    }

}



