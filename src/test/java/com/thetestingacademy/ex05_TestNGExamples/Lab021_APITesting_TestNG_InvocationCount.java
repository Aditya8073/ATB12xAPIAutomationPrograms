package com.thetestingacademy.ex05_TestNGExamples;

import org.testng.annotations.Test;

public class Lab021_APITesting_TestNG_InvocationCount {

    @Test(invocationCount = 2)
    public void test1(){
        System.out.println("Hi");
    }

    @Test(invocationCount = 3)
    public void test2(){
        System.out.println("Bye");
    }
}
