package com.abelov.aop.demo;

import OOP.MyInterface;
import OOP.SampleChild;
import OOP.SampleParent;
import another.DynamicInvocationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.Proxy;

@SpringBootApplication
//@EnableAspectJAutoProxy(proxyTargetClass = false) // true = CGLIB2
public class DemoApplication {

	@Autowired
	private MyServiceImpl myService;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			myService.method_1();
		};
	}

}
