package com.abelov.aop.demo;

import org.springframework.aop.SpringProxy;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class MyServiceImpl {

    @Annotation1
    public void method_1() {
        System.out.println("method_1");
        method_2();
    }

   @Annotation1
    public void method_2() {
        System.out.println("method_2");
    }

}
