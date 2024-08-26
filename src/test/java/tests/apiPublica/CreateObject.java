package tests.apiPublica;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CreateObject {
    String path = "./Reporte/Apis.html";
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter(path);
    ExtentTest test;


    @Test
    public void createObject() {

        try {
            extent.attachReporter(spark);
            test = extent.createTest("Prueba");
            File postBody = new File("src/main/resources/createObject.json");
            test.log(Status.INFO, "Pasó la ruta del archivo que es : " + postBody);
            RequestSpecification request = given()
                    .baseUri("https://api.restful-api.dev")
                    .basePath("/objects")

                    .header("Content-Type", "application/json")
                    .body(postBody);

            Response response = request
                    .when()
                    .post();

            test.log(Status.INFO, "Se realizó el consumo del Api de prueba");
            response.prettyPrint();
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "El estatus code es : " + statusCode);
            Assert.assertEquals(statusCode, 200);
        } catch (Exception e) {
            System.out.println("Error:" +e);
        }

    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE){
            test.log(Status.FAIL, "Fué fallido el test ");
        } else {
            test.log(Status.PASS, "Fué exitoso el test");
        }
        extent.flush();
    }

}

