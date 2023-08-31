package PageObjectModule;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.PageFactory;

public class memberProfileEnquiry {
    public WebDriver driver;
    public RequestSpecification httprequest;
    public RequestSpecification httprequest2;
    public Response response;
    public Response response2;
    public ResponseBody responsebody;

    public ResponseBody responsebody2;
    public JsonPath jsonPath;


    public memberProfileEnquiry(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getUrl(String url) {
        RestAssured.baseURI = url;

    }

    public void getResponse() {

        String a ="uat";

        if (a.equals("int1")) {
            RestAssured.baseURI = "https://np-api.leaguedata.ca:443/int1/horizon-los-eapi/v1/";
            httprequest = RestAssured.given().header("client_secret", "2c8aBcF9Dd2B461381159FCE475466A8").header("client_id", "a86bcd23876c42fb875f59cf26c5aeaf").header("cuID", "2");
            response = httprequest.get("/members/011204282");
            responsebody = response.getBody();
            String resopnse1 = responsebody.asString();
            System.out.println(resopnse1);
        } else if (a.equals("uat")) {
            RestAssured.baseURI = "https://np-api.leaguedata.ca:443/uat/horizon-los-eapi/v1/";
            httprequest = RestAssured.given().header("client_secret", "2c8aBcF9Dd2B461381159FCE475466A8").header("client_id", "a86bcd23876c42fb875f59cf26c5aeaf").header("cuID", "6");
            response = httprequest.get("/members/011400318");
            responsebody = response.getBody();
            String resopnse1 = responsebody.asString();
            System.out.println(resopnse1);

        }
    }

    public void getMemberId( ) {
        jsonPath = response.jsonPath();
        String MemberId = jsonPath.get("member[0].memberNumber");
        String  a[]={"011400318","0114423"};
        for(int i=0;i<a.length;i++){
            if(a[i]==MemberId)
            Assert.assertEquals(a[i],MemberId);
        }
    }

    public void branchNumber() {
        String branchnum = jsonPath.get("member[0].branchNumber");
        String  a[]={"01","02"};
        for(int i=0;i<a.length;i++){
            if(a[i]==branchnum)
                Assert.assertEquals(a[i],branchnum);
        }
    }

    public void FN_ML_LN() {
        String FN = jsonPath.get("member[0].firstName");
        String  a[]={"Sandip","Sandeep"};
        for(int i=0;i<a.length;i++){
            if(a[i]==FN)
                Assert.assertEquals(a[i],FN);
        }
        String MN = jsonPath.get("member[0].middleName");
        String  a1[]={"Balaji","Balaji"};
        for(int i=0;i<a.length;i++){
            if(a1[i]==MN)
                Assert.assertEquals(a[i],MN);
        }
        String LN = jsonPath.get("member[0].lastName");
        String  a2[]={"Pandeye","Pande"};
        for(int i=0;i<a.length;i++){
            if(a2[i]==LN)
                Assert.assertEquals(a[i],LN);
        }
    }
    public void DOB() {
        String DOB = jsonPath.get("member[0].dob");
        String  a[]={"03042020","02012023"};
        for(int i=0;i<a.length;i++){
            if(a[i]==DOB)
                Assert.assertEquals(a[i],DOB);
        }
    }

    public void memberContactDetails() {
        String homePhone = jsonPath.get("contacts[0].homePhone");
        String  a[]={"8736388","123456"};
        for(int i=0;i<a.length;i++){
            if(a[i]==homePhone)
                Assert.assertEquals(a[i],homePhone);
        }
        String workPhone = jsonPath.get("contacts[0].workPhone");
        String  a1[]={"1234","1111111111"};
        for(int i=0;i<a.length;i++){
            if(a1[i]==workPhone)
                Assert.assertEquals(a[i],workPhone);
        }
        String emailAddress = jsonPath.get("contacts[0].emailAddress");
        String  a2[]={"abc@gmail.com","xyz@gmail.com"};
        for(int i=0;i<a.length;i++){
            if(a2[i]==emailAddress)
                Assert.assertEquals(a[i],emailAddress);
        }
    }

    public void memberAddressDetails() {
        String addressLine1 = jsonPath.get("addresses[0].addressLine1");
        String  a[]={"Canada - CA","Pune"};
        for(int i=0;i<a.length;i++){
            if(a[i]==addressLine1)
                Assert.assertEquals(a[i],addressLine1);
        }
        String postalCode = jsonPath.get("addresses[0].postalCode");
        String  a1[]={"411057","411057"};
        for(int i=0;i<a.length;i++){
            if(a[i]==postalCode)
                Assert.assertEquals(a[i],postalCode);
        }


        String country = jsonPath.get("addresses[0].country");
        String  a2[]={"3","2"};
        for(int i=0;i<a.length;i++){
            if(a[i]==country)
                Assert.assertEquals(a[i],country);
        }
    }

    public void empOccuption() {
        String empStatus = jsonPath.get("empDetails.empStatus");
        String  a[]={"3-Retired","2-Full Time"};
        for(int i=0;i<a.length;i++){
            if(a[i]==empStatus)
                Assert.assertEquals(a[i],empStatus);
        }
        String occupation = jsonPath.get("empDetails.occupation");
        String  a1[]={"B012 Financial and Investment Analysts","D013 Dentists"};
        for(int i=0;i<a.length;i++){
            if(a1[i]==occupation)
                Assert.assertEquals(a[i],occupation);
        }
        String empIndustryCode = jsonPath.get("empDetails.empIndustryCode");
        String  a2[]={"D1","B1"};
        for(int i=0;i<a.length;i++){
            if(a2[i]==empIndustryCode)
                Assert.assertEquals(a[i],empIndustryCode);


        }
    }

    public void InvalidHeaders(){
        httprequest2 = RestAssured.given().header("client_id", "a86bcd23876c42fb875f59cf26c5aeaf").header("cuID", "2");
        response2 = httprequest2.get("members/011442304");
        String responsebody2 = response2.getBody().asString();
        System.out.println(responsebody2);
        JsonPath jsonpath1 = response2.jsonPath();
        String error = jsonpath1.get("error");
        Assert.assertEquals("Invalid Client",error);

        int statuscode = response2.getStatusCode();
        Assert.assertEquals(401,statuscode);

    }
}

