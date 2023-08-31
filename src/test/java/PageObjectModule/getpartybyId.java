package PageObjectModule;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class getpartybyId {
    public RequestSpecification httprequest;
    public WebDriver driver;
    public RequestSpecification httprequest1;
    public Response response;
    public Response response1;
    public ResponseBody responsebody;

    public ResponseBody responsebody1;
    public JsonPath jsonPath;

    String ac1;
    String url1;


    public getpartybyId(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getURL(String url) {

        RestAssured.baseURI = url;
        url1= url;
    }

    public void getResponse() {
        String env = "uat";

        if (env.equals("int1")) {
            RestAssured.baseURI = url1;
            httprequest = RestAssured.given().header("Username", "asapp-user").header("Password", "secret@123").header("Authorization", "Basic YXNhcHAtdXNlcjpzZWNyZXRAMTIz").header("Content-Type", "application/x-www-form-urlencoded").formParam("username", "00201051");
            response = httprequest.post("/oauth/token");
            responsebody = response.getBody();
            String resopnse = responsebody.asString();
            jsonPath = responsebody.jsonPath();
            String accesstoken = jsonPath.get("access_token");
            ac1 = "Bearer " + accesstoken;

            System.out.println(resopnse);

            httprequest1 = RestAssured.given().header("Content-Type", "application/json").header("Authorization", ac1);
            response1 = httprequest1.request(Method.GET, "/PartyMessage/101088424");
            responsebody1 = response1.getBody();
            String resonsebody1 = responsebody1.asString();
            System.out.println("response is" + resonsebody1);

        } else if (env.equals("uat")) {

            RestAssured.baseURI = url1;

            httprequest = RestAssured.given().header("Username", "asapp-user").header("Password", "secret@123").header("client_secret", "33C394254542453b839eCe485C4f055b").header("cuId", "2").header("Authorization", "Basic YXNhcHAtdXNlcjpzZWNyZXRAMTIz").header("Content-Type", "application/x-www-form-urlencoded").formParam("username", "76603006");
            response = httprequest.post("/oauth/token");
            responsebody = response.getBody();
            String resopnse2 = responsebody.asString();
            jsonPath = responsebody.jsonPath();
            String accesstoken = jsonPath.get("access_token");
            ac1 = "Bearer " + accesstoken;

            System.out.println(resopnse2);

            httprequest1 = RestAssured.given().header("Content-Type", "application/json").header("Authorization", ac1);
            response1 = httprequest1.request(Method.GET, "/PartyMessage/011338529");
            responsebody1 = response1.getBody();
            String resonsebody1 = responsebody1.asString();
            System.out.println("response is" + resonsebody1);

        }

    }
    public void taxIdType() {
        jsonPath = response.jsonPath();
        String TaxIdType = jsonPath.get("partyMessage.partyList.party[0].taxInformationList.taxInformation[0].taxIdType");
        String expectedTitles[]= {"IndividualTaxpayerIdentificationNumber","IndividualTaxpayerIdentificationNumber"};
        List<String> expectedTitlesList = Arrays.asList(expectedTitles);
        assertTrue(expectedTitlesList.contains((TaxIdType)));
    }
    public void taxId() {
        jsonPath=responsebody1.jsonPath();
        String TaxId = jsonPath.get("partyMessage.partyList.party[0].taxInformationList.taxInformation[1].taxId");
        String expectedTitles[]= {"719029506","71902902"};
        List<String> expectedTitlesList = Arrays.asList(expectedTitles);
        assertTrue(expectedTitlesList.contains((TaxId)));
    }

    public void firstName() {

        String FirstName = jsonPath.get("partyMessage.partyList.party[0].characteristics.individual.firstName");
        String expectedTitles[]= {"ASAAP","Sandy"};
        List<String> expectedTitlesList = Arrays.asList(expectedTitles);
        assertTrue(expectedTitlesList.contains((FirstName)));
        }

    public void lastName() {

        String LastName = jsonPath.get("partyMessage.partyList.party[0].characteristics.individual.lastName");
        String expectedTitles[]= {"Pande11","Testing"};
        List<String> expectedTitlesList = Arrays.asList(expectedTitles);
        assertTrue(expectedTitlesList.contains((LastName)));
    }

    public void birthDay() {

        String BirthDay = jsonPath.get("partyMessage.partyList.party[0].characteristics.individual.birthdate");
        String expectedTitles[]= {"2022-10-05","1978-06-06"};
        List<String> expectedTitlesList = Arrays.asList(expectedTitles);
        assertTrue(expectedTitlesList.contains((BirthDay)));
    }

    public void phoneNumber() {

        String Num = jsonPath.get("partyMessage.partyList.party[0].contactList.contact[1].contactPoint.phone.number");
        String expectedTitles[]= {"097654321","5142793325"};
        List<String> expectedTitlesList = Arrays.asList(expectedTitles);
        assertTrue(expectedTitlesList.contains((Num)));
    }


}
