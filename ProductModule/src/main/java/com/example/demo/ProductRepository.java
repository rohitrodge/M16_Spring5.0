package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("unused")
public interface ProductRepository extends JpaRepository<Product,Integer> {

	

}