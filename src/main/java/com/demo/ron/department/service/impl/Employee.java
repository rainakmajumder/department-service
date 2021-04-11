package com.demo.ron.department.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Employee {

	@Autowired
	private AddessClass addessClass;
	
	public void details(AddessClass aa) {
		System.out.println("#################: " +aa.getAddress());
	}
		

	@PostConstruct
	public void init() {
		System.out.println("Initializing Employee Bean");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroying Employee Bean");
	}
}
