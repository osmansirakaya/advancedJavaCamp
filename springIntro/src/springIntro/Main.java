package springIntro;

import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ICustomerService customerService = (context.getBean("service",ICustomerService.class));  // databae'deki classı newleyerek geri döndürür
		customerService.add();
	}
}
