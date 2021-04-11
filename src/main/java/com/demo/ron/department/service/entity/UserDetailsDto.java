package com.demo.ron.department.service.entity;

import lombok.Data;

@Data
public class UserDetailsDto {

	private long userId;
	private String userName;
	private String userDesignation;
	private long deptId;
	
	public long getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserDesignation() {
		return userDesignation;
	}
	public long getDeptId() {
		return deptId;
	}
	
	
}
