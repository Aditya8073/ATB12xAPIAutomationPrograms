package com.thetestingacademy.ex04_RestAssured_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab010_APITesting_PUT_NonBDDStyle {

    // token, booking id - A

//    public void get_token(){ }
//    public void get_booking_id(){}

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_PUT_NonBDDStyle(){
        String booking_id="1588";
        String token="baf40dfc5686d0c";

        String payload="{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r=RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + booking_id);
        r.contentType(ContentType.JSON);
        r.cookie("token",token );
//        r.auth().basic();
//        r.header("api-key", "abc");
//        r.header("bearer", "xyz");
        r.body(payload).log().all();

        response=r.when().log().all().put();

        vr=response.then().log().all();
        vr.statusCode(200);

    }
}
