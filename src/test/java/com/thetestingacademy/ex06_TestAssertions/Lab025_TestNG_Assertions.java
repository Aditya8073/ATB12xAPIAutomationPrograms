package com.thetestingacademy.ex06_TestAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lab025_TestNG_Assertions {

    @Test
    public void test_hardAssert_example(){
        System.out.println("start of the program");
        Assert.assertEquals("aditya", "Aditya");
        System.out.println("end of the program");
    }

    @Test
    public void test_softAssert_example(){
        System.out.println("start of the program");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("aditya", "Aditya");
        System.out.println("End of the program");
        softAssert.assertAll();
    }
}
