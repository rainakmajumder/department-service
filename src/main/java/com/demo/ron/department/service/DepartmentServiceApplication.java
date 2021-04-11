package com.demo.ron.department.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import com.demo.ron.department.service.impl.AddessClass;
import com.demo.ron.department.service.impl.Book;
import com.demo.ron.department.service.impl.Employee;
import com.demo.ron.department.service.impl.VahicleRegistry;

@SpringBootApplication
@EnableAsync
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		VahicleRegistry car = context.getBean(VahicleRegistry.class);
		AddessClass aa = context.getBean("address", AddessClass.class);
		System.out.println(aa.getAddress());
		car.service();
		Employee emp = context.getBean(Employee.class);
		//System.out.println("Emp Details: "+ emp.getAddessClass().getStreet()+":"+emp.getAddessClass().getLine1());
		emp.details(aa);
		
		Book bookDetails = context.getBean(Book.class);
		System.out.println(bookDetails.getBook());
		
		context.close();
	}
	

}
