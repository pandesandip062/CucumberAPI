package PageObjectModule;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.PageFactory;

public class memberProfileEnquiry {
    public WebDriver driver;
    public RequestSpecification httprequest;
    public RequestSpecification httprequest2;
    public Response response;
    public Response response2;
    public ResponseBody responsebody;

    public ResponseBody responsebody2;
    public JsonPath jsonPath;


    public memberProfileEnquiry(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getUrl(String url) {
        RestAssured.baseURI = url;

    }

    public void getResponse() {

        httprequest = RestAssured.given().header("client_secret", "2c8aBcF9Dd2B461381159FCE475466A8").header("client_id", "a86bcd23876c42fb875f59cf26c5aeaf").header("cuID", "2");
        response = httprequest.get("members/011442304");
        responsebody = response.getBody();
        String resopnse1 = responsebody.asString();
        System.out.println(resopnse1);
    }

    public void getMemberId() {
        jsonPath = response.jsonPath();
        String MemberId = jsonPath.get("member[0].memberNumber");
        Assert.assertEquals("011442304", MemberId);

    }

    public void branchNumber() {
        String branchnum = jsonPath.get("member[0].branchNumber");
        Assert.assertEquals("01", branchnum);

    }

    public void FN_ML_LN() {
        String FN = jsonPath.get("member[0].firstName");
        Assert.assertEquals("Sandip", FN);

        String MN = jsonPath.get("member[0].middleName");
        Assert.assertEquals("Balaji", MN);

        String LN = jsonPath.get("member[0].lastName");
        Assert.assertEquals("Pandeye", LN);
    }

    public void DOB() {
        String DOB = jsonPath.get("member[0].dob");
        Assert.assertEquals("02012023", DOB);

    }

    public void memberContactDetails() {
        String homePhone = jsonPath.get("contacts[0].homePhone");
        Assert.assertEquals("8736388", homePhone);

        String workPhone = jsonPath.get("contacts[0].workPhone");
        Assert.assertEquals("1111111111", workPhone);

        String emailAddress = jsonPath.get("contacts[0].emailAddress");
        Assert.assertEquals("abc@gmail.com", emailAddress);
    }

    public void memberAddressDetails() {
        String addressLine1 = jsonPath.get("addresses[0].addressLine1");
        Assert.assertEquals("Canada - CA", addressLine1);

        String postalCode = jsonPath.get("addresses[0].postalCode");
        Assert.assertEquals("411057", postalCode);

        String country = jsonPath.get("addresses[0].country");
        Assert.assertEquals("3", country);
    }

    public void empOccuption() {
        String empStatus = jsonPath.get("empDetails.empStatus");
        Assert.assertEquals("2-Full Time", empStatus);

        String occupation = jsonPath.get("empDetails.occupation");
        Assert.assertEquals("B012 Financial and Investment Analysts", occupation);

        String empIndustryCode = jsonPath.get("empDetails.empIndustryCode");
        Assert.assertEquals("B1", empIndustryCode);
    }

    public void InvalidHeaders(){
        httprequest2 = RestAssured.given().header("client_id", "a86bcd23876c42fb875f59cf26c5aeaf").header("cuID", "2");
        response2 = httprequest2.get("members/011442304");
        String responsebody2 = response2.getBody().asString();
        System.out.println(responsebody2);
        JsonPath jsonpath1 = response2.jsonPath();
        String error = jsonpath1.get("error");
        Assert.assertEquals("Invalid Client",error);

        int statuscode = response2.getStatusCode();
        Assert.assertEquals(401,statuscode);

    }
}

