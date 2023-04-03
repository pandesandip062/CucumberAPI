package PageObjectModule;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GetPartybyName {

    public WebDriver driver;
    public RequestSpecification httprequest1;
    public Response response1;
    public ResponseBody responsebody1;
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
        response1 = httprequest1.request(Method.GET, "PartyMessage?lastName=pande");
        responsebody1 = response1.getBody();
        String resonsebody1 = responsebody1.asString();
        System.out.println("response is" + resonsebody1);
    }


}
