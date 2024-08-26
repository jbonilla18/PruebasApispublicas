package tests.apiPublica;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UpdatePartiallyObject {

    @Test
    public void updateObject(){

        File patchBody = new File("src/main/resources/patchUpdate.json");

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type","application/json")
                .body(patchBody);

        Response response = request
                .when()
                .patch("/ff80818190c0e1170190c5d3dbff086f");

        response.prettyPrint();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }
}
