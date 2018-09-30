package com.adinnet.codeview.builder;

/**
 * @author zoujian.
 * @date 2018/9/20
 */

public class Director {
    private  Builder mBuilder;

    public Director(Builder builder){
        this.mBuilder = builder;
    }

    public void buildProduct(){
        this.mBuilder.buildPartOne();
        this.mBuilder.buildPartTwo();
    }

    public Products getProdect(){
        return this.mBuilder.getProduct();
    }
}
