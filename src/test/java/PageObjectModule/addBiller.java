package PageObjectModule;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class addBiller {

    WebDriver driver;

    public addBiller(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

  public void launch_url(String url){
      RestAssured.useRelaxedHTTPSValidation();
      RestAssured.baseURI = url;
  }

  public void payload(){
      RequestSpecification httprequest = RestAssured.given().header("client_secret", "33C394254542453b839eCe485C4f055b").header("client_id", "89fefd7ce57943f0ab8f71c11e7ebf8e").header("X-Tenant-ID", "at_sydney").header("Content-Type", "application/json").header("X-Request-Trace-ID", "1").header("X-Context-ID", "011616931");

      String Payload ="{\n" +
              "  \"vendorId\": \"45\",\n" +
              "  \"vendorMemberAccount\": \"873209090989\",\n" +
              "  \"nickname\": \"nicky\"\n" +
              "}";
      Response response = httprequest.body(Payload).post("/bill-payment/payee");
      ResponseBody responsebody = response.getBody();
      String resopnse1= responsebody.asString();
      System.out.println(resopnse1);
  }

}
