package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);	
		ICustomerDal customerDal = (context.getBean("database",ICustomerDal.class));  // databae'deki classı newleyerek geri döndürür
		customerDal.add();
	}
}
