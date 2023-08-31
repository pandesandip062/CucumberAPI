package PageObjectModule;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.assertTrue;

public class postAccount {

    public WebDriver driver;
    public String url1;
    public RequestSpecification httpRequest;
    public RequestSpecification httpRequest1;
    public Response response;
    public Response response1;
    public ResponseBody responseBody;
    public ResponseBody responseBody1;
    public String ac1;
    public JsonPath jsonPath;

    public postAccount(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void getURL(String url){
        RestAssured.baseURI=url;
        url1=url;

    }
    public void getResponse(){

        String env="int1";

        if(env.equals("int1")){
            RestAssured.baseURI = url1;
            httpRequest = RestAssured.given().header("Username", "asapp-user").header("Password", "secret@123").header("Authorization", "Basic YXNhcHAtdXNlcjpzZWNyZXRAMTIz").header("Content-Type", "application/x-www-form-urlencoded").formParam("username", "00201051");
            response = httpRequest.post("/oauth/token");
            responseBody = response.getBody();
            String resopnse = responseBody.asString();
            jsonPath = responseBody.jsonPath();
            String accesstoken = jsonPath.get("access_token");
            ac1 = "Bearer " + accesstoken;

            System.out.println(resopnse);

            httpRequest1 = RestAssured.given().header("Content-Type", "application/json").header("Authorization",ac1);
            response1 = httpRequest1.body(new File(".//ASAAP_datafiles/postAccount1.json")).post("/AccountMessage");
            responseBody1 = response1.getBody();
            String resonsebody1 = responseBody1.asString();
            System.out.println("response is" + resonsebody1);


        } else if (env.equals("UAT")) {
            RestAssured.baseURI = url1;
            httpRequest = RestAssured.given().header("Username", "asapp-user").header("Password", "secret@123").header("Authorization", "Basic YXNhcHAtdXNlcjpzZWNyZXRAMTIz").header("Content-Type", "application/x-www-form-urlencoded").formParam("username", "76603006");
            response = httpRequest.post("/oauth/token");
            responseBody = response.getBody();
            String resopnse = responseBody.asString();
            jsonPath = responseBody.jsonPath();
            String accesstoken = jsonPath.get("access_token");
            ac1 = "Bearer " + accesstoken;

            System.out.println(resopnse);

            httpRequest1 = RestAssured.given().header("Content-Type", "application/json").header("Authorization",ac1);
            response1 = httpRequest1.body(new File(".//ASAAP_datafiles/postAccount1.json")).post("/AccountMessage");
            responseBody1 = response1.getBody();
            String resonsebody1 = responseBody1.asString();
            System.out.println("response is" + resonsebody1);

        }


    }

  public void validate(){
        jsonPath= response1.jsonPath();
        String statusMessage = jsonPath.get("accountMessage.messageContext.statusList.status[0].statusMessage");
        System.out.println(statusMessage);
        String expectedMessage[]={"RECORD ADDED","RECORD ADDED"};
        List<String> expectedMessageList= Arrays.asList(expectedMessage);
        assertTrue(expectedMessageList.contains((statusMessage)));
  }





}




