package com.demo.ron.department.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("carBean")
public class Car implements Vahicle{

	@Override
	public void start() {
		System.out.println("Car is started");
		
	}

	@Override
	public void stop() {
		System.out.println("Car is stop");
		
	}

}
