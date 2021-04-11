package com.demo.ron.department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VahicleRegistry {

	@Autowired
	@Qualifier("carBean")
	Vahicle vahicle;
	
	public void service() {
		vahicle.start();
		vahicle.stop();
	}
}
