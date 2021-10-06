package com.agiliz.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agiliz.product.model.Product;

public interface MyRepository extends JpaRepository<Product, Integer> {

}
