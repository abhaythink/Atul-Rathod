package com.thinkitive.mokito.mokito_demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBussinessImplTest {
    SomeImplementationInf someImplementationInf=new SomeImplementationInf();
    SomeBussinessImpl sbimp=new SomeBussinessImpl(someImplementationInf);



    @Test
    public void getmaximumValueFromTest(){
       int max= sbimp.getmaximumValueFrom();
       assertEquals(max,203);

    }
}
class SomeImplementationInf implements BussinessImpl{

    @Override
    public int[] someValues() {
        return new int[]{10,203,30,20,12};
    }
}
