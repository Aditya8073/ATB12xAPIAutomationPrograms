package com.thetestingacademy.Payload_Management.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lab027_RestAssured_Payload_Map {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void test_POST() {

//        String payload_post = "{\n" +
//                "    \"firstname\" : \"Aditya\",\n" +
//                "    \"lastname\" : \"Verma\",\n" +
//                "    \"totalprice\" : 123,\n" +
//                "    \"depositpaid\" : false,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2024-01-01\",\n" +
//                "        \"checkout\" : \"2024-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Lunch\"\n" +
//                "}";

        // Hashmap -> key and value pair
        // Parent Hashmap ->  key and value , Child Hashmap

        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname", "Aditya");
        jsonBodyUsingMap.put("lastname", "Verma");
        jsonBodyUsingMap.put("totalprice", 123);
        jsonBodyUsingMap.put("depositpaid", false);

        Map<String, Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin", "2024-01-01");
        bookingDatesMap.put("checkout", "2024-01-01");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");
        System.out.println(jsonBodyUsingMap);

        // Hashmap -> JSON? or ClaSS TO json
        // 1. Gson
        // 2. Jackson API

        requestSpecification=RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        response=requestSpecification.when().post();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);

        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Dutta"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(false));
        validatableResponse.body("bookingid", Matchers.notNullValue());
    }
}
