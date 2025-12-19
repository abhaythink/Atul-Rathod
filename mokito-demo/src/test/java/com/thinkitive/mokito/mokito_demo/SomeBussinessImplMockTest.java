package com.thinkitive.mokito.mokito_demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBussinessImplMockTest {

    @Mock
    BussinessImpl bussiness;

    @InjectMocks
    SomeBussinessImpl someBussiness;


    @Test
    public void getMockitoImpleTest(){
        when(bussiness.someValues()).thenReturn(new int[]{10,203,30,20,12});
        assertEquals(400,someBussiness.getmaximumValueFrom());
    }



    @Test
    public void getmaximumValueFromTest(){
        BussinessImpl biInterface = mock(BussinessImpl.class);
        when(biInterface.someValues()).thenReturn(new int[]{10,203,30,20,12});
        SomeBussinessImpl sbimp=new SomeBussinessImpl(biInterface);
       int max= sbimp.getmaximumValueFrom();
       assertEquals(max,203);

    }
}