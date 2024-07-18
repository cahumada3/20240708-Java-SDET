package com.skillstorm.hello_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.skillstorm.hello_spring_boot.beans.Vehicle;

/**
 * @SpringBootApplication is a combo of three annotations:
 * 
 * 		@Configuration - specifies that a class will be a configuration class - more specifically,
 * 						 this will be a class that has beans that Spring needs to manage
 * 
 * 		@ComponentScan - searches your package for any class annotated with @Component and make beans for those components
 * 
 * 		@EnableAutoConfiguration - tells spring boot to auto-configure the app context with things we need (like a server for a web app)
 * 
 */


@SpringBootApplication
public class HelloSpringBootApplication implements CommandLineRunner {

	@Autowired				//ask spring to give us a bean - instead of asking app conext
	@Qualifier("camaro") 	//tells spring which bean to give us
	private Vehicle car3;

	public static void main(String[] args) {

		/**
		 * APPLICATION CONTEXT
		 * 		starts up your IoC Container
		 * 		where your beans live
		 */

		ApplicationContext context = SpringApplication.run(HelloSpringBootApplication.class, args);

		Vehicle car = (Vehicle) context.getBean("tesla");
		System.out.println("I'm driving my new Tesla! WOOOO!");
		car.drive();

		Vehicle car2 = (Vehicle) context.getBean("tesla");
		// prints out the same car since we set our scope to singleton
		System.out.println("Car 1: " + car);
		System.out.println("Car 2: " + car2);

		Vehicle car4 = (Vehicle) context.getBean("tesla");
		System.out.println("I'm driving my new Tesla! WOOOO!");
		car.drive();
		
	}

	/**
	 * COMMAND LINE RUNNER
	 * 		method that runs AFTER the app context is loaded
	 * 		
	 * 		usually ued to perform some setup for an application - like loading data
	 * 
	 * 		functional interface - so it could be a lambda if you wanted
	 * 
	 * 		you no longer have to call context.getBean() - @Autowired will do that for you
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println(car3);
		System.out.println("I'm driving my new camaro!!");
		car3.drive();
	}

}
