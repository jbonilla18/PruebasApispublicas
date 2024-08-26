package tests.apiPublica;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetSingleObjects {

    @Parameters({"id", "EsperadoStatusCode"})
    @Test

        public void getSingleObjects(String id, int EsperadoStatusCode) {

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects");

        Response response = request
                .when()
                .get(id);
        response.prettyPrint();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, EsperadoStatusCode);


//FORMA DE EXTRAER UN OBJETO PRINCIPAL
     /*   JSONObject jsonResponse = new JSONObject(response.asString());
        String name = jsonResponse.getString("name");
        System.out.println(name);

//FORMA DE EXTRAER UN OBJETO QUE ESTA DENTRO DE UN PRINCIPAL
        JSONObject jsonData = jsonResponse.getJSONObject("data");
        String cpuModel = jsonData.getString("CPU model");
        System.out.println(cpuModel);*/
    }
}
