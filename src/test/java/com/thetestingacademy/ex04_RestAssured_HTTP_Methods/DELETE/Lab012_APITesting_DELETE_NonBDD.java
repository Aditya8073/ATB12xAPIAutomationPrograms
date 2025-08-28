package com.thetestingacademy.ex04_RestAssured_HTTP_Methods.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab012_APITesting_DELETE_NonBDD {

    @Test
    public void test_DELETE_NonBDD(){
        String booking_id="5167";
        String token="9200e4170e70c93";

        RequestSpecification requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + booking_id);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.log().all();

        Response response = requestSpecification.when().delete();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
    }
}
