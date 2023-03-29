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

public class GetAccounts {

   public WebDriver driver;

   public GetAccounts(WebDriver driver){
       this.driver= driver;
       PageFactory.initElements(driver,this);
   }

   public void Getaccountsapi(String url){


       RestAssured.useRelaxedHTTPSValidation();
       RestAssured.baseURI = url;
   }

   public void response(){
       RequestSpecification httprequest = RestAssured.given().header("client_secret", "33C394254542453b839eCe485C4f055b").header("client_id", "89fefd7ce57943f0ab8f71c11e7ebf8e").header("X-Tenant-ID", "at_sydney").header("Content-Type", "application/json").header("X-Request-Trace-ID", "1").header("X-Context-ID", "011442304");
       Response response = httprequest.request(Method.GET, "");

       ResponseBody responsebody = response.getBody();
       String resonsebody1 = responsebody.asString();
       System.out.println("response is" + resonsebody1);
       JsonPath jsonpathview = responsebody.jsonPath();

   }

    public void ar(){

    }
}
