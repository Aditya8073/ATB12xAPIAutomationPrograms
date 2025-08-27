package com.thetestingacademy.ex04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab006_APITesting_GET_BDDStyle {

    @Test
    public void test_GET_Positive(){
        String pinCode = "110048";
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
}
