package com.thetestingacademy.ex01_RA_Concepts;

public class Lab003_APITesting_BuilderPattern {

    public Lab003_APITesting_BuilderPattern step1(){
        System.out.println("step 1");
        return this;
    }
    public Lab003_APITesting_BuilderPattern step2(){
        System.out.println("step 2");
        return this;
    }
    public Lab003_APITesting_BuilderPattern step3(String param){
        System.out.println("step 3");
        return this;
    }

    public static void main(String[] args) {
        Lab003_APITesting_BuilderPattern bp = new Lab003_APITesting_BuilderPattern();
        bp.step1().step2().step3("Aditya");
    }
}
