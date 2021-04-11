package com.demo.ron.department.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bikeBean")
public class Bike implements Vahicle{

	@Override
	public void start() {
		System.out.println("Bike is started");
		
	}

	@Override
	public void stop() {
		System.out.println("Bike is stop");
		
	}

}
