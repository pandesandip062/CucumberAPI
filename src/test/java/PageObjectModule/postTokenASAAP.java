package PageObjectModule;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class postTokenASAAP {


    public WebDriver driver;

    public postTokenASAAP(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }


    public void geturl(String url1){
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = url1;

    }

    public void payload1(String url2){

        RequestSpecification httprequest = RestAssured.given().header("Username","asapp-user").header("Password","secret@123").header("client_secret", "33C394254542453b839eCe485C4f055b").header("cuId", "2").header("Authorization", "Basic YXNhcHAtdXNlcjpzZWNyZXRAMTIz").header("Content-Type", "application/x-www-form-urlencoded").formParam("username","76603006");
        Response response = httprequest.post(url2);
        ResponseBody responsebody = response.getBody();
        String resopnse1= responsebody.asString();
        System.out.print(resopnse1);
        JsonPath jshonpath= responsebody.jsonPath();
        String scope1 = jshonpath.getJsonObject("scope");
        Assert.assertEquals("read write",scope1);


    }


}
