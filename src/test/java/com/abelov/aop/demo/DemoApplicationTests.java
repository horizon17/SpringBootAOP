package com.abelov.aop.demo;

import OOP.MyInterface;
import OOP.SampleChild;
import OOP.SampleParent;
import another.DynamicInvocationHandler;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 	нет разницы в поведении JDK dp and CGLIB для случая OOP

 	а для случая аннотаций? Как будет работать JDK dp?
 */
@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {

//		Map proxyInstance = (Map) Proxy.newProxyInstance(
//				DemoApplicationTests.class.getClassLoader(),
//				new Class[] { Map.class },
//				new DynamicInvocationHandler());
//
//		proxyInstance.put("hello", "world");

	}

	@Test
	void proxyTest() {

		// pure OOP
		SampleChild sampleChild = new SampleChild();
		sampleChild.method1();
		// SampleParent.method1
		// SampleChild.method2


	}

	@Test
	void testJDKproxy() {

		MyInterface myInterface = new SampleChild();

		MyInterface proxyInstance = (MyInterface) Proxy.newProxyInstance(
				MyInterface.class.getClassLoader(),
				myInterface.getClass().getInterfaces(),
				new DynamicInvocationHandler(myInterface));

		proxyInstance.method1();
//		SampleParent.method1
//		SampleChild.method2
//		Invoked method! : {} method1
	}

	@Test
	void testCGLIBproxy() {

		new SampleChild().method1();

		System.out.println("//------------------------------------------//");

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(SampleChild.class);
		enhancer.setCallback(new MethodInterceptor() {
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
					throws Throwable {
				if(method.getName().equals("method2")) {
					System.out.println("SampleProxy.method2");
					proxy.invokeSuper(obj, args);
					return null;
				} else {
					return proxy.invokeSuper(obj, args);
				}
			}
		});
		((SampleChild) enhancer.create()).method1();

//		SampleParent.method1
//		SampleChild.method2
////------------------------------------------//
//		SampleParent.method1
//		SampleProxy.method2
//		SampleChild.method2
	}

}
