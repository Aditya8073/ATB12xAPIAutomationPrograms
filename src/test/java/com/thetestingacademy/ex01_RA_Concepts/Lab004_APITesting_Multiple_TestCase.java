package com.thetestingacademy.ex01_RA_Concepts;

import io.restassured.RestAssured;

public class Lab004_APITesting_Multiple_TestCase {
    public static void main(String[] args) {
        String pinCode="110048";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pinCode)
                .when()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200);

        pinCode = "#";
        RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/IN/"+pinCode).when().get().then().log().all().statusCode(200);

        pinCode = "1avb";
        RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/IN/"+pinCode).when().get().then().log().all().statusCode(200);
    }
}
