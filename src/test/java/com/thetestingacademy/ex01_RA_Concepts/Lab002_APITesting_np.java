package com.thetestingacademy.ex01_RA_Concepts;

public class Lab002_APITesting_np {

    public void step1(){
        System.out.println("Step 1");
    }

    public void step2(){
        System.out.println("Step 2");
    }

    public void step3(String param){
        System.out.println("Step 3");
    }

    public static void main(String[] args) {
        Lab002_APITesting_np np = new Lab002_APITesting_np();
        np.step1();
        np.step2();
        np.step3("Aditya");

    }
}
