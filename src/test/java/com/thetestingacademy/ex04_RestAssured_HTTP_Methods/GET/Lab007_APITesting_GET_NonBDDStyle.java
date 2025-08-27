package com.thetestingacademy.ex04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab007_APITesting_GET_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String pincode;

    @Test
    public void test_Positive_TC01(){
        pincode = "560048";

        //Divide them into 3 parts
        //given() - Part 1
        r=RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        //when() - Part 2
        response=r.when().log().all().get();
        System.out.println(response.asString());

        //then() - Part 3
        vr=response.then().log().all();
        vr.statusCode(200);
        // Write the further testcases or assertions also here.


    }

    @Test
    public void test_Negative_TC02(){
        pincode = "@";

        r=RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        response=r.when().log().all().get();
        System.out.println(response.asString());

        vr=response.then().log().all();
        vr.statusCode(404);
    }
}
