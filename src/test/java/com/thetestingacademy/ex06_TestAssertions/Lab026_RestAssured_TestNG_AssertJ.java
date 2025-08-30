package com.thetestingacademy.ex06_TestAssertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Lab026_RestAssured_TestNG_AssertJ {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void test_POST(){

        String payload_post= "{\n" +
                "    \"firstname\" : \"Aditya\",\n" +
                "    \"lastname\" : \"Verma\",\n" +
                "    \"totalprice\" : 123,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        requestSpecification=RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_post).log().all();

        response=requestSpecification.when().post();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers; %4-%5
        // Matchers.equalto()

        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname", Matchers.equalTo("Aditya"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Verma"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(false));

        // TestNG - Extract the details of the firstname, bookingId, lastname from Response.
        Integer bookingid=response.then().extract().path("bookingid");
        String firstname=response.then().extract().path("booking.firstname");
        String lastname=response.then().extract().path("booking.lastname");

        // TestNG Assertions - 75%
        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.
        Assert.assertEquals(firstname,"Aditya");
        Assert.assertEquals(lastname, "Verma");
        Assert.assertNotNull(bookingid);

        assertThat(bookingid).isNotNull().isPositive().isNotZero();
        assertThat(firstname).isNotBlank().isNotNull().isEqualTo("Aditya");
    }
}
