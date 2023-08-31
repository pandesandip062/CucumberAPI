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

public class AddLoanBallonpayment {
    public RequestSpecification httpRequest;
    public RequestSpecification httpRequest2;
    public Response resopnse;
    public Response resopnse2;
    public ResponseBody responseBody;
    public ResponseBody responseBody2;

    public JsonPath jsonPath;
    public String url1;

    WebDriver driver;

    public AddLoanBallonpayment(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void getURL(String url){

        RestAssured.baseURI=url;
        url1=url;
    }
    public void getpayload(){
        String env="int1";

        if(env.equals("int1")){
            httpRequest = RestAssured.given().header("client_secret", "2c8aBcF9Dd2B461381159FCE475466A8").header("client_id", "a86bcd23876c42fb875f59cf26c5aeaf").header("cuID", "002").header("branchId", "2").header("tellerNo", "rfievet").header("tellerId", "rfievet").header("memberNumber", "101082378").header("Content-Type","application/json");
            resopnse = httpRequest.body(new File(".//AddLoan_dataFiles/AddLoan1.json")).post("accounts/loans");
            responseBody = resopnse.getBody();
            String Response = responseBody.asString();
            jsonPath= responseBody.jsonPath();
            System.out.println(Response);

        } else if (env.equals("uat")) {
            httpRequest = RestAssured.given().header("client_secret", "2c8aBcF9Dd2B461381159FCE475466A8").header("client_id", "a86bcd23876c42fb875f59cf26c5aeaf").header("cuID", "766").header("branchId", "2").header("tellerNo", "rfievet").header("tellerId", "pslqa").header("memberNumber", "101996766").header("Content-Type","application/json");
            resopnse = httpRequest.body(new File(".//AddLoan_dataFiles/AddLoan1.json")).post("accounts/loans");
            responseBody = resopnse.getBody();
            String Response = responseBody.asString();
            jsonPath= responseBody.jsonPath();
            System.out.println(Response);

        }

    }
   public void statusMessage(){
        jsonPath= responseBody.jsonPath();
        String StatusMssage = jsonPath.get("responseType");
       Assert.assertEquals("success",StatusMssage);
   }
}
