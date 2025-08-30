package com.thetestingacademy.ex05_TestNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab023_APITesting_TestNG_AllAnnotations {

    @BeforeTest
    public void demo2(){
        System.out.println("Before Test");
    }

    @Test
    public void demo5(){
        System.out.println("Test");
    }

    @AfterTest
    public void demo8(){
        System.out.println("After Test");
    }
}
