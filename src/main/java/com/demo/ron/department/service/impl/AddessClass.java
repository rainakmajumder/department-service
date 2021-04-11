package com.demo.ron.department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class AddessClass {
	
	@Autowired
	private Book book;

	private int street;
	private String line1;
	
	public String getAddress() {
		System.out.println("00000000000000000000"+book.getBook());
		return street + "-" + line1;
	}
}
