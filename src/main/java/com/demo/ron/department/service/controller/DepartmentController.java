package com.demo.ron.department.service.controller;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ron.department.service.entity.Customer;
import com.demo.ron.department.service.entity.Department;
import com.demo.ron.department.service.entity.UserDetailsDto;
import com.demo.ron.department.service.enums.Error;
import com.demo.ron.department.service.response.UserResponse;
import com.demo.ron.department.service.service.DepartmentService;
import com.demo.ron.department.service.service.ResponseDepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/dept")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	@Autowired
	private ResponseDepartmentService response;
	
	private static final String RESPONSE = "Department Saved Successfully";
	
	@PostMapping("/")
	public List<Department> saveDept(@RequestBody List<Department> dept) throws InterruptedException {
		log.info("Inside saveDept of DepartmentController");
		response.sendMessage(RESPONSE);
		System.out.println("Thread Details: "+Thread.currentThread().getName());
		return service.saveDepartment(dept);
	}
	
	@GetMapping("/{id}")
	public Department findDeptById(@PathVariable("id") Long id) {
		log.info("Inside findDeptById of DepartmentController");
		return service.findDept(id);
	}
	
	@GetMapping("/getTime")
	public String callAsyncMethod() {
		log.info("Inside callAsyncMethod of DepartmentController");
		CompletableFuture<String> fut1 = response.futureResponse();
		CompletableFuture<String> fut2 = response.futureResponse();
		CompletableFuture<String> fut3 = response.futureResponse();
		CompletableFuture<String> fut4 = response.futureResponse();
		CompletableFuture<Void> allCompletesFuture = CompletableFuture.allOf(fut1, fut2, fut3, fut4);
		allCompletesFuture.join();
		if(allCompletesFuture.isDone()) {
			try {
				System.out.println(fut1.get());
				System.out.println(fut2.get());
				System.out.println(fut3.get());
				System.out.println(fut4.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		return Calendar.getInstance().getTime().toGMTString();
	}
	
	@PostMapping("/update-user")
	public String updateUser(@RequestBody UserDetailsDto userDetails) throws Exception {
		if(userDetails.getUserId() > 0 && userDetails.getUserName() != null) {
			UserResponse response = service.updateData(userDetails);
			if(response.getStatusCode() != 200) {
				throw new Exception(response.getStatus());
			}
		} else {
			throw new Exception(Error.BAD_REQUEST.toString());
		}
		return "User Updated";
	}
	
	@PostMapping("/add-customer")
	public Customer addCustomer(@RequestBody Customer cust) {
		return service.addCustomer(cust);
	}
	
	@GetMapping("/find-all-customer")
	public List<Customer> findAllCustomer() {
		return service.findAllCustomer();
	}
	
}
