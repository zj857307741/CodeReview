package com.adinnet.codeview.builder;

/**
 * @author zoujian.
 * @date 2018/9/20
 */

public class ConcreteBuilderB implements Builder {
    private Products mProducts;

    @Override
    public void buildPartOne() {

    }

    @Override
    public void buildPartTwo() {

    }

    @Override
    public Products getProduct() {
        return mProducts;
    }
}
