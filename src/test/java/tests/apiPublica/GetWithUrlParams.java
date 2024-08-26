package tests.apiPublica;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetWithUrlParams {

    //@Test
    public void getWithUrlParams() {

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .formParams("id","5")
                .formParams("id","10");

        Response response = request
                .when()
                .get();
        response.prettyPrint();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }
    @Test
    public void getWithUrlParams2() {

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .formParam("id",5,7,10);



        Response response = request
                .when()
                .get();
        response.prettyPrint();
    }
}
