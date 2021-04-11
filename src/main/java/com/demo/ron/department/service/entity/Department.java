package com.demo.ron.department.service.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO )
	private String pk;
	private long deptId;
	private String deptName;
	private String deptAddress;
	private String deptCode;
	
	
}
