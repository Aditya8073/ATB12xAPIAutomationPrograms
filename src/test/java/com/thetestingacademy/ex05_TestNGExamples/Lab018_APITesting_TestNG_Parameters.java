package com.thetestingacademy.ex05_TestNGExamples;

import com.beust.jcommander.Parameter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab018_APITesting_TestNG_Parameters {

    @Parameters("browser")
    @Test
    public void test_parameter(String value){
        System.out.println("Parameter example program");

        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Start the chrome browser");
        }
        if(value.equalsIgnoreCase("firefox")){
            System.out.println("Start the firefox browser");
        }
    }
}
