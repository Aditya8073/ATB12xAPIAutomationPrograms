package com.thetestingacademy.ex05_TestNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab014_APITesting_BeforeTest {
    //PUT Request
    //1.Get token
    //2.Get booking id
    //3.test_PUT (which will use the above 2 methods (1 &2)
    //4.close all things

    @BeforeTest
    public void getToken(){
        System.out.println("Token");
    }

    @BeforeTest
    public void getBookingId(){
        System.out.println("Booking Id");
    }

    @Test
    public void test_PUT(){
        //Token and Booking ID
        System.out.println("PUT Request");
    }

    @AfterTest
    public void closeAllThings(){
        System.out.println("Close all things");
    }
}
