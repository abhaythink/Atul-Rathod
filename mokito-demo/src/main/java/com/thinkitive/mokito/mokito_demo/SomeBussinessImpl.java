package com.thinkitive.mokito.mokito_demo;

public class SomeBussinessImpl {
    private BussinessImpl bussiness;

    public SomeBussinessImpl(BussinessImpl bussiness) {
        this.bussiness = bussiness;
    }

    public int getmaximumValueFrom(){

        int[] values=bussiness.someValues();
        int max_value=Integer.MIN_VALUE;
        for(int i:values){
            if (i >max_value){
                max_value=i;
            }
        }
        return max_value;

    }


}
 interface BussinessImpl{
    int[] someValues();

        }
