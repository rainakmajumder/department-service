package com.demo.ron.department.service.impl;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private String name;
	private Double price;
	private String auther;
	
	public String getBook() {
		return name + "-" + String.valueOf(price) + "-" + auther;
	}
}
