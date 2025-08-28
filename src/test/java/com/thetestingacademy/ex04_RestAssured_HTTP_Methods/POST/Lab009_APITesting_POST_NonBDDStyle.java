package com.thetestingacademy.ex04_RestAssured_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab009_APITesting_POST_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_POST_NonBDDStyle_Create_Token(){

        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        System.out.println(" ----  Pre-Requisites before making a request - Part 1 ---- ");

        r=RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload).log().all();

        System.out.println(" ----    Making a request - Part 2 ---- ");
        response=r.when().log().all().post();

        System.out.println(" ----    Validating the response - Part 3 ---- ");
        vr=response.then().log().all();
        vr.statusCode(200);
    }

}
