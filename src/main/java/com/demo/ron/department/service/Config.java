package com.demo.ron.department.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.demo.ron.department.service.impl.AddessClass;
import com.demo.ron.department.service.impl.Book;
import com.demo.ron.department.service.impl.Employee;
import com.demo.ron.department.service.impl.VahicleRegistry;

@Configuration
@ComponentScan("com.demo.ron.department.service.impl")
public class Config {

	@Bean
	public VahicleRegistry vahicleRegistry() {
		return new VahicleRegistry();
	}
	
	@Bean
	public Book book() {
		return new Book("2 States", 90.00, "Chetan Bhagat");
	}
	
	@Bean
	public AddessClass address() {
		return new AddessClass(new Book(), 30,"Nischinda, Ghoshpara, Bally");
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
