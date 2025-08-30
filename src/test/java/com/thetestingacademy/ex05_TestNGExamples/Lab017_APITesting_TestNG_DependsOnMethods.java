package com.thetestingacademy.ex05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab017_APITesting_TestNG_DependsOnMethods {

    @Test
    public void serverStarted(){
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStarted")
    public void test1(){
        System.out.println("Method 1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStarted")
    public void test2(){
        System.out.println("Method 2");
        Assert.assertTrue(true);
    }

}
