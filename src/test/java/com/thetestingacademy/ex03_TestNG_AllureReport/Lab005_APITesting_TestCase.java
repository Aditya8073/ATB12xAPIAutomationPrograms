package com.thetestingacademy.ex03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab005_APITesting_TestCase {
    String pinCode = "110048";

    @Test
    public void test_GET_Positive_TC1() {
        pinCode = "110048";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pinCode)
                .when()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void test_GET_Negative_TC2(){
        pinCode = "#";
        RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/IN/"+pinCode).when().get().then().log().all().statusCode(200);
    }

    @Test
    public void test_GET_Negative_TC3(){
        pinCode = "1avb";
        RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/IN/"+pinCode).when().get().then().log().all().statusCode(200);
    }
}