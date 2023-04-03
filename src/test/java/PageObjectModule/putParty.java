package PageObjectModule;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class putParty {
    public WebDriver driver;
    public RequestSpecification httprequest1;
   public  Response response1;
   public ResponseBody responsebody1;
   public String ac1;
    protected String accessToke;


    public putParty(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void gettoken(){
        RestAssured.baseURI = "https://np-api.leaguedata.ca:443/int1/asapp-eapi/v1";
        RequestSpecification httprequest = RestAssured.given().header("Username", "asapp-user").header("Password", "secret@123").header("client_secret", "33C394254542453b839eCe485C4f055b").header("cuId", "2").header("Authorization", "Basic YXNhcHAtdXNlcjpzZWNyZXRAMTIz").header("Content-Type", "application/x-www-form-urlencoded").formParam("username", "00201123");
        Response response = httprequest.post("/oauth/token");
        ResponseBody responsebody = response.getBody();
        JsonPath jsonpathview = responsebody.jsonPath();
        String accesstoken = jsonpathview.get("access_token");
        ac1 = "Bearer "+accesstoken;
    }

    public void getURl(String url){
        RestAssured.baseURI=url;

    }
    public void updateData(){
        httprequest1 = RestAssured.given().header("Content-Type", "application/json").header("Authorization",ac1);
        response1 = httprequest1.body(new File(".//ASAAP_datafiles/putbody.json")).put("/v1/PartyMessage");
        responsebody1 = response1.getBody();
        String resopnse2 = responsebody1.asString();
        System.out.println(resopnse2);


    }

    public void statusMessage(){

        JsonPath jsonpath1=responsebody1.jsonPath();
        String statusmessage = jsonpath1.get("partyMessage.messageContext.statusList.status[0].statusMessage");
        Assert.assertEquals("RECORD UPDATED",statusmessage);
    }

    public void statusCode(){

        int statuscode =response1.getStatusCode();
        Assert.assertEquals(201,statuscode);

    }
    
    public void accessToke(){
        String access = ac1;
    }
}



