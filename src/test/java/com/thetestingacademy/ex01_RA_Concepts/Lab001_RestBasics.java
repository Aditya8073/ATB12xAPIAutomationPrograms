package com.thetestingacademy.ex01_RA_Concepts;

import io.restassured.RestAssured;

public class Lab001_RestBasics {
    public static void main(String[] args) {

        RestAssured.given().baseUri("https://api.postalpincode.in/pincode/500098")
                .when()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}
