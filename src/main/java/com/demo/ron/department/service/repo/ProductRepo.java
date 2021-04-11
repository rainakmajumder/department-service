package com.demo.ron.department.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.ron.department.service.entity.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Integer>{

}
