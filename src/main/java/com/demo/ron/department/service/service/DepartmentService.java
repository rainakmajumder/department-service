package com.demo.ron.department.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.ron.department.service.entity.Customer;
import com.demo.ron.department.service.entity.Department;
import com.demo.ron.department.service.entity.UserDetailsDto;
import com.demo.ron.department.service.repo.CustomerRepo;
import com.demo.ron.department.service.repo.DepartmentRepo;
import com.demo.ron.department.service.repo.ProductRepo;
import com.demo.ron.department.service.response.UserResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepo repo;
	
	@Autowired
	private CustomerRepo custRepo;
	
	@Autowired
	private ProductRepo proRepo;

	@Autowired
	private RestTemplate restTemplate;

	public List<Department> saveDepartment(List<Department> dept) {
		log.info("Inside saveDepartment of DepartmentService");
		for(Department d : dept) {
			d.setPk(d.getDeptName()+"-"+d.getDeptId());
		}
		return repo.saveAll(dept);
	}

	public Department findDept(Long id) {
		log.info("Inside saveDepartment of DepartmentService");
		return repo.findByDeptId(id);
	}

	public UserResponse updateData(UserDetailsDto userDetails){
		UserResponse response = restTemplate.postForObject("http://USER-SERVICE/users/update-user-request", userDetails,
				UserResponse.class);
		return response;
	}

	public Customer addCustomer(Customer cust) {
		return custRepo.save(cust);
		
	}

	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return custRepo.findAll();
	}
}
