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

public class GetPartybyName {

    public WebDriver driver;
    public RequestSpecification httprequest1;
    public RequestSpecification httprequest2;
    public Response response1;
    public Response response2;
    public ResponseBody responsebody1;
    public JsonPath jsonPath;
    public String ac1;

    public GetPartybyName(WebDriver driver){

        this.driver= driver;
        PageFactory.initElements(driver,this);
    }


    public void gettoken(){
        RestAssured.baseURI = "https://np-api.leaguedata.ca:443/int1/asapp-eapi/v1";
        RequestSpecification httprequest2 = RestAssured.given().header("Username", "asapp-user").header("Password", "secret@123").header("client_secret", "33C394254542453b839eCe485C4f055b").header("cuId", "2").header("Authorization", "Basic YXNhcHAtdXNlcjpzZWNyZXRAMTIz").header("Content-Type", "application/x-www-form-urlencoded").formParam("username", "00201123");
        Response response2 = httprequest2.post("/oauth/token");
        ResponseBody responsebody = response2.getBody();
        String resopnse2 = responsebody.asString();
        JsonPath jsonpathview = responsebody.jsonPath();
        String accesstoken = jsonpathview.get("access_token");
        ac1 = "Bearer "+accesstoken;
        System.out.println(accesstoken);
    }

    public void geturl(String url){
        RestAssured.baseURI=url;
    }

    public void getresponse(){

        httprequest1 = RestAssured.given().header("Content-Type", "application/json").header("Authorization",ac1);
        response1 = httprequest1.request(Method.GET, "PartyMessage?lastName=pandeye");
        responsebody1 = response1.getBody();
        String resonsebody1 = responsebody1.asString();
        System.out.println("response is" + resonsebody1);
    }


    public void getmemberid(){
         jsonPath = responsebody1.jsonPath();
         String memberId= jsonPath.getString("partyMessage.partyList.party[0].id");
         Assert.assertEquals("011442304",memberId);

    }

    public void geFN_LN(){
        String FN = jsonPath.get("partyMessage.partyList.party[0].characteristics.individual.firstName");
        Assert.assertEquals("Sandip",FN);
        String LN= jsonPath.get("partyMessage.partyList.party[0].characteristics.individual.lastName");
        Assert.assertEquals("Pandeye",LN);
    }

    public void getbirthDate(){
        String bithdate = jsonPath.get("partyMessage.partyList.party[0].characteristics.individual.birthdate");
        Assert.assertEquals("2023-02-01",bithdate);

    }

    public void contactaddressPhone_Home(){
        String phone_home= jsonPath.get("partyMessage.partyList.party[0].contactList.contact[1].contactPoint.phone.number");
        Assert.assertEquals("8736388",phone_home);
    }
    public void contactaddressPhone_Mobile(){
        String phone_Mobile= jsonPath.get("partyMessage.partyList.party[0].contactList.contact[2].contactPoint.phone.number");
        Assert.assertEquals("1234567890",phone_Mobile);
    }
    public void addresType_Mailing(){
        String line1= jsonPath.get("partyMessage.partyList.party[0].contactList.contact[0].contactPoint.address[0].line1");
        Assert.assertEquals("Canada - CA",line1);

        String line2 = jsonPath.get("partyMessage.partyList.party[0].contactList.contact[0].contactPoint.address[0].line2");
        Assert.assertEquals("Udgir",line2);

        String postalcode = jsonPath.get("partyMessage.partyList.party[0].contactList.contact[0].contactPoint.address[0].postalCode");
        Assert.assertEquals("411057",postalcode);

        String addressType = jsonPath.get("partyMessage.partyList.party[0].contactList.contact[0].contactPoint.address[0].addressType");
        Assert.assertEquals("Mailing",addressType);
    }

    public void brachNumber(){
        String brachnumber = jsonPath.get("partyMessage.partyList.party[0].contactList.customData.valuePair[0].value");
        Assert.assertEquals("01",brachnumber);
    }
     public void closeIndicator(){
        String closeindicator = jsonPath.get("partyMessage.partyList.party[0].contactList.customData.valuePair[1].value");
        Assert.assertEquals("false",closeindicator);
     }

     public void statuscode_validheaders(){
        int statuscode = response1.getStatusCode();
        Assert.assertEquals(200,statuscode);
     }

     public void statuscode_invalidHeadesr(){
         RestAssured.baseURI="https://np-api.leaguedata.ca/int1/asapp-eapi/v1/";
         httprequest2 = RestAssured.given().header("Content-Type", "application/json");
         response2 = httprequest2.request(Method.GET, "PartyMessage?lastName=pandeye");
         int statuscode1 = response2.getStatusCode();
         Assert.assertEquals(400,statuscode1);
         System.out.println(statuscode1);
     }

}

