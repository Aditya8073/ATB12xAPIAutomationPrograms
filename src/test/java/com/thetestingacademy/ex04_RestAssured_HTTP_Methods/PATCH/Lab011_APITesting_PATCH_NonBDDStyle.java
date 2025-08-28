package com.thetestingacademy.ex04_RestAssured_HTTP_Methods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab011_APITesting_PATCH_NonBDDStyle {

    @Test
    public void test_PATCH_NonBDDStyle(){
        String booking_id="1234";
        String token="c6b5ebb7d2c77a2";
        String payload="{\n" +
                "    \"firstname\" : \"Aditya\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        RequestSpecification requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + booking_id);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payload).log().all();

        Response response =requestSpecification.when().log().all().patch();

        ValidatableResponse validatableResponse =response.then().log().all();
        validatableResponse.statusCode(200);
    }

}
