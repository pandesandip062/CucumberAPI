package PageObjectModule;

import io.cucumber.java.bs.A;
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

public class GetPartybyName {

    public WebDriver driver;
    public RequestSpecification httprequest1;
    public RequestSpecification httprequest;
    public Response response1;
    public Response response;
    public ResponseBody responsebody1;
    public ResponseBody responsebody;
    public JsonPath jsonPath;
    public String ac1;
    String url1;


    public GetPartybyName(WebDriver driver){

        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void geturl(String url){

        RestAssured.baseURI=url;
        url1=url;
    }

    public void getresponse(){

       String env ="uat";

     if(env.equals("int1")){
        RestAssured.baseURI = url1;
        httprequest = RestAssured.given().header("Username", "asapp-user").header("Password", "secret@123").header("Authorization", "Basic YXNhcHAtdXNlcjpzZWNyZXRAMTIz").header("Content-Type", "application/x-www-form-urlencoded").formParam("username", "00201051");
        response = httprequest.post("/oauth/token");
        responsebody = response.getBody();
        String resopnse2 = responsebody.asString();
        jsonPath = responsebody.jsonPath();
        String accesstoken = jsonPath.get("access_token");
        ac1 = "Bearer "+accesstoken;
        System.out.println(accesstoken);

        httprequest1 = RestAssured.given().header("Content-Type", "application/json").header("Authorization",ac1);
        response1 = httprequest1.request(Method.GET, "/PartyMessage?lastName=Testing12");
        responsebody1 = response1.getBody();
        String resonsebody1 = responsebody1.asString();
        System.out.println("response is" + resonsebody1);
    } else if (env.equals("uat")) {

         RestAssured.baseURI = url1;
         httprequest = RestAssured.given().header("Username", "asapp-user").header("Password", "secret@123").header("Authorization", "Basic YXNhcHAtdXNlcjpzZWNyZXRAMTIz").header("Content-Type", "application/x-www-form-urlencoded").formParam("username", "76603006");
         response = httprequest.post("/oauth/token");
         responsebody = response.getBody();
         String resopnse2 = responsebody.asString();
         jsonPath = responsebody.jsonPath();
         String accesstoken = jsonPath.get("access_token");
         ac1 = "Bearer "+accesstoken;
         System.out.println(accesstoken);

         httprequest1 = RestAssured.given().header("Content-Type", "application/json").header("Authorization",ac1);
         response1 = httprequest1.request(Method.GET, "/PartyMessage?lastName=Pande11");
         responsebody1 = response1.getBody();
         String resonsebody1 = responsebody1.asString();
         System.out.println("response is" + resonsebody1);
     }

     }


          public void getmemberid(){
            jsonPath=responsebody1.jsonPath();
            String MemberId = jsonPath.get("partyMessage.partyList.party[0].id");
            String expectedTitles[]= {"101411834","011338529"};
            List<String> expectedTitlesList = Arrays.asList(expectedTitles);
            assertTrue(expectedTitlesList.contains((MemberId)));
    }

    public void geFN_LN(){
        String FN = jsonPath.get("partyMessage.partyList.party[0].characteristics.individual.firstName");
        String expectedTitles[]= {"ASAAP","Sandy"};
        List<String> expectedTitlesList = Arrays.asList(expectedTitles);
        assertTrue(expectedTitlesList.contains((FN)));
    }

    public void getbirthDate(){
        String BirthDay =jsonPath.get("partyMessage.partyList.party[0].characteristics.individual.birthdate");
        String expectedTitles[]= {"1978-06-06","2022-10-05"};
        List<String> expectedTitlesList = Arrays.asList(expectedTitles);
        assertTrue(expectedTitlesList.contains((BirthDay)));

    }

    public void contactaddressPhone_Home(){
        String Phone_home =jsonPath.get("partyMessage.partyList.party[0].contactList.contact[1].contactPoint.phone.number");
        String expectedTitles[]= {"8736388","097654321"};
        List<String> expectedTitlesList = Arrays.asList(expectedTitles);
        assertTrue(expectedTitlesList.contains((Phone_home)));
    }
    public void contactaddressPhone_Mobile(){
        String phone_Mobile =jsonPath.get("partyMessage.partyList.party[0].contactList.contact[2].contactPoint.phone.number");
        String expectedTitles[]= {"5142793325","097854332"};
        List<String> expectedTitlesList = Arrays.asList(expectedTitles);
        assertTrue(expectedTitlesList.contains((phone_Mobile)));
    }
    public void addresType_Mailing(){
        String line1 = jsonPath.get("partyMessage.partyList.party[0].contactList.contact[0].contactPoint.address.line1");
        String expectedTitles[]= {"1 Fourth St","Pund"};
        List<String> expectedTitlesList = Arrays.asList(expectedTitles);
        assertTrue(expectedTitlesList.contains((line1)));

        String line2 =  jsonPath.get("partyMessage.partyList.party[0].contactList.contact[0].contactPoint.address.line2");
        String expectedTitles1[]= {"Pune","Hinjewada"};
        List<String> expectedTitlesList1 = Arrays.asList(expectedTitles1);
        assertTrue(expectedTitlesList1.contains((line2)));

        String postalcode =   jsonPath.get("partyMessage.partyList.party[0].contactList.contact[0].contactPoint.address.postalCode");
        String expectedTitles2[]= {"A1N2B2","41112"};
        List<String> expectedTitlesList2 = Arrays.asList(expectedTitles2);
        assertTrue(expectedTitlesList2.contains((postalcode)));

        String addressType = jsonPath.get("partyMessage.partyList.party[0].contactList.contact[0].contactPoint.address.addressType");
        String expectedTitles3[]= {"Mailing","Mailing"};
        List<String> expectedTitlesList3 = Arrays.asList(expectedTitles3);
        assertTrue(expectedTitlesList3.contains((addressType)));
    }

    public void brachNumber(){
        String brachnumber =  jsonPath.get("partyMessage.partyList.party[0].contactList.customData.valuePair[0].value");
        String expectedTitles[]= {"01","01"};
        List<String> expectedTitlesList = Arrays.asList(expectedTitles);
        assertTrue(expectedTitlesList.contains((brachnumber)));
    }
     public void closeIndicator(){
         String closeindicator = jsonPath.get("partyMessage.partyList.party[0].contactList.customData.valuePair[1].value");
         String expectedTitles[]= {"false","false"};
         List<String> expectedTitlesList = Arrays.asList(expectedTitles);
         assertTrue(expectedTitlesList.contains((closeindicator)));
     }

     public void statuscode_validheaders(){
        int statuscode = response1.getStatusCode();
        Assert.assertEquals(200,statuscode);

     }

     public void statuscode_invalidHeadesr(){
         RestAssured.baseURI=url1;
         httprequest = RestAssured.given().header("Content-Type", "application/json");
         response = httprequest.request(Method.GET, "/PartyMessage?lastName=pandeye");
         int statuscode1 = response.getStatusCode();
         Assert.assertEquals(400,statuscode1);
         System.out.println(statuscode1);
     }

}

