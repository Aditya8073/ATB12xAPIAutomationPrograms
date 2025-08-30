package com.thetestingacademy.ex05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab016_APITesting_TestNG_Groups {

    @Test(groups = {"sanity","regression"})
    public void test_sanityRun(){
        System.out.println("sanity");
        Assert.assertTrue(true);
    }

    @Test(groups = {"regression"})
    public void test_regRun(){
        System.out.println("regression");
        Assert.assertTrue(false);
    }

    @Test(groups = {"smoke","regression"})
    public void test_smokeRun(){
        System.out.println("smoke");
        Assert.assertTrue(false);
    }
}
