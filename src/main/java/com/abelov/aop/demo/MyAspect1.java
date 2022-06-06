package com.abelov.aop.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Aspect
@Component
public class MyAspect1 implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

    @Pointcut("@annotation(com.abelov.aop.demo.Annotation1)")
    public void annotated() {}

    @Before("annotated()")
    public void printABit() {
        System.out.println("Aspect1");
    }

}
