package com.demo.ron.department.service.service;

import java.util.Calendar;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ResponseDepartmentService {

	@Async
	public void sendMessage(String message) throws InterruptedException {
		//Thread.sleep(5000);
		System.out.println(message +"-"+ Thread.currentThread().getName());
	}
	
	@Async
	public CompletableFuture<String> futureResponse() {
		CompletableFuture<String> future = new CompletableFuture<>();
		try {
			Thread.sleep(2000);
			future.complete("Success on "+Calendar.getInstance().getTime().toGMTString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return future;
	}
}
