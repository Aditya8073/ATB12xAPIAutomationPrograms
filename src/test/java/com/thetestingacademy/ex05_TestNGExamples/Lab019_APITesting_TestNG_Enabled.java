package com.thetestingacademy.ex05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab019_APITesting_TestNG_Enabled {

    @Test
    public void test1(){
        System.out.println("Method 1");
        Assert.assertTrue(true);
    }

    @Test(enabled = false)
    public void test2(){
        System.out.println("Method 2");
        Assert.assertTrue(true);
    }

    @Test
    public void test3(){
        System.out.println("Method 3");
        Assert.assertTrue(true);
    }
}
